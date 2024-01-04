package fmu.money;

import android.app.Dialog;
import android.content.Context;
import android.content.DialogInterface;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatDialogFragment;

import com.google.android.material.dialog.MaterialAlertDialogBuilder;

import java.util.Calendar;

import fmu.money.db.modelos.Despesa;
import fmu.money.db.modelos.Receita;

public class AddReceitaDialogFragment extends AppCompatDialogFragment  {
    private ReceitaDialogListener listener;
    private EditText inputReceitaValor, inputReceitaDescr;
    private MaterialAlertDialogBuilder dialogBuilder;


    /** Interface que serve de ponte entre o DialogFragment e a MainActivity  */
    public interface ReceitaDialogListener {
        void onReceitaDialogPositiveClick(Receita receita);
    }

    @Override
    public void onAttach(@NonNull Context context) {
        super.onAttach(context);

        try{
            this.listener = (ReceitaDialogListener) context;
        } catch (ClassCastException c){
            throw new ClassCastException(getActivity().toString()
                    + "deve implementar a interface DespesaDialogListener");
        }
    }

    @NonNull
    @Override
    public Dialog onCreateDialog(@Nullable Bundle savedInstanceState) {
        LayoutInflater inflater = getActivity().getLayoutInflater();
        View modalView = inflater.inflate(R.layout.modal_receita , null);

        inputReceitaValor = modalView.findViewById(R.id.inputReceitaValor);
        inputReceitaDescr = modalView.findViewById(R.id.inputReceitaDescr);

        dialogBuilder = new MaterialAlertDialogBuilder(getContext())
                .setView(modalView)
                .setPositiveButton("Salvar", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {

                        // Apenas se as informações forem preenchidas
                        if (inputReceitaValor.getText().length() != 0 && inputReceitaDescr.getText().length() != 0){

                            Receita r = new Receita(
                                    inputReceitaDescr.getText().toString(),
                                    Double.parseDouble(inputReceitaValor.getText().toString()),
                                    Calendar.getInstance(),
                                    0
                            );

                            listener.onReceitaDialogPositiveClick(r);
                        } else {
                            Toast.makeText(getContext(), "Preencha as informações", Toast.LENGTH_SHORT).show();
                        }
                    }
                })
                .setNegativeButton("Voltar", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        dialog.dismiss();
                    }
                })
                .setBackground(new ColorDrawable(Color.parseColor("#d3d3d3")));

        return dialogBuilder.create();
    }
}
