package manas25.github.SSIwithJWT;

import manas25.github.SSIwithJWT.entities.Users;

public class AppUtils {
    public static int getHashId(String text)
    {
        int hashCode = 0;

        for( int i = 0; i < text.length(); i++) {
            hashCode += Character.getNumericValue(text.charAt(i))*(i+1);
        }
        return hashCode;
    }
}
