package kz.epam.electricalappliance.action;

import kz.epam.electricalappliance.entity.ElectricalAppliance;

public class ElectricalApplianceListOnOff {
    public static void turnOn(int size, ElectricalAppliance[] applianceList){
        for(int i =0;i<size;i++){
            applianceList[i].on();
        }
    }
    public static void turnOff(int size, ElectricalAppliance[] applianceList){
        for(int i =0;i<size;i++){
            applianceList[i].off();
        }
    }
    private ElectricalApplianceListOnOff(){
        throw new IllegalStateException("Utility Class");
    }
}
