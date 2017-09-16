package gerenciador;

import java.util.ArrayList;
import java.util.Random;

public class TesteOrdenação {

	public static ArrayList<Double> insertionSort(ArrayList<Double> array){
		int indice, percorrer = 0;
		double auxiliar = 0, auxiliaTroca = 0;
		
		for(indice = 1; indice < array.size(); indice++) {
			auxiliar = array.get(indice);
			auxiliaTroca = array.get(indice);
			percorrer = indice - 1;
			
			while(auxiliar < array.get(percorrer) && percorrer >= 0) {
				array.add(percorrer+1, array.get(percorrer));
				array.add(percorrer, auxiliaTroca);
				
				percorrer = percorrer - 1;
				if(percorrer < 0) {
					break;
				}
			}
			
			array.add(percorrer+1, auxiliar);
		}
		return array;
	}
	public static void main(String[] args) {
		ArrayList<Double> array = new ArrayList<Double>();
		Random gerador = new Random();
		for(int i = 0; i < 10; i++) {
			array.add(gerador.nextDouble());
		}
		
		for(double valor : array) {
			System.out.println(" "+valor);
		}
		
		insertionSort(array);
		System.out.print("\n");
		for(double valor : array) {
			System.out.println("."+valor);
		}
	}

}
