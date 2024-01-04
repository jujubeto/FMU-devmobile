package fmu.money;

import android.app.Dialog;
import android.content.Context;
import android.content.DialogInterface;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
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

public class AddDespesaDialogFragment extends AppCompatDialogFragment {
    private DespesaDialogListener listener;
    private EditText inputDespesaValor, inputDespesaDescr;
    private Spinner spinnerCategorias;
    private MaterialAlertDialogBuilder dialogBuilder;



    /** Interface que serve de ponte entre o DialogFragment e a MainActivity  */
    public interface DespesaDialogListener{
        void onDespesaDialogPositiveClick(Despesa despesa);
    }


    @Override
    public void onAttach(@NonNull Context context) {
        super.onAttach(context);

        try{
            this.listener = (DespesaDialogListener) context;
        } catch (ClassCastException c){
            throw new ClassCastException(getActivity().toString()
                    + "deve implementar a interface DespesaDialogListener");
        }
    }

    @NonNull
    @Override
    public Dialog onCreateDialog(@Nullable Bundle savedInstanceState) {
        LayoutInflater inflater = getActivity().getLayoutInflater();
        View modalView = inflater.inflate(R.layout.modal_despesa , null);

        //Componentes da view
        inputDespesaValor = modalView.findViewById(R.id.inputDespesaValor);
        inputDespesaDescr = modalView.findViewById(R.id.inputDespesaDescr);
        spinnerCategorias = modalView.findViewById(R.id.spinnerCategorias);

        //Adapter do spinner pra instanciar os valores na lista
        ArrayAdapter<CharSequence> categoriaAdapter = ArrayAdapter.createFromResource(
                getActivity(),
                R.array.categorias,
                androidx.appcompat.R.layout.support_simple_spinner_dropdown_item
        );
        spinnerCategorias.setAdapter(categoriaAdapter);


        dialogBuilder = new MaterialAlertDialogBuilder(getContext())
                .setView(modalView)
                .setPositiveButton("Salvar", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {

                        // Apenas se as informações forem preenchidas
                        if (inputDespesaValor.getText().length() != 0 && inputDespesaDescr.getText().length() != 0){

                            Despesa d = new Despesa(
                                    spinnerCategorias.getSelectedItem().toString(),
                                    Double.parseDouble(inputDespesaValor.getText().toString()),
                                    inputDespesaDescr.getText().toString(),
                                    Calendar.getInstance(),
                                    0
                            );

                            listener.onDespesaDialogPositiveClick(d);
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
