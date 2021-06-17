package poo_rh;

public abstract class Analista extends Funcionario{
    private static final String CONTRATO = "CLT";
    private String CPF;
    private String hierarquia;

    public Analista(String cpf, String nome) {
        super(nome, CONTRATO, cpf);
        setCPF(cpf);
    }

    public String getCPF() {
        return CPF;
    }

    public void setCPF(String CPF) {
        this.CPF = CPF;
    }

    public String getHierarquia() {
        return hierarquia;
    }

    public void setHierarquia(String hierarquia) {
    		this.hierarquia = hierarquia;
    }
    	

    @Override
    public abstract double getSalario();
    @Override
    public abstract double getValor13();
    @Override
    public abstract double getValorFerias();
}
