package SimuladorDeNumerosRandom;

import org.apache.commons.math3.analysis.UnivariateFunction;
import org.apache.commons.math3.analysis.UnivariateFunction;
import org.apache.commons.math3.analysis.integration.SimpsonIntegrator;
import org.apache.commons.math3.analysis.integration.UnivariateIntegrator;
import org.apache.commons.math3.distribution.ChiSquaredDistribution;

import java.util.ArrayList;
import java.util.*;

public class ChiCuadrada {
	
	ArrayList<Double> observables;
	public ChiCuadrada(ArrayList<Double> numbers) {
		this.observables = numbers;
	}
	
	public void OrderNumbers() {
		Collections.sort(this.observables);
	}
	
	public ArrayList<Integer> cleanFreqAbs(ArrayList<Integer> freqAbs, Integer k){
		ArrayList<Integer> cleanfreqAbs = new ArrayList<Integer>();
		double ei = observables.size()/k; // se tiene que redondear si queda decimal?
		System.out.println("Ei "+ ei);
		double totalEi = 0;
		
		for(int i = 0; i< freqAbs.size(); i++) {
			if(freqAbs.get(i) < 5 && i != freqAbs.size()-1) {
				int newnum = freqAbs.get(i) + freqAbs.get(i+1);
				freqAbs.remove(i);
				cleanfreqAbs.add(newnum);
				totalEi = totalEi + ei * 2;
			}else if(freqAbs.get(freqAbs.size()-1) < 5){
				int newnum = freqAbs.get(i) + freqAbs.get(i-1);
				cleanfreqAbs.add(freqAbs.get(i));
				totalEi = totalEi + ei;
			}else {
				cleanfreqAbs.add(freqAbs.get(i));
				totalEi = totalEi + ei;
				
			}
		}
		System.out.println("total ei " + totalEi);
		return cleanfreqAbs;
	}
	
	public ArrayList<Integer> findFreq(Double clase) {
		int freq =0;
		double claseOriginal = clase;
		ArrayList<Integer> freqAbs= new ArrayList<Integer>();
		for(int i = 0; i< this.observables.size(); i++) {
			if(this.observables.get(i) < clase) {
				freq++;
				if(i == this.observables.size()-1){
					freqAbs.add(freq);
				}

			}else {
				clase = clase + claseOriginal;
				freqAbs.add(freq);
				freq = 1;
			}

		}
		
		return freqAbs;
	}
	
	public void CalcularValores() {
		 OrderNumbers();
		 
		 for (int i = 0; i < this.observables.size(); i++) {
	            System.out.println(this.observables.get(i));
	        }
		 Double rango = this.observables.get(this.observables.size()-1) - this.observables.get(0);
	     Double rangoRound = Math.floor(rango*100.0)/100.0;
	     System.out.println("Rango: " + rangoRound);
	     Double tempK = 1 + 3.322*Math.log10(this.observables.size());
	     int k = (int) Math.floor(tempK);
	     System.out.println("k: " + k);
	     Double clase = rangoRound/k;
	     Double claseRound = Math.ceil(clase*100.0)/100.0;
	     System.out.println("Clase: " + claseRound);
	     
	     ArrayList<ArrayList<Double>> ranges = new ArrayList<ArrayList<Double>>(k);
	     ArrayList<Integer> a = findFreq(claseRound);
	     ArrayList<Integer> b = cleanFreqAbs(a, k);
	     
	     for (int i = 0; i < a.size(); i++) {
	            System.out.println(a.get(i));
	      }
	     for (int i = 0; i < b.size(); i++) {
	    	 System.out.println("CLEAN");
	            System.out.println(b.get(i));
	      }
	}
	

	public static double ChiTable(int n, double error) {
        ChiSquaredDistribution CHD = new ChiSquaredDistribution(n);
        return CHD.inverseCumulativeProbability(1-error);
    }

}
