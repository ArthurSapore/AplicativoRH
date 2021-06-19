package poo_rh;

import java.util.InputMismatchException;
import java.util.Random;
import java.util.List;
import java.util.Scanner;

public class OperacoesFuncionario {
    static private Funcionario  funcionario;
    static Scanner leitor = new Scanner(System.in);
    
    public static void pesquisarFunc (List<Funcionario> funcionarios) {
        System.out.println("Digite o nome do funcionario ");
        String pesquisa = leitor.nextLine();
        for(Funcionario funcionarioss: funcionarios){
            if(funcionarioss.getNome().equals(pesquisa)) {
                funcionario = funcionarioss;
                System.out.println("Funcionário encontrado!\n");
                voltar();
                operacoes(funcionarios);
            }
        }
        if(funcionario==null) {
            System.out.println("Funcion�rio nao existente.");
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
        voltar();
        operacoes(funcionarios);
    }
	
    private static void operacoes(List<Funcionario> funcionarios){	

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
	
    private static void alterarDados (List<Funcionario> funcionarios) {

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
        
    private static void alterarContrato(List<Funcionario> funcionarios) {
        Funcionario promovido;
        if(funcionario instanceof Analista_Junior) {
            promovido = new Analista_Senior(funcionario.getNome(), funcionario.getIdentificadorUnico());
            funcionarios.remove(funcionario);
            funcionarios.add(promovido);
            funcionario = promovido;
            System.out.println("Funcionário "+funcionario.getNome()+ " promovido para Analista Senior com sucesso");
        }

        else if(funcionario instanceof Analista_Senior) {
            promovido = new Gerente(funcionario.getNome(), funcionario.getIdentificadorUnico());
            funcionarios.remove(funcionario);
            funcionarios.add(promovido);
            funcionario = promovido;
            System.out.println("Funcionário "+funcionario.getNome()+ " promovido para Gerente com sucesso");
        }

        else if(funcionario instanceof Gerente) {
            promovido = new Diretor(funcionario.getNome(), funcionario.getIdentificadorUnico());
            funcionarios.remove(funcionario);
            funcionarios.add(promovido);
            funcionario = promovido;
            System.out.println("Funcionário "+funcionario.getNome()+ " promovido para Diretor com sucesso");
        }
        else{
            System.out.println("Funcionário "+funcionario.getNome()+ " possui o cargo de diretor. Não pode ser promovido.");
        }
        voltar();
        alterarDados(funcionarios);
    }
    
    private static void alterarFaltas(List<Funcionario> funcionarios) {

       try{
           System.out.println("Digite o n�mero de dias:");
           int dias = leitor.nextInt();
           leitor.nextLine();
           System.out.println("1 - acrescentar \n2 - diminuir");
           String opc = leitor.nextLine();
           switch(opc) {
               case "1":
                   funcionario.setNumFaltas(funcionario.getNumFaltas() + dias);
                   voltar();
                   alterarDados(funcionarios);
                   break;
               case "2":
                   if(funcionario.getNumFaltas() - dias >= 0) {
                       funcionario.setNumFaltas(funcionario.getNumFaltas() - dias);
                   }else {
                       funcionario.setNumFaltas(0);
                   }
                   voltar();
                   alterarDados(funcionarios);
                   break;
               default:{
                   System.out.println("Opcao inv�lida!!");
                   voltar();
                   alterarFaltas(funcionarios);
               }
           }
       }catch(InputMismatchException ex){
           System.out.println("Erro causado porque a entrada está não é número inteiro. ");
       }
    }
	
    private static void alterarBonus(List<Funcionario> funcionarios) {

        try{
            System.out.println("Digite o valor do bonus: ");
            double valor = leitor.nextDouble();

            if((funcionario instanceof Gerente)) {
                ((Gerente) funcionario).setValorBonus(valor);
                System.out.println("Valor adicionado com sucesso.\n");
            }else if(funcionario instanceof Diretor) {
                ((Diretor) funcionario).setValorBonus(valor);
                System.out.println("Valor adicionado com sucesso.\n");
            }else {
                System.out.println("O funcionario "+funcionario.getNome()+" nao recebe bonus");
                voltar();
                alterarDados(funcionarios);
            }
            voltar();
            alterarDados(funcionarios);
        }catch(InputMismatchException ex){
            System.out.println("Erro causado porque a entrada está não é número double. ");
        }
    }
	
    private static void relatorioFuncionario (List<Funcionario> funcionarios) {
        System.out.println(funcionario.toString());
        voltar();
        operacoes(funcionarios);
    }

    private static void calcular13salario(List<Funcionario> funcionarios) {
    	if(funcionario instanceof Analista_Junior || (funcionario instanceof Analista_Senior) ) {
    		((IOperacaoAnalista) funcionario).calcular13();
    		System.out.println("13 salario do " +funcionario.getNome() + ": R$"+funcionario.getValor13());
    	}else {
    		System.out.println("O funcion�rio "+funcionario.getNome()+" n�o recebe 13� sal�rio");
    		voltar();
                operacoes(funcionarios);
    	}
        voltar();
    	operacoes(funcionarios);
    	
    } 
    
    private static void calcularFerias(List<Funcionario> funcionarios) {
    	if((funcionario instanceof Analista_Junior) || (funcionario instanceof Analista_Senior)) {
    		((IOperacaoAnalista) funcionario).calcularFerias();
    		System.out.println("O valor das ferias do " +funcionario.getNome() + ": R$"+funcionario.getValorFerias());
    	}else {
    		System.out.println("O funcionario "+funcionario.getNome()+" nao recebe ferias");
                voltar();
    		operacoes(funcionarios);
    	}
        voltar();
    	operacoes(funcionarios); 	
    }

    public static void voltar(){
        System.out.println("Pressione ENTER para ir para o Menu.");
        String resposta = leitor.nextLine();
    } 
}


