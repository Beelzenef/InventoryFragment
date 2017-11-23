package com.example.inventoryfragment.utils;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Created by usuario on 13/11/17.
 */

public final class CommonUtils {

    /**
     * Metodo para comprobacion de contraseña con requisitos:
     * Debe contener al menos un digito (0-9)
     * Debe contener al menos un caracter en mayusculas
     * Debe contener al menos un caracter en minúscula
     * Longitud de al menos 6 caracteres
     * @param passw
     * @return matching password with pattern
     */
    public static boolean isPasswordValid(String passw)
    {
        Pattern pattern;
        Matcher matcher;

        final String PASSWORD_PATTERN = ".*";//([a-z]+[A-Z]+[0-9]+){6,}";

        pattern = Pattern.compile(PASSWORD_PATTERN);
        matcher = pattern.matcher(passw);

        return matcher.matches();
    }
}
