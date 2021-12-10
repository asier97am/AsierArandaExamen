package com.asier.aranda.asierarandaexamen;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.DividerItemDecoration;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    MiAdaptadorSimple adapter;
    public Button btConvertir;
    public TextView tvDivisas, tvCantEuros, tvConversionDivisas;
    public EditText etDinero;

    //almaceno en variables las monedas
    double usd = 1.1293946;
    double gbp = 0.85447758;
    double cad = 1.4339265;
    double aud = 1.5788175;
    double jpy = 128.17384;
    double inr = 85.36992;
    double nzd = 1.6631981;
    double chf = 1.0441295;
    double zar = 18.030472;
    double rub = 83.219626;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //TextView
        tvConversionDivisas = findViewById(R.id.tvConversionDivisas);
        tvCantEuros = findViewById(R.id.tvCantEuros);
        tvDivisas = findViewById(R.id.tvDivisas);

        //EditText
        etDinero = findViewById(R.id.etDinero);

        //Button
        btConvertir = findViewById(R.id.btConvertir);


        ArrayList<String> divisasRecy = new ArrayList<>();
        divisasRecy.add("USD");
        divisasRecy.add("GBP");
        divisasRecy.add("CAD");
        divisasRecy.add("AUD");
        divisasRecy.add("JPY");
        divisasRecy.add("INR");
        divisasRecy.add("NZD");
        divisasRecy.add("CHF");
        divisasRecy.add("ZAR");
        divisasRecy.add("RUB");


        RecyclerView recyclerView = findViewById(R.id.recyclerDivisas);
        recyclerView.setHasFixedSize(true);
        LinearLayoutManager mLayout = new LinearLayoutManager(this);
        recyclerView.setLayoutManager(mLayout);

        //aqui referencio con el otro java
        adapter = new MiAdaptadorSimple(this, divisasRecy);
        recyclerView.setAdapter(adapter);

        DividerItemDecoration dividerItemDecoration = new DividerItemDecoration(recyclerView.getContext(), mLayout.getOrientation());
        recyclerView.addItemDecoration(dividerItemDecoration);

    }
}