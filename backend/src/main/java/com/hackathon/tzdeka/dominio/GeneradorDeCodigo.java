package com.hackathon.tzdeka.dominio;

import java.security.SecureRandom;

public class GeneradorDeCodigo {
    public static String generar() {
        String caracteres = "ABCDEFGHIJKLMNOPQRSTUVWXYZ0123456789";
        SecureRandom random = new SecureRandom();
        StringBuilder codigo = new StringBuilder();

        for (int i = 0; i < 8; i++) {
            int indice = random.nextInt(caracteres.length());
            char caracter = caracteres.charAt(indice);
            codigo.append(caracter);
        }

        return codigo.toString();
    }
}
