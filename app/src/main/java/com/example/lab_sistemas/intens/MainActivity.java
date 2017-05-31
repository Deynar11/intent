package com.example.lab_sistemas.intens;

import android.content.Intent;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import static android.R.attr.data;

public class MainActivity extends AppCompatActivity {

    private Button btnAbrir;
    private Button btnEnviar;
    private Button btnRecibir;
    private Button btnAbrirMarcado;
    private Button btnLlamar;
    private Button btnAbrirGoogleMaps;
    private Button btnAbrirPaginaWeb;
    private Button btnCompartirTexto;
    private Button btnCompartirImagen;
    private Button btnEnviarEmail;
    private Button btnAbrirAplicacion;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        btnAbrir = (Button) findViewById(R.id.btnAbrir);
        btnEnviar = (Button) findViewById(R.id.btnEnviar);
        btnRecibir =(Button) findViewById(R.id.btnRecibir);
        btnAbrirMarcado = (Button) findViewById(R.id.btnMarcado);
        btnLlamar = (Button) findViewById(R.id.btnLlamar);
        btnAbrirGoogleMaps = (Button)findViewById(R.id.btnMaps);
        btnAbrirPaginaWeb = (Button) findViewById(R.id.btnWeb);
        btnCompartirTexto = (Button) findViewById(R.id.btnComTex);
        btnCompartirImagen = (Button) findViewById(R.id.btnComIma);
        btnEnviarEmail = (Button) findViewById(R.id.btnEmail);
        btnAbrirAplicacion = (Button) findViewById(R.id.btnApp);

        btnAbrir.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(),SegundaActivity.class);
                startActivity(intent);
            }
        });
        btnEnviar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(),SegundaActivity.class);
                intent.putExtra("dato1", "Android Unifranz");
                startActivity(intent);
            }
        });

        btnRecibir.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(),SegundaActivity.class);
                intent.putExtra("dato","Es un String");
                startActivityForResult(intent,2);
            }
        });
        btnAbrirMarcado.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Intent.ACTION_DIAL);
                intent.setData(Uri.parse("tel: 76515987"));
                startActivity(intent);
            }
        });
        btnAbrirGoogleMaps.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Intent.ACTION_VIEW);
                intent.setData(Uri.parse("geo:-16.25451,-68.45215"));
                startActivity(intent);
            }
        });
        btnAbrirPaginaWeb.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Intent.ACTION_VIEW);
                intent.setData(Uri.parse("https://www.google.com"));
                startActivity(intent);
            }
        });

    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode,data);
        if(requestCode == 2){
            if (resultCode == RESULT_OK){
                String res = data.getStringExtra("respuesta").toString();
                Toast.makeText(getApplicationContext(),"RECIBIDO"+res,Toast.LENGTH_LONG).show();
            }else{
                Toast.makeText(getApplicationContext(),"CANCELO LA OPERACION",Toast.LENGTH_LONG).show();
            }
        }
    }
}
