package gerenciador;

import java.util.ArrayList;

public class TopicosPorArea {
	private Disciplina disciplinas[];
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
	
	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
		
	}

	public void setAluno(String aluno){
		this.alunos.add(aluno);
		this.contAlunos++;
	}
	public void setNota(double nota){
		this.notas.add(nota);
		this.contNotas++;
	}
	public void TopicosPorArea(){
		
	}
	
	public void melhorAluno(){
		
	
		
	}

}
