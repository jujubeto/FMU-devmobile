package fmu.money.db.modelos;

import java.util.Calendar;
import fmu.money.utils.CalendarUtils;

public class Receita {
    private int id;
    private String nome;
    private double valor;
    private Calendar data;
    private int recorrencia;

    public Receita(double valor) {
        this.nome = "Entrada";
        this.valor = valor;
        this.data = Calendar.getInstance();
        this.recorrencia = 1;
    }

    public Receita(String nome, double valor, Calendar data, int recorrencia) {
        this.nome = nome;
        this.valor = valor;
        this.data = data;
        this.recorrencia = recorrencia;
    }

    public int getId() {
        return id;
    }

    public String getNome() {
        return nome;
    }
    public void setNome(String nome) {
        this.nome = nome;
    }

    public double getValor() {
        return valor;
    }
    public void setValor(double valor) {
        this.valor = valor;
    }

    public Calendar getData() {
        return data;
    }
    public void setData(Calendar data) {
        this.data = data;
    }

    public int getRecorrencia() {
        return recorrencia;
    }
    public void setRecorrencia(int recorrencia) {
        this.recorrencia = recorrencia;
    }

    @Override
    public String toString(){
        return
            "ID #" + id + 
            "\n" + this.nome +
            "\nR$ " + this.valor +
            "\nData: " + CalendarUtils.getDataString(this.data) +
            "\nRecorrência: " + this.recorrencia;
    }
}

