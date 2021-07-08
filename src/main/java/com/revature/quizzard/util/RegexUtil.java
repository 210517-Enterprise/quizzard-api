package com.revature.quizzard.util;

public class RegexUtil {

    private RegexUtil() {
        super();
    }

    public static final String PASSWORD_REGEX = "^(?=.*[a-z])(?=.*[A-Z])(?=.*\\d)(?=.*[@$!%*?&])[A-Za-z\\d@$!%*?&]{8,}$";

}
