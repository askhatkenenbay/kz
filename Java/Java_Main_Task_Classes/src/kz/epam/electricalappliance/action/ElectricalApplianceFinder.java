package kz.epam.electricalappliance.action;

import kz.epam.electricalappliance.entity.ElectricalAppliance;

public class ElectricalApplianceFinder {
    public static String findByCompanyNameAndYearOfProduction(String companyName,int startYear,int endYear,int size, ElectricalAppliance[] applianceList){
        StringBuilder result = new StringBuilder();
        for(int i=0;i<size;i++){
            if(companyName.equals(applianceList[i].getCompanyName())){
                if(startYear<=applianceList[i].getYearOfProduction() && endYear>=applianceList[i].getYearOfProduction()){
                    result.append(applianceList[i]);
                }
            }
        }
        return result.toString();
    }
    public static String findByPowerConsuptionAndWeight(int powerConsuption, double startWeight, double endWeight,int size, ElectricalAppliance[] applianceList){
        StringBuilder result = new StringBuilder();
        for(int i=0;i<size;i++){
            if(powerConsuption==applianceList[i].getPowerConsumption()){
                if(startWeight<=applianceList[i].getWeight() && endWeight>=applianceList[i].getWeight()){
                    result.append(applianceList[i]);
                }
            }
        }
        return result.toString();
    }
    private ElectricalApplianceFinder(){
        throw new IllegalStateException("Utility Class");
    }
}
