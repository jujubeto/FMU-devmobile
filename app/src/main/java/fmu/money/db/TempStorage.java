package fmu.money.db;

import java.util.ArrayList;

import fmu.money.db.modelos.Despesa;
import fmu.money.db.modelos.Receita;
import fmu.money.db.modelos.User;

/** Classe Singleton que armazena um usuário com nome e saldo e suas listas de despesas e receitas
 * <code>receitaList</code> e <code>despesaList</code> são temporários, substitua pela implementação do banco mais tarde
 */
public class TempStorage {
    private User user;
    private ArrayList<Receita> receitaList;
    private ArrayList<Despesa> despesaList;
    private static TempStorage instancia;

    /** Retorna a instância de um armazenamento em classe Singleton */
    public static synchronized TempStorage getInstancia(){
        if (instancia == null){
            instancia = new TempStorage();
        }

        return instancia;
    }

    private TempStorage(){
        this.receitaList = new ArrayList<>();
        this.despesaList = new ArrayList<>();
    }

    public User getSavedUser() {
        if (this.user != null)
        {
            return this.user;
        }

        return null;
    }

    public void setSavedUser(User user) {
        this.user = user;
    }

    public ArrayList<Receita> getReceitaList() {
        return receitaList;
    }
    public ArrayList<Despesa> getDespesaList() {
        return despesaList;
    }
}
