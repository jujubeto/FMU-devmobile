package fmu.money.db;

import java.util.ArrayList;
import fmu.money.db.interfaces.DespesaDAOInterface;
import fmu.money.db.modelos.Despesa;

/** Classe DAO falsa que usa armazenamento temporário. Substitua pela implementação do banco  */
public class DespesaFakeDAO implements DespesaDAOInterface{
    private TempStorage storage = TempStorage.getInstancia();
    private double total = 0;


    @Override
    public ArrayList<Despesa> listDespesas() {
        return storage.getDespesaList();
    }

    @Override
    public Despesa getDespesa(int id) {
        return storage.getDespesaList().get(id);
    }

    @Override
    public boolean addDespesa(Despesa despesa) {
        return storage.getDespesaList().add(despesa);
    }

    @Override
    public boolean removeDespesa(int id) {
        Despesa temp = storage.getDespesaList().get(id);
        return storage.getDespesaList().remove(temp);
    }

    public double getTotal(){
        total = 0;

        for (Despesa d : storage.getDespesaList()){
            total += d.getValor();
        }

        return total;
    };
}
