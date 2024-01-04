package fmu.money.db.modelos;

public class User {
    private String nome;
    private double saldo;


    public User(String nome, double saldo){
        this.nome = nome;
        this.saldo = saldo;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public double getSaldo() {
        return saldo;
    }

    /**Atualiza o saldo do usuário com um certo valor */
    public void updateSaldo(double valor) {
        this.saldo += valor;
    }
}
