package org.itsimulator.germes.app.infra.util;

import com.google.common.hash.Hashing;

import java.nio.charset.Charset;

/**
 * Security and encryption-related routines
 *
 * @author Stekanov
 */
public class SecurityUtil {
    private SecurityUtil() {
    }

    /**
     * Encryptes source text using SHA-2 encoding
     *
     * @param source
     * @return
     */
    public static String encryptSHA(String source) {
        return Hashing.sha256().hashString(source, Charset.forName("UTF-8")).toString();
    }

}
