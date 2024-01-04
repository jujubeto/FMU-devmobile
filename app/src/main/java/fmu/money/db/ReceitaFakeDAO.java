package fmu.money.db;

import java.util.ArrayList;

import fmu.money.db.interfaces.ReceitaDAOInterface;
import fmu.money.db.modelos.Receita;

/** Classe DAO falsa que usa armazenamento temporário. Substitua pela implementação do banco  */
public class ReceitaFakeDAO implements ReceitaDAOInterface{
    private TempStorage storage = TempStorage.getInstancia();
    private double total = 0;

    @Override
    public ArrayList<Receita> listReceitas() {
        return storage.getReceitaList();
    }

    @Override
    public Receita getReceita(int id) {
        return storage.getReceitaList().get(id);
    }

    @Override
    public boolean addReceita(Receita receita) {
        return storage.getReceitaList().add(receita);
    }

    @Override
    public boolean removeReceita(int id) {
        Receita temp = storage.getReceitaList().get(id);
        return storage.getReceitaList().remove(temp);
    }

    public double getTotal(){
        total = 0;

        for (Receita r : storage.getReceitaList()){
            total += r.getValor();
        }

        return total;
    };
}
