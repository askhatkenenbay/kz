package kz.epam.electricalappliance.validator;

public class FridgeValidator {
    private static final int MIN_VOLUME = 1;
    private static final int MAX_VOLUME = 10000;
    private static final int MIN_NOISE_LEVEL = 1;
    private static final int MAX_NOISE_LEVEL = 50;
    private static final int MIN_CAMERA_NUMBER = 1;
    private static final int MAX_CAMERA_NUMBER = 10;
    public static boolean validateFridge(int totalVolumeIn, int noiseLevelIn, int numberOfCamerasIn){
        if(totalVolumeIn<MIN_VOLUME || totalVolumeIn>MAX_VOLUME){
            return false;
        }
        if(noiseLevelIn<MIN_NOISE_LEVEL || noiseLevelIn>MAX_NOISE_LEVEL){
            return false;
        }
        if(numberOfCamerasIn<MIN_CAMERA_NUMBER || numberOfCamerasIn>MAX_CAMERA_NUMBER){
            return false;
        }
        return true;
    }
    private FridgeValidator(){
        throw new IllegalStateException("Utility Class");
    }
}
