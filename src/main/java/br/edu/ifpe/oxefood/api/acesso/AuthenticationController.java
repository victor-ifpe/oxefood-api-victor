package br.edu.ifpe.oxefood.api.acesso;

import java.util.HashMap;
import java.util.Map;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.edu.ifpe.oxefood.api.seguranca.JwtService;
import io.swagger.v3.oas.annotations.tags.Tag;

@RestController
@RequestMapping("/api/auth")
@Tag(name = "API Autenticação", description = "API responsável pelos serviços de autenticação no sistema")

public class AuthenticationController {

  private final JwtService jwtService;
  private final UsuarioService usuarioService;

  public AuthenticationController(JwtService jwtService, UsuarioService usuarioService) {

    this.jwtService = jwtService;
    this.usuarioService = usuarioService;
  }

  @PostMapping
  public Map<Object, Object> signin(@RequestBody AuthenticationDTO dto) {

    Usuario authenticatedUser = usuarioService.authenticate(dto.getUsername(), dto.getPassword());

    String jwtToken = jwtService.generateToken(authenticatedUser);

    Map<Object, Object> loginResponse = new HashMap<>();
    loginResponse.put("username", authenticatedUser.getUsername());
    loginResponse.put("token", jwtToken);
    loginResponse.put("tokenExpiresIn", jwtService.getExpirationTime());

    return loginResponse;
  }

}