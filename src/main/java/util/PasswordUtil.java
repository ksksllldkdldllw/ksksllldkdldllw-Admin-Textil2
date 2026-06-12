package util;

import org.mindrot.jbcrypt.BCrypt;

public final class PasswordUtil {

    private PasswordUtil() {
    }

    public static String hash(String plainText) {
        return BCrypt.hashpw(plainText, BCrypt.gensalt(10));
    }

    public static boolean verificar(String plainText, String storedHash) {
        if (storedHash == null || plainText == null) {
            return false;
        }
        if (storedHash.startsWith("$2a$") || storedHash.startsWith("$2b$")) {
            return BCrypt.checkpw(plainText, storedHash);
        }
        return plainText.equals(storedHash);
    }

    public static boolean esHash(String value) {
        return value != null
                && (value.startsWith("$2a$") || value.startsWith("$2b$"));
    }
}
