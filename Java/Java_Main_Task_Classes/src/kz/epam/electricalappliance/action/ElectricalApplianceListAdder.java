package kz.epam.electricalappliance.action;

import kz.epam.electricalappliance.entity.buttonappliance.Fridge;
import kz.epam.electricalappliance.entity.buttonappliance.Washer;
import kz.epam.electricalappliance.entity.ElectricalAppliance;
import kz.epam.electricalappliance.entity.screenappliance.Projector;
import kz.epam.electricalappliance.entity.screenappliance.TV;
import kz.epam.electricalappliance.exception.InvalidInputException;

public class ElectricalApplianceListAdder {
    public static TV addTV(String companyNameIn,String modelNameIn, int yearOfProductionIn, double weightIn, int powerConsumptionIn, double displayDiagonalIn, int screenResolutionFirstIntIn, int screenResolutionSecondIntIn,
                                boolean supportSmartTV,boolean support3D, int refreshRate){
        try{
            TV addTV = new TV(companyNameIn,modelNameIn,yearOfProductionIn,weightIn,powerConsumptionIn,displayDiagonalIn,screenResolutionFirstIntIn,screenResolutionSecondIntIn,
            supportSmartTV,support3D,refreshRate);
            return addTV;
        }catch(InvalidInputException e){
            return null;
        }
    }
    public static Projector addProjector(String companyNameIn,String modelNameIn, int yearOfProductionIn, double weightIn, int powerConsumptionIn, double displayDiagonalIn, int screenResolutionFirstIntIn, int screenResolutionSecondIntIn,
                                       int minFocalLengthIn, int maxFocalLengthIn, int operatingTemperatureIn){
        try{
            Projector addProjector = new Projector(companyNameIn,modelNameIn,yearOfProductionIn,weightIn,powerConsumptionIn,displayDiagonalIn,screenResolutionFirstIntIn,screenResolutionSecondIntIn,
                    minFocalLengthIn, maxFocalLengthIn, operatingTemperatureIn);
            return addProjector;
        }catch(InvalidInputException e){
            return null;
        }
    }
    public static Fridge addFridge(String companyNameIn, String modelNameIn, int yearOfProductionIn, double weightIn, int powerConsumptionIn,
                                    int totalVolumeIn, int noiseLevelIn, int numberOfCamerasIn){
        try{
            Fridge addFridge = new Fridge(companyNameIn,modelNameIn,yearOfProductionIn,weightIn,powerConsumptionIn, totalVolumeIn,noiseLevelIn,numberOfCamerasIn);
            return addFridge;
        }catch(InvalidInputException e){
            return null;
        }
    }
    public static Washer addWasher(String companyNameIn,String modelNameIn, int yearOfProductionIn, double weightIn, int powerConsumptionIn,
                                    double maxLoadIn,int maxRotationSpeedIn, int waterConsuptionForWashingIn){
        try{
            Washer addWasher = new Washer(companyNameIn,modelNameIn,yearOfProductionIn,weightIn,powerConsumptionIn, maxLoadIn,maxRotationSpeedIn,waterConsuptionForWashingIn);
            return addWasher;
        }catch(InvalidInputException e){
            return null;
        }
    }
    private ElectricalApplianceListAdder(){
        throw new IllegalStateException("Utility Class");
    }
}
