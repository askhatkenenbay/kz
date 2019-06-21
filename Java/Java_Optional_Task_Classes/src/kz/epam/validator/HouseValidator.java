package kz.epam.validator;

public class HouseValidator {
    private static final int ACCEPTABLE_ID_DIGIT = 5;

    private static final int MIN_NUMBER_OF_HOUSE = 1;
    private static final int MAX_NUMBER_OF_HOUSE = 1_00_000;

    private static final double MIN_AREA_OF_HOUSE = 1.0;
    private static final double MAX_AREA_OF_HOUSE = 10_000.0;

    private static final int MIN_FLOOR_NUMBER = 1;
    private static final int MAX_FLOOR_NUMBER = 300;

    private static final int MIN_ROOM_NUMBER = 1;
    private static final int MAX_ROOM_NUMBER = 1_000;

    private static final int MIN_STREET_LENGTH = 4;
    private static final int MAX_STREET_LENGTH = 20;

    private static final int MIN_EXPLOITATION_PERIOD = 20;
    private static final int MAX_EXPLOITATION_PERIOD = 100;

    private static boolean idValidator(int idIn) {
        String str = Integer.toString(idIn);
        return (str.length() == ACCEPTABLE_ID_DIGIT) ? true : false;
    }

    private static boolean numberOfHouseValidator(int numberOfHouseIn) {
        return (numberOfHouseIn >= MIN_NUMBER_OF_HOUSE && numberOfHouseIn<=MAX_NUMBER_OF_HOUSE) ? true: false;
    }

    private static boolean areaOfHouseValidator(double areaOfHouseIn) {
        return (areaOfHouseIn >= MIN_AREA_OF_HOUSE && areaOfHouseIn<=MAX_AREA_OF_HOUSE) ? true: false;
    }

    private static boolean floorValidator(int floorIn) {
        return (floorIn >= MIN_FLOOR_NUMBER && floorIn<=MAX_FLOOR_NUMBER) ? true: false;
    }

    private static boolean numberOfRoomsValidator(int numberOfRoomsIn) {
        return (numberOfRoomsIn >= MIN_ROOM_NUMBER && numberOfRoomsIn<=MAX_ROOM_NUMBER) ? true: false;
    }

    private static boolean nameOfStreetValidator(String nameOfStreetIn) {
        int lengthOfStreet = nameOfStreetIn.length();
        return (lengthOfStreet >= MIN_STREET_LENGTH && lengthOfStreet<=MAX_STREET_LENGTH) ? true: false;
    }

    private static boolean periodOfExploitationValidator(int periodOfExploitationIn) {
        return (periodOfExploitationIn >=  MIN_EXPLOITATION_PERIOD && periodOfExploitationIn<=MAX_EXPLOITATION_PERIOD) ? true: false;
    }

    public static boolean houseValidator(int idIn, int numberOfHouseIn, double areaOfHouseIn, int floorIn, int numberOfRoomsIn,
                                         String nameOfStreetIn, int periodOfExploitationIn) {
        if(!idValidator(idIn)) {
            return false;
        }
        if(!numberOfHouseValidator(numberOfHouseIn)) {
            return false;
        }
        if(!areaOfHouseValidator(areaOfHouseIn)) {
            return false;
        }
        if(!floorValidator(floorIn)) {
            return false;
        }
        if(!numberOfRoomsValidator(numberOfRoomsIn)) {
            return false;
        }
        if(!nameOfStreetValidator(nameOfStreetIn)) {
            return false;
        }
        if(!periodOfExploitationValidator(periodOfExploitationIn)) {
            return false;
        }
        return true;
    }

    public static boolean houseValidator(int idIn, int numberOfHouseIn, double areaOfHouseIn, int floorIn,
                                         int numberOfRoomsIn, int periodOfExploitationIn) {
        if(!idValidator(idIn)) {
            return false;
        }
        if(!numberOfHouseValidator(numberOfHouseIn)) {
            return false;
        }
        if(!areaOfHouseValidator(areaOfHouseIn)) {
            return false;
        }
        if(!floorValidator(floorIn)) {
            return false;
        }
        if(!numberOfRoomsValidator(numberOfRoomsIn)) {
            return false;
        }
        if(!periodOfExploitationValidator(periodOfExploitationIn)) {
            return false;
        }
        return true;
    }

    public static boolean houseValidator(int idIn, int numberOfHouseIn, double areaOfHouseIn, int floorIn,
                                         int numberOfRoomsIn, String nameOfStreetIn) {
        if(!idValidator(idIn)) {
            return false;
        }
        if(!numberOfHouseValidator(numberOfHouseIn)) {
            return false;
        }
        if(!areaOfHouseValidator(areaOfHouseIn)) {
            return false;
        }
        if(!floorValidator(floorIn)) {
            return false;
        }
        if(!numberOfRoomsValidator(numberOfRoomsIn)) {
            return false;
        }
        if(!nameOfStreetValidator(nameOfStreetIn)) {
            return false;
        }
        return true;
    }

    public static boolean houseValidator(int idIn, int numberOfHouseIn, double areaOfHouseIn,
                                         int floorIn,int numberOfRoomsIn) {
        if(!idValidator(idIn)) {
            return false;
        }
        if(!numberOfHouseValidator(numberOfHouseIn)) {
            return false;
        }
        if(!areaOfHouseValidator(areaOfHouseIn)) {
            return false;
        }
        if(!floorValidator(floorIn)) {
            return false;
        }
        if(!numberOfRoomsValidator(numberOfRoomsIn)) {
            return false;
        }
        return true;
    }

    //there must not be object of this class
    private HouseValidator() {
        throw new IllegalStateException("Utility class");
    }
}

