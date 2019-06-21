package kz.epam.electricalappliance.entity;
import kz.epam.electricalappliance.exception.InvalidInputException;
import  kz.epam.electricalappliance.validator.ElectricalApplianceValidator;
public abstract class ElectricalAppliance {
    //between 1970 and 2019
    private int yearOfProduction;
    private String companyName;
    private String modelName;
    //in kg
    //must be bigger than 0
    private double weight;
    //in watt
    //must be bigger than 0
    private int powerConsumption;
    public ElectricalAppliance(String companyNameIn,String modelNameIn, int yearOfProductionIn,
                               double weightIn, int powerConsumptionIn) throws InvalidInputException {
        if(ElectricalApplianceValidator.validateElectricalAppliance(companyNameIn,modelNameIn,yearOfProductionIn,weightIn,powerConsumptionIn)){
            companyName = companyNameIn;
            modelName = modelNameIn;
            yearOfProduction = yearOfProductionIn;
            weight = weightIn;
            powerConsumption = powerConsumptionIn;
        }else{
            throw new InvalidInputException();
        }
    }
    public String toString(){
        StringBuilder result = new StringBuilder();
        result.append(companyName+":"+modelName+":"+yearOfProduction+"\n");
        result.append("Weight:"+weight+"\n");
        result.append("Power consuption:"+powerConsumption+"\n");
        return result.toString();
    }
    public abstract void on();
    public abstract void off();

    public int getYearOfProduction() {
        return yearOfProduction;
    }

    public String getCompanyName() {
        return companyName;
    }

    public double getWeight() {
        return weight;
    }

    public int getPowerConsumption() {
        return powerConsumption;
    }
}
