package poo_rh;

import java.util.List;
import java.util.Scanner;

public class OperacoesFuncionario {
	static private Funcionario  funcionario;
	static Scanner leitor = new Scanner(System.in);
	
	public static void pesquisarFunc (List<Funcionario> funcionarios) {
		System.out.println("Digite o nome do funcion�rio ");
		String pesquisa = leitor.nextLine();
		for(Funcionario funcionarioss: funcionarios){
            if(funcionarioss.getNome().equals(pesquisa)) {
            	funcionario = funcionarioss;
                operacoes(funcionarios);
            }
        }
		if(funcionario==null) {
                    System.out.println("Funcion�rio n�o existente.");
                    System.out.println("Deseja tentar novamente? \n1-SIM \n2-NAO");
                    pesquisa = leitor.nextLine();
                    switch(pesquisa) {
                        case"1":
                            pesquisarFunc(funcionarios);
                            break;
                        case"2":
                            RH.menu();
                            break;
                        default:{
                            System.out.println("Opcao invalida");
                            RH.menu();
                        }
                    }
                }
            operacoes(funcionarios);
	}
	
	public static void operacoes(List<Funcionario> funcionarios){
		
    	Scanner leitor = new Scanner(System.in);

        System.out.println("                  ========================================"); 
        System.out.println("                  |                                      |");
        System.out.println("                  |       1 - Status do funcionario      |");
        System.out.println("                  |                                      |");
        System.out.println("                  |   2 - Alterar dados do funcionario   |");
        System.out.println("                  |                                      |");
        System.out.println("                  |   3 - Pesquisar outro funcionario    |");
        System.out.println("                  |                                      |");
        System.out.println("                  |       4 - Calcular 13� terceiro      |");
        System.out.println("                  |                                      |");
        System.out.println("                  |         5 - Calcular ferias          |");
        System.out.println("                  |                                      |");
        System.out.println("                  |              6 - VOLTAR              |");
        System.out.println("                  |                                      |");
        System.out.println("                  |                                      |");
        System.out.println("                  ========================================\n");
        String opcao = leitor.nextLine();
        
        switch(opcao){
        case "1":
        	relatorioFuncionario(funcionarios);
        	operacoes(funcionarios);
        	break;
        case "2":
        	alterarDados(funcionarios);
        	operacoes(funcionarios);
        	break;
        case "3":
        	pesquisarFunc(funcionarios);
        	operacoes(funcionarios);
        	break;
        case "4":
        	calcular13salario(funcionarios);
        	operacoes(funcionarios);
        	break;
        case "5":
        	calcularFerias(funcionarios);
        	operacoes(funcionarios);
        	break;
        case "6":
        	RH.menu();
        	operacoes(funcionarios);
        	break;
    	default:{
    		System.out.println("Opcao Invalida!!");
    		operacoes(funcionarios);
    	}
        	
        }
	}
	
	public static void alterarDados (List<Funcionario> funcionarios) {
		Scanner leitor = new Scanner(System.in);

        System.out.println("                  ========================================"); 
        System.out.println("                  |                                      |");
        System.out.println("                  |        1 - Alterar contrato          |");
        System.out.println("                  |                                      |");
        System.out.println("                  |         2 - Alterar Faltas           |");
        System.out.println("                  |                                      |");
        System.out.println("                  |         3 - Alterar Bonus            |");
        System.out.println("                  |                                      |");
        System.out.println("                  |            4 - VOLTAR                |");
        System.out.println("                  |                                      |");
        System.out.println("                  |                                      |");
        System.out.println("                  ========================================\n");
        String opcao = leitor.nextLine();
        
        switch(opcao){
        case "1":
        	alterarContrato(funcionarios);
        	break;
        case "2":
        	alterarFaltas(funcionarios);
        	break;
        case "3":
        	alterarBonus(funcionarios);
        	break;
        case "4":
        	operacoes(funcionarios);
        	break;
        default:{
    		System.out.println("Opcao Invalida!!");
    		alterarDados(funcionarios);
    	}
        	
        }
	}
        
	public static void alterarContrato(List<Funcionario> funcionarios) {
		if(funcionario instanceof Analista_Junior) {
			funcionario = new Analista_Senior(funcionario.getNome(), ((Analista_Junior) funcionario).getCPF());
			funcionarios.remove(funcionario);
		}
		
		else if(funcionario instanceof Analista_Senior) {
			funcionario = new Gerente(funcionario.getNome(), ((Analista_Senior) funcionario).getCPF());
			funcionarios.remove(funcionario);
		}
		
		else {
			funcionario=new Diretor(funcionario.getNome(),((Gerente) funcionario).getCNPJ());
			funcionarios.remove(funcionario);
		}
		
		alterarDados(funcionarios);
	}
    
	public static void alterarFaltas(List<Funcionario> funcionarios) {
		
		System.out.println("Digite o n�mero de dias:");
		int dias = leitor.nextInt();
		
    	System.out.println("1 - acrescentar \n2 - diminuir");
		String opc = leitor.nextLine();
		switch(opc) {
			case "1":
				funcionario.setNumFaltas(funcionario.getNumFaltas() + dias);
				break;
			case "2":
				if(funcionario.getNumFaltas() - dias >= 0) {
					funcionario.setNumFaltas(funcionario.getNumFaltas() - dias);
				}else {
					funcionario.setNumFaltas(0);
				}
				break;
				default:{
					System.out.println("Opcao inv�lida!!");
					alterarFaltas(funcionarios);
				}
		alterarDados(funcionarios);
				
		}
		
		
		
		
		alterarDados(funcionarios);
	}
	
	public static void alterarBonus(List<Funcionario> funcionarios) {
		System.out.println("Digite o valor do bonus: ");
		double valor = leitor.nextDouble();
		
		if(funcionario instanceof Gerente) {
    		((Gerente) funcionario).setValorBonus(valor);
    	}else if(funcionario instanceof Diretor) {
    		((Diretor) funcionario).setValorBonus(valor);
    	}else {
    		System.out.println("O funcion�rio "+funcionario.getNome()+" n�o recebe bonus");
    		alterarDados(funcionarios);
    	}
		alterarDados(funcionarios);
	}
	
	public static void relatorioFuncionario (List<Funcionario> funcionarios) {
		funcionario.toString();
		operacoes(funcionarios);
	}
        
    public static void calcular13salario(List<Funcionario> funcionarios) {
    	if(funcionario instanceof Analista_Junior) {
    		((Analista_Junior) funcionario).calcular13();
    		System.out.println("13 salario do " +funcionario.getNome() + ": "+funcionario.getValor13());
    	}else if(funcionario instanceof Analista_Senior) {
    		((Analista_Junior) funcionario).calcular13();
    		System.out.println("13 salario do " +funcionario.getNome() + ": "+funcionario.getValor13());
    	}else {
    		System.out.println("O funcion�rio "+funcionario.getNome()+" n�o recebe 13� sal�rio");
    		operacoes(funcionarios);
    	}
    	operacoes(funcionarios);
    	
    } 
    
    public static void calcularFerias(List<Funcionario> funcionarios) {
    	if(funcionario instanceof Analista_Junior) {
    		((Analista_Junior) funcionario).calcularFerias();
    		System.out.println("O valor das ferias do " +funcionario.getNome() + ": "+funcionario.getValorFerias());
    	}else if(funcionario instanceof Analista_Senior) {
    		((Analista_Junior) funcionario).calcularFerias();
    		System.out.println("13 salario do " +funcionario.getNome() + ": "+ funcionario.getValorFerias());
    	}else {
    		System.out.println("O funcion�rio "+funcionario.getNome()+" n�o recebe ferias");
    		operacoes(funcionarios);
    	}
    	operacoes(funcionarios); 	
    }
}


