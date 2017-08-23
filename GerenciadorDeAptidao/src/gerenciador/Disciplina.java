package gerenciador;

import java.util.ArrayList;
import java.util.Arrays;

public class Disciplina {
	
	private ArrayList<Aluno> alunos = new ArrayList<Aluno> ();
	private int quantAlunos = 0;
	private String nome;
	
	
	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public Disciplina() {
		
	}
	
	//Recebe o array de alunos e procura alunos matriculados na disciplina
	
	public int getQuantAlunos(){
		
		return this.quantAlunos;
	}
	
	public void adicionaAluno(Aluno aluno){
		this.alunos.add(aluno);
	}
}
