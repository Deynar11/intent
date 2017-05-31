package com.example.lab_sistemas.intens;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class SegundaActivity extends AppCompatActivity {

    private EditText etResultado;
    private Button btnDevolver;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_segunda);

        etResultado = (EditText) findViewById(R.id.etResultado);
        btnDevolver =(Button) findViewById(R.id.btnDevolver);

        Bundle bundle = getIntent().getExtras();

        String resultado = bundle.getString("dato1");

        etResultado.setText(resultado);

        btnDevolver.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent();
                intent.putExtra("respuesta", etResultado.getText().toString());
                setResult(RESULT_OK, intent);
                finish();
            }
        });
    }
}
