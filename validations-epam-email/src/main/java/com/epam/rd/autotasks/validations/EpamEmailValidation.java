package com.epam.rd.autotasks.validations;

import java.util.regex.Matcher;
import java.util.regex.Pattern;


public class EpamEmailValidation {


    public static boolean validateEpamEmail(String email) {
        // Put your code here
        if(email == null) return false;
        String emailRegex = "[a-zA-Z]+\\_[a-zA-Z]+(\\d)*\\@epam.com";
        Pattern emailPat = Pattern.compile(emailRegex,Pattern.CASE_INSENSITIVE);
        Matcher matcher = emailPat.matcher(email);

        return matcher.find();
    }
}





