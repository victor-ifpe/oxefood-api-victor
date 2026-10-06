package br.edu.ifpe.oxefood.util;

import java.util.Random;

public class GeradorDocumento {

    private static final Random random = new Random();

    public static String gerarCPF() {
        int[] cpf = new int[11];

        for (int i = 0; i < 9; i++) {
            cpf[i] = random.nextInt(10);
        }

        int soma = 0;

        for (int i = 0; i < 9; i++) {
            soma += cpf[i] * (10 - i);
        }

        int resto = soma % 11;
        cpf[9] = resto < 2 ? 0 : 11 - resto;

        soma = 0;

        for (int i = 0; i < 10; i++) {
            soma += cpf[i] * (11 - i);
        }

        resto = soma % 11;
        cpf[10] = resto < 2 ? 0 : 11 - resto;

        return String.format(
                "%d%d%d.%d%d%d.%d%d%d-%d%d",
                cpf[0], cpf[1], cpf[2],
                cpf[3], cpf[4], cpf[5],
                cpf[6], cpf[7], cpf[8],
                cpf[9], cpf[10]);
    }

    public static String gerarCNPJ() {
        int[] cnpj = new int[14];

        for (int i = 0; i < 8; i++) {
            cnpj[i] = random.nextInt(10);
        }

        if (cnpj[0] == 0) {
            cnpj[0] = random.nextInt(9) + 1;
        }

        cnpj[8] = 0;
        cnpj[9] = 0;
        cnpj[10] = 0;
        cnpj[11] = 1;

        int[] pesos1 = { 5, 4, 3, 2, 9, 8, 7, 6, 5, 4, 3, 2 };

        int soma = 0;

        for (int i = 0; i < 12; i++) {
            soma += cnpj[i] * pesos1[i];
        }

        int resto = soma % 11;
        cnpj[12] = resto < 2 ? 0 : 11 - resto;

        int[] pesos2 = { 6, 5, 4, 3, 2, 9, 8, 7, 6, 5, 4, 3, 2 };

        soma = 0;

        for (int i = 0; i < 13; i++) {
            soma += cnpj[i] * pesos2[i];
        }

        resto = soma % 11;
        cnpj[13] = resto < 2 ? 0 : 11 - resto;

        return String.format(
                "%d%d.%d%d%d.%d%d%d/%d%d%d%d-%d%d",
                cnpj[0], cnpj[1],
                cnpj[2], cnpj[3], cnpj[4],
                cnpj[5], cnpj[6], cnpj[7],
                cnpj[8], cnpj[9], cnpj[10], cnpj[11],
                cnpj[12], cnpj[13]);
    }
}