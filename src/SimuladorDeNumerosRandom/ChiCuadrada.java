package SimuladorDeNumerosRandom;

import org.apache.commons.math3.analysis.UnivariateFunction;
import org.apache.commons.math3.analysis.UnivariateFunction;
import org.apache.commons.math3.analysis.integration.SimpsonIntegrator;
import org.apache.commons.math3.analysis.integration.UnivariateIntegrator;
import org.apache.commons.math3.distribution.ChiSquaredDistribution;

import java.util.ArrayList;
import java.util.*;

public class ChiCuadrada {
	
	ArrayList<Double> eis = new ArrayList<Double>();
	static ArrayList<Double> observables;
	
	public ChiCuadrada(ArrayList<Double> numbers) {
		this.observables = numbers;
	}
	
	public boolean checkIfLessThanFive( ArrayList<Integer> cleanFreqAbs ) {
		boolean lessThanFive = true;
		for(int i = 0; i < cleanFreqAbs.size(); i++) {
			if(cleanFreqAbs.get(i) < 5) {
				lessThanFive = true;
			}else {
				lessThanFive = false;
			}
		}
		return lessThanFive;
	}
	
	public void OrderNumbers() {
		Collections.sort(this.observables);
	}
	
	public boolean acceptNullHypothesis(double chiSum, double chiTabla) {	
		if(chiSum <= chiTabla) return true;
		else return false;
	}
	
	public double chiCuadradaSum(ArrayList<Double> eis, ArrayList<Integer> cleanFreqAbs ) {
		double sum = 0;
		for(int i = 0; i< cleanFreqAbs.size(); i++) {
			sum = sum + (Math.pow(cleanFreqAbs.get(i) - eis.get(i), 2))/ eis.get(i);
		}
		return sum;
	}
	
	public ArrayList<Integer> cleanFreqAbs(ArrayList<Integer> freqAbs, Integer k){
		ArrayList<Integer> cleanfreqAbs = new ArrayList<Integer>();
		double ei = observables.size()/k;
		double totalEi = 0;
		
		for(int i = 0; i< freqAbs.size(); i++) {
			if(freqAbs.get(i) < 5 && i != freqAbs.size()-1) {
				int newnum = freqAbs.get(i) + freqAbs.get(i+1);
				freqAbs.remove(i);
				cleanfreqAbs.add(newnum);
				totalEi = totalEi + ei * 2;
				eis.add(ei*2);
			}else if(freqAbs.get(freqAbs.size()-1) < 5){
				System.out.println("freqAbs" + freqAbs.get(i));	
				int newnum = freqAbs.get(i) + freqAbs.get(i-1);
				
				cleanfreqAbs.add(freqAbs.get(i));
				totalEi = totalEi + ei;
				eis.add(ei);
			}else {
				cleanfreqAbs.add(freqAbs.get(i));
				totalEi = totalEi + ei;
				eis.add(ei);
			}
		}
		 System.out.println("clean freq abs" + cleanfreqAbs);	
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
	
	public double CalcularValores() {
		 OrderNumbers();
		 
		 for (int i = 0; i < this.observables.size(); i++) {
	            System.out.println(this.observables.get(i));
	        }
		 Double rango = this.observables.get(this.observables.size()-1) - this.observables.get(0);
	     Double rangoRound = Math.floor(rango*100.0)/100.0;

	     Double tempK = 1 + 3.322*Math.log10(this.observables.size());
	     int k = (int) Math.ceil(tempK);

	     Double clase = rangoRound/k;
	     Double claseRound = Math.ceil(clase*100.0)/100.0;
	     System.out.println("k" + k);	
	     System.out.println("clase Round" + claseRound);	
	     ArrayList<ArrayList<Double>> ranges = new ArrayList<ArrayList<Double>>(k);
	     ArrayList<Integer> a = findFreq(claseRound);
	     ArrayList<Integer> b = cleanFreqAbs(a, k);
	     
	     /*while(checkIfLessThanFive(b)) {
	    	 b = cleanFreqAbs(a, k);
	     }*/
	    
	     double chiSum = chiCuadradaSum(this.eis, b);
	
	     
	     return chiSum;
	}
	

	public static double ChiTable(int n, double error) {
        ChiSquaredDistribution CHD = new ChiSquaredDistribution(n);
        return CHD.inverseCumulativeProbability(1-error);
    }
	


}
