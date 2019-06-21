package kz.epam.entity.entity;

import kz.epam.validator.HouseValidator;

public class House {
    // id must be 5 digit number and it is unique to each house
    private int id;

    // number of house must be bigger than 0 and less than 100000
    //there cannot be two houses with same number of house in same building( checked by id)
    // old information about this house will be changed to new
    private int numberOfHouse;

    // area of house must be bigger than 0 and less than 10000
    private double areaOfHouse;

    //floor must be bigger than 0 and less than 300
    private int floor;

    //number of rooms must be bigger than 0 and less than 1000
    private int numberOfRooms;

    //name of Street must contain at least 4 characters and at max 20 characters
    private String nameOfStreet;


    private TypesOfBuilding typeOfBuilding;

    //in years
    //must be at least 20, at max 100
    private int periodOfExploitation;


    public House(int idIn, int numberOfHouseIn, double areaOfHouseIn, int floorIn, int numberOfRoomsIn,
                 String nameOfStreetIn, TypesOfBuilding typeOfBuildingIn, int periodOfExploitationIn) throws Exception {
        if(HouseValidator.houseValidator(idIn, numberOfHouseIn, areaOfHouseIn, floorIn,
                numberOfRoomsIn, nameOfStreetIn, periodOfExploitationIn)) {
            id = idIn;
            numberOfHouse = numberOfHouseIn;
            areaOfHouse = areaOfHouseIn;
            floor = floorIn;
            numberOfRooms = numberOfRoomsIn;
            nameOfStreet = nameOfStreetIn;
            typeOfBuilding = typeOfBuildingIn;
            periodOfExploitation = periodOfExploitationIn;
        }else {
            throw new Exception("Invalid Input");
        }
    }

    public House(int idIn, int numberOfHouseIn, double areaOfHouseIn, int floorIn, int numberOfRoomsIn,
                TypesOfBuilding typeOfBuildingIn, int periodOfExploitationIn) throws Exception{
        if(HouseValidator.houseValidator(idIn, numberOfHouseIn, areaOfHouseIn, floorIn,
                numberOfRoomsIn, periodOfExploitationIn)) {
            id = idIn;
            numberOfHouse = numberOfHouseIn;
            areaOfHouse = areaOfHouseIn;
            floor = floorIn;
            numberOfRooms = numberOfRoomsIn;
            typeOfBuilding = typeOfBuildingIn;
            periodOfExploitation = periodOfExploitationIn;
            nameOfStreet = "DefaultName";
        }else {
            throw new Exception("Invalid Input");
        }
    }

    public House(int idIn, int numberOfHouseIn, double areaOfHouseIn, int floorIn, int numberOfRoomsIn,
                 String nameOfStreetIn, TypesOfBuilding typeOfBuildingIn)throws Exception{
        if(HouseValidator.houseValidator(idIn, numberOfHouseIn, areaOfHouseIn, floorIn,
                numberOfRoomsIn, nameOfStreetIn)) {
            id = idIn;
            numberOfHouse = numberOfHouseIn;
            areaOfHouse = areaOfHouseIn;
            floor = floorIn;
            numberOfRooms = numberOfRoomsIn;
            nameOfStreet = nameOfStreetIn;
            typeOfBuilding = typeOfBuildingIn;
            periodOfExploitation = -1;
        }else {
            throw new Exception("Invalid Input");
        }
    }


    public House(int idIn, int numberOfHouseIn, double areaOfHouseIn,
                 int floorIn, int numberOfRoomsIn, TypesOfBuilding typeOfBuildingIn) throws Exception {
        if(HouseValidator.houseValidator(idIn, numberOfHouseIn, areaOfHouseIn, floorIn,
                numberOfRoomsIn)) {
            id = idIn;
            numberOfHouse = numberOfHouseIn;
            areaOfHouse = areaOfHouseIn;
            floor = floorIn;
            numberOfRooms = numberOfRoomsIn;
            nameOfStreet = "DefaultName";
            typeOfBuilding = typeOfBuildingIn;
            periodOfExploitation = -1;
        }else {
            throw new Exception("Invalid Input");
        }
    }

    public String toString() {
        String result = "";
        result+="House Id: "+id+"\n";
        result+="Number of House: "+numberOfHouse+"\n";
        result+="Area of House: "+areaOfHouse+" m^2\n";
        result+="Number of floor: "+floor+"\n";
        result+="Number of rooms: "+numberOfRooms+"\n";
        result+="Name of Street: "+nameOfStreet+"\n";
        result+="Type of Building: "+typeOfBuilding+"\n";
        result+="Period of Exploitation: "+periodOfExploitation+"\n";
        return result;
    }

    public int getId() {
        return id;
    }



    public int getNumberOfHouse() {
        return numberOfHouse;
    }



    public double getAreaOfHouse() {
        return areaOfHouse;
    }



    public int getFloor() {
        return floor;
    }



    public int getNumberOfRooms() {
        return numberOfRooms;
    }



    public String getNameOfStreet() {
        return nameOfStreet;
    }



    public TypesOfBuilding getTypeOfBuilding() {
        return typeOfBuilding;
    }



    public int getPeriodOfExploitation() {
        return periodOfExploitation;
    }
}
