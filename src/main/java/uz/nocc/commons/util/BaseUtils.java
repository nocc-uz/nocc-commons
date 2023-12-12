package uz.nocc.commons.util;

/**
 * @author Jonibek Amirkulov (thejwa)
 * @since 30/11/23 Thursday
 */
public class BaseUtils {
    public static String generateOtpCode() {
        return String.format("%04d", Math.round(Math.random() * 10000));
    }
}
