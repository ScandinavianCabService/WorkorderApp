package com.example.form;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class TaximeterScreen extends AppCompatActivity {

    private int homeValue = 3;

    private Button m2Button;
    private Button c30Button;
    private Button megtaxButton;
    private Button digitaxButton;
    private Button taxaBackButton;
    private infoPackage bio;
    private String task;

    private Button menu1;
    private Button menu2;
    private Button menu3;
    private Button menu4;
    private Button menu5;

    private completePackage cp;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_taximeter);

        if (getIntent().getExtras().get("package") != null) {

            cp = (completePackage) getIntent().getExtras().get("package");

        } else {

            cp = new completePackage();
        }

        menu1 = (Button) findViewById(R.id.menu1taximeter);
        menu2 = (Button) findViewById(R.id.menu2taximeter);
        menu3 = (Button) findViewById(R.id.menu3taximeter);
        menu4 = (Button) findViewById(R.id.menu4taximeter);
        menu5 = (Button) findViewById(R.id.menu5taximeter);

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

        menu1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                sendTo(1);
            }
        });

        menu2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                sendTo(2);
            }
        });

        menu3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                sendTo(3);
            }
        });

        menu4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                sendTo(4);
            }
        });

        menu5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                sendTo(5);
            }
        });

    }

    public void sendTo(int where) {
        Intent intent;
        if (where != homeValue) {


            switch (where) {

                case 1:
                    intent = new Intent(this, MainScreen.class);
                    break;
                case 2:
                    intent = new Intent(this, InformationScreen.class);
                    //startActivity(intent);
                    break;
                case 3:
                    intent = new Intent(this, TaximeterScreen.class);
                    // startActivity(intent);
                    break;
                case 4:
                    intent = new Intent(this, activity_tariffs.class);
                    // startActivity(intent);
                    break;
                case 5:
                    intent = new Intent(this, summeryScreen.class);
                    // startActivity(intent);
                    break;
                default:
                    intent = new Intent(this, MainScreen.class);
                    System.err.println("!!!!!!!!!!!!!! -- Something went wrong -- !!!!!!!!!!!!!!!!!!");
                    break;


            }
            intent.putExtra("package", cp);
            startActivity(intent);

        }
    }

    private void nextPage(String taxameter) {

        Intent intent = new Intent(this, activity_tariffs.class);
        intent.putExtras(getIntent().getExtras());
        cp.setTaxameter(taxameter);
        intent.putExtra("package", cp);
        intent.putExtra("taxameter", taxameter);
        startActivity(intent);

    }

    private void goBack() {

        Intent intent = new Intent(this, InformationScreen.class);
        startActivity(intent);

    }

}
