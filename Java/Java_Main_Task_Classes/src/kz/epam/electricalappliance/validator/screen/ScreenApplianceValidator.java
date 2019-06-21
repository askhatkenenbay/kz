package kz.epam.electricalappliance.validator.screen;

public class ScreenApplianceValidator {
    private static final int MIN_DISPLAY_DIAGONAL =1;
    private static final int MAX_DISPLAY_DIAGONAL =10000;
    private static final int MIN_SCREEN_RESOLUTION =144;
    private static final int MAX_SCREEN_RESOLUTION =16384;
    public static boolean validateScreenAppliance( double displayDiagonalIn, int screenResolutionFirstIntIn, int screenResolutionSecondIntIn){
        if(displayDiagonalIn<MIN_DISPLAY_DIAGONAL || displayDiagonalIn>MAX_DISPLAY_DIAGONAL){
            return false;
        }
        if(screenResolutionFirstIntIn<MIN_SCREEN_RESOLUTION || screenResolutionFirstIntIn>MAX_SCREEN_RESOLUTION){
            return false;
        }
        if(screenResolutionSecondIntIn<MIN_SCREEN_RESOLUTION || screenResolutionSecondIntIn>MAX_DISPLAY_DIAGONAL){
            return false;
        }
        return true;
    }
    private ScreenApplianceValidator(){
        throw new IllegalStateException("Utility Class");
    }
}
