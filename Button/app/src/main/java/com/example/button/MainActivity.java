package com.example.button;

import android.os.Bundle;
import android.view.View;
import android.widget.*;
import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

    EditText editText;
    RadioGroup radioGroup;
    RadioButton selectedRadio;
    CheckBox checkBox;
    ToggleButton toggleButton;
    Button button;
    Spinner spinner;

    String[] countries = {"Select Country", "India", "USA", "UK", "Canada"};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        editText = findViewById(R.id.editTextName);
        radioGroup = findViewById(R.id.radioGroup);
        checkBox = findViewById(R.id.checkBoxAgree);
        toggleButton = findViewById(R.id.toggleButton);
        button = findViewById(R.id.buttonSubmit);
        spinner = findViewById(R.id.spinnerCountry);

        // Spinner Adapter
        ArrayAdapter<String> adapter = new ArrayAdapter<>(
                this,
                android.R.layout.simple_spinner_item,
                countries
        );
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinner.setAdapter(adapter);

        // Button Click
        button.setOnClickListener(v -> {

            String name = editText.getText().toString();

            int selectedId = radioGroup.getCheckedRadioButtonId();
            selectedRadio = findViewById(selectedId);

            String gender = (selectedRadio != null)
                    ? selectedRadio.getText().toString()
                    : "Not Selected";

            String agree = checkBox.isChecked() ? "Agreed" : "Not Agreed";

            String toggleState = toggleButton.isChecked() ? "ON" : "OFF";

            String country = spinner.getSelectedItem().toString();

            String message = "Name: " + name +
                    "\nGender: " + gender +
                    "\nCountry: " + country +
                    "\nCheckBox: " + agree +
                    "\nToggle: " + toggleState;

            Toast.makeText(MainActivity.this, message, Toast.LENGTH_LONG).show();
        });

        // Toggle Event
        toggleButton.setOnCheckedChangeListener((buttonView, isChecked) -> {
            Toast.makeText(MainActivity.this,
                    isChecked ? "Toggle ON" : "Toggle OFF",
                    Toast.LENGTH_SHORT).show();
        });

        // CheckBox Event
        checkBox.setOnCheckedChangeListener((buttonView, isChecked) -> {
            Toast.makeText(MainActivity.this,
                    isChecked ? "Checked" : "Unchecked",
                    Toast.LENGTH_SHORT).show();
        });

        // Spinner Event
        spinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                Toast.makeText(MainActivity.this,
                        "Selected: " + countries[position],
                        Toast.LENGTH_SHORT).show();
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {
            }
        });
    }
}