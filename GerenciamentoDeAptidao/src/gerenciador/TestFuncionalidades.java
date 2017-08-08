package gerenciador;

import java.io.*;

public class TestFuncionalidades {

	public static void main(String[] args) {
		Disciplina calculo = new Disciplina();
		Disciplina vetorial = new Disciplina();
		
		Aluno betao = new Aluno();
		Aluno DannyBoy = new Aluno();
		betao.setIra(80.1);
		DannyBoy.setIra(79.9);
		
		calculo.adicionaAluno(betao, DannyBoy);
		
		
		TopicosPorArea mat = new TopicosPorArea(calculo);
		
		
	}

}
