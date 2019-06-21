package kz.epam.electricalappliance.validator;

public class ElectricalApplianceValidator {
    private static final int MIN_NAME_LENGTH = 1;
    private static final int MAX_NAME_LENGTH = 25;
    private static final int MIN_PRODUCTION_YEAR = 1990;
    private static final int MAX_PRODUCTION_YEAR = 2019;
    private static final double MIN_WEIGHT = 0.01;
    private static final int MAX_WEIGHT = 2000;
    private static final int MIN_POWER_CONSUMPTION = 1;
    private static final int MAX_POWER_CONSUMPTION = 100000;
    public static boolean validateElectricalAppliance(String companyNameIn,String modelNameIn,
                                                      int yearOfProductionIn,double weightIn, double powerConsumptionIn){
        if(companyNameIn.length()<MIN_NAME_LENGTH || companyNameIn.length()>MAX_NAME_LENGTH){
            return false;
        }
        if(modelNameIn.length()<MIN_NAME_LENGTH || modelNameIn.length()>MAX_NAME_LENGTH){
            return false;
        }
        if(yearOfProductionIn<MIN_PRODUCTION_YEAR || yearOfProductionIn>MAX_PRODUCTION_YEAR){
            return false;
        }
        if(weightIn<MIN_WEIGHT || weightIn>MAX_WEIGHT){
            return false;
        }
        if(powerConsumptionIn<MIN_POWER_CONSUMPTION || powerConsumptionIn>MAX_POWER_CONSUMPTION){
            return false;
        }
        return true;
    }
    private ElectricalApplianceValidator(){
        throw new IllegalStateException("Utility Class");
    }
}
