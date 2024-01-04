package fmu.money;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import com.google.android.material.floatingactionbutton.FloatingActionButton;

public class InfoActivity extends AppCompatActivity implements View.OnClickListener{

    private FloatingActionButton fabReturnMain;

    @Override
    public void onClick(View v) {
        Intent reopenMainActivity;
        int viewId = v.getId();

        if (viewId == R.id.fabReturnMain){
            reopenMainActivity = new Intent(this, MainActivity.class);

            //Coloca a MainActivity no topo se já estiver iniciada (não chama o onCreate() dela repetidamente sem motivo)
            reopenMainActivity.setFlags(Intent.FLAG_ACTIVITY_REORDER_TO_FRONT);
            startActivityIfNeeded(reopenMainActivity, 0);
        }
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_info);

        fabReturnMain = findViewById(R.id.fabReturnMain);
        fabReturnMain.setOnClickListener(this);
    }
}