package kz.epam.parking.entity;


public class Car implements Runnable {
    private String carName;
    private Parking first;
    private Parking second;
    private Parking third;
    public Car(String name, Parking first,Parking second,Parking third){
        carName = name;
       this.first = first;
       this.second = second;
       this.third = third;
    }

    public String getCarName() {
        return carName;
    }

    @Override
    public void run() {
       boolean result;
       result = first.parkCar(this);
       if(result){
           System.out.println(carName + " was parked at "+ first.getParkingName());
           return;
       }
        result = second.parkCar(this);
        if(result){
            System.out.println(carName + " was parked at "+ second.getParkingName());
            return;
        }
        result = third.parkCar(this);
        if(result){
            System.out.println(carName + " was parked at "+ third.getParkingName());
            return;
        }
        if(!result){
            System.out.println(carName+" WAS NOT PARKED" );
        }
    }

}

