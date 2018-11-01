package com.example.taamefl2.muenzsammler;

import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.widget.Toast;

import com.google.gson.Gson;

import org.json.JSONException;

public class LogBuch {
    private Intent logbookIntent = new Intent("ch.appquest.intent.LOG");

    // Checks if logbook app is installed on the phone
    public boolean checkIfLogbookInstalled(Context context) {
        if (context.getPackageManager().queryIntentActivities(logbookIntent, PackageManager.MATCH_DEFAULT_ONLY).isEmpty()) {
            Toast.makeText(context, "Logbook App not Installed", Toast.LENGTH_LONG).show();
            return false;
        } else {
            return true;
        }
    }

    // Passes JSON object with solution info to logbook app
    public void passDataToLogbook(Context context, Loesung solution) throws JSONException {
        Gson gson = new Gson();
        //JSONObject solutionJSON = new JSONObject();

        //solutionJSON.put("task", "Muenzensammler");
        //solutionJSON.put("coins", solution);
        String myJSON = gson.toJson(solution);

        logbookIntent.putExtra("ch.appquest.logmessage", myJSON);
        context.startActivity(logbookIntent);
    }
}
