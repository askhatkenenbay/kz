package kz.epam.parking.entity;


import kz.epam.parking.exception.ParkingException;
import kz.epam.parking.validator.ValidatorParking;

import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.locks.ReentrantLock;

public class Parking {
    // number of places in parking
    private Car[] parkingPlaces;
    //name of this parking
    private String parkingName;

    private AtomicInteger numberOfCarInParking = new AtomicInteger(0);

    private ReentrantLock lock = new ReentrantLock();

    public Parking(int numberOfPlaces, String name) throws ParkingException {
        if(ValidatorParking.validateParking(numberOfPlaces)){
            parkingPlaces = new Car[numberOfPlaces];
            this.parkingName = name;
        }else{
            throw new ParkingException();
        }

    }
    public boolean parkCar(Car car){
        try {
            if(!lock.tryLock(1, TimeUnit.SECONDS)){
                return false;
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        if((parkingPlaces.length) == numberOfCarInParking.get()){
            //lock.unlock();
            return false;
        }
        try{
            parkingPlaces[numberOfCarInParking.get()] = car;
            numberOfCarInParking.incrementAndGet();
        }finally {
            lock.unlock();
            return true;
        }
    }
    public String toString(){
        StringBuilder result = new StringBuilder();
        result.append("Parking name: ");
        result.append(parkingName);
        result.append("\n");
        result.append("Number of places in park: ");
        result.append(parkingPlaces.length);
        result.append("\n");
        result.append("Number of cars in park now: ");
        result.append(numberOfCarInParking.get());
        result.append("\n");
        return result.toString();
    }
    public String detailedToString(){
        StringBuilder result = new StringBuilder();
        result.append(toString());
        for(int i=0;i<numberOfCarInParking.get();i++){
            result.append("Place:");
            result.append(i+1);
            result.append(" --> ");
            result.append(parkingPlaces[i].getCarName());
            result.append("\n");
        }
        return result.toString();
    }

    public String getParkingName() {
        return parkingName;
    }
}
