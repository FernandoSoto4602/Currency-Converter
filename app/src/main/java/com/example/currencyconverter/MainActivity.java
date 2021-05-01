package com.example.currencyconverter;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void convertMoney(View view){
        EditText moneyText = (EditText) (findViewById(R.id.usdTextBox));
        double moneyDouble = Double.parseDouble(moneyText.getText().toString());
        double result = convertCurrency(moneyDouble);
        String stringResult = Double.toString(result);
        Toast.makeText(getApplicationContext(),stringResult,Toast.LENGTH_SHORT).show();
    }

    public double convertCurrency(double amount){
        double euroAmount =  .83;
        double finalAmount;
        finalAmount = amount * euroAmount;

        return finalAmount;
    }
}