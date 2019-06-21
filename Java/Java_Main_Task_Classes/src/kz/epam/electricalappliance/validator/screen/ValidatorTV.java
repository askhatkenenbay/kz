package kz.epam.electricalappliance.validator.screen;

public class ValidatorTV {
    private static final int MIN_REFRESH_RATE = 1;
    private static final int MAX_REFRESH_RATE = 1000;
    public static boolean validateTV( int refreshRate){
        if(refreshRate>MIN_REFRESH_RATE && refreshRate<MAX_REFRESH_RATE){
            return true;
        }
        return false;
    }
    private ValidatorTV(){
        throw new IllegalStateException("Utility Class");
    }
}
