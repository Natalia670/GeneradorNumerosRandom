import java.util.*;
import org.apache.spark.mllib.stat.Statistics;

public class Kolmo{
    public static void main(String [] args){
        // Recibimos una lista de observables
        // Ordenamos la lista
        ArrayList<Double> observables = new ArrayList<Double>();
        observables.add(0.018);
        observables.add(0.037);
        observables.add(0.156);
        observables.add(0.191);
        observables.add(0.213);
        observables.add(0.233);
        observables.add(0.281);
        observables.add(0.383);
        observables.add(0.392);
        observables.add(0.408);
        observables.add(0.411);
        observables.add(0.434);
        observables.add(0.469);
        observables.add(0.541);
        observables.add(0.553);
        observables.add(0.575);
        observables.add(0.598);
        observables.add(0.668);
        observables.add(0.671);
        observables.add(0.719);
        observables.add(0.730);
        observables.add(0.770);
        observables.add(0.771);
        observables.add(0.791);
        observables.add(0.819);
        observables.add(0.826);
        observables.add(0.894);
        observables.add(0.914);
        observables.add(0.984);
        observables.add(0.995);

        ArrayList<Integer> iList = new ArrayList<Integer>();
        for(int i = 0; i < observables.size(); i++){
            iList.add(i+1);
        }

        ArrayList<Double> iN = new ArrayList<Double>();
        for(int i = 0; i < observables.size(); i++){
            Double temp = (double) iList.get(i) / (double) observables.size();
            Double tempRound = Math.round(temp*100000.0)/100000.0;
            iN.add(tempRound);
        }
        /*for(int i = 0; i < iN.size(); i++){
            System.out.println(iN.get(i));
        }*/

        ArrayList<Double> absINRi = new ArrayList<Double>();
        for(int i = 0; i < observables.size(); i++){
            Double temp = Math.abs(iN.get(i) - observables.get(i));
            Double tempRound = Math.round(temp*100000.0)/100000.0;
            absINRi.add(tempRound);
        }
        Double tempDMas = Collections.max(absINRi);
        Double dMas = Math.round(tempDMas*10000.0)/10000.0;
        System.out.println("D+: " + dMas);
        /*for(int i = 0; i < absINRi.size(); i++){
            System.out.println(absINRi.get(i));
        }*/
        ArrayList<Double> riIN = new ArrayList<Double>();
        for(int i = 0; i < observables.size(); i++){
            Double resta = iList.get(i) - 1.00;
            Double division = resta / (double) observables.size();
            Double temp = Math.abs(observables.get(i) - division);
            Double tempRound = Math.round(temp*10000.0)/10000.0;
            riIN.add(tempRound);
        }
        Double tempDMenos = Collections.max(riIN);
        Double dMenos = Math.round(tempDMenos*10000.0)/10000.0;
        System.out.println("D-: " + dMenos);
        /*for(int i = 0; i < riIN.size(); i++){
            System.out.println(riIN.get(i));
        }*/
        Double d = maxD(dMas, dMenos);
        System.out.println("D: " + d);
    }

    public static Double maxD(Double dMas, Double dMenos){
        if(dMas > dMenos) return dMas;
        else return dMenos;
    }
}