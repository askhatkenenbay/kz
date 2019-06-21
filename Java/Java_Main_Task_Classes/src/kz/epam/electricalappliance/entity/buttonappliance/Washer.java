package kz.epam.electricalappliance.entity.buttonappliance;

import kz.epam.electricalappliance.entity.ElectricalAppliance;
import kz.epam.electricalappliance.exception.InvalidInputException;
import kz.epam.electricalappliance.validator.WasherValidator;

public class Washer extends ElectricalAppliance {
    private boolean working = false;
    private double maxLoad;//in kg
    private int maxRotationSpeed; //in rpm
    private int waterConsuptionForWashing; // in liter

    public Washer(String companyNameIn,String modelNameIn, int yearOfProductionIn, double weightIn, int powerConsumptionIn,
                  double maxLoadIn,int maxRotationSpeedIn, int waterConsuptionForWashingIn) throws InvalidInputException {
        super(companyNameIn,modelNameIn,yearOfProductionIn,weightIn,powerConsumptionIn);
        if(WasherValidator.validateWasher(maxLoadIn,maxRotationSpeedIn,waterConsuptionForWashingIn)){
            maxLoad =maxLoadIn;
            maxRotationSpeed = maxRotationSpeedIn;
            waterConsuptionForWashing = waterConsuptionForWashingIn;
        }else{
            throw new InvalidInputException();
        }
    }
    @Override
    public void on() {
        working = true;
    }
    @Override
    public void off() {
        working = false;
    }
    public String toString(){
        StringBuilder result = new StringBuilder();
        result.append(super.toString());
        result.append("Max load:"+maxLoad+"kg\n");
        result.append("Max rotation speed:"+maxRotationSpeed+"rpm\n");
        result.append("Water consuption for washing:"+waterConsuptionForWashing+"\n");
        return result.toString();
    }
}
