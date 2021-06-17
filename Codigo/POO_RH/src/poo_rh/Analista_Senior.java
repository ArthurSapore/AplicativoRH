package poo_rh;

public class Analista_Senior extends Analista implements IOperacaoAnalista{
    private static final double VALOR_BASE = 1200.00;
    private static final double TAXA13 = VALOR_BASE / 12;
    private static final String HIERARQUIA = "Analista Senior";
    private double valorFerias;
    private double salarioTotal;
    private double valor13;

    public Analista_Senior(String CPF, String nome) {
        super(CPF, nome);
        this.setHierarquia(HIERARQUIA);
        this.setFuncao(HIERARQUIA);
    }

    @Override
    public double calcular13() {
        int quantMesesTrabalhados = super.getMesesTrabalhados();
        if(quantMesesTrabalhados < 12) quantMesesTrabalhados = (quantMesesTrabalhados % 12);
        else quantMesesTrabalhados = 12;
        this.valor13 = ((this.VALOR_BASE/ 12) * quantMesesTrabalhados);
        return this.valor13;
    }

    @Override
    public double calcularFerias() {
        this.valorFerias = this.VALOR_BASE + (this.VALOR_BASE/3);
        return this.valorFerias;
    }

    @Override
    public double calcularSalario() {
        double salario = this.VALOR_BASE - (super.getNumFaltas() * 60);
        return salario;
    }

    @Override
    public double getSalario() {
        return this.calcularSalario();
    }

    @Override
    public double getValor13() {
        return this.calcular13();
    }

    @Override
    public double getValorFerias() {
        return this.calcularFerias();
    }

    @Override
    public double getBonus() {
        throw new UnsupportedOperationException("Classe nao possui bonus!");
    }
}
