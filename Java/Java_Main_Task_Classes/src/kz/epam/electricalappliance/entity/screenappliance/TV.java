package kz.epam.electricalappliance.entity.screenappliance;

import kz.epam.electricalappliance.exception.InvalidInputException;
import kz.epam.electricalappliance.validator.screen.ValidatorTV;

public class TV  extends ScreenAppliance {
    private boolean working = false;
    private boolean supportSmartTV;
    private boolean support3D;
    private int refreshRate; //in HZ
    public TV(String companyNameIn,String modelNameIn, int yearOfProductionIn, double weightIn, int powerConsumptionIn, double displayDiagonalIn, int screenResolutionFirstIntIn, int screenResolutionSecondIntIn,
              boolean supportSmartTV,boolean support3D, int refreshRate) throws InvalidInputException {
        super(companyNameIn,modelNameIn,yearOfProductionIn,weightIn,powerConsumptionIn,displayDiagonalIn,screenResolutionFirstIntIn,screenResolutionSecondIntIn);
        if(ValidatorTV.validateTV(refreshRate)){
            this.support3D = support3D;
            this.refreshRate = refreshRate;
            this.supportSmartTV = supportSmartTV;
        }else{
            throw new InvalidInputException("Invalid input for TV");
        }
    }
    public String toString(){
        StringBuilder result = new StringBuilder();
        result.append(super.toString());
        if(supportSmartTV){
            result.append("SmartTV:Yes\n");
        }else{
            result.append("SmartTV:No\n");
        }
        if(support3D){
            result.append("3D:Yes\n");
        }else{
            result.append("3D:No\n");
        }
        result.append("Refresh Rate:"+refreshRate+"\n");
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
