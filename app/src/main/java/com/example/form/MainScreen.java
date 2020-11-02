package com.example.form;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import java.util.HashMap;

public class MainScreen extends AppCompatActivity {

    private menuNavigator navigator;

    private Button inspectionButton;
    private Button installationButton;
    private Button demontageButton;

    private int homeValue = 1;
    private Button updateTariffsButton;
    private Button troubleshootButton;

    private Button menu1;
    private Button menu2;
    private Button menu3;
    private Button menu4;
    private Button menu5;

    private completePackage cp;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        if (getIntent().getExtras() != null) {

            cp = (completePackage) getIntent().getExtras().get("package");

        } else {

            cp = new completePackage();
        }


        menu1 = (Button) findViewById(R.id.Menu1arbete);
        menu2 = (Button) findViewById(R.id.Menu2arbete);
        menu3 = (Button) findViewById(R.id.Menu3arbete);
        menu4 = (Button) findViewById(R.id.Menu4arbete);
        menu5 = (Button) findViewById(R.id.Menu5arbete);

        navigator = new menuNavigator(1, this, menu1, menu2, menu3, menu4, menu5);

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


        inspectionButton = (Button) findViewById(R.id.inspectionButton);
        installationButton = (Button) findViewById(R.id.installationButton);
        demontageButton = (Button) findViewById(R.id.demontageButton);
        //updateTariffsButton = (Button) findViewById(R.id.updateTarifsButton);
        //troubleshootButton = (Button) findViewById(R.id.troubleshootButton);

        inspectionButton.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {

                goToBio("Besiktning");

            }
        });

        installationButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                goToBio("Installation");

            }
        });

        demontageButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                goToBio("Demontage");

            }
        });

       /* updateTariffsButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                goToBio("Tariffs");

            }
        });

        troubleshootButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

          //      goToBio("Troubleshoot");
                goToTest();

            }
        });
        */
    }

    private void goToBio(String task) {

        Intent intent = new Intent(this, InformationScreen.class);
        cp.setTask(task);
        intent.putExtra("task", task);
        intent.putExtra("package", cp);
        startActivity(intent);

    }

    private void goToTest() {

        Intent intent = new Intent(this, activity_tariffs.class);
        startActivity(intent);

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

    //TODO: REMOVE THIS BEFORE RELEASING
    public void sendDataTest(String requestURL, HashMap<String, String> postDataParams) {


    }
}
