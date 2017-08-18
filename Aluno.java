package gerenciador;

public class Aluno {
	private Disciplina disciplinas[];
	private String nome, matricula, ira;
	private double iraEspecifico, notas[];
	
	
	public Aluno() {
		
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


	public double getIraEspecifico() {
		return iraEspecifico;
	}


	public void setIraEspecifico(double iraEspecifico) {
		this.iraEspecifico = iraEspecifico;
	}
	
	

}
