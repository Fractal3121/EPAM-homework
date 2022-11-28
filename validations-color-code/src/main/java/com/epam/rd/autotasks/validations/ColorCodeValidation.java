package com.epam.rd.autotasks.validations;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class ColorCodeValidation {
    public static boolean validateColorCode(String color) {

        // Put your code here
        if (color == null)return false;
        String colorRegex = "^#([a-fA-F0-9]{6}|[a-fA-F0-9]{3})$";
        Pattern colorPat = Pattern.compile(colorRegex, Pattern.CASE_INSENSITIVE);
        Matcher matcher = colorPat.matcher(color);
        return matcher.find();

    }
}





