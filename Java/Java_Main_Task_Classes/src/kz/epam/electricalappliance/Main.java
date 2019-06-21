package kz.epam.electricalappliance;

import kz.epam.electricalappliance.entity.ElectricalApplianceList;

public class Main {
    public static void main(String[] args){
        ElectricalApplianceList example = new ElectricalApplianceList();
        example.addTV("Samsung","QE65Q67RAUXCE",2018,26,205,
                165,3840,2160,true,false,120);

        example.addProjector("Epson","EB-X05",2017,2.5,210,
                320,1024,768,17,21,35);

        example.addFridge("LG","GC-B22FTMPL",2018,104,156,
                464,40,3);

        example.addWasher("Bosch","WAW-325X0ME",2016,79,920,
                9.2,1600,48);
        System.out.println("Power Consuption with all appliances turn on");
        example.turnOnAllAppliance();
        System.out.println(example.calculatePowerConsuption());
        System.out.println("Appliances sorted by their power consuption");
        example.sortByPowerConsuption();
        System.out.println(example.toString());
        System.out.println("Appliance with company name \"Samsung\" and year of production between 2015 and 2019");
        System.out.println(example.findByCompanyNameAndYearOfProduction("Samsung",2015,2019));
        System.out.println("Appliance with power consuption:156 and weight between 100 and 120");
        System.out.println(example.findByPowerConsuptionAndWeight(156,100.0,120.0));
    }
}
