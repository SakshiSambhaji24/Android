package com.example.sqlite;

import android.database.Cursor;
import android.os.Bundle;
import android.view.View;
import android.widget.*;
import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

    EditText etName, etAge, etId;
    Button btnInsert, btnView, btnUpdate, btnDelete;
    TextView tvResult;

    DBHelper db;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        etName = findViewById(R.id.etName);
        etAge = findViewById(R.id.etAge);
        etId = findViewById(R.id.etId);

        btnInsert = findViewById(R.id.btnInsert);
        btnView = findViewById(R.id.btnView);
        btnUpdate = findViewById(R.id.btnUpdate);
        btnDelete = findViewById(R.id.btnDelete);

        tvResult = findViewById(R.id.tvResult);

        db = new DBHelper(this);

        // INSERT
        btnInsert.setOnClickListener(v -> {
            String name = etName.getText().toString();
            int age = Integer.parseInt(etAge.getText().toString());

            boolean inserted = db.insertData(name, age);
            Toast.makeText(this, inserted ? "Inserted" : "Failed", Toast.LENGTH_SHORT).show();
        });

        // VIEW
        btnView.setOnClickListener(v -> {
            Cursor cursor = db.getAllData();
            StringBuilder data = new StringBuilder();

            while (cursor.moveToNext()) {
                data.append("ID: ").append(cursor.getInt(0))
                        .append("\nName: ").append(cursor.getString(1))
                        .append("\nAge: ").append(cursor.getInt(2))
                        .append("\n\n");
            }

            tvResult.setText(data.toString());
        });

        // UPDATE
        btnUpdate.setOnClickListener(v -> {
            int id = Integer.parseInt(etId.getText().toString());
            String name = etName.getText().toString();
            int age = Integer.parseInt(etAge.getText().toString());

            boolean updated = db.updateData(id, name, age);
            Toast.makeText(this, updated ? "Updated" : "Failed", Toast.LENGTH_SHORT).show();
        });

        // DELETE
        btnDelete.setOnClickListener(v -> {
            int id = Integer.parseInt(etId.getText().toString());

            boolean deleted = db.deleteData(id);
            Toast.makeText(this, deleted ? "Deleted" : "Failed", Toast.LENGTH_SHORT).show();
        });
    }
}