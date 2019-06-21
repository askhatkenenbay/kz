package kz.epam.parking.validator;

public class ValidatorParking {
    private static final int MIN_PARKING_PLACE = 1;
    public static boolean validateParking(int parkingPlace){
        if(parkingPlace>=MIN_PARKING_PLACE){
            return true;
        }
        return false;
    }
}
