package com.example.event;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

    EditText editName;
    Button btnClick;
    TextView txtResult;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        editName = findViewById(R.id.editName);
        btnClick = findViewById(R.id.btnClick);
        txtResult = findViewById(R.id.txtResult);

        btnClick.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String name = editName.getText().toString().trim();

                if(name.isEmpty()){
                    txtResult.setText("Please enter your name");
                } else {
                    txtResult.setText("Hello " + name);
                }
            }
        });
    }
}