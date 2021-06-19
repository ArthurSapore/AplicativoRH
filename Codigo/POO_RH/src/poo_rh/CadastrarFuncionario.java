package poo_rh;

import java.util.Scanner;
import java.util.ArrayList;
import java.util.List;

public class CadastrarFuncionario {
	
    static Scanner leitor = new Scanner(System.in);
    static Funcionario funcionario;
    static String [] dados = new String[2];


    //CHAMA M�TODOS QUE FAZEM REGISTRO E VERIFICA��ES
    public static void cadastrarUsuario(List<Funcionario> funcionarios) {
        cargo(funcionarios);
        nome();
    }

    public static void nome(){
        System.out.print("Nome do funcionario: ");
        System.out.println("Para voltar ao menu principal, digite: 'VOLTAR'\n ");
        String nomeFuncionario = leitor.nextLine();
        if(nomeFuncionario.equalsIgnoreCase("voltar")) {
            RH.menu();
        }
        dados[1] = nomeFuncionario;
    }

    public static void cargo(List<Funcionario> funcionarios) {
        System.out.println("Cargo do funcionario: ");
        System.out.println("1 - Analista Junior");
        System.out.println("2 - Analista Senior ");
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
                funcionarios.add(funcionario);
                break;
            case "2":
                cpf();
                funcionario = new Analista_Senior(dados[1], dados[0]);
                funcionarios.add(funcionario);
                break;
            case "3":
                cnpj();
                funcionario = new Gerente(dados[1], dados[0]);
                funcionarios.add(funcionario);
                break;
            case "4":
                cnpj();
                funcionario = new Diretor(dados[1], dados[0]);
                funcionarios.add(funcionario);
                break;
            default:{
                System.out.println("Opcao invalida!\n");
                OperacoesFuncionario.voltar();
                cargo(funcionarios);
            }
        }  
    }

    public static void cpf() {
        System.out.println("Digite o cpf do funcionario");
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
        System.out.println("Funcionario cadastrado com sucesso.");
    }

    public static void cnpj() {
        System.out.println("Digite o CNPJ do funcionario");
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
        System.out.println("Funcionario cadastrado com sucesso.");
    }
}
		
		
		



		
	
	

