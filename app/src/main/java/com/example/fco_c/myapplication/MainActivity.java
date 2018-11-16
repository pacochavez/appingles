package com.example.fco_c.myapplication;

import android.content.Intent;
import android.graphics.Color;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity  extends AppCompatActivity {

  String[] palabras= {"Cat","Dog","Mouse","Fish","Bird","Parrot","Frog","Rabbit","Pig","Hedgehog","Black","White","Gray","Yellow","Red","Blue","Green","Purple","Orange","Pink","Apple","Pear","Banana","Grape","Cherry","Chair","Couch","Bed","Table","Pillow"};
  String[] correctas= {"Gato","Perro","Ratón","Péz","Ave","Loro","Rana","Conejo","Cerdo","Erizo","Negro","Blanco","Gris","Amarillo","Rojo","Azul","Verde","Purpura","Naranja","Rosado","Manzana","Pera","Platano","Uva","Cereza","Silla","Sillon","Cama","Mesa","Almohada"};
  public Button btnUno;
  public Button btnDos;
  public Button btnTres;
  public Button btnCuatro;
  public Button btnAceptar;
  public TextView txtPalabra;

  //Respuesta correcta
  int n=0;

  //Correctas
  int c=0;

  //Secuencia
  int i=0;

  //Boton Correcto
  int v=0;

  public void Secuencia(){
    n= (int)(Math.random()*30);
    txtPalabra.setText(palabras[n]);
    int x=(int)(Math.random()*4);
    v=x;

    btnUno.setText(correctas[(int)(Math.random()*30)]);
    btnDos.setText(correctas[(int)(Math.random()*30)]);
    btnTres.setText(correctas[(int)(Math.random()*30)]);
    btnCuatro.setText(correctas[(int)(Math.random()*30)]);

    switch(x){

      case 0:
        btnUno.setText(correctas[n]);
        break;
      case 1:
        btnDos.setText(correctas[n]);
        break;
      case 2:
        btnTres.setText(correctas[n]);
        break;
      case 3:
        btnCuatro.setText(correctas[n]);
        break;
    }
  }

  public void resultado(){

    btnUno.setBackgroundColor(Color.RED);
    btnDos.setBackgroundColor(Color.RED);
    btnTres.setBackgroundColor(Color.RED);
    btnCuatro.setBackgroundColor(Color.RED);
    switch(v){
      case 0:
        btnUno.setBackgroundColor(Color.GREEN);
        break;
      case 1:
        btnDos.setBackgroundColor(Color.GREEN);
        break;
      case 2:
        btnTres.setBackgroundColor(Color.GREEN);
        break;
      case 3:
        btnCuatro.setBackgroundColor(Color.GREEN);
        break;
    }
    btnUno.setEnabled(false);
    btnDos.setEnabled(false);
    btnTres.setEnabled(false);
    btnCuatro.setEnabled(false);
  }

  public void confirmar(){

    btnAceptar.setOnClickListener(new View.OnClickListener() {
      @Override
      public void onClick(View view) {

        btnUno.setBackgroundColor(btnAceptar.getSolidColor());
        btnDos.setBackgroundColor(btnAceptar.getSolidColor());
        btnTres.setBackgroundColor(btnAceptar.getSolidColor());
        btnCuatro.setBackgroundColor(btnAceptar.getSolidColor());

        btnUno.setEnabled(true);
        btnDos.setEnabled(true);
        btnTres.setEnabled(true);
        btnCuatro.setEnabled(true);
        Secuencia();
      }
    });
  }

  @Override
  protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.activity_main);

    btnUno = (Button) findViewById(R.id.btnA);
    btnDos = (Button) findViewById(R.id.btnB);
    btnTres = (Button) findViewById(R.id.btnC);
    btnCuatro = (Button) findViewById(R.id.btnD);
    btnAceptar= (Button) findViewById(R.id.btnAceptar);
    txtPalabra = (TextView) findViewById(R.id.txtPalabra);

    Secuencia();
    while (i < 15) {
      btnUno.setOnClickListener(new View.OnClickListener() {
        @Override
        public void onClick(View view) {

          if (btnUno.getText().equals(correctas[n])) {
            c = c + 1;
          } else {

            resultado();
          }
          confirmar();
        }
      });

      btnDos.setOnClickListener(new View.OnClickListener() {
        @Override
        public void onClick(View view) {

          if (btnDos.getText().equals(correctas[n])) {
            c = c + 1;
          } else {
            resultado();
          }
          confirmar();
        }
      });

      btnTres.setOnClickListener(new View.OnClickListener() {
        @Override
        public void onClick(View view) {

          if (btnTres.getText().equals(correctas[n])) {
            c = c + 1;
          } else {
            resultado();
          }
          confirmar();
        }
      });

      btnCuatro.setOnClickListener(new View.OnClickListener() {
        @Override
        public void onClick(View view) {

          if (btnCuatro.getText().equals(correctas[n])) {
            c = c + 1;
          } else {
            resultado();
          }
          confirmar();
        }
      });
      i=i+1;
    }
   // Intent intent= new Intent(MainActivity.this,demo_resultado.class);
   // Bundle b= new Bundle();
   // b.putInt("key",c);
   // intent.putExtras(b);
   // startActivity(intent);
    //finish();
  }
}
