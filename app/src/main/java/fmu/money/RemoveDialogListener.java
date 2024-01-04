package fmu.money;

/** Interface para fazer uma ponte entre o Adapter e classes que o instanciem
 * https://stackoverflow.com/questions/48048977/send-string-from-custom-adapter-to-activity
 */
public interface RemoveDialogListener {

    /** Ocorre quando "Sim" for selecionado em um diálogo pra remover despesa ou receita
     * @param indice O índice da despesa ou receita a ser removida
     */
    void onRemoveDialogPositiveClick(int indice);
}
