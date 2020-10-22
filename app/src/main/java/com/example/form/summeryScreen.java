package com.example.form;

import androidx.appcompat.app.AppCompatActivity;

import java.io.IOException;
import java.util.ArrayList;

import okhttp3.MediaType;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.RequestBody;
import okhttp3.Response;

import android.os.Build;
import android.os.Bundle;
import android.os.StrictMode;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class summeryScreen extends AppCompatActivity {

    OkHttpClient client = new OkHttpClient();
    private Button nextButton;
    private Button getTestButton;
    private TextView testField;
    private completePackage cp;
    public static final MediaType JSON = MediaType.get("application/json; charset=utf-8");
    public static final MediaType PLAINTEXT = MediaType.get("text/plain; charset=utf-8");
    public static final String baseURL = "http://192.168.1.5:8080/RestClient/resources/REST/";

    private String type;
    private String model;
    private String regnr;
    private String orgnr;
    private String companyName;
    private String adress;
    private String postnr;
    private String ort;
    private String email;
    private String telefon;
    private String tarrif1;
    private String tarrif2;
    private String tarrif3;

    private TextView typeView;
    private TextView modelView;
    private TextView regnrView;
    private TextView orgnrView;
    private TextView companyNameView;
    private TextView adressView;
    private TextView postnrView;
    private TextView ortView;
    private TextView emailView;
    private TextView telefonView;
    private TextView tarrifView1;
    private TextView tarrifView2;
    private TextView tarrifView3;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_summery_screen);

        int SDK_INT = Build.VERSION.SDK_INT;
        if (SDK_INT > 8) {
            StrictMode.ThreadPolicy policy = new StrictMode.ThreadPolicy.Builder()
                    .permitAll().build();
            StrictMode.setThreadPolicy(policy);
        }

        infoPackage bio = (infoPackage)getIntent().getExtras().get("bio");
        String task = getIntent().getExtras().getString("task");
        String taxameter = getIntent().getExtras().getString("taxameter");
        ArrayList<Integer> tarrifs = (ArrayList<Integer>)getIntent().getExtras().get("tarrifs");

        typeView = (TextView) findViewById(R.id.typeSum);
        modelView = (TextView) findViewById(R.id.modelSum);
        regnrView = (TextView) findViewById(R.id.regnrFieldSum);
        orgnrView = (TextView) findViewById(R.id.orgnrFieldSum);
        companyNameView = (TextView) findViewById(R.id.companyNameSum);
        adressView = (TextView) findViewById(R.id.adressFieldSum);
        postnrView = (TextView) findViewById(R.id.postnrFieldSum);
        ortView = (TextView) findViewById(R.id.ortFieldSum);
        emailView = (TextView) findViewById(R.id.emailFieldSum);
        telefonView = (TextView) findViewById(R.id.telefonSum);
        tarrifView1 = (TextView) findViewById(R.id.tarrifSum1);
        tarrifView2 = (TextView) findViewById(R.id.tarrifSum2);
        tarrifView3 = (TextView) findViewById(R.id.tarrifSum3);

        typeView.setText(task);
        modelView.setText(taxameter);
        regnrView.setText(bio.getRegnr());
        orgnrView.setText(bio.getOrgnr());
        companyNameView.setText(bio.getCompanyName());
        adressView.setText(bio.getAdress());
        postnrView.setText(bio.getPostnr());
        ortView.setText(bio.getOrt());
        emailView.setText(bio.getEmail());
        telefonView.setText(bio.getTelefon());
        if(tarrifs.size() > 0) {
            tarrifView1.setText("" + tarrifs.get(0).toString());
        }
        if(tarrifs.size() > 1) {
            tarrifView2.setText("" + tarrifs.get(1).toString());
        }
        if(tarrifs.size() > 2) {
            tarrifView3.setText("" + tarrifs.get(2).toString());
        }

        cp = new completePackage(bio, task, taxameter, tarrifs);

        testField = (TextView) findViewById(R.id.testField);


        nextButton = (Button) findViewById(R.id.nextButton);
        nextButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                try {

                    post();

                } catch (IOException e) {
                    System.out.println("Error" + e);
                }

            }
        });

        getTestButton = (Button) findViewById(R.id.getTestButton);
        getTestButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                try {
                    get();
                } catch (IOException e) {
                    System.out.println("Error" + e);
                }

            }
        });

    }

    protected void post() throws IOException {

        RequestBody body = RequestBody.create("" + cp.toString(), PLAINTEXT);
        Request request = new Request.Builder()
                .url(baseURL + cp.toString())
                .post(body)
                .build();
        try (Response response = client.newCall(request).execute()) {

            testField.setText(response.body().string());


        }


    }

    protected void get() throws IOException {

        Request request = new Request.Builder()
                .url(baseURL + "test")
                .build();

        try (Response response = client.newCall(request).execute()) {

            testField.setText(response.body().string());

        }


    }




}
