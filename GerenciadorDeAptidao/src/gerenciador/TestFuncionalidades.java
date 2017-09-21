package gerenciador;

import java.io.*;
import java.util.Scanner;

public class TestFuncionalidades {

	public static void main(String[] args) {
		
		ExtrairDados dados = new ExtrairDados();
		
		
		dados.criaAlunos("Alfredo");
		dados.criaAlunos("Leonardo");
		dados.criaAlunos("Daniel");
		dados.criaAlunos("Alberto");
		dados.criaAlunos("Willian");
		
		Scanner entrada = new Scanner(System.in);
		
		int opcao = 0, contadorCriarTopico = 0;
		do {
			System.out.println("Seja bem vindo ao Gerenciamento de Aptidão!");
			System.out.println("Digite\n1-Criar Tópico\n2-Escolher Tópico pré-definido");
			opcao = entrada.nextInt();
			
			if(opcao == 1) {
				dados.imprimirDisciplinas();
				System.out.println("Digite os codigos das disciplinas com o peso para o tópico\nExemplo:\nCódigo: TEC.0455\nPeso: 2\nDigite 0 para terminar");
				dados.criarTopico();
			}
			else if(opcao == 2) {
				int opcaoTopico = 0;
				System.out.println("Digite\n1 - Desenvolvimento de Software\n2 - Eletrônica");
				opcaoTopico = entrada.nextInt();
				if(opcaoTopico == 1) {
					dados.criarTopicoPreDefinido("DesenvolvedorSoftware","Algoritmos e Programa��o",4,"Estruturas de Dados e Algoritmos",3);
				}else if(opcaoTopico == 2) {
					dados.criarTopicoPreDefinido("Eletrônica","Sistemas Digitais I", 3,"Sistemas Digitais II", 5);
				}
			}
		}while(opcao != -1);
		
		/*dados.criarTopico("programador","Algoritmos e Programa��o",4,"Ci�ncias do Ambiente",4);
		dados.criarTopico("eletr�nica","Sistemas Digitais I", 3,"Cálculo Diferencial e Integral I", 5);
		dados.imprimirTudo("Algoritmos e Programa��o","programador");
		dados.imprimirTudo("Sistemas Digitais I","eletr�nica");*/
	}

}
