package fmu.money.db.interfaces;

import java.util.ArrayList;
import fmu.money.db.modelos.Receita;

public interface ReceitaDAOInterface {

    /** Executa um SELECT para retornar a lista de Receitas */
    ArrayList<Receita> listReceitas();

    /** Retorna uma Receita dado seu ID */
    Receita getReceita(int id);

    /** Adiciona uma Receita ao banco
     * @param receita
     * @return TRUE se sucesso
     */
    boolean addReceita(Receita receita);

    /** Remove uma receita existente
     * @param id
     * @return TRUE se sucesso
     */
    boolean removeReceita(int id);

    /** Retorna o somatório de despesas */
    double getTotal();

}
