package kz.epam.entity.Action;

import kz.epam.entity.entity.House;
import kz.epam.entity.entity.TypesOfBuilding;

public class HouseListAction {
    public static boolean addHouse(int idIn, int numberOfHouseIn, double areaOfHouseIn, int floorIn, int numberOfRoomsIn,
                                String nameOfStreetIn, TypesOfBuilding typeOfBuildingIn, int periodOfExploitationIn,
                                int realLength, House[] houseList){
        try {
            House houseToAdd = new House(idIn, numberOfHouseIn, areaOfHouseIn, floorIn, numberOfRoomsIn,
                    nameOfStreetIn, typeOfBuildingIn, periodOfExploitationIn);


            for(int i =0;i<realLength;i++) {
                if(houseList[i].getId() == idIn && houseList[i].getNumberOfRooms() == numberOfHouseIn) {
                    houseList[i] = houseToAdd;
                    return true;
                }
            }
            houseList[realLength] = houseToAdd;
            return true;
        }catch(Exception e) {
            return false;
        }
    }

    public static boolean addHouse(int idIn, int numberOfHouseIn, double areaOfHouseIn, int floorIn, int numberOfRoomsIn,
                                   TypesOfBuilding typeOfBuildingIn, int periodOfExploitationIn,
                                   int realLength, House[] houseList){
        try {
            House houseToAdd = new House(idIn, numberOfHouseIn, areaOfHouseIn, floorIn, numberOfRoomsIn,
                    typeOfBuildingIn, periodOfExploitationIn);


            for(int i =0;i<realLength;i++) {
                if(houseList[i].getId() == idIn && houseList[i].getNumberOfRooms() == numberOfHouseIn) {
                    houseList[i] = houseToAdd;
                    return true;
                }
            }
            houseList[realLength] = houseToAdd;
            return true;
        }catch(Exception e) {
            return false;
        }
    }

    public static boolean addHouse(int idIn, int numberOfHouseIn, double areaOfHouseIn, int floorIn, int numberOfRoomsIn,
                                   String nameOfStreetIn, TypesOfBuilding typeOfBuildingIn,
                                   int realLength, House[] houseList){
        try {
            House houseToAdd = new House(idIn, numberOfHouseIn, areaOfHouseIn, floorIn, numberOfRoomsIn,
                    nameOfStreetIn, typeOfBuildingIn);


            for(int i =0;i<realLength;i++) {
                if(houseList[i].getId() == idIn && houseList[i].getNumberOfRooms() == numberOfHouseIn) {
                    houseList[i] = houseToAdd;
                    return true;
                }
            }
            houseList[realLength] = houseToAdd;
            return true;
        }catch(Exception e) {
            return false;
        }
    }

    public static boolean addHouse(int idIn, int numberOfHouseIn, double areaOfHouseIn, int floorIn, int numberOfRoomsIn,
                                   TypesOfBuilding typeOfBuildingIn, int realLength, House[] houseList){
        try {
            House houseToAdd = new House(idIn, numberOfHouseIn, areaOfHouseIn, floorIn, numberOfRoomsIn, typeOfBuildingIn);


            for(int i =0;i<realLength;i++) {
                if(houseList[i].getId() == idIn && houseList[i].getNumberOfRooms() == numberOfHouseIn) {
                    houseList[i] = houseToAdd;
                    return true;
                }
            }
            houseList[realLength] = houseToAdd;
            return true;
        }catch(Exception e) {
            return false;
        }
    }

    public static String findHouseByAmountOfRoom(int rooms, int realLength, House[] houseList){
        StringBuilder result = new StringBuilder();
        for(int i =0; i<realLength;i++) {
            if(houseList[i].getNumberOfRooms()==rooms) {
                result.append(houseList[i]);
                result.append("\n");
            }
        }
        return result.toString();
    }

    public static String findHouseByRoomAndFloor(int rooms, int startFloor, int endFloor, int realLength,House[] houseList ) {
        StringBuilder result = new StringBuilder();
        for(int i =0; i<realLength;i++) {
            if(houseList[i].getNumberOfRooms()==rooms && houseList[i].getFloor()>=startFloor && houseList[i].getFloor()<=endFloor) {
                result.append(houseList[i]);
                result.append("\n");
            }
        }
        return result.toString();
    }

    public static String findHouseByArea(double area, int realLength,House[] houseList) {
        StringBuilder result = new StringBuilder();
        for(int i =0; i<realLength;i++){
            if(houseList[i].getAreaOfHouse()>area){
                result.append(houseList[i]);
                result.append("\n");
            }
        }
        return result.toString();
    }

    public static String findHouseByBuildingType(TypesOfBuilding typeOfBuilding, int realLength,House[] houseList){
        StringBuilder result = new StringBuilder();
        for(int i =0; i<realLength;i++){
            if(houseList[i].getTypeOfBuilding() == typeOfBuilding){
                result.append(houseList[i]);
                result.append("\n");
            }
        }
        return result.toString();
    }

    public static String showAllHouse(int realLength, House[] houseList){
        StringBuilder result = new StringBuilder();
        for(int i=0;i<realLength;i++){
            result.append("№"+(i+1)+"\n"+houseList[i]+"\n");
        }
        return result.toString();
    }
    private HouseListAction(){
        throw new IllegalStateException("Utility Class");
    }
}
