package kz.epam.electricalappliance.entity.buttonappliance;

import kz.epam.electricalappliance.entity.ElectricalAppliance;
import kz.epam.electricalappliance.exception.InvalidInputException;
import kz.epam.electricalappliance.validator.FridgeValidator;

public class Fridge extends ElectricalAppliance {
    private boolean working = false;
    private int totalVolume;// in liter
    private int noiseLevel; // in dB
    private int numberOfCameras;
    public Fridge(String companyNameIn,String modelNameIn, int yearOfProductionIn, double weightIn, int powerConsumptionIn,
                  int totalVolumeIn, int noiseLevelIn, int numberOfCamerasIn)throws InvalidInputException {
        super(companyNameIn, modelNameIn, yearOfProductionIn,weightIn,powerConsumptionIn);
        if(FridgeValidator.validateFridge(totalVolumeIn,noiseLevelIn,numberOfCamerasIn)){
            totalVolume =totalVolumeIn;
            noiseLevel = noiseLevelIn;
            numberOfCameras = numberOfCamerasIn;
        }
        else{
            throw new InvalidInputException("Invalid input for Fridge");
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
        result.append("Total volume:"+totalVolume+"\n");
        result.append("Number of cameras:"+numberOfCameras+"\n");
        result.append("Noise Level:"+noiseLevel+"\n");
        return result.toString();
    }
}
