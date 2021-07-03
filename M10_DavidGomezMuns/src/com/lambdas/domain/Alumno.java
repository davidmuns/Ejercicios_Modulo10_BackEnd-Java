package com.lambdas.domain;

import java.util.Comparator;



public class Alumno implements Comparator<Alumno>{
	private String nombre, curso;
	private int edad, nota;
	
	public Alumno(String nombre, String curso, int edad, int nota) {
		super();
		this.nombre = nombre;
		this.curso = curso;
		this.edad = edad;
		this.nota = nota;
	}

	public String getNombre() {
		return nombre;
	}

	public String getCurso() {
		return curso;
	}

	public int getEdad() {
		return edad;
	}

	public int getNota() {
		return nota;
	}

	@Override
	public String toString() {
		return "Alumno [nombre=" + nombre + ", curso=" + curso + ", edad=" + edad + ", nota=" + nota + "]";
	}

	@Override
	public int compare(Alumno a1, Alumno a2) {
		
		return a1.getNombre().compareTo(a2.getNombre());
	}
	
	
	
}