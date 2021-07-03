package com.lambdas.view;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import com.lambdas.interfaces.*;

public class AppNivel_1 {
		
	public static void main(String[] args) {
		
		
		//************ NIVEL 1 *************		
		/* 
		 * Fase 1.1 
		 * *********
		 * Tenint una llista de cadenes de noms propis, escriu un mètode que
		 * retorne una llista de totes les cadenes que comencen amb la lletra 'a'
		 * (mayuscula) i tenen exactament 3 lletres. Imprimeix el resultat.
		 */
		System.out.println("NIVEL 1. FASE 1.1\n*********");
		List<String> nombresPropios = Arrays.asList("Ana", "Pedro", "Antonio", "Eduardo", "Alejandro", "Alberto", "Ada", "Pol", "Susana");
		System.out.println(aMayusculaTresLetras(nombresPropios) + "\n");
		
		/*
		 * Fase 1.2 
		 * ********
		 * Escriu un mètode que retorne una cadena separada per comes basada en
		 * una llista d’Integers. Cada element hauria d'anar precedit per la lletra "e"
		 * si el nombre és parell, i precedit de la lletra "o" si el nombre és imparell.
		 * Per exemple, si la llista d'entrada és (3,44), la sortida hauria de ser
		 * "o3, e44". Imprimeix el resultat.
		 */
		System.out.println("NIVEL 1. FASE 1.2\n*********");
		List<Integer> numeros = Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8, 9);
		System.out.println(paresImpares(numeros) + "\n");
		
		/* Fase 1.3
		 * ********
		 * Tenint una llista de Strings, escriu un mètode que retorne una llista de
		 * totes les cadenes que continguen la lletra ‘o’ i imprimeix el resultat.
		 */ 
		System.out.println("NIVEL 1. FASE 1.3\n*********");
		System.out.println(palabrasConLetraO(nombresPropios) + "\n");
		
		/* Fase 1.4
		 * ********
		 * Has de fer el mateix que en el punt anterior, però retornant una llista que
		 * incloga els elements amb més de 5 lletres. Imprimeix el resultat.
		 */
		System.out.println("NIVEL 1. FASE 1.4\n*********");
		System.out.println(palabrasConLetraO_MayorCincoLetras(nombresPropios) + "\n");
		
		/* Fase 1.5
		 * ********
		 * Crea una llista amb els noms dels mesos de l’any. Imprimeix tots els
		 * elements de la llista amb una lambda.
		 */ 
		System.out.println("NIVEL 1. FASE 1.5\n*********");
		List<String> meses = Arrays.asList("Enero", "Febrero", "Marzo", "Abril", "Mayo", "Junio", "Julio", "Agosto", "Septiembre", "Octubre", "Noviembre", "Diciembre");
		meses.forEach(mes -> System.out.println(mes));
		System.out.println();
	
		/* Fase 1.6
		 * ********
		 * Has de fer la mateixa impressió del punt anterior però fent-ho mitjançant
		 * method reference.
		 */
		System.out.println("NIVEL 1. FASE 1.6\n*********");
		meses.forEach(System.out::println);
		System.out.println();
		
		/*
		 * Fase 2
		 ********
		 *Crea una Functional Interface que continga un mètode abstracte getPiValue (), 
		 *que retorna un valor double; en una altra classe, instancie la interfície i assigneu-li mitjançant 
		 *una lambda el valor 3.1415. Invoca el mètode getPiValue de la instància d'interfície i imprimeix el resultat. 
		 */		
		System.out.println("NIVEL 1. FASE 2\n*********");
		IValorPi valorPi = () -> 3.1415;
		System.out.println(valorPi.getPiValue() + "\n");
		
		/*
		 * Fase 3
		 ********
		 *Crea una Functional Interface que continga un mètode abstracte reverse (), 
		 *que retorne un valor String; en una altra classe, injecta a la interfície creada mitjançant 
		 *una lambda el cos del mètode, de manera que torne la mateixa cadena que rep com a paràmetre 
		 *però a l'inrevés. Invoca la instància de la interfície passant-li una cadena i comprovant el resultat. 
		 */
		System.out.println("NIVEL 1. FASE 3\n*********");
		IReverseString cadena  = input -> {
			String output = "";
			for(int i = input.length()-1; i >= 0; i--)
	            output += input.charAt(i);
			return output;
		};
		printLambda(cadena, "analleva al oso la avell anA");
		
	}
	
	
	//Método fase 1.1
	public static List<String> aMayusculaTresLetras(List<String> lista) {
		List<String> subLista = new ArrayList<>();
		for (String nombre : lista) 
			if (nombre.startsWith("A") && nombre.length() == 3) subLista.add(nombre);
		return subLista;
	}
	//Método fase 1.2
	public static List<String> paresImpares(List<Integer> nums) {
		List<String> subLista = new ArrayList<>();
		for(Integer num: nums) 
			if(num % 2 == 0) subLista.add("e" + num);
				else subLista.add("o" + num);
		return subLista;
	}
	//Método fase 1.3
	public static List<String> palabrasConLetraO(List<String> list) {
		List<String> subLista = new ArrayList<>();
		for (int i = 0; i < list.size(); i++) 
			if (list.get(i).contains("o")) subLista.add(list.get(i));
		return subLista;
	}
	//Método fase 1.4
	public static List<String> palabrasConLetraO_MayorCincoLetras(List<String> list) {
		List<String> subLista = new ArrayList<>();
		for (int i = 0; i < list.size(); i++) 
			if (list.get(i).contains("o") && list.get(i).length() > 5) 
				subLista.add(list.get(i));
		return subLista;
	}
	//Método fase 3
	public static void printLambda(IReverseString cadena1, String cadena2) {
		System.out.println(cadena1.reverse(cadena2));
	}
}

