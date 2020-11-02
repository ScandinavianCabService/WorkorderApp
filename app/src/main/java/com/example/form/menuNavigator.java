package com.example.form;

import android.content.Context;
import android.content.Intent;
import android.view.View;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;

public class menuNavigator extends AppCompatActivity {


    private int homeValue;
    private Context context;
    private Button menu1;
    private Button menu2;
    private Button menu3;
    private Button menu4;
    private Button menu5;

    private Intent intent;


    public menuNavigator(int homeValue, final Context context, Button menu1, Button menu2, Button menu3, Button menu4, Button menu5) {
        this.homeValue = homeValue;
        this.context = context;
        this.menu1 = (Button)menu1;
        this.menu2 = (Button)menu2;
        this.menu3 = (Button)menu3;
        this.menu4 = (Button)menu4;
        this.menu5 = (Button)menu5;

        System.out.println(context);
/*
        menu1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                sendTo(1);

            }
        });

        menu2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                System.out.println(context);
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
*/
    }

    public void sendTo(int where, Context context) {

        if (where != homeValue) {

            switch (where) {

                case 1:
                    intent = new Intent(context, MainScreen.class);
                    startActivity(intent);
                    break;
                case 2:
                    intent = new Intent(this, InformationScreen.class);
                    startActivity(intent);
                    break;
                case 3:
                    intent = new Intent(context, TaximeterScreen.class);
                    startActivity(intent);
                    break;
                case 4:
                    intent = new Intent(context, Tarrif.class);
                    startActivity(intent);
                    break;
                case 5:
                    intent = new Intent(context, summeryScreen.class);
                    startActivity(intent);
                    break;


            }

        }

    }


}
