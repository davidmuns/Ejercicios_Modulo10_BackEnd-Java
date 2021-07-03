package com.lambdas.view;
import java.util.ArrayList;
import java.util.Arrays;

import com.lambdas.interfaces.IOpeeracionesAritmeticas;
import com.lambdas.interfaces.ILetraE_Lambda;

public class AppNivel_2 {

	public static void main(String[] args) {
		
		//************ NIVEL 2 *************		
				
		//Feu una matriu que contingui algunes cadenes de text y numeros.
		System.out.println("NIVEL 2\n*********");
		String[] cadenas = {"Febrero", "Martes", "1", "5", "78", "Alejandro","Palabra", "Sol", "Septiembre", "1512"};
		System.out.println("Array original\n***********");
		System.out.println(Arrays.toString(cadenas) + "\n");
		
		//Ordeneu-lo per:
		
		//longitud (de més curta a més llarga) 
		System.out.println("Array ordenado por longitud cadena (menor a mayor)\n*************");
		System.out.println(Arrays.toString(longitudCadeanMenorMayor(cadenas)) + "\n");
		
		//longitud inversa (de  més llarga a més curta)
		System.out.println("Array ordenado por longitud cadena (mayor a menor)\n*************");
		System.out.println(Arrays.toString(longitudCadeanMayorMenor(cadenas)) + "\n");
		
		//alfabèticament pel primer caràcter (Nota: charAt (0) retorna el codi numèric del primer caràcter) 
		System.out.println("Array ordenado alfabeticamente\n*************");
		System.out.println(Arrays.toString(ordenarAlfabeticamente(cadenas)) + "\n");
		
		//Les cadenes que contenen "e" primer, tota la resta en segon lloc. 
		//De moment, poseu el codi directament a la lambda.
		System.out.println("Array odenado por cadenas que conienen la letra 'e' en primer lugar\n*************");
		ILetraE_Lambda letraE = inputArray -> {
			 String temp; 
		        int startIndex; // Variable que almacena el índice del array en cada iteración
		        
		        // Algoritmo de ordenamiento por selección
		        for (int i = 0; i < inputArray.length; i++) {
		          startIndex = i; // Almacenar índice en cada iteración
		          for (int j = i + 1; j < inputArray.length; j++) { // Comparar todos los elementos en cada iteración
		                if ( inputArray[j].contains("e")) { 
		                    startIndex = j;
		                }
		            }
		          // Intercambiar posiciones después de comparar los elementos
		          temp = inputArray[i];
		          inputArray[i] = inputArray[startIndex];
		          inputArray[startIndex] = temp;
		        }      
		        return inputArray;
		};
		System.out.println(Arrays.toString(letraE.devolver(cadenas)) + "\n");
		
		//Modifica tots els elements de la matriu per canviar els caracters “a” a “4”
		System.out.println("Modificar elemnetos qe contienen letra 'a' por '4'\n*************");
		System.out.println(Arrays.toString(cambiarApor4(cadenas)) + "\n");
		
		//Mostra només els elements que siguin 100% numerics. (tot i que estigui guardats com strings)
		System.out.println("Mostar solo elementos numéricos\n*************");
		System.out.println(Arrays.toString(devolverValoresNumericos(cadenas)) + "\n");
		
		/*
		 * Crea una Functional Interface que continga un mètode abstracte operacio (),
		 * que retorne un valor float; injecta a la interfície creada mitjançant una
		 * lambda el cos del mètode, de manera que pugis transformar la operació a una
		 * suma, resta, multiplicació i divisio.
		 */
		System.out.println("Functional interface \n*************");
		float valor1 = 10.3f;
		float valor2 = 5.3f;
		
		IOpeeracionesAritmeticas suma = (a, b)-> a + b;
		
		IOpeeracionesAritmeticas resta = (a, b)-> a - b;
		
		IOpeeracionesAritmeticas mult = (a, b)-> a * b;
		
		IOpeeracionesAritmeticas div = (a, b)-> {
			if(b == 0) return 0;
			return a / b;
		};
		
		System.out.println("Valor1 = " + valor1 + ", Valor2 = " + valor2);
		System.out.println("Suma: " + suma.operacion(valor1, valor2));
		System.out.println("Resta: " + resta.operacion(valor1, valor2));
		System.out.println("Multiplicación: " + mult.operacion(valor1, valor2));
		System.out.println("División: " + div.operacion(valor1, valor2));

	}
	public static String[] devolverValoresNumericos(String[] array) {
		ArrayList<String> nums = new ArrayList<>();
		
		for(int i = 0; i < array.length; i++) {
			try {
				@SuppressWarnings("unused")
				int num = Integer.parseInt(array[i]);
				nums.add(array[i]);
			} catch (Exception e) {
				
			}
		}
		String[] soloNums = new String[nums.size()];
		for(int i = 0; i < nums.size(); i++) {
			soloNums[i] = nums.get(i);
		}
		
		return soloNums;
	}
	public static String [] cambiarApor4(String[] array) {
		String[] arrayModificado = new String[array.length];
		
		for(int i = 0; i < array.length; i++) {
			
			arrayModificado[i] = array[i].replace("a","4").replace("A", "4");
		}
		
		return arrayModificado;
	}
	
	public static String[] ordenarAlfabeticamente(String[] array) {
		
		Arrays.sort(array);
		
		return array;
	}
    public static String[] longitudCadeanMayorMenor(String [] array){
        String temp; 
        int startIndex; // Variable que almacena el índice del array en cada iteración
        
        // Algoritmo de ordenamiento por selección
        for (int i = 0; i < array.length; i++) {
          startIndex = i; // Almacenar índice en cada iteración
          for (int j = i + 1; j < array.length; j++) { // Comparar longitud elementos en cada iteración
                if ( array[j].length() > array[startIndex].length()) { 
                    startIndex = j;
                }
            }
          // Intercambiar posiciones después de comparar los elementos
          temp = array[i];
          array[i] = array[startIndex];
          array[startIndex] = temp;
        }
        return array;
       
    } 
    
    public static String[] longitudCadeanMenorMayor(String [] array){
        String temp; // Variable temporal
        int startIndex; // Variable que almacena el índice del array en cada iteración
        
        // Algoritmo de ordenamiento por selección
        for (int i = 0; i < array.length; i++) {
          startIndex = i; // Almacenar índice en cada iteración
          for (int j = i + 1; j < array.length; j++) { // Comparar longitud elementos en cada iteración
                if ( array[j].length() < array[startIndex].length()) { 
                    startIndex = j;
                }
            }
          // Intercambiar posiciones después de comparar los elementos
          temp = array[i];
          array[i] = array[startIndex];
          array[startIndex] = temp;
        }
        return array;
       
    }

}
