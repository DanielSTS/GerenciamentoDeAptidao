package gerenciador;

import java.io.File;
import jxl.Sheet;
import jxl.Workbook;
import jxl.Cell;

 
public class ExtrairDados {
	private Workbook planilha; // objeto que receberÃ¡ um instancia da planilha estudada

	private Sheet aba; // objeto que serÃ¡ a aba

	private File arquivo; // arquivo .xls que serÃ¡ lido
	
	private Aluno alunos[];
	private int i = 0;
	
	public ExtrairDados() {

	
	}
	//adicionar os alunos num array
	public void criaAlunos(String aluno){
		Aluno aluno7 = new Aluno();
		alunos[i] = aluno7;
		Cell ira = null, nome = null;
		try {

			arquivo = new File(aluno+".xls");

			// instancia a planilha

			planilha = Workbook.getWorkbook(arquivo);

			//Obendo as Abas da planilha

			Sheet[] abas = planilha.getSheets();

			aba = planilha.getSheet(9); // pega a decima aba, ou seja, aba de indice 9.
			Cell[] linha = aba.getRow(1); // pega a segunda linha, ou seja, linhas de indice 1.
			ira = linha[0];
			aluno1.setIra(ira.getContents());
			
			aba = planilha.getSheet(1);
			Cell[] linha2 = aba.getRow(0);
			nome = linha2[1];
			aluno1.setNome(nome.getContents());
			/*for para criar array de disciplinas e notas,analisar se a disciplina foi paga mais de uma vez e buscar melhor nota*/
			for
			
			System.out.println(aluno1.getNome());
			System.out.println(aluno1.getIra());
			

			} catch (Exception e) {
			e.printStackTrace();
			}
		
		
		
	}
	
	
	public String getIRAExcel(){
		Cell ira = null;
		try {

			arquivo = new File("Daniel.xls");

			// instancia a planilha

			planilha = Workbook.getWorkbook(arquivo);

			//Obendo as Abas da planilha

			Sheet[] abas = planilha.getSheets();

			aba = planilha.getSheet(9); // pega a decima aba, ou seja, aba de indice 9.

			Cell[] linha = aba.getRow(1); // pega a segunda linha, ou seja, linhas de indice 1.
			
			ira = linha[0];

			} catch (Exception e) {
			e.printStackTrace();
			}
		return ira.getContents();
			
	}
}


