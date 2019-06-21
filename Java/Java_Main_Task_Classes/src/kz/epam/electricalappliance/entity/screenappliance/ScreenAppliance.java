package kz.epam.electricalappliance.entity.screenappliance;

import kz.epam.electricalappliance.entity.ElectricalAppliance;
import kz.epam.electricalappliance.exception.InvalidInputException;
import kz.epam.electricalappliance.validator.screen.ScreenApplianceValidator;

public abstract class ScreenAppliance extends ElectricalAppliance {
    private double displayDiagonal; //in cm
    private int screenResolutionFirstInt;
    private int screenResolutionSecondInt;
    public ScreenAppliance(String companyNameIn,String modelNameIn, int yearOfProductionIn, double weightIn, int powerConsumptionIn,
                           double displayDiagonalIn, int screenResolutionFirstIntIn, int screenResolutionSecondIntIn) throws InvalidInputException{
        super(companyNameIn, modelNameIn, yearOfProductionIn,weightIn,powerConsumptionIn);
        if(ScreenApplianceValidator.validateScreenAppliance(displayDiagonalIn,screenResolutionFirstIntIn,screenResolutionSecondIntIn)){
            displayDiagonal = displayDiagonalIn;
            screenResolutionFirstInt = screenResolutionFirstIntIn;
            screenResolutionSecondInt = screenResolutionSecondIntIn;
        }else{
            throw new InvalidInputException("Invalid screen input");
        }
    }
    public String toString(){
        StringBuilder result = new StringBuilder();
        result.append(super.toString());
        result.append("Dispay Diagonal:"+displayDiagonal+"\n");
        result.append("Screen Resolution:"+screenResolutionFirstInt+"x"+screenResolutionSecondInt+"\n");
        return result.toString();
    }
}
