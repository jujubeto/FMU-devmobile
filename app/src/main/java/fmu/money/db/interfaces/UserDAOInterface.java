package fmu.money.db.interfaces;

public interface UserDAOInterface {
    /** Cria um usuário no banco.
     * Só é possível ter UM usuário. Implemente a lógica para criar se não existir ou retornar o existente.
     * @param nome
     * @param saldo
     * @return TRUE se sucesso
     */
    boolean createUser(String nome, double saldo);

    /** Retorna o nome do usuário existente no banco
     */
    String getUserName();

    /** Retorna o saldo do usuário existente no banco
     */
    double getUserSaldo();

    /** Atualiza o saldo do usuário existente no banco
     * @param valor
     */
    void updateUserSaldo(double valor);
}
