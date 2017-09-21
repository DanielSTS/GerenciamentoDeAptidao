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
		for(int i = 1; i < contNotas; i++) {
			double key = this.notas.get(i);
			int j = i;
			
			while((j > 0) && (this.notas.get(j - 1) > key)) {
				this.notas.add(j, this.notas.get(j - 1));
				j -= 1;
				this.notas.add(j, key);
			}
		}
		/*void insertionSort(int lista[], int tamanho){
		int indice, percorrer = 0;
		double auxiliar = 0, auxiliaTroca = 0;
		for(indice = 1; indice < this.contNotas; indice++){
			auxiliar = this.notas.get(indice); //lista[indice];
			auxiliaTroca = this.notas.get(indice);//lista[indice];
			percorrer = indice - 1;
			
			while(auxiliar <= this.notas.get(percorrer) && percorrer >= 0){
				
				this.notas.add(percorrer + 1, this.notas.get(percorrer)); //lista[percorrer];
				this.notas.add(percorrer, auxiliaTroca); //lista[percorrer] = auxiliaTroca;
				percorrer = percorrer - 1;
				
			}
			this.notas.add(percorrer + 1, auxiliar);//lista[percorrer + 1] = auxiliar;
		}*/
		
	}
	
	
	public void imprimeDados(){
		//rankingAlunos();
		for (int i = 0; i < contAlunos; i++){
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
