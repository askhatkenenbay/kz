package kz.epam;
import kz.epam.entity.entity.HouseList;
import kz.epam.entity.entity.TypesOfBuilding;

public class Main {
    public static void main(String[] args){
        HouseList example = new HouseList();
        //add house with all fields
        example.addHouse(12345, 778, 125.56, 5,5,"Baker",TypesOfBuilding.APARTMENT,40);
        //add house with Street name missing
        example.addHouse(45459,45,78.78,3,3,TypesOfBuilding.LODGE,35);
        //add house with period of exploitation missing
        example.addHouse(45459,47,85.85,3,2,"Astana",TypesOfBuilding.LODGE);
        //add house with Street name and period of exploitation missing
        example.addHouse(12345,255,785.3,55,8,TypesOfBuilding.SKYSCRAPER);
        System.out.println(example.showAllHouse());
        System.out.println("*****Houses with given room number*****");
        System.out.println(example.findHouseByAmountOfRoom(5));
        System.out.println("*****Houses with given room number and between given floors*****");
        System.out.println(example.findHouseByRoomAndFloor(3,1,6));
        System.out.println("*****Houses with area more that given*****");
        System.out.println(example.findHouseByArea(80.2));
        System.out.println("*****Houses with given type of building*****");
        System.out.println(example.findHouseByBuildingType(TypesOfBuilding.LODGE));

    }
}
