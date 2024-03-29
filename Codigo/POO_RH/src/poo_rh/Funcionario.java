package poo_rh;

public abstract class Funcionario {
    private String identificadorUnico;
    private String nome;
    private String contrato;
    private int numFaltas = 0;
    private String funcao;
    private int mesesTrabalhados = 0;
    
    public Funcionario( String nome, String contrato, String identificador) {
        this.nome=nome;
        this.contrato=contrato;
        this.identificadorUnico = identificador;
    }
    
    public String getIdentificadorUnico() {
        return nome;
    }

    public void setIdentificadorUnico(String identificador) {
        this.identificadorUnico = identificador;
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
    
    @Override
    public String toString(){
        String aux = this.nome;
        StringBuilder desc = new StringBuilder(aux);
        
        desc.append(" - "+this.identificadorUnico+"\nFuncao: "+this.funcao+"\nMeses Trabalhados: "+this.mesesTrabalhados+"\nNumero de faltas: "+this.numFaltas+"\nValor do salario: R$"+this.getSalario()+"\n ");
        aux = desc.toString();
        return aux;
    }
}
