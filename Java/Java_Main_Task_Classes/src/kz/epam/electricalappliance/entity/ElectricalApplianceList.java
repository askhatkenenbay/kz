package kz.epam.electricalappliance.entity;

import kz.epam.electricalappliance.action.ElectricalApplianceFinder;
import kz.epam.electricalappliance.action.ElectricalApplianceListAdder;
import kz.epam.electricalappliance.action.ElectricalApplianceListOnOff;
import kz.epam.electricalappliance.action.ElectricalApplianceMath;
import kz.epam.electricalappliance.entity.buttonappliance.Fridge;
import kz.epam.electricalappliance.entity.buttonappliance.Washer;
import kz.epam.electricalappliance.entity.screenappliance.Projector;
import kz.epam.electricalappliance.entity.screenappliance.TV;

public class ElectricalApplianceList {
    private ElectricalAppliance[] applianceList = new ElectricalAppliance[10_000];
    private int size = 0;
    public boolean addTV(String companyNameIn,String modelNameIn, int yearOfProductionIn, double weightIn, int powerConsumptionIn, double displayDiagonalIn, int screenResolutionFirstIntIn, int screenResolutionSecondIntIn,
                         boolean supportSmartTV,boolean support3D, int refreshRate){
        TV result =  ElectricalApplianceListAdder.addTV(companyNameIn,modelNameIn,yearOfProductionIn,weightIn,powerConsumptionIn,displayDiagonalIn,screenResolutionFirstIntIn,screenResolutionSecondIntIn,
                supportSmartTV,support3D,refreshRate);
        if(result!=null){
            applianceList[size] = result;
            size++;
        }else{
            return false;
        }
        return true;
    }
    public boolean addProjector(String companyNameIn,String modelNameIn, int yearOfProductionIn, double weightIn, int powerConsumptionIn, double displayDiagonalIn, int screenResolutionFirstIntIn, int screenResolutionSecondIntIn,
                                int minFocalLengthIn, int maxFocalLengthIn, int operatingTemperatureIn){
        Projector result =  ElectricalApplianceListAdder.addProjector(companyNameIn,modelNameIn,yearOfProductionIn,weightIn,powerConsumptionIn,displayDiagonalIn,screenResolutionFirstIntIn,screenResolutionSecondIntIn,
        minFocalLengthIn,maxFocalLengthIn,operatingTemperatureIn);
        if(result!=null){
            applianceList[size] = result;
            size++;
        }else{
            return false;
        }
        return true;
    }
    public boolean addFridge(String companyNameIn,String modelNameIn, int yearOfProductionIn, double weightIn, int powerConsumptionIn,
                             int totalVolumeIn, int noiseLevelIn, int numberOfCamerasIn){
        Fridge result =  ElectricalApplianceListAdder.addFridge(companyNameIn,modelNameIn,yearOfProductionIn,weightIn,powerConsumptionIn,totalVolumeIn,noiseLevelIn,numberOfCamerasIn);
        if(result!=null){
            applianceList[size] = result;
            size++;
        }else{
            return false;
        }
        return true;
    }
    public boolean addWasher(String companyNameIn,String modelNameIn, int yearOfProductionIn, double weightIn, int powerConsumptionIn,
                             double maxLoadIn,int maxRotationSpeedIn, int waterConsuptionForWashingIn){
        Washer result = ElectricalApplianceListAdder.addWasher(companyNameIn,modelNameIn,yearOfProductionIn,weightIn,powerConsumptionIn,maxLoadIn,maxRotationSpeedIn,waterConsuptionForWashingIn);
        if(result!=null){
            applianceList[size] = result;
            size++;
        }else{
            return false;
        }
        return true;
    }
    public void turnOnAllAppliance() {
        ElectricalApplianceListOnOff.turnOn(size,applianceList);
    }
    public void turnOffAllAppliance(){
        ElectricalApplianceListOnOff.turnOff(size,applianceList);
    }
    public double calculatePowerConsuption(){
        return ElectricalApplianceMath.calculatePowerConsuption(size,applianceList);
    }
    public void sortByPowerConsuption(){
       ElectricalApplianceMath.sortByPowerConsuption(size,applianceList);
    }
    public String findByCompanyNameAndYearOfProduction(String companyName,int startYear,int endYear){
        return ElectricalApplianceFinder.findByCompanyNameAndYearOfProduction(companyName,startYear,endYear,size,applianceList);
    }
    public String findByPowerConsuptionAndWeight(int powerConsuption, double startWeight, double endWeight){
        return ElectricalApplianceFinder.findByPowerConsuptionAndWeight(powerConsuption,startWeight,endWeight,size,applianceList);
    }
    public String toString(){
        StringBuilder result = new StringBuilder();
        for(int i =0;i<size;i++){
            result.append(applianceList[i].toString()+"\n");
        }
        return result.toString();
    }
}
