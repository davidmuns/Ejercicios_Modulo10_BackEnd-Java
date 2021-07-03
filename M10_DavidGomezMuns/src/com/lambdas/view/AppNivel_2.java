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
		
		//longitud (de m�s curta a m�s llarga) 
		System.out.println("Array ordenado por longitud cadena (menor a mayor)\n*************");
		System.out.println(Arrays.toString(longitudCadeanMenorMayor(cadenas)) + "\n");
		
		//longitud inversa (de  m�s llarga a m�s curta)
		System.out.println("Array ordenado por longitud cadena (mayor a menor)\n*************");
		System.out.println(Arrays.toString(longitudCadeanMayorMenor(cadenas)) + "\n");
		
		//alfab�ticament pel primer car�cter (Nota: charAt (0) retorna el codi num�ric del primer car�cter) 
		System.out.println("Array ordenado alfabeticamente\n*************");
		System.out.println(Arrays.toString(ordenarAlfabeticamente(cadenas)) + "\n");
		
		//Les cadenes que contenen "e" primer, tota la resta en segon lloc. 
		//De moment, poseu el codi directament a la lambda.
		System.out.println("Array odenado por cadenas que conienen la letra 'e' en primer lugar\n*************");
		ILetraE_Lambda letraE = inputArray -> {
			 String temp; 
		        int startIndex; // Variable que almacena el �ndice del array en cada iteraci�n
		        
		        // Algoritmo de ordenamiento por selecci�n
		        for (int i = 0; i < inputArray.length; i++) {
		          startIndex = i; // Almacenar �ndice en cada iteraci�n
		          for (int j = i + 1; j < inputArray.length; j++) { // Comparar todos los elementos en cada iteraci�n
		                if ( inputArray[j].contains("e")) { 
		                    startIndex = j;
		                }
		            }
		          // Intercambiar posiciones despu�s de comparar los elementos
		          temp = inputArray[i];
		          inputArray[i] = inputArray[startIndex];
		          inputArray[startIndex] = temp;
		        }      
		        return inputArray;
		};
		System.out.println(Arrays.toString(letraE.devolver(cadenas)) + "\n");
		
		//Modifica tots els elements de la matriu per canviar els caracters �a� a �4�
		System.out.println("Modificar elemnetos qe contienen letra 'a' por '4'\n*************");
		System.out.println(Arrays.toString(cambiarApor4(cadenas)) + "\n");
		
		//Mostra nom�s els elements que siguin 100% numerics. (tot i que estigui guardats com strings)
		System.out.println("Mostar solo elementos num�ricos\n*************");
		System.out.println(Arrays.toString(devolverValoresNumericos(cadenas)) + "\n");
		
		/*
		 * Crea una Functional Interface que continga un m�tode abstracte operacio (),
		 * que retorne un valor float; injecta a la interf�cie creada mitjan�ant una
		 * lambda el cos del m�tode, de manera que pugis transformar la operaci� a una
		 * suma, resta, multiplicaci� i divisio.
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
		System.out.println("Multiplicaci�n: " + mult.operacion(valor1, valor2));
		System.out.println("Divisi�n: " + div.operacion(valor1, valor2));

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
        int startIndex; // Variable que almacena el �ndice del array en cada iteraci�n
        
        // Algoritmo de ordenamiento por selecci�n
        for (int i = 0; i < array.length; i++) {
          startIndex = i; // Almacenar �ndice en cada iteraci�n
          for (int j = i + 1; j < array.length; j++) { // Comparar longitud elementos en cada iteraci�n
                if ( array[j].length() > array[startIndex].length()) { 
                    startIndex = j;
                }
            }
          // Intercambiar posiciones despu�s de comparar los elementos
          temp = array[i];
          array[i] = array[startIndex];
          array[startIndex] = temp;
        }
        return array;
       
    } 
    
    public static String[] longitudCadeanMenorMayor(String [] array){
        String temp; // Variable temporal
        int startIndex; // Variable que almacena el �ndice del array en cada iteraci�n
        
        // Algoritmo de ordenamiento por selecci�n
        for (int i = 0; i < array.length; i++) {
          startIndex = i; // Almacenar �ndice en cada iteraci�n
          for (int j = i + 1; j < array.length; j++) { // Comparar longitud elementos en cada iteraci�n
                if ( array[j].length() < array[startIndex].length()) { 
                    startIndex = j;
                }
            }
          // Intercambiar posiciones despu�s de comparar los elementos
          temp = array[i];
          array[i] = array[startIndex];
          array[startIndex] = temp;
        }
        return array;
       
    }

}
