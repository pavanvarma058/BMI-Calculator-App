package com.example.bmi_calculator;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.TextView;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import java.text.DecimalFormat;

public class MainActivity extends AppCompatActivity {

    TextView resultView;
    RadioButton maleBtn;
    RadioButton femaleBtn;
    EditText feetText;
    EditText inchesText;
    EditText ageText;
    EditText weightText;
    Button calculateBtn;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);
        findViews();
        setUpOnClickListener();
    }

    private void findViews(){
        resultView = findViewById(R.id.view_result);
        maleBtn = findViewById(R.id.radio_button_male);
        femaleBtn = findViewById(R.id.radio_button_female);
        feetText = findViewById(R.id.edit_feet);
        inchesText = findViewById(R.id.edit_inches);
        ageText = findViewById(R.id.text_age);
        weightText = findViewById(R.id.text_weight);
        calculateBtn = findViewById(R.id.calculate_btn);
    }

    private void setUpOnClickListener(){
        calculateBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                double bmiResult = calculateBMI();

                String age = ageText.getText().toString();
                int ageValue = Integer.parseInt(age);

                if(ageValue >= 18){
                    displayResult(bmiResult);
                }else {
                    displayGuidance(bmiResult);
                }
            }
        });
    }


    private double calculateBMI() {
       String feet = feetText.getText().toString();
       String inches = inchesText.getText().toString();
       String weight = weightText.getText().toString();

       int feetValue = Integer.parseInt(feet);
       int inchesValue = Integer.parseInt(inches);
       int weightValue = Integer.parseInt(weight);

       int totalInches = (feetValue * 12) + inchesValue;

       double heightInMeters = totalInches * 0.0254;
       // bmi formula
       double bmi = weightValue / (heightInMeters * heightInMeters);
       return bmi;
    }

    private void displayResult(double bmi){
        DecimalFormat myDecimalFormatter = new DecimalFormat("0.00");
        String bmiResult = myDecimalFormatter.format(bmi);
        String fullResultString;
        if(bmi < 18.5){
            fullResultString = bmiResult + " - You are underweight";
        } else if(bmi > 25){
            fullResultString = bmiResult + " - You are overweight";
        }else{
            fullResultString = bmiResult + " - You are a healthy weight";
        }
        resultView.setText(fullResultString);
    }

    private void displayGuidance(double bmi) {
        DecimalFormat myDecimalFormatter = new DecimalFormat("0.00");
        String bmiResult = myDecimalFormatter.format(bmi);

        String fullResultString;

        if(maleBtn.isChecked()){
            fullResultString = bmiResult + " - As you are under 18, please consult with your doctor for the healty range for boys";
        }else if(femaleBtn.isChecked()){
            fullResultString = bmiResult + " - As you are under 18, please consult with your doctor for the healty range for girls";
        }else {
            fullResultString = bmiResult + " - As you are under 18, please consult with your doctor for the healty range";
        }

        resultView.setText(fullResultString);
    }
}