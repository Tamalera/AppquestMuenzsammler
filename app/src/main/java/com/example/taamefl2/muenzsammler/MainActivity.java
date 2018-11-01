package com.example.taamefl2.muenzsammler;

import android.content.Context;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;

import org.json.JSONException;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    private Context context = this;

    private LogBuch logBuch = new LogBuch();

    //@fixme: testdata only
    private Loesung mockSolution;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        final Button logBuchButton = findViewById(R.id.mockSolutionButton);

        logBuchButton.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                boolean logbookInstalled = logBuch.checkIfLogbookInstalled(context);
                if (logbookInstalled) {
                    try {
                        fillMockSolutionWithMockData();
                        logBuch.passDataToLogbook(context, mockSolution);
                    } catch (JSONException e) {
                        e.printStackTrace();
                    }
                }
            }
        });

    }

    //@fixme: delete this when implemented proper solution
    private void fillMockSolutionWithMockData() {
        ArrayList<Coin> muenzListe= new ArrayList<>();
        muenzListe.add(new Coin(1, 111));
        muenzListe.add(new Coin(2, 222));
        muenzListe.add(new Coin(3, 333));
        muenzListe.add(new Coin(4, 444));
        muenzListe.add(new Coin(5, 555));
        muenzListe.add(new Coin(6, 666));
        muenzListe.add(new Coin(7, 777));
        mockSolution = new Loesung(muenzListe);
    }

}
