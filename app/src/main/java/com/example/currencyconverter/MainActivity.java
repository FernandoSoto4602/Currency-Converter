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
        // Grabs the string from the usdTextBox and stores it into moneyText
        EditText moneyText = (EditText) (findViewById(R.id.usdTextBox));

        // Checks to make sure we have some type of input inside the textField and we also call the isNumeric function to make sure the inputted String is numeric only else we set error to null
        // We display a Toast bubble to let the user know they need to input a amount to convert in USD until a valid input is entered
        if(moneyText.getText().toString().length() == 0 || !isNumeric(moneyText.getText().toString())){
            moneyText.setError(null);
            Toast.makeText(getApplicationContext(), "Please enter USD amount ", Toast.LENGTH_SHORT).show();
        } else{
            // Using the created spinner we get the selected option the user has picked to help convert to the desired currency
            Spinner spinner = (Spinner) findViewById(R.id.currencySpinner);
            String selectedCurrency = spinner.getSelectedItem().toString();

            // We get the String from moneyText and convert it to a Double
            double moneyDouble = Double.parseDouble(moneyText.getText().toString());
            // To find the final result we call the convertCurrency with the spinner selection and amount that was converted
            double result = convertCurrency(moneyDouble, selectedCurrency);
            // Convert the Double we got back from convertCurrency back to a String to use it with Toast
            String stringResult = Double.toString(result);
            Toast.makeText(getApplicationContext(), stringResult, Toast.LENGTH_SHORT).show();
        }

    }

    public double convertCurrency(double amount, String currency) {
        // Creates a Double named result and converts the currency selected
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

    // Function to check whether a String is numeric
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