package poo_rh;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class RH {
    private static List<Funcionario> funcionarios = new ArrayList<>();
    
    public static void lerDados () throws FileNotFoundException, IOException {	
    	Funcionario funcionario;
        Scanner leitor = new Scanner(new File("POO_RH.txt"));
        while(leitor.hasNextLine()) {
            String linha = leitor.nextLine();
            String[] dados = linha.split(";");

            if(dados[2].equals("AJ")) {
            	funcionario = new Analista_Junior(dados[0], dados[1]);
            }else if(dados[2].equals("AS")) {
            	funcionario = new Analista_Senior(dados[0], dados[1]);
            }else if(dados[2].equals("G")) {
            	funcionario = new Gerente(dados[0], dados[1]);
            }else {
            	funcionario = new Diretor(dados[0], dados[1]);
            }
            funcionarios.add(funcionario);
        }
    }  
    
    public static void calcSumSalario(List<Funcionario> funcionarios){
        double salario = 0;
        for(Funcionario funcionarioss: funcionarios){
            salario += funcionarioss.getSalario();
        }
        System.out.println("Somatorio do salario de todos os funcionarios cadastrados no sistema: " + "R$" + salario);
        menu();
    }
    
    public static void menu (){
    	Scanner leitor = new Scanner(System.in);

    	System.out.println("                  ========================================");
    	System.out.println("                   |          MENU PRINCIPAL             | ");
        System.out.println("                  ========================================");
        System.out.println("                  |                                      |");
        System.out.println("                  |     1 - Cadastrar novo funcionario   |");
        System.out.println("                  |                                      |");
        System.out.println("                  |     2 - Operacoes com funcionario    |");
        System.out.println("                  |                                      |");
        System.out.println("                  |  3 - Calcular somatorio dos salario  |");
        System.out.println("                  |                                      |");        
        System.out.println("                  |             4 - SAIR                 |");
        System.out.println("                  |                                      |");
        System.out.println("                  |                                      |");
        System.out.println("                  ========================================\n");
		
        String opc = leitor.nextLine();
        switch(opc) {
        case "1": //CADASTRAR FUNCIONARIO
        	CadastrarFuncionario.cadastrarUsuario();
            break;
        case "2": //OPERACOES COM FUNCIONARIO
        	OperacoesFuncionario.pesquisarFunc(funcionarios);
            break;
        case "3": 
            calcSumSalario(funcionarios);
            break;
        case "4": // "SAI DO PROGRAMA" 
            System.out.println("Ate a Proxima...");
            System.exit(0);
            break;
        default:
            System.out.println("OPCAO INVALIDA!");
            menu();
            break;
        }
    }
    
    public static void main(String[] args) throws FileNotFoundException, IOException {
    	lerDados();
    	menu();
    }
}
