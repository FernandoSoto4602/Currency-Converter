package com.example.currencyconverter;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


    }

    public void convertMoney(View view) {
        EditText moneyText = (EditText) (findViewById(R.id.usdTextBox));

        if(moneyText.getText().toString().length() == 0 || !isNumeric(moneyText.getText().toString())){
            moneyText.setError(null);
            Toast.makeText(getApplicationContext(), "Please enter USD amount ", Toast.LENGTH_SHORT).show();
        } else{
            Spinner spinner = (Spinner) findViewById(R.id.currencySpinner);
            String selectedCurrency = spinner.getSelectedItem().toString();


            double moneyDouble = Double.parseDouble(moneyText.getText().toString());
            double result = convertCurrency(moneyDouble, selectedCurrency);
            String stringResult = Double.toString(result);
            Toast.makeText(getApplicationContext(), stringResult, Toast.LENGTH_SHORT).show();
        }

    }

    public double convertCurrency(double amount, String currency) {
        double result;

        if (currency.equals("EUR")) {
            result = amount * .85;
            return result;
        } else if (currency.equals("JPY")) {
            result = amount * 109.30;
            return result;
        } else if (currency.equals("GBP")) {
            result = amount * .72;
            return result;
        } else if (currency.equals("CHF")) {
            result = amount * .91;
            return result;
        } else if (currency.equals("CAD")) {
            result = amount * 1.23;
            return result;
        } else if (currency.equals("ZAR")) {
            result = amount * 14.50;
            return result;
        } else
            return 0.00;

    }

    public static boolean isNumeric(String strNum) {
        if (strNum == null) {
            return false;
        }
        try {
            double d = Double.parseDouble(strNum);
        } catch (NumberFormatException nfe) {
            return false;
        }
        return true;
    }
}