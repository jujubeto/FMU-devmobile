package fmu.money.db;

import fmu.money.db.interfaces.UserDAOInterface;
import fmu.money.db.modelos.User;

/** Classe DAO falsa que usa armazenamento temporário. Substitua pela implementação do banco  */
public class UserFakeDAO implements UserDAOInterface {
    TempStorage storage = TempStorage.getInstancia();
    User user;

    @Override
    public boolean createUser(String nome, double saldo){

        if (storage.getSavedUser() == null){
            user = new User(nome, saldo);
            storage.setSavedUser(user);
            return true;
        }

        return false;
    }

    @Override
    public String getUserName() {
        return storage.getSavedUser().getNome();
    }

    @Override
    public double getUserSaldo() {
        return storage.getSavedUser().getSaldo();
    }

    @Override
    public void updateUserSaldo(double valor) {
        storage.getSavedUser().updateSaldo(valor);
    }
}
