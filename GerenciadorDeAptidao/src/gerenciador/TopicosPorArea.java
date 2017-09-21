package gerenciador;

import java.util.ArrayList;

public class TopicosPorArea {
	private Disciplina disciplinas[];
	private ArrayList<String> alunos = new ArrayList<String>();
	private ArrayList<Double> notas = new ArrayList<Double> ();
	private int contAlunos = 0, contNotas = 0;
	private String nome;
	
	//Criar um vetor com os mesmos valores do ArrayList e depois ordenar
	public void rankingAlunos() {
		double auxNotas = 0;
		String auxAlunos;
		for(int i = 0; i < this.contNotas; i++) {
			for(int j = 0; j < this.contNotas - 1; j++) {
				if(this.notas.get(j) > this.notas.get(j+1)) {
					auxNotas = this.notas.get(j);
					auxAlunos = this.alunos.get(j);
					
					this.notas.set(j, this.notas.get(j+1));
					this.alunos.set(j, this.alunos.get(j+1));
					
					this.notas.set(j+1, auxNotas);
					this.alunos.set(j+1, auxAlunos);
				}
			}
		}
	}
	
	public void imprimeDados(){
		rankingAlunos();
		int posicao = 1;
		for (int i = contAlunos-1; i >= 0; i--){
			System.out.println(posicao+"ºLugar");
			System.out.println(this.alunos.get(i));
			System.out.printf("%.2f\n\n", (this.notas.get(i)));
			posicao++;
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
