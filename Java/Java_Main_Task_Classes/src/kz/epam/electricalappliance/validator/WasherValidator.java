package kz.epam.electricalappliance.validator;

public class WasherValidator {
    private static final int MIN_LOAD_IN = 1;
    private static final int MAX_LOAD_IN = 25;
    private static final int MIN_ROTATION_SPEED = 400;
    private static final int MAX_ROTATION_SPEED = 4000;
    private static final int MIN_WATER_CONSUMPTION = 1;
    private static final int MAX_WATER_CONSUMPTION = 200;
    public static boolean validateWasher(double maxLoadIn,int maxRotationSpeedIn, int waterConsumptionForWashingIn){
        if(maxLoadIn<MIN_LOAD_IN || maxLoadIn>MAX_LOAD_IN){
            return false;
        }
        if(maxRotationSpeedIn<MIN_ROTATION_SPEED || maxRotationSpeedIn>MAX_ROTATION_SPEED){
            return false;
        }
        if(waterConsumptionForWashingIn< MIN_WATER_CONSUMPTION || waterConsumptionForWashingIn> MAX_WATER_CONSUMPTION){
            return false;
        }
        return true;
    }
    private WasherValidator(){
        throw new IllegalStateException("Utility Class");
    }
}
