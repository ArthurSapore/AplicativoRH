package poo_rh;

public class Gerente extends Funcionario implements IOperacaoAdm{
    private static final String CONTRATO = "PJ";
    private static final double VALOR_BASE = 7000.00;
    private static final String FUNCAO = "Gerente";
    private String CNPJ;
    private double valorBonus = 0;
    private double salarioTotal;

    public Gerente(String CNPJ, String nome) {
        super(nome, CONTRATO, CNPJ);
        this.CNPJ = CNPJ;
        this.setFuncao(FUNCAO);
    }

    public String getCNPJ() {
        return CNPJ;
    }

    public void setCNPJ(String CNPJ) {
        this.CNPJ = CNPJ;
    }

    public double getValorBonus() {
        return valorBonus;
    }

    public void setValorBonus(double valorBonus) {
        this.valorBonus = valorBonus;
    }
    
    @Override
    public double calcularBonus() {
        return this.valorBonus*this.VALOR_BASE;
    }

    @Override
    public double calcularSalario() {
        double salario;
        if(super.getNumFaltas() > 0){
            return this.VALOR_BASE;
        }
        else{
            salario = (this.calcularBonus() + this.VALOR_BASE);
            this.salarioTotal = salario;
            return salario;
        }
    }

    @Override
    public double getSalario() {
        return this.calcularSalario();
    }

    @Override
    public double getBonus() {
        return this.calcularBonus();
    }

    @Override
    public double getValor13() {
        throw new UnsupportedOperationException("Valor de 13 nao calculavel na classe!");
    }

    @Override
    public double getValorFerias() {
        throw new UnsupportedOperationException("Valor de ferias nao calculavel na classe!");
    }
}
