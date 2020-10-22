package com.example.form;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class TariffScreen extends AppCompatActivity {


    private Button tariffBackButton;
    private Button avgPriceButton1;
    private Button avgPriceButton2;
    private Button nextButton;
    private EditText valueG1;
    private EditText valueG2;
    private EditText km1;
    private EditText km2;
    private EditText tim1;
    private EditText tim2;
    private EditText tariffNameField1;
    private EditText tariffNameField2;
    private TextView avgPrice1;
    private TextView avgPrice2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tariffs);

        avgPrice1 = (TextView) findViewById(R.id.avgPrice1);
        avgPrice2 = (TextView) findViewById(R.id.avgPrice2);
        tariffNameField1 = (EditText) findViewById(R.id.tariffNameField1);
        tariffNameField2 = (EditText) findViewById(R.id.tariffNameField2);


        avgPriceButton1 = (Button) findViewById(R.id.avgPriceButton1);
        avgPriceButton1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {


                if (valueG1.getText().length() > 0 && km1.getText().length() > 0 && tim1.getText().length() > 0) {

                    tariffNameField1.setVisibility(View.VISIBLE);
                    tariffNameField1.requestFocus();

                } else {

                    if (valueG1.length() == 0) {

                        valueG1.requestFocus();

                    } else if (km1.length() == 0) {

                        km1.requestFocus();

                    } else if (tim1.length() == 0) {

                        tim1.requestFocus();

                    }

                }
            }
        });

        avgPriceButton2 = (Button) findViewById(R.id.avgPriceButton2);
        avgPriceButton2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                if (valueG2.getText().length() > 0 && km2.getText().length() > 0 && tim2.getText().length() > 0) {

                    tariffNameField2.setVisibility(View.VISIBLE);
                    tariffNameField2.requestFocus();

                } else {

                    if (valueG2.length() == 0) {

                        valueG2.requestFocus();

                    } else if (km2.length() == 0) {

                        km2.requestFocus();

                    } else if (tim2.length() == 0) {

                        tim2.requestFocus();

                    }

                }

            }
        });


        tariffBackButton = (Button) findViewById(R.id.tariffBackButton);
        tariffBackButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                goBack();

            }
        });

        valueG1 = (EditText) findViewById(R.id.g1);
        valueG2 = (EditText) findViewById(R.id.g2);
        valueG1.setOnFocusChangeListener(new View.OnFocusChangeListener() {
            @Override
            public void onFocusChange(View v, boolean hasFocus) {

                if (!hasFocus) {

                    calculateAvgPrice(1);

                }

            }
        });

        valueG2.setOnFocusChangeListener(new View.OnFocusChangeListener() {
            @Override
            public void onFocusChange(View v, boolean hasFocus) {
                if (!hasFocus) {

                    calculateAvgPrice(2);

                }
            }
        });

        km1 = (EditText) findViewById(R.id.km1);
        km2 = (EditText) findViewById(R.id.km2);
        km1.setOnFocusChangeListener(new View.OnFocusChangeListener() {
            @Override
            public void onFocusChange(View v, boolean hasFocus) {

                if (!hasFocus) {

                    calculateAvgPrice(1);

                }

            }
        });

        km2.setOnFocusChangeListener(new View.OnFocusChangeListener() {
            @Override
            public void onFocusChange(View v, boolean hasFocus) {

                if (!hasFocus) {

                    calculateAvgPrice(2);

                }

            }
        });

        tim1 = (EditText) findViewById(R.id.tim1);
        tim2 = (EditText) findViewById(R.id.tim2);
        tim1.setOnFocusChangeListener(new View.OnFocusChangeListener() {
            @Override
            public void onFocusChange(View v, boolean hasFocus) {

                if (!hasFocus) {

                    calculateAvgPrice(1);

                }

            }
        });

        tim2.setOnFocusChangeListener(new View.OnFocusChangeListener() {
            @Override
            public void onFocusChange(View v, boolean hasFocus) {

                if (!hasFocus) {

                    calculateAvgPrice(2);

                }

            }
        });

        nextButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                goToSummery();

            }
        });

    }

    public void calculateAvgPrice(int row) {

        if (row == 1) {


            if (valueG1.getText().length() > 0 && km1.getText().length() > 0 && tim1.getText().length() > 0) {

                double avgPrice = 0;
                double basePrice = Integer.parseInt(valueG1.getText().toString());
                double kmPrice = Integer.parseInt(km1.getText().toString());
                double timPrice = Integer.parseInt(tim1.getText().toString());

                avgPrice = basePrice + (kmPrice * 10) + (timPrice / 4);
                String finalValue = "" + avgPrice;
                avgPrice1.setText(finalValue);


            } else {

                avgPrice1.setText("");

            }
        } else if (row == 2) {

            if (valueG2.getText().length() > 0 && km2.getText().length() > 0 && tim2.getText().length() > 0) {

                double avgPrice = 0;
                double basePrice = Integer.parseInt(valueG2.getText().toString());
                double kmPrice = Integer.parseInt(km2.getText().toString());
                double timPrice = Integer.parseInt(tim2.getText().toString());

                avgPrice = basePrice + (kmPrice * 10) + (timPrice / 4);
                String finalValue = "" + avgPrice;
                avgPrice2.setText(finalValue);


            } else {

                avgPrice2.setText("");

            }
        }
    }

    private void goBack() {

        Intent intent = new Intent(this, TaximeterScreen.class);
        startActivity(intent);

    }

    public void goToSummery() {

        Intent intent = new Intent(this, summeryScreen.class);
        //intent.putExtra("Task", task);
        startActivity(intent);

    }

}
