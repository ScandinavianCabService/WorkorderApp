package com.example.form;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class InformationScreen extends AppCompatActivity {

    private String task;

    private Button infoBackButton;
    private Button infoDoneButton;

    private EditText regnrField;
    private EditText orgnrField;
    private EditText companyField;
    private EditText adressField;
    private EditText postnrField;
    private EditText ortField;
    private EditText emailField;
    private EditText telefonField;

    private String Registreringsnummer = "Registreringsnummer";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_information);

        infoBackButton = (Button) findViewById(R.id.infoBackButton);
        infoDoneButton = (Button) findViewById(R.id.infoDoneButton);

        regnrField = (EditText) findViewById(R.id.regNrField);
        orgnrField = (EditText) findViewById(R.id.orgnrField);
        companyField = (EditText) findViewById(R.id.companyNameField);
        adressField = (EditText) findViewById(R.id.adressField);
        postnrField = (EditText) findViewById(R.id.postnrField);
        ortField = (EditText) findViewById(R.id.ortField);
        emailField = (EditText) findViewById(R.id.emailField2);
        telefonField = (EditText) findViewById(R.id.phoneField);

        task = getIntent().getExtras().getString("task");


        infoBackButton.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {


                goBack();

            }
        });

        infoDoneButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                infoPackage bio = new infoPackage(
                        regnrField.getText().toString(),
                        orgnrField.getText().toString(),
                        companyField.getText().toString(),
                        adressField.getText().toString(),
                        postnrField.getText().toString(),
                        ortField.getText().toString(),
                        emailField.getText().toString(),
                        telefonField.getText().toString());

                nextPage(bio);

            }
        });


    }


    private boolean checkValues() {

        boolean returnValue = true;

        for (int i = 0; i < 8; i++) {

            if (i == 0 && regnrField.getText().toString().length() < 6 || checkRegnr(regnrField.getText().toString()) == false) {

                returnValue = false;
                regnrField.requestFocus();
                regnrField.setError("Ogiltigt Registrerings nummer");
                break;
            } else if (i == 1 && orgnrField.getText().toString().length() < 10) {
                returnValue = false;
                orgnrField.requestFocus();
                orgnrField.setError("Organisations nummer måste vara 10 siffror");
                break;
            } else if (i == 2 && companyField.getText().toString().length() == 0) {
                returnValue = false;
                companyField.requestFocus();
                companyField.setError("Företags namn kan inte vara tomt");
                break;
            } else if (i == 3 && adressField.getText().toString().length() == 0) {
                returnValue = false;
                adressField.requestFocus();
                adressField.setError("Adress kan inte vara tomt");
                break;
            } else if (i == 4 && postnrField.getText().toString().length() < 5) {
                returnValue = false;
                postnrField.requestFocus();
                postnrField.setError("Post nummer måste vara 5 siffror");
                break;
            } else if (i == 5 && ortField.getText().toString().length() == 0) {
                returnValue = false;
                ortField.requestFocus();
                ortField.setError("Ort kan inte vara tomt");
                break;
            } else if (i == 6) {
                boolean emailError = false;
                String emailErrorText = "Inte giltig Epost";
                emailError = emailField.getText().toString().length() == 0;
                System.out.println("Email: " + emailField.getText().toString());
                if (emailError == false) {
                    emailError = checkMail(emailField.getText().toString().toLowerCase());
                }

                if (emailError == false) {
                    returnValue = false;
                    emailField.requestFocus();
                    emailField.setError(emailErrorText);
                    break;
                }
            } else if (i == 7) {

                boolean telefonError = false;

                telefonError = telefonField.getText().toString().length() == 0;

                if (!telefonError) {
                    telefonError = telefonField.getText().toString().length() < 8;
                }
                if (!telefonError) {
                    telefonError = telefonField.getText().toString().charAt(0) != '0';
                }

                if (telefonError) {
                    returnValue = false;
                    telefonField.requestFocus();
                    telefonField.setError("Ogiltigt telefon nummer");
                    break;
                }

            }

        }


        return returnValue;

    }

    private boolean checkMail(String email) {

        Pattern pattern = Pattern.compile("(?:[a-z0-9!#$%&'*+/=?^_`{|}~-]+(?:\\.[a-z0-9!#$%&'*+/=?^_`{|}~-]+)*|\"(?:[\\x01-\\x08\\x0b\\x0c\\x0e-\\x1f\\x21\\x23-\\x5b\\x5d-\\x7f]|\\[\\x01-\\x09\\x0b\\x0c\\x0e-\\x7f])*\")@(?:(?:[a-z0-9](?:[a-z0-9-]*[a-z0-9])?\\.)+[a-z0-9](?:[a-z0-9-]*[a-z0-9])?|\\[(?:(?:25[0-5]|2[0-4][0-9]|[01]?[0-9][0-9]?)\\.){3}(?:25[0-5]|2[0-4][0-9]|[01]?[0-9][0-9]?|[a-z0-9-]*[a-z0-9]:(?:[\\x01-\\x08\\x0b\\x0c\\x0e-\\x1f\\x21-\\x5a\\x53-\\x7f]|\\[\\x01-\\x09\\x0b\\x0c\\x0e-\\x7f])+)\\])");
        Matcher matcher = pattern.matcher(email);
        return matcher.matches();

    }

    private boolean checkRegnr(String regnr) {

        Pattern pattern = Pattern.compile("[a-zA-Z]{3}[0-9]{2}[a-zA-Z0-9]");
        Matcher matcher = pattern.matcher(regnr);
        return matcher.matches();

    }

    private void goBack() {

        Intent intent = new Intent(this, MainScreen.class);
        startActivity(intent);

    }

    private void nextPage(infoPackage infoPackage) {

        if (checkValues()) {

            Intent intent = new Intent(this, TaximeterScreen.class);
            intent.putExtras(getIntent().getExtras());
            intent.putExtra("bio", infoPackage);

            startActivity(intent);
        } else {
            //TODO: Add error function
        }

    }
}
