package kz.epam.electricalappliance.validator.screen;

public class ProjectorValidator {
    private static final int MIN_FOCAL_LENGTH = 8;
    private static final int MAX_FOCAL_LENGTH = 256;
    private static final int MIN_OPERATING_TEMPERATURE = 1;
    private static final int MAX_OPERATING_TEMPERATURE = 40;
    public static boolean validateProjector(int minFocalLengthIn, int maxFocalLengthIn, int operatingTemperatureIn){
        if(minFocalLengthIn<MIN_FOCAL_LENGTH){
            return false;
        }
        if(maxFocalLengthIn>MAX_FOCAL_LENGTH){
            return false;
        }
        if(operatingTemperatureIn<MIN_OPERATING_TEMPERATURE || operatingTemperatureIn>MAX_OPERATING_TEMPERATURE){
            return false;
        }
        return true;
    }
    private ProjectorValidator(){
        throw new IllegalStateException("Utility Class");
    }
}
