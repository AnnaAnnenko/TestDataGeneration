package qa.annenko.utils;

import java.security.SecureRandom;

public class RandomUtils {

    public static String getRandomString(int len) {
        String AB = "0123456789ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz";
        SecureRandom rnd = new SecureRandom();
            StringBuilder result = new StringBuilder(len);
            for(int i = 0; i < len; i++)
                result.append(AB.charAt(rnd.nextInt(AB.length())));
            return result.toString();
        }
    }

