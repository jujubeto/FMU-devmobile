package fmu.money.db.modelos;

import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;

import java.util.Calendar;

import fmu.money.utils.CalendarUtils;

public class Despesa{
    private int id;
    private String categoria;
    private String descricao;
    private double valor;
    private Calendar data;
    private int recorrencia;

    public Despesa(String categoria, double valor) {
        this.categoria = categoria;
        this.valor = valor;
        this.data = Calendar.getInstance();
        this.recorrencia = 1;
    }

    public Despesa(String categoria, double valor, String descricao, Calendar data, int recorrencia) {
        this.categoria = categoria;
        this.valor = valor;
        this.descricao = descricao;
        this.data = data;
        this.recorrencia = recorrencia;
    }

    public int getId() {
        return id;
    }

    public String getCategoria() {
        return categoria;
    }
    public void setCategoria(String categoria) {
        this.categoria = categoria;
    }

    public double getValor() {
        return valor;
    }
    public void setValor(double valor) {
        this.valor = valor;
    }

    public String getDescricao() {
        return descricao;
    }
    public void setDescricao(String descricao) {
        this.descricao = descricao;
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
            "\nCategoria: " + this.categoria +
            "\nDescrição: " + this.descricao +
            "\nR$ " + this.valor +
            "\nData: " + CalendarUtils.getDataString(this.data) +
            "\nRecorrência: " + this.recorrencia;
    }
}

