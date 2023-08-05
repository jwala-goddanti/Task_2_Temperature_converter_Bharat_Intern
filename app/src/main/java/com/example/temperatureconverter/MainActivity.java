package com.example.temperatureconverter;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {
    private EditText celEditText, kelEditText, faranEditText;
    private TextView resultTextView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        celEditText = findViewById(R.id.cel);
        kelEditText = findViewById(R.id.kel);
        faranEditText = findViewById(R.id.faran);
        resultTextView = findViewById(R.id.tv);

        Button celButton = findViewById(R.id.btncel);
        celButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                convertTemperatureFromCelsius();
            }
        });

        Button kelButton = findViewById(R.id.btnkel);
        kelButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                convertTemperatureFromKelvin();
            }
        });

        Button faranButton = findViewById(R.id.btnfaran);
        faranButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                convertTemperatureFromFahrenheit();
            }
        });

        Button clearButton = findViewById(R.id.clearbtn);
        clearButton.setOnClickListener(new View.OnClickListener(){
            @Override
                    public  void onClick(View v){
                clearFunc();
            }
        });
    }

        private void convertTemperatureFromCelsius () {
        String celsiusString = celEditText.getText().toString().trim();

        if (!celsiusString.isEmpty()) {
            double celsius = Double.parseDouble(celsiusString);
            double kelvin = celsius + 273.15;
            double fahrenheit = (celsius * 9 / 5) + 32;

            kelEditText.setText(String.valueOf(kelvin) + " K ");
            faranEditText.setText(String.valueOf(fahrenheit) + " F ");
            resultTextView.setText(kelEditText.getText().toString() + "  " + faranEditText.getText().toString());
        }
    }

        private void convertTemperatureFromKelvin () {
        String kelvinString = kelEditText.getText().toString().trim();

        if (!kelvinString.isEmpty()) {
            double kelvin = Double.parseDouble(kelvinString);
            double celsius = kelvin - 273.15;
            double fahrenheit = (celsius * 9 / 5) + 32;

            celEditText.setText(String.valueOf(celsius) + " C");
            faranEditText.setText(String.valueOf(fahrenheit) + " F");
            resultTextView.setText(celEditText.getText().toString() + "  " + faranEditText.getText().toString());
        }
    }

        private void convertTemperatureFromFahrenheit () {
        String fahrenheitString = faranEditText.getText().toString().trim();

        if (!fahrenheitString.isEmpty()) {
            double fahrenheit = Double.parseDouble(fahrenheitString);
            double celsius = (fahrenheit - 32) * 5 / 9;
            double kelvin = celsius + 273.15;

            celEditText.setText(String.valueOf(celsius) + " C");
            kelEditText.setText(String.valueOf(kelvin) + " K");
            resultTextView.setText(celEditText.getText().toString() + " " + kelEditText.getText().toString());
        }}

            private void clearFunc () {
                celEditText.setText("");
                kelEditText.setText("");
                faranEditText.setText("");
                resultTextView.setText("Hello! Please enter the temperature");
                }

    }


