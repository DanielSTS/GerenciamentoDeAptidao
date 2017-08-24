package gerenciador;

import java.util.ArrayList;
import java.util.Arrays;

public class Disciplina {
	
	private ArrayList<String> alunos = new ArrayList<String>();
	private ArrayList<Double> notas = new ArrayList<Double> ();
	private int contAlunos = 0,contNotas = 0;
	private String nome;
	
	
	public void imprimeDados(){
		for (int i = 0; i<contAlunos;i++){
			System.out.println(this.alunos.get(i));
			System.out.println(this.notas.get(i));
		}
	}
	
	public ArrayList<String>  getAlunos(){
		return this.alunos;
	}
	
	public void setAluno(String Aluno){
		this.alunos.add(Aluno);
		contAlunos++;
	}
	
	public void setNota(Double nota){
		this.notas.add(nota);
		contNotas++;
	}
	
	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public Disciplina() {
		
	}
	
	
}
