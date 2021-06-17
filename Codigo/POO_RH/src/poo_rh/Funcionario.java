package poo_rh;

public abstract class Funcionario {
    private String nome;
    private String contrato;
    private int numFaltas;
    private String funcao;
    private int mesesTrabalhados;
    
    public Funcionario( String nome, String contrato) {
        this.nome=nome;
        this.contrato=contrato;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public int getNumFaltas() {
        return numFaltas;
    }

    public void setNumFaltas(int numFaltas) {
        this.numFaltas = numFaltas;
    }

    public String getFuncao() {
        return funcao;
    }

    public void setFuncao(String funcao) {
        this.funcao = funcao;
    }

    public int getMesesTrabalhados() {
        return mesesTrabalhados;
    }

    public void setMesesTrabalhados(int mesesTrabalhados) {
        this.mesesTrabalhados = mesesTrabalhados;
    }
    
    public abstract double getSalario();
    public abstract double getValor13();
    public abstract double getValorFerias();
    public abstract double getBonus();
}
