package com.example.btn;

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

        ArrayAdapter<String> adapter = new ArrayAdapter<>(
                this,
                android.R.layout.simple_spinner_item,
                countries
        );
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinner.setAdapter(adapter);

        button.setOnClickListener(v -> {

            String name = editText.getText().toString();

            int selectedId = radioGroup.getCheckedRadioButtonId();

            if (selectedId == -1) {
                Toast.makeText(this, "Please select gender", Toast.LENGTH_SHORT).show();
                return;
            }

            selectedRadio = findViewById(selectedId);

            String gender = selectedRadio.getText().toString();
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

        toggleButton.setOnCheckedChangeListener((buttonView, isChecked) ->
                Toast.makeText(this,
                        isChecked ? "Toggle ON" : "Toggle OFF",
                        Toast.LENGTH_SHORT).show()
        );

        checkBox.setOnCheckedChangeListener((buttonView, isChecked) ->
                Toast.makeText(this,
                        isChecked ? "Checked" : "Unchecked",
                        Toast.LENGTH_SHORT).show()
        );

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