package com.example.fco_c.myapplication;

import android.content.Intent;
import android.graphics.Color;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class demo_resultado extends AppCompatActivity {

  public Button retorno;
  public TextView aciertos;
  public TextView veredicto;

  @Override
  protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.demo_resultado);

    retorno= (Button) findViewById(R.id.btnRegresar);
    aciertos= (TextView) findViewById(R.id.txtAciertos);
    veredicto= (TextView) findViewById(R.id.txtVeredicto);

    //Importa el valor de la actividad de resultado
    Intent intent= getIntent();
    int n= intent.getIntExtra("key",0);

    aciertos.setText(n+" / 15");
    if(n>=12){

      veredicto.setBackgroundColor(Color.GREEN);
      veredicto.setText("Pasaste!");
    }
    else{
      veredicto.setBackgroundColor(Color.RED);
      veredicto.setText("Intenta otra vez!");
    }

    retorno.setOnClickListener(new View.OnClickListener() {
      @Override
      public void onClick(View view) {

        Intent intent= new Intent(demo_resultado.this,demo_menu.class);
        startActivity(intent);
        //finish();
      }
    });

  }
}
