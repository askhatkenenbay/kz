package kz.epam.electricalappliance.entity.screenappliance;

import kz.epam.electricalappliance.exception.InvalidInputException;
import kz.epam.electricalappliance.validator.screen.ProjectorValidator;

public class Projector extends ScreenAppliance{
    private int minFocalLength; //in mm
    private int maxFocalLength;
    private int operatingTemperature;//in Celsius
    private boolean working = false;
    public Projector(String companyNameIn,String modelNameIn, int yearOfProductionIn, double weightIn, int powerConsumptionIn, double displayDiagonalIn, int screenResolutionFirstIntIn, int screenResolutionSecondIntIn,
                     int minFocalLengthIn, int maxFocalLengthIn, int operatingTemperatureIn)throws InvalidInputException {
        super(companyNameIn,modelNameIn,yearOfProductionIn,weightIn,powerConsumptionIn,displayDiagonalIn, screenResolutionFirstIntIn, screenResolutionSecondIntIn);
        if(ProjectorValidator.validateProjector(minFocalLengthIn,maxFocalLengthIn,operatingTemperatureIn)){
            minFocalLength = minFocalLengthIn;
            maxFocalLength = maxFocalLengthIn;
            operatingTemperature = operatingTemperatureIn;
        }else{
            throw new InvalidInputException("Invalid input for projector");
        }
    }
    public String toString(){
        StringBuilder result = new StringBuilder();
        result.append(super.toString());
        result.append("Min focal length:"+minFocalLength+"mm"+"\n");
        result.append("Max focal length:"+maxFocalLength+"mm"+"\n");
        result.append("Operating temperature:"+operatingTemperature+"Celsius"+"\n");
        return result.toString();
    }

    @Override
    public void on() {
        working = true;
    }

    @Override
    public void off() {
        working = false;
    }
}
