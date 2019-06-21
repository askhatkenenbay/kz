package kz.epam.electricalappliance.action;

import kz.epam.electricalappliance.entity.ElectricalAppliance;



public class ElectricalApplianceMath {
    public static double calculatePowerConsuption(int size, ElectricalAppliance[] applianceList){
       int result = 0;
        for(int i =0;i<size;i++){
            result+=applianceList[i].getPowerConsumption();
        }
        return result;
    }
    //uses Randomized Quicksort which sort according to power consuption
    public static void sortByPowerConsuption(int size, ElectricalAppliance[] applianceList){
        randomizedQuicksort(applianceList,0,size-1);
    }

    /**
     * @param array 		input array which will be sorted
     * @param startIndex	starting index
     * @param endIndex		ending index
     * to sort whole array pass startIndex=0 && endIndex=array.length-1
     * running time average(nlgn)
     */
   private  static void randomizedQuicksort(ElectricalAppliance[] array, int startIndex, int endIndex) {
        if(startIndex<endIndex) {
            int q = randomizedPartition(array, startIndex, endIndex);
            randomizedQuicksort(array,startIndex,q-1);
            randomizedQuicksort(array,q+1,endIndex);
        }

    }
    private static int randomizedPartition(ElectricalAppliance[] arrayIn, int startIndex, int endIndex) {
        int i = (int)(Math.random()*((endIndex-startIndex)+1))+startIndex;
        ElectricalAppliance temp = arrayIn[endIndex];
        arrayIn[endIndex] = arrayIn[i];
        arrayIn[i] = temp;
        return  partition(arrayIn,startIndex,endIndex);
    }
    private static int partition(ElectricalAppliance[] arrayIn, int startIndex, int endIndex) {
        int x = arrayIn[endIndex].getPowerConsumption();
        int i = startIndex-1;
        ElectricalAppliance temp;
        for(int j=startIndex;j<endIndex;j++) {
            if(arrayIn[j].getPowerConsumption()<=x) {
                i++;
                temp =arrayIn[j];
                arrayIn[j]=arrayIn[i];
                arrayIn[i]=temp;
            }
        }
        temp =arrayIn[i+1];
        arrayIn[i+1]=arrayIn[endIndex];
        arrayIn[endIndex]=temp;
        return i+1;
    }
    private ElectricalApplianceMath(){
        throw new IllegalStateException("Utility Class");
    }
}
