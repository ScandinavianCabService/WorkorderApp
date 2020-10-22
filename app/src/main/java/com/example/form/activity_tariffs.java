package com.example.form;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.ToggleButton;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

public class activity_tariffs extends AppCompatActivity {

    private Button doneButton;

    private ToggleButton taxa199;
    private ToggleButton taxa299;
    private ToggleButton taxa375;
    private ToggleButton taxa399;
    private ToggleButton taxa495;
    private ToggleButton taxa496;
    private ToggleButton taxa499;
    private ToggleButton taxa625;
    private ToggleButton taxa750;
    private ToggleButton taxa895;

    private TextView grundpris1;
    private TextView grundpris2;
    private TextView grundpris3;
    private TextView grundpris4;
    private TextView grundpris5;

    private TextView krkm1;
    private TextView krkm2;
    private TextView krkm3;
    private TextView krkm4;
    private TextView krkm5;

    private TextView krtim1;
    private TextView krtim2;
    private TextView krtim3;
    private TextView krtim4;
    private TextView krtim5;

    private TextView avg1;
    private TextView avg2;
    private TextView avg3;
    private TextView avg4;
    private TextView avg5;

    private ArrayList<Integer> list = new ArrayList<>();
    private ArrayList<Tarrif_list_item> tList = new ArrayList<>();
    private ArrayList<ToggleButton> buttonList = new ArrayList<>();

    private Tarrif_list_item i199 = new Tarrif_list_item(40, 7.45,339, 199);
    private Tarrif_list_item i299 = new Tarrif_list_item(45, 12.5, 515, 299);
    private Tarrif_list_item i375 = new Tarrif_list_item(56, 16.25, 625, 375);
    private Tarrif_list_item i399 = new Tarrif_list_item(49, 15,800, 399);
    private Tarrif_list_item i495 = new Tarrif_list_item(70, 30, 500, 495);
    private Tarrif_list_item i496 = new Tarrif_list_item(50, 30, 584, 496);
    private Tarrif_list_item i499 = new Tarrif_list_item(49, 15 , 1200, 499);
    private Tarrif_list_item i625 = new Tarrif_list_item(70, 32,940, 625);
    private Tarrif_list_item i750 = new Tarrif_list_item(75, 47.5, 800, 750);
    private Tarrif_list_item i895 = new Tarrif_list_item(75, 37,1800, 895);

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tariffs2);

        doneButton = (Button) findViewById(R.id.doneButton);

        taxa199 = (ToggleButton) findViewById(R.id.taxa199Button);
        taxa299 = (ToggleButton) findViewById(R.id.taxa299Button);
        taxa375 = (ToggleButton) findViewById(R.id.taxa375Button);
        taxa399 = (ToggleButton) findViewById(R.id.taxa399Button);
        taxa495 = (ToggleButton) findViewById(R.id.taxa495Button);
        taxa496 = (ToggleButton) findViewById(R.id.taxa496Button);
        taxa499 = (ToggleButton) findViewById(R.id.taxa499button);
        taxa625 = (ToggleButton) findViewById(R.id.taxa625Button);
        taxa750 = (ToggleButton) findViewById(R.id.taxa750Button);
        taxa895 = (ToggleButton) findViewById(R.id.taxa895Button);

        grundpris1 = (TextView) findViewById(R.id.grundpris1);
        grundpris2 = (TextView) findViewById(R.id.grundpris2);
        grundpris3 = (TextView) findViewById(R.id.grundpris3);
        grundpris4 = (TextView) findViewById(R.id.grundpris4);
        grundpris5 = (TextView) findViewById(R.id.grundpris5);

        krkm1 = (TextView) findViewById(R.id.krkm1);
        krkm2 = (TextView) findViewById(R.id.krkm2);
        krkm3 = (TextView) findViewById(R.id.krkm3);
        krkm4 = (TextView) findViewById(R.id.krkm4);
        krkm5 = (TextView) findViewById(R.id.krkm5);

        krtim1 = (TextView) findViewById(R.id.krtim1);
        krtim2 = (TextView) findViewById(R.id.krtim2);
        krtim3 = (TextView) findViewById(R.id.krtim3);
        krtim4 = (TextView) findViewById(R.id.krtim4);
        krtim5 = (TextView) findViewById(R.id.krtim5);

        avg1 = (TextView) findViewById(R.id.avg1);
        avg2 = (TextView) findViewById(R.id.avg2);
        avg3 = (TextView) findViewById(R.id.avg3);
        avg4 = (TextView) findViewById(R.id.avg4);
        avg5 = (TextView) findViewById(R.id.avg5);

        buttonList.add(taxa199);
        buttonList.add(taxa299);
        buttonList.add(taxa375);
        buttonList.add(taxa399);
        buttonList.add(taxa495);
        buttonList.add(taxa496);
        buttonList.add(taxa499);
        buttonList.add(taxa625);
        buttonList.add(taxa750);
        buttonList.add(taxa895);

        doneButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                nextPage();

            }
        });

        taxa199.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                if(taxa199.isChecked()) {

                    list.add(199);
                    tList.add(i199);

                } else {
                    if(list.contains(199)) {
                        list.remove("199");

                    }

                    if(tList.contains(i199)) {

                        tList.remove(i199);

                    }

                }

                updateTariffs();

            }
        });

        taxa299.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                if(taxa299.isChecked()) {

                    list.add(299);
                    tList.add(i299);


                } else {
                    if(list.contains(299)) {
                        list.remove("299");
                    }

                    if(tList.contains(i299)) {
                        tList.remove(i299);
                    }

                }

                updateTariffs();

            }
        });

        taxa375.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                if(taxa375.isChecked()) {

                    list.add(375);
                    tList.add(i375);

                } else {

                    if(list.contains(375)) {
                        list.remove("375");
                    }

                    if(tList.contains(i375)) {
                        tList.remove(i375);
                    }

                }

                updateTariffs();

            }
        });

        taxa399.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                if(taxa399.isChecked()) {

                    list.add(399);
                    tList.add(i399);

                } else {

                    if(list.contains(399)) {
                        list.remove("399");
                    }
                    if(tList.contains(i399)) {
                        tList.remove(i399);
                    }
                }

                updateTariffs();

            }
        });

        taxa495.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                if(taxa495.isChecked()) {

                    list.add(495);
                    tList.add(i495);

                } else {

                    if(list.contains(495)) {
                        list.remove("495");
                    }
                    if(tList.contains(i495)) {
                        tList.remove(i495);
                    }
                }

                updateTariffs();

            }
        });

        taxa496.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                if(taxa496.isChecked()) {

                    list.add(496);
                    tList.add(i496);

                } else {

                    if(list.contains(496)) {
                        list.remove("496");
                    }
                    if(tList.contains(i496)) {
                        tList.remove(i496);
                    }
                }

                updateTariffs();

            }
        });

        taxa499.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                if(taxa499.isChecked()) {
                    list.add(499);
                    tList.add(i499);

                } else {

                    if(list.contains(499)) {
                        list.remove("499");
                    }
                    if(tList.contains(i499)) {
                        tList.remove(i499);
                    }
                }

                updateTariffs();

            }
        });

        taxa625.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                if(taxa625.isChecked()) {
                    list.add(625);
                    tList.add(i625);

                } else {

                    if(list.contains(625)) {
                        list.remove("625");
                    }
                    if(tList.contains(i625)) {
                        tList.remove(i625);
                    }
                }

                updateTariffs();

            }
        });

        taxa750.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                if(taxa750.isChecked()) {
                    list.add(750);
                    tList.add(i750);

                } else {

                    if(list.contains(750)) {
                        list.remove("750");
                    }
                    if(tList.contains(i750)) {
                        tList.remove(i750);
                    }
                }

                updateTariffs();

            }
        });

        taxa895.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                if(taxa895.isChecked()) {
                    list.add(895);
                    tList.add(i895);

                } else {

                    if(list.contains(895)) {
                        list.remove("895");
                    }
                    if(tList.contains(i895)) {
                        tList.remove(i895);
                    }
                }

                updateTariffs();

            }
        });

    }

    private void updateTariffs() {

        if(!list.isEmpty()) {

            Collections.sort(list, Collections.<Integer>reverseOrder());

            Collections.sort(tList, Collections.<Tarrif_list_item>reverseOrder());

            clear();
            lockButtons();

            if(tList.size() > 0) {

                grundpris1.setText("" + tList.get(0).getGrundpris());
                krkm1.setText("" + tList.get(0).getKrkm());
                krtim1.setText("" + tList.get(0).getKrtim());
                avg1.setText("" + tList.get(0).getAvg());

            }

            if(tList.size() > 1) {

                grundpris2.setText("" + tList.get(1).getGrundpris());
                krkm2.setText("" + tList.get(1).getKrkm());
                krtim2.setText("" + tList.get(1).getKrtim());
                avg2.setText("" + tList.get(1).getAvg());

            }

            if(tList.size() > 2) {

                grundpris3.setText("" + tList.get(2).getGrundpris());
                krkm3.setText("" + tList.get(2).getKrkm());
                krtim3.setText("" + tList.get(2).getKrtim());
                avg3.setText("" + tList.get(2).getAvg());

            }

            if(tList.size() > 3) {

                grundpris4.setText("" + tList.get(3).getGrundpris());
                krkm4.setText("" + tList.get(3).getKrkm());
                krtim4.setText("" + tList.get(3).getKrtim());
                avg4.setText("" + tList.get(3).getAvg());

            }

            if(tList.size() > 4) {

                grundpris5.setText("" + tList.get(4).getGrundpris());
                krkm5.setText("" + tList.get(4).getKrkm());
                krtim5.setText("" + tList.get(4).getKrtim());
                avg5.setText("" + tList.get(4).getAvg());

            }


        }

    }

    public void lockButtons() {

        if(tList.size() > 2) {

            if(!taxa199.isChecked()) {
                taxa199.setEnabled(false);
            }

            if(!taxa299.isChecked()) {
                taxa299.setEnabled(false);
            }

            if(!taxa375.isChecked()) {
                taxa375.setEnabled(false);
            }

            if(!taxa399.isChecked()) {
                taxa399.setEnabled(false);
            }

            if(!taxa495.isChecked()) {
                taxa495.setEnabled(false);
            }

            if(!taxa496.isChecked()) {
                taxa496.setEnabled(false);
            }

            if(!taxa499.isChecked()) {
                taxa499.setEnabled(false);
            }

            if(!taxa625.isChecked()) {
                taxa625.setEnabled(false);
            }

            if(!taxa750.isChecked()) {
                taxa750.setEnabled(false);
            }

            if(!taxa895.isChecked()) {
                taxa895.setEnabled(false);
            }

        }

        if(tList.size() < 3) {

            taxa199.setEnabled(true);
            taxa299.setEnabled(true);
            taxa375.setEnabled(true);
            taxa399.setEnabled(true);
            taxa495.setEnabled(true);

            taxa496.setEnabled(true);
            taxa499.setEnabled(true);
            taxa625.setEnabled(true);
            taxa750.setEnabled(true);
            taxa895.setEnabled(true);

        }

    }

    public void clear() {

        grundpris1.setText("");
        grundpris2.setText("");
        grundpris3.setText("");
        grundpris4.setText("");
        grundpris5.setText("");

        krkm1.setText("");
        krkm2.setText("");
        krkm3.setText("");
        krkm4.setText("");
        krkm5.setText("");

        krtim1.setText("");
        krtim2.setText("");
        krtim3.setText("");
        krtim4.setText("");
        krtim5.setText("");

        avg1.setText("");
        avg2.setText("");
        avg3.setText("");
        avg4.setText("");
        avg5.setText("");
    }

    public void nextPage() {

        Intent intent = new Intent(this, summeryScreen.class);
        intent.putExtras(getIntent().getExtras());
        intent.putExtra("tarrifs", list);

        startActivity(intent);

    }
}