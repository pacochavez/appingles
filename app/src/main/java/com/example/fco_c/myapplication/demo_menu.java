package com.example.fco_c.myapplication;

import android.content.Intent;
  import android.support.v7.app.AppCompatActivity;
  import android.os.Bundle;
  import android.view.View;
  import android.widget.Button;

import static com.example.fco_c.myapplication.R.layout.activity_main;

public class demo_menu extends AppCompatActivity {

  public Button principiante;
  public Button cerrar;

  @Override
  protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.demo_menu);
    principiante=(Button)findViewById(R.id.btnPrincipiante);
    principiante.setOnClickListener(new View.OnClickListener(){
      @Override
      public void onClick(View view){

        Intent intent= new Intent(demo_menu.this,MainActivity.class);

        startActivity(intent);
        //finish();
      }
    });

    cerrar=(Button)findViewById(R.id.btnSalir);
    cerrar.setOnClickListener(new View.OnClickListener(){
      @Override
      public void onClick(View view){
        finish();
      }
    });
  }
}
