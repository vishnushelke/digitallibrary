package org.geeksforgeeks.digitallibrary.utils;

import org.springframework.security.crypto.bcrypt.BCrypt;


public class BCryptEncryptor {

    private static BCrypt encryptor;
    private static final String salt = BCrypt.gensalt(12);

    public static String encryptPassword(String password) {
        return BCrypt.hashpw(password, salt);
    }

    public static boolean matchPassword(String password, String hash) {
        return BCrypt.checkpw(password, hash);
    }
}
