package poo_rh;

import java.util.Scanner;


public class CadastrarFuncionario {
	
	static Scanner leitor = new Scanner(System.in);
	static Funcionario funcionario;
	static String [] dados = new String[2];


	//CHAMA Mï¿½TODOS QUE FAZEM REGISTRO E VERIFICAï¿½ï¿½ES
		public static void cadastrarUsuario() {
			cargo();
	        nome();
		}
	        
		public static void nome(){
	            System.out.print("Nome do funcionário: ");
	            System.err.println("Para voltar ao menu principal, digite: 'VOLTAR' ");
	            String nomeFuncionario = leitor.nextLine();
	            if(nomeFuncionario.equalsIgnoreCase("voltar")) {
	                RH.menu();
	            }
	            dados[1] = nomeFuncionario;
	    }
		
		public static void cargo() {
			System.out.println("Cargo do funcionário: ");
			System.out.println("1 - Analista Junior");
			System.out.println("2 - Analista Sênior ");
			System.out.println("3 - Gerente ");
			System.out.println("4 - Diretor ");
            String cargo = leitor.nextLine();
            if(cargo.equalsIgnoreCase("voltar")) {
            	RH.menu();
            }
			
            switch(cargo){
            case "1":
            	cpf();
            	funcionario = new Analista_Junior(dados[1], dados[0]);
            	break;
            case "2":
            	cpf();
            	funcionario = new Analista_Senior(dados[1], dados[0]);
            	break;
            case "3":
            	cnpj();
            	funcionario = new Gerente(dados[1], dados[0]);
            	break;
            case "4":
            	cnpj();
            	funcionario = new Diretor(dados[1], dados[0]);
            	break;
            	default:{
            		System.out.println("Opcão inválida!");
            		cargo();
            	}
            }  
		}

		public static void cpf() {
			System.out.println("Digite o cpf do funcionário");
			String cpf = leitor.nextLine();
			
			int cont = 0;
	        
	    	if(!cpf.matches("[0-9]*")) {
	    		System.err.println("CPF invalido! Digite novamente!");
	    		cpf();
	    	}
	    	if(cpf.length() != 11 ) {
	    		System.err.println("CPF invalido! Digite novamente!");
	    		cpf();
	    	}
	    	for (int i = 0; i<3 ;i++) {
	    		if(cpf.charAt(i)==cpf.charAt(3+i)) {
	    			cont ++;
	    		}
	    	}
	    	if(cont>=3) {
	    		System.err.println("CPF invalido! Digite novamente!");
	    		cpf();
	    	}
	    	
	    	dados [0] = cpf;
		}
		
		public static void cnpj() {
			System.out.println("Digite o CNPJ do funcionário");
			String cnpj = leitor.nextLine();
			
			int cont = 0;
	        
	    	if(!cnpj.matches("[0-9]*")) {
	    		System.err.println("CNPJ invalido! Digite novamente!");
	    		cnpj();
	    	}
	    	if(cnpj.length() != 14 ) {
	    		System.err.println("CNPJ invalido! Digite novamente!");
	    		cnpj();
	    	}
	    	for (int i = 0; i<3 ;i++) {
	    		if(cnpj.charAt(i)==cnpj.charAt(3+i)) {
	    			cont ++;
	    		}
	    	}
	    	if(cont>=3) {
	    		System.err.println("cnpj invalido! Digite novamente!");
	    		cnpj();
	    	}
	    	dados[0] = cnpj; 
		}
}
		
		
		



		
	
	

