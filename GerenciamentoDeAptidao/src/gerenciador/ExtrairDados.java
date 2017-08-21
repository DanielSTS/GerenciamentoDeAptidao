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
	
	private int contAlunos = -1;
	
	public ArrayList<Aluno> getAlunos() {
		return alunos;
	}
	
	public ExtrairDados() {

	
	}
	//adicionar os alunos num array
	public void criaAlunos(String nomeAluno){
		
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
		
			//Loop para obter informações da planilha de cada aluno!
			
			while (ira == null){
			
				aba = planilha.getSheet(contadorAbas);
				Cell[] linha = aba.getRow(0);
				
				//Adiciona o nome do aluno
				if(linha[0].getContents().equals("Nome:")){
					nome = linha[1];
					alunos.get(this.contAlunos).setNome(nome.getContents());
					contadorAbas++;
					
				//Adiciona a Matrícula do Aluno	
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
					
				// Adiciona as disciplinas e notas do Aluno 
				//Double.valueOf(linha2[5].getContents()).doubleValue()  Transforma de String em Double
				//variavel "aux" para o loop de disciplinas e notas 
				}else if(linha[0].getContents().equals("Período Letivo")){
					while(aux<5){
						Cell[] linha2 = aba.getRow(aux);
						alunos.get(this.contAlunos).setDisciplina(linha2[3].getContents());
						alunos.get(this.contAlunos).setNotas(Double.valueOf(linha2[5].getContents()).doubleValue());
						aux++;
					contadorAbas++;
					}
					
				}else{
					contadorAbas++;
					}
			}
			
			
			
			
			System.out.println(alunos.get(this.contAlunos).getNome());
			System.out.println(alunos.get(this.contAlunos).getMatricula());
			System.out.println(alunos.get(this.contAlunos).getIra());
			alunos.get(this.contAlunos).imprimirNotaseDisciplinas();
			
			
			} catch (Exception e) {
			e.printStackTrace();
			}
		
		
	}
	
	
}


