package com.example.form;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class TaximeterScreen extends AppCompatActivity {

    private Button m2Button;
    private Button c30Button;
    private Button megtaxButton;
    private Button digitaxButton;
    private Button taxaBackButton;
    private infoPackage bio;
    private String task;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_taximeter);

        m2Button = (Button) findViewById(R.id.m2Button);
        c30Button = (Button) findViewById(R.id.c30Button);
        megtaxButton = (Button) findViewById(R.id.megtaxButton);
        digitaxButton = (Button) findViewById(R.id.digitaxButton);
        taxaBackButton = (Button) findViewById(R.id.taxaBackButton);




        m2Button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                nextPage("M2");

            }
        });

        c30Button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                nextPage("C30");

            }
        });

        megtaxButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                nextPage("Megtax");

            }
        });

        digitaxButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                nextPage("Digitax");

            }
        });

        taxaBackButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                goBack();

            }
        });

    }

    private void nextPage(String taxameter) {

        Intent intent = new Intent(this, activity_tariffs.class);
        intent.putExtras(getIntent().getExtras());
        intent.putExtra("taxameter", taxameter);
        startActivity(intent);

    }

    private void goBack() {

        Intent intent = new Intent(this, InformationScreen.class);
        startActivity(intent);

    }

}
