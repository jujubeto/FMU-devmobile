package fmu.money.db.interfaces;

import java.util.ArrayList;
import fmu.money.db.modelos.Despesa;

public interface DespesaDAOInterface {

    /** Executa um SELECT para retornar a lista de despesas */
    ArrayList<Despesa> listDespesas();

    /** Retorna uma despesa dado seu ID */
    Despesa getDespesa(int id);

    /** Adiciona uma despesa ao banco
     * @param despesa
     * @return TRUE se sucesso
     */
    boolean addDespesa(Despesa despesa);

    /** Remove uma despesa existente
     * @param id
     * @return TRUE se sucesso
     */
    boolean removeDespesa(int id);

    /** Retorna o somatório de despesas */
    double getTotal();
}
