import java.util.*;

public class Chi{
    public static void main(String arg[]){
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

        /*for (int i = 0; i < observables.size(); i++) {
            System.out.println(observables.get(i));
        }*/

        Double rango = observables.get(observables.size()-1) - observables.get(0);
        Double rangoRound = Math.floor(rango*100.0)/100.0;
        System.out.println("Rango: " + rangoRound);
        Double tempK = 1 + 3.322*Math.log10(observables.size());
        int k = (int) Math.floor(tempK);
        System.out.println("k: " + k);
        Double clase = rangoRound/k;
        Double claseRound = Math.ceil(clase*100.0)/100.0;
        System.out.println("Clase: " + claseRound);
    }
}