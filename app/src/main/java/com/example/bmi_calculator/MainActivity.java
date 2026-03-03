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

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);

        TextView resultView = findViewById(R.id.view_result);
        RadioButton maleBtn = findViewById(R.id.radio_button_male);
        RadioButton femaleBtn = findViewById(R.id.radio_button_female);
        EditText feetText = findViewById(R.id.edit_feet);
        EditText inchesText = findViewById(R.id.edit_inches);
        EditText ageText = findViewById(R.id.text_age);
        EditText weightText = findViewById(R.id.text_weight);
        Button calculateBtn = findViewById(R.id.calculate_btn);

        calculateBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(MainActivity.this, "Wow, a btn click", Toast.LENGTH_LONG).show();
            }
        });

    }
}