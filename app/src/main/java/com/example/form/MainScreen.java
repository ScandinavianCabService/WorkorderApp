package com.example.form;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import java.util.HashMap;

public class MainScreen extends AppCompatActivity {

    private Button inspectionButton;
    private Button installationButton;
    private Button demontageButton;
    private Button updateTariffsButton;
    private Button troubleshootButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        inspectionButton = (Button) findViewById(R.id.inspectionButton);
        installationButton = (Button) findViewById(R.id.installationButton);
        demontageButton = (Button) findViewById(R.id.demontageButton);
        updateTariffsButton = (Button) findViewById(R.id.updateTarifsButton);
        troubleshootButton = (Button) findViewById(R.id.troubleshootButton);

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

        updateTariffsButton.setOnClickListener(new View.OnClickListener() {
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

    }

    private void goToBio(String task) {

        Intent intent = new Intent(this, InformationScreen.class);
        intent.putExtra("task", task);
        startActivity(intent);

    }

    private void goToTest() {

        Intent intent = new Intent(this, activity_tariffs.class);
        startActivity(intent);

    }

    //TODO: REMOVE THIS BEFORE RELEASING
    public void sendDataTest(String requestURL, HashMap<String, String> postDataParams) {



    }
}
