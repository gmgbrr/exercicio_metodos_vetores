package application;
import java.util.Arrays;
import java.util.Scanner;

class Main {

  static Scanner console = new Scanner(System.in);

  static boolean SITUACAO = false;
  static double NOTA_AI = 0;
  static final int TOTAL_AVALIACOES = 3;
  static final String NOMES_AVALIACOES[] = {"A1","A2", "A3","AI"};
  static final double NOTA_MAX_AVALIACOES[] = {30.00, 30.00, 40.00, 30.00};
  
  static double notas[] = new double [TOTAL_AVALIACOES];

  
  static void cadastrarAI(int posicao, double notas[]) {
	  
	  double min = Math.min(notas[0], notas[1]);
	   
	  System.out.println();
	  NOTA_AI = lerNota(NOMES_AVALIACOES[posicao],NOTA_MAX_AVALIACOES[posicao]);
	  
	  if (notas[0] != notas[1]) {		  
	  notas[Arrays.binarySearch(notas, min)] = NOTA_AI;	
	  } else if (notas[0] == notas[1]) {
		  notas[0] = NOTA_AI;
	  }
	  
  }//FIM DO METODO
  
  static String maiorNota(double notas[]) {
	  
		String maiorNota = "";
			
		if (notas[0] > notas[1] && notas[0] > notas[2]) {
			maiorNota = NOMES_AVALIACOES[0];
		} else if (notas[1] > notas[0] && notas[1] > notas[2]) {
			maiorNota = NOMES_AVALIACOES[1];
		} else if (notas[2] > notas[1] && notas[2] > notas[0]) {
			maiorNota = NOMES_AVALIACOES[2];
		} else if (notas[0] == notas[1] && notas[0] == notas[2]) {
			maiorNota = "Todas as notas foram iguais";
		} else if(notas[0] == notas[1]) {
			maiorNota = (NOMES_AVALIACOES[0] + " e " + NOMES_AVALIACOES[1]);
		} else if (notas[0] == notas[2]) {
			maiorNota = (NOMES_AVALIACOES[0] + " e " + NOMES_AVALIACOES[2]);
		} else {
			maiorNota = (NOMES_AVALIACOES[1] + " e " + NOMES_AVALIACOES[2]);
		}
		
		return maiorNota;
	}
  
  static double calcularMedia(double notas[]) {
	
	  double somaNotas = 0;
	  
	  for(int x = 0; x < notas.length; x++) {
		  somaNotas += notas[x];
	  }
	  
	  somaNotas /= TOTAL_AVALIACOES;
	  
	  	return somaNotas;
  }
  
  static double lerNota(String mensagem, double notaMaxima) {

      double nota = 0.0;

      do {

        System.out.printf("%s = ", mensagem);
        nota = console.nextDouble();
        
      } while (nota < 0.00 || nota > notaMaxima);

    return nota;
	}

  static void atualizarNota(int indiceNota) {

    System.out.println();
    notas[indiceNota] = lerNota(NOMES_AVALIACOES[indiceNota], NOTA_MAX_AVALIACOES[indiceNota]);
  
  }

  static String avaliarSituacao(double notaFinal) {

    if(notaFinal < 30) {
    	SITUACAO = true;
    	 return "REPROVADO";
    } else if (notaFinal < 70) {
    	SITUACAO = true;
    	 return "EM RECUPERAÇÃO";
    } else {
    	 return "APROVADO";
    }
  }
  
  static void mostrarNotas() {

    double notaFinal = 0.0;

    System.out.println("\n\t\tNOTAS");
    System.out.println();
    
    for (int i = 0; i < TOTAL_AVALIACOES; i++) {

      System.out.printf("Avaliação %s = %.2f pts", NOMES_AVALIACOES[i], notas[i]);
      System.out.println();
      notaFinal += notas[i];
    
    }

    System.out.printf("\n  Nota Final = %.2f pts", notaFinal);
    System.out.printf("\n    Situação = %s", avaliarSituacao(notaFinal));
    System.out.printf("\n      Média Final = %.2f pts", calcularMedia(notas));
    System.out.print("\n        Maior Nota = " + maiorNota(notas));
  } 

  static void mostrarMenu() {

    System.out.println("\n\n");
    System.out.println("\t\tMENU");
    System.out.println();
    
    System.out.println("[1] Cadastrar Nota A1");
    System.out.println("[2] Cadastrar Nota A2");
    System.out.println("[3] Cadastrar Nota A3");
    System.out.println("[4] Mostrar Notas");
    System.out.println("[0] SAIR");

    System.out.print("\nDigite uma opção:  ");
    byte opcao = console.nextByte();


    switch(opcao) {

      case 0:
        System.exit(0);
        break;
      
      case 1:
        atualizarNota(0);
        break;
      
      case 2:
        atualizarNota(1);
        break;

      case 3:
        atualizarNota(2);
        break;

      case 4:
    	mostrarNotas();
        break;   

      default:
        mostrarMenu();
        break;

    }
    
	    if (SITUACAO == true) {
	    	mostrarMenuRec();
	    } else {
	    	mostrarMenu();
	    }

  }

  static void mostrarMenuRec() {

	    System.out.println("\n\n");
	    System.out.println("\t\tMENU");
	    System.out.println();
	    
	    System.out.println("[1] Cadastrar Nota A1");
	    System.out.println("[2] Cadastrar Nota A2");
	    System.out.println("[3] Cadastrar Nota A3");
	    System.out.println("[4] Cadastrar Nota AI");
	    System.out.println("[5] Mostrar Notas");
	    System.out.println("[0] SAIR");

	    System.out.print("\nDigite uma opção:  ");
	    byte opcao = console.nextByte();


	    switch(opcao) {

	      case 0:
	        System.exit(0);
	        break;
	      
	      case 1:
	        atualizarNota(0);
	        break;
	      
	      case 2:
	        atualizarNota(1);
	        break;

	      case 3:
	        atualizarNota(2);
	        break;

	      case 4:
	    	cadastrarAI(3,notas);
	        break;
	        
	      case 5:
	        mostrarNotas();
	        break;   

	      default:
	        mostrarMenu();
	        break;

	    }

	    	mostrarMenuRec();
	  }
  
  public static void main(String[] args) {

    mostrarMenu();
    
  }
  
} // Fim da classe Main
