package gerenciador;

import java.io.File;

import jxl.Sheet;
 
import jxl.Workbook;/***
 
* @author J Gabriel Lima
 
*/
 
public class ExemploJXL {
 
private Workbook planilha; // objeto que receberá um instancia da planilha estudada
 
private Sheet aba; // objeto que será a aba
 
private File arquivo; // arquivo .xls que será lido
 
public ExemploJXL() {
 
try {
 
arquivo = new File("arq.xls");
 
// instancia a planilha
 
planilha = Workbook.getWorkbook(arquivo);
 
//Obendo as Abas da planilha
 
Sheet[] abas = planilha.getSheets();
 
//loop para o vetor de abas
 
for (Sheet a : abas) {
 
System.out.println(a.getName());
 
}
 
} catch (Exception e) {
 
e.printStackTrace();
 
}
 
}
 
public static void main(String[] args) {
 
new ExemploJXL();
 
}
}
