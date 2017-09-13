package gerenciador;

import java.io.File;

import jxl.Sheet; 
import jxl.Workbook;
import jxl.Cell;
import java.util.ArrayList;
import java.util.Arrays;
import java.text.NumberFormat;

 
public class ExtrairDados {
	private Workbook planilha; // objeto que recebera um instancia da planilha estudada

	private Sheet aba; // objeto que sera a aba

	private File arquivo; // arquivo .xls que sera lido
	
	private ArrayList<Aluno> alunos = new ArrayList<Aluno> ();
	 
	private ArrayList<Disciplina> disciplinas = new ArrayList<Disciplina> ();
	
	private ArrayList<String> nomesdisciplinas = new ArrayList<String>();
	
	private ArrayList<TopicosPorArea> TopicosPorArea = new ArrayList<TopicosPorArea>();

	private ArrayList<String> nomeTopicosPorArea = new ArrayList<String>();
	
	private int contAlunos = -1,contDisciplinas = -1,contTopicosPorArea = -1;
	
	public ArrayList<Aluno> getAlunos() {
		return alunos;
	}
	
	public ExtrairDados() {

	
	}
	//adicionar os alunos num array
	public void criaAlunos(String nomeAluno){
		
		String ultimaDisciplina = null;
		double ultimaNota = 0;
		
		int contadorAbas = 0, aux = 2;
		
		this.alunos.add(new Aluno());
		this.contAlunos++;
		
		Cell ira = null, nome = null, matricula = null;
		
		try {
			
			arquivo = new File(nomeAluno+".xls");

			// instanciando a planilha

			planilha = Workbook.getWorkbook(arquivo);
		
			//Obtendo as Abas da planilha

			Sheet[] abas = planilha.getSheets();
		
			//Loop para obter informa��es da planilha de cada aluno!
			
			while (ira == null){
			
				aba = planilha.getSheet(contadorAbas);
				Cell[] linha = aba.getRow(0);
				
				//Adiciona o nome do aluno
				if(linha[0].getContents().equals("Nome:")){
					nome = linha[1];
					alunos.get(this.contAlunos).setNome(nome.getContents());
					contadorAbas++;
					
				//Adiciona a Matricula do Aluno	
				}else if(linha[0].getContents().trim().substring(0, 9).equals("Dados Aca")){
					linha = aba.getRow(1);
					matricula = linha[0];
					alunos.get(this.contAlunos).setMatricula(matricula.getContents().substring(29, 41));
					contadorAbas++;
					
				//Adiciona o Coeficiente de Rendimento do Aluno	
				}else if(linha[0].getContents().equals("Coeficiente de Rendimento")){
					linha = aba.getRow(1);
					ira = linha[0];
					alunos.get(this.contAlunos).setIra(ira.getContents());
					contadorAbas++;
					
				/* Adiciona as disciplinas e notas do Aluno 
				   Double.valueOf(linha2[5].getContents()).doubleValue()  Transforma de String em Double
				   variavel "aux" para o loop de disciplinas e notas */
					
					/*Adiciona as notas e disiplinas, tratando os casos em que o aluno pagou mais de uma vez a mesma disciplina  */
				}else if(linha[0].getContents().equals("Per�odo Letivo")){
					
					while(aux<21){
						Cell[] linha2 = aba.getRow(aux);
						
						
						
						if((linha2[3].getContents()).equals(ultimaDisciplina)){
							
							if(!(linha2[5].getContents().equals("-")) && Double.valueOf(linha2[5].getContents()).doubleValue() > ultimaNota){
								
								
								alunos.get(this.contAlunos).substituirNota(Double.valueOf(linha2[5].getContents()).doubleValue());
								
								ultimaDisciplina = linha2[3].getContents();
								ultimaNota = Double.valueOf(linha2[5].getContents()).doubleValue();
								aux++;
								criarDisciplinas(alunos.get(this.contAlunos), ultimaDisciplina,ultimaNota);
								
							}
						
						}else if(!linha2[5].getContents().equals("-")){
						
						alunos.get(this.contAlunos).setDisciplina(linha2[3].getContents());
						alunos.get(this.contAlunos).setNotas(Double.valueOf(linha2[5].getContents()).doubleValue());
						ultimaDisciplina = linha2[3].getContents();
						ultimaNota = Double.valueOf(linha2[5].getContents()).doubleValue();
						aux++;
						criarDisciplinas(alunos.get(this.contAlunos), ultimaDisciplina,ultimaNota);
						
						}else{
							aux++;
							
						}
						
					}
					
					contadorAbas++;
				} 
				else{
					contadorAbas++;
				} 
			
			}
			
			
			/*System.out.println(alunos.get(this.contAlunos).getNome());
			System.out.println(alunos.get(this.contAlunos).getMatricula());
			System.out.println(alunos.get(this.contAlunos).getIra());
			alunos.get(this.contAlunos).imprimirNotaseDisciplinas();
			//disciplinas.get(this.contDisciplinas).imprimeDados();*/
			
			
			
		} catch (Exception e) {
			e.printStackTrace();
			}
		
		
	}
	
	//Cria as disciplinas analisando se j� existem, adiciona alunos e notas em cada
	public void criarDisciplinas(Aluno nomeAluno,String nomeDisciplina, double notaAluno ){
		
	
		if(this.nomesdisciplinas.indexOf(nomeDisciplina) == -1){
			this.nomesdisciplinas.add(nomeDisciplina);
			this.disciplinas.add(new Disciplina());
			this.contDisciplinas++;
			this.disciplinas.get(this.contDisciplinas).setNome(nomeDisciplina);
			
		}if (this.disciplinas.get(this.nomesdisciplinas.lastIndexOf(nomeDisciplina)).getAlunos().indexOf(nomeAluno.getNome()) == -1){
			this.disciplinas.get(this.nomesdisciplinas.lastIndexOf(nomeDisciplina)).setAluno(nomeAluno.getNome());
			this.disciplinas.get(this.nomesdisciplinas.lastIndexOf(nomeDisciplina)).setNota(notaAluno);
			
		}
		
	}
	//imprime os alunos cadastrados em determinada disciplina
	public void imprimirTudo(String nomeDisciplina,String nomeTopico){
		int posicao = this.nomesdisciplinas.lastIndexOf(nomeDisciplina);
		this.disciplinas.get(posicao).imprimeDados();
		int posicao2 = this.nomeTopicosPorArea.lastIndexOf(nomeTopico);
		this.TopicosPorArea.get(posicao2).imprimeDados();
	}
	
	public void criarTopico(String nomeTopicosPorArea, String disciplina1, double peso1,String disciplina2, double peso2){
		this.nomeTopicosPorArea.add(nomeTopicosPorArea);
		this.TopicosPorArea.add(new TopicosPorArea());
		this.contTopicosPorArea++;
		this.TopicosPorArea.get(this.contTopicosPorArea).setNome(nomeTopicosPorArea);
		
		for (int i = 0; i<=contAlunos;i++){
			double nota1 = this.alunos.get(i).getNotas().get(this.alunos.get(i).getDisciplina().lastIndexOf(disciplina1))*(peso1);
			double nota2 = this.alunos.get(i).getNotas().get(this.alunos.get(i).getDisciplina().lastIndexOf(disciplina2))*(peso2);
			this.TopicosPorArea.get(this.contTopicosPorArea).setAluno(this.alunos.get(i).getNome());
			this.TopicosPorArea.get(this.contTopicosPorArea).setNota((nota1+nota2)/(peso1+peso2));
		}
		
	}
	
}


