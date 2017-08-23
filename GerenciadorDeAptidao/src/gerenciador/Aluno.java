package gerenciador;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;


public class Aluno {
	private ArrayList<String> disciplinas = new ArrayList<String>();
	private ArrayList<Double> notas = new ArrayList<Double> ();
	private String nome, matricula, ira;
	private int contDisciplina = 0,contNotas = 0;
	
	
	public Aluno() {
		
	}
	
	public void substituirNota(double nota){
		this.notas.set(contNotas -1, nota);
	}
	public void imprimirNotaseDisciplinas(){
		for (int i = 0; i<contDisciplina;i++){
			System.out.println(disciplinas.get(i));
			System.out.println(notas.get(i));
		}
	}
	
	public ArrayList<String>  getDisciplina(){
		return this.disciplinas;
	}

	public void setNotas(double notas){
		this.notas.add(notas);
		contNotas++;
	}
	public void setDisciplina(String disciplina){
		this.disciplinas.add(disciplina);
		contDisciplina++;
	}
	
	public String getNome() {
		return nome;
	}


	public void setNome(String nome) {
		this.nome = nome;
	}


	public String getMatricula() {
		return matricula;
	}


	public void setMatricula(String matricula) {
		this.matricula = matricula;
	}


	public String getIra() {
		return ira;
	}


	public void setIra(String ira) {
		this.ira = ira;
	}


}
