package gerenciador;

import java.io.File;
import jxl.Sheet;
import jxl.Workbook;
import jxl.Cell;

 
public class ExtrairDados {
	private Workbook planilha; // objeto que receberÃ¡ um instancia da planilha estudada

	private Sheet aba; // objeto que serÃ¡ a aba

	private File arquivo; // arquivo .xls que serÃ¡ lido

	
	public ExtrairDados() {

	
	}
	public String getIRAExcel(){
		Cell ira = null;
		try {

			arquivo = new File("HistoricoParcialIFPB.xls");

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


