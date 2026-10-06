package br.edu.ifpe.oxefood;

import br.edu.ifpe.oxefood.util.GeradorDocumento;

public class GerarDocumentos {

    public static void main(String[] args) {

        System.out.println("CPF: " + GeradorDocumento.gerarCPF());
        System.out.println("CNPJ: " + GeradorDocumento.gerarCNPJ());

    }
}