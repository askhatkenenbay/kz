package kz.epam.parking;


import kz.epam.parking.entity.Car;
import kz.epam.parking.entity.Parking;
import kz.epam.parking.exception.ParkingException;

public class Main {
    public static void main(String[] args){
        Parking firstPark = null;
        Parking secondPark = null;
        Parking thirdPark = null;
        try {
            firstPark = new Parking(2,"First Parking");
            secondPark =new Parking(3,"Second Parking");
            thirdPark  =new Parking(4,"Third Parking");
        } catch (ParkingException e) {
            e.printStackTrace();
        }

        System.out.println(firstPark);
        System.out.println(secondPark);
        System.out.println(thirdPark);
        Thread car1 = new Thread(new Car("BMW",firstPark,secondPark,thirdPark));
        Thread car2 = new Thread(new Car("Nissan",firstPark,secondPark,thirdPark));
        Thread car3 = new Thread(new Car("Kia",firstPark,secondPark,thirdPark));
        Thread car4 = new Thread(new Car("Audi",firstPark,secondPark,thirdPark));
        Thread car5 = new Thread(new Car("Land Rover",firstPark,secondPark,thirdPark));
        Thread car6 = new Thread(new Car("Aston",firstPark,secondPark,thirdPark));
        Thread car7 = new Thread(new Car("Bugatti",firstPark,secondPark,thirdPark));
        Thread car8 = new Thread(new Car("Ford",firstPark,secondPark,thirdPark));
        Thread car9 = new Thread(new Car("Tesla",firstPark,secondPark,thirdPark));
        Thread car10 = new Thread(new Car("Hyundai",firstPark,secondPark,thirdPark));
        try{
            car1.start();
            car1.join();
            car2.start();
            car2.join();
            car3.start();
            car3.join();
            car4.start();
            car4.join();
            car5.start();
            car5.join();
            car6.start();
            car6.join();
            car7.start();
            car7.join();
            car8.start();
            car8.join();
            car9.start();
            car9.join();
            car10.start();
            car10.join();
        }catch(InterruptedException e){
           e.printStackTrace();
        }
        System.out.println("-------------------------------------------------");
        System.out.println(firstPark.detailedToString());
        System.out.println(secondPark.detailedToString());
        System.out.println(thirdPark.detailedToString());
    }
}

