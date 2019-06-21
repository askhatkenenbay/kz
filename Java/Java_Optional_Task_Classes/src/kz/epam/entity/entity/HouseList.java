package kz.epam.entity.entity;

import kz.epam.entity.Action.HouseListAction;

public class HouseList {
    private House[] houseList = new House[1_000_000];
    private int realLength = 0;

    public boolean addHouse(int idIn, int numberOfHouseIn, double areaOfHouseIn, int floorIn, int numberOfRoomsIn,
                            String nameOfStreetIn, TypesOfBuilding typeOfBuildingIn, int periodOfExploitationIn) {
        boolean result =  HouseListAction.addHouse(idIn, numberOfHouseIn, areaOfHouseIn, floorIn, numberOfRoomsIn,
                nameOfStreetIn, typeOfBuildingIn, periodOfExploitationIn, realLength, houseList);
        realLength++;
        return result;
    }

    public boolean addHouse(int idIn, int numberOfHouseIn, double areaOfHouseIn, int floorIn, int numberOfRoomsIn,
                            TypesOfBuilding typeOfBuildingIn, int periodOfExploitationIn) {
        boolean result =  HouseListAction.addHouse(idIn, numberOfHouseIn, areaOfHouseIn, floorIn, numberOfRoomsIn,
                typeOfBuildingIn, periodOfExploitationIn, realLength, houseList);
        realLength++;
        return result;
    }

    public boolean addHouse(int idIn, int numberOfHouseIn, double areaOfHouseIn, int floorIn, int numberOfRoomsIn,
                            String nameOfStreetIn, TypesOfBuilding typeOfBuildingIn) {
        boolean result =  HouseListAction.addHouse(idIn, numberOfHouseIn, areaOfHouseIn, floorIn, numberOfRoomsIn,
                nameOfStreetIn, typeOfBuildingIn, realLength, houseList);
        realLength++;
        return result;
    }

    public boolean addHouse(int idIn, int numberOfHouseIn, double areaOfHouseIn, int floorIn, int numberOfRoomsIn,
                           TypesOfBuilding typeOfBuildingIn) {
        boolean result =  HouseListAction.addHouse(idIn, numberOfHouseIn, areaOfHouseIn, floorIn, numberOfRoomsIn,
                typeOfBuildingIn,realLength, houseList);
        realLength++;
        return result;
    }

    public String findHouseByAmountOfRoom(int rooms) {
        return HouseListAction.findHouseByAmountOfRoom(rooms,realLength, houseList);
    }


    public String findHouseByRoomAndFloor(int rooms, int startFloor, int endFloor) {
        return HouseListAction.findHouseByRoomAndFloor(rooms,startFloor, endFloor, realLength,houseList);
    }


    public String findHouseByArea(double area) {
        return HouseListAction.findHouseByArea(area,realLength,houseList);
    }

    public String findHouseByBuildingType(TypesOfBuilding typeOfBuilding){
        return HouseListAction.findHouseByBuildingType(typeOfBuilding,realLength,houseList);
    }

    public String showAllHouse(){
        return HouseListAction.showAllHouse(realLength,houseList);
    }

}
