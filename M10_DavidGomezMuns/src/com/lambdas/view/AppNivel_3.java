package com.lambdas.view;

import java.util.Arrays;
import java.util.List;
import java.util.function.Consumer;
import java.util.function.Predicate;
import com.lambdas.domain.Alumno;

public class AppNivel_3 {

	public static void main(String[] args) {
		
		//************ NIVEL 3 *************
		
		//Crea una clase Alumne que tingui com a propietats: Nom, edat, curs i nota. Omple la llista amb 10 alumnes.
		List<Alumno> listaAlumnos = Arrays.asList(new Alumno("David", "Java", 24, 7),
												  new Alumno("Juan", "PHP", 27, 8),
												  new Alumno("Antonio", "Java", 42, 9),
												  new Alumno("Jesus", "PHP", 21, 4),
												  new Alumno("Susana", "PHP", 52, 9),
												  new Alumno("Silvia", "Java", 18, 5),
												  new Alumno("Alejandro", "PHP", 36, 4),
												  new Alumno("Nuria", "Java", 29, 3),
												  new Alumno("Ana", "PHP", 43, 8),
												  new Alumno("Albert", "Java", 28, 4));
		
		//Mostra per pantalla el nom i l’edat de cada alumne.
		System.out.println("Listar por nombre y edad\n***********************");
		imprimeListaSi(listaAlumnos, alumno -> true, alumno -> System.out.println("Nombre: " + alumno.getNombre() + ", edad: " + alumno.getEdad()));
		System.out.println();
		
		//Filtra la llista per tots els alumnes que el nom comensi per “a”, asigna-ho a
		//un altre llista y mostra per pantalla la nova llista (tot amb lambdas)
		System.out.println("Listar nombres que empiezan por 'a'\n***********************");
		imprimeListaSi(listaAlumnos, alumno -> alumno.getNombre().charAt(0) == 'a' || alumno.getNombre().charAt(0) == 'A', alumno -> System.out.println(alumno));
		System.out.println();
		
		//Filtra y mostra per pantalla els alumnes que tinguin un 5 o mes de nota.
		System.out.println("Listar alumnos con nota igual o superior a 5\n***********************");
		imprimeListaSi(listaAlumnos, alumno -> alumno.getNota() >= 5, alumno -> System.out.println(alumno));
		System.out.println();
		
		//Filtra y mostra per pantalla els alumnes que tinguin un 5 o mes de nota y que no siguin de PHP.
		System.out.println("Listar alumnos con nota igual o superior a 5 y no estudien PHP\n***********************");
		imprimeListaSi(listaAlumnos, alumno -> alumno.getNota() >= 5 && !alumno.getCurso().equalsIgnoreCase("PHP"), alumno -> System.out.println(alumno));
		System.out.println();
		
		//Mostra tots els alumnes que facin JAVA i siguin majors d’edat.
		System.out.println("Listar alumnos que estudian JAVA y son mayores de edad\n***********************");
		imprimeListaSi(listaAlumnos, alumno -> alumno.getCurso().equalsIgnoreCase("Java") && alumno.getEdad() >= 18, alumno -> System.out.println(alumno));
		System.out.println();
	}
	public static void imprimeListaSi(List<Alumno> alumnos, Predicate<Alumno> predicate, Consumer<Alumno> consumer) {
		for(Alumno alumno: alumnos) 
			if(predicate.test(alumno)) consumer.accept(alumno);
	}
}




