package br.edu.ifpe.oxefood.api.empresa;

import java.io.IOException;
import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import br.edu.ifpe.oxefood.api.acesso.Perfil;
import br.edu.ifpe.oxefood.api.acesso.PerfilRepository;
import br.edu.ifpe.oxefood.api.acesso.Usuario;
import br.edu.ifpe.oxefood.api.acesso.UsuarioService;
import br.edu.ifpe.oxefood.exception.EmpresaException;
import br.edu.ifpe.oxefood.util.Util;
import jakarta.transaction.Transactional;

@Service
public class EmpresaService {

    private static final long TAMANHO_MAXIMO_LOGO = 2 * 1024 * 1024;

    private final EmpresaRepository repository;
    private final UsuarioService usuarioService;
    private final PerfilRepository perfilUsuarioRepository;

    public EmpresaService(EmpresaRepository repository, UsuarioService usuarioService,
            PerfilRepository perfilUsuarioRepository) {
        this.repository = repository;
        this.usuarioService = usuarioService;
        this.perfilUsuarioRepository = perfilUsuarioRepository;
    }

    public Empresa build(EmpresaDTO dto) {

        Empresa empresa = null;

        if (dto.getId() == null) {
            empresa = new Empresa();

            Usuario usuario = new Usuario();
            usuario.setUsername(dto.getEmail());
            usuario.setPassword(dto.getPassword());
            usuario.getRoles().add(new Perfil(Perfil.ROLE_EMPRESA));
            empresa.setUsuario(usuario);

        } else {
            empresa = repository.findById(dto.getId()).get();
        }

        empresa.setSite(dto.getSite());
        empresa.setCnpj(dto.getCnpj());
        empresa.setInscricaoEstadual(dto.getInscricaoEstadual());
        empresa.setNomeEmpresarial(dto.getNomeEmpresarial());
        empresa.setNomeFantasia(dto.getNomeFantasia());
        empresa.setFone(dto.getFone());
        empresa.setFoneAlternativo(dto.getFoneAlternativo());

        return empresa;
    }

    @Transactional
    public Empresa cadastrar(EmpresaDTO dto) {

        Empresa empresa = build(dto);

        usuarioService.save(empresa.getUsuario());

        for (Perfil perfil : empresa.getUsuario().getRoles()) {
            perfil.setHabilitado(Boolean.TRUE);
            perfilUsuarioRepository.save(perfil);
        }

        empresa.setHabilitado(true);
        return repository.save(empresa);
    }

    public List<Empresa> listar() {
        return repository.findAll();
    }

    public Empresa buscarPorId(Long id) {
        return repository.findById(id).get();
    }

    @Transactional
    public Empresa atualizar(EmpresaDTO dto) {

        Empresa empresa = build(dto);
        return repository.save(empresa);
    }

    @Transactional
    public Empresa saveLogo(Long id, MultipartFile logo) {

        validarLogo(logo);

        Empresa empresa = buscarPorId(id);
        String logoAnterior = empresa.getLogo();

        String logoUpada = Util.fazerUploadImagem(logo);

        if (logoUpada == null) {
            throw new EmpresaException(EmpresaException.MSG_LOGO_FALHA_UPLOAD);
        }

        empresa.setLogo(logoUpada);
        Empresa empresaSalva = repository.save(empresa);

        // Remove o arquivo da logo substituída, para não acumular imagens sem uso
        Util.removerImagem(logoAnterior);

        return empresaSalva;
    }

    private void validarLogo(MultipartFile logo) {

        if (logo == null || logo.isEmpty()) {
            throw new EmpresaException(EmpresaException.MSG_LOGO_VAZIA);
        }

        if (logo.getSize() > TAMANHO_MAXIMO_LOGO) {
            throw new EmpresaException(EmpresaException.MSG_LOGO_TAMANHO_EXCEDIDO);
        }

        String nomeArquivo = logo.getOriginalFilename() == null ? "" : logo.getOriginalFilename().toLowerCase();

        boolean extensaoValida = nomeArquivo.endsWith(".png")
                || nomeArquivo.endsWith(".jpg")
                || nomeArquivo.endsWith(".jpeg")
                || nomeArquivo.endsWith(".webp");

        if (!extensaoValida) {
            throw new EmpresaException(EmpresaException.MSG_LOGO_FORMATO_INVALIDO);
        }

        // Confere o conteúdo do arquivo (assinatura), e não apenas o nome informado pelo cliente
        try {
            if (!conteudoEhImagemPermitida(logo.getBytes())) {
                throw new EmpresaException(EmpresaException.MSG_LOGO_FORMATO_INVALIDO);
            }
        } catch (IOException e) {
            throw new EmpresaException(EmpresaException.MSG_LOGO_FALHA_UPLOAD);
        }
    }

    private boolean conteudoEhImagemPermitida(byte[] bytes) {

        boolean png = bytes.length >= 8
                && (bytes[0] & 0xFF) == 0x89 && bytes[1] == 'P' && bytes[2] == 'N' && bytes[3] == 'G';

        boolean jpeg = bytes.length >= 3
                && (bytes[0] & 0xFF) == 0xFF && (bytes[1] & 0xFF) == 0xD8 && (bytes[2] & 0xFF) == 0xFF;

        boolean webp = bytes.length >= 12
                && bytes[0] == 'R' && bytes[1] == 'I' && bytes[2] == 'F' && bytes[3] == 'F'
                && bytes[8] == 'W' && bytes[9] == 'E' && bytes[10] == 'B' && bytes[11] == 'P';

        return png || jpeg || webp;
    }

    @Transactional
    public void remover(Long id) {

        Empresa empresa = repository.findById(id).get();
        empresa.setHabilitado(false);

        repository.save(empresa);
    }
}