package fr.ludovic.vimont.gsonexample;

import org.apache.commons.lang3.RandomStringUtils;

import java.util.Arrays;

public class StringUtils {
    private static final int ID_LENGTH = 6;
    private static String[] types = { ".png", ".jpg", ".gif" };

    public static boolean isAnImageURL(String imageURL) {
        if(imageURL != null) {
            if (Arrays.asList(types).contains(imageURL.substring(imageURL.length() - 4, imageURL.length())) && imageURL.contains("http")) {
                return true;
            }
        }
        return false;
    }

    public static String generateID() {
        return RandomStringUtils.random(ID_LENGTH, true, true);
    }
}