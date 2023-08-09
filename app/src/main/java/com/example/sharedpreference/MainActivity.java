package com.example.sharedpreference;

import androidx.appcompat.app.AppCompatActivity;

import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Switch;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    TextView textView;
    Button moveBtn, saveBtn;
    EditText textEdit;
    Switch ss;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // id define
        textView = findViewById(R.id.textView);
        textEdit = findViewById(R.id.textEdit);
        moveBtn = findViewById(R.id.moveBtn);
        saveBtn = findViewById(R.id.saveBtn);
        ss = findViewById(R.id.switch1);


        // text show
        moveBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                textView.setText(textEdit.getText().toString());
            }
        });


        //text save
        saveBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                saveText();
            }
        });
        loadData();
    }

    private void saveText() {
        SharedPreferences preferences = getSharedPreferences("SharePreference", MODE_PRIVATE);
        SharedPreferences.Editor editor = preferences.edit();
        editor.putString("text", textView.getText().toString());
        editor.putBoolean("switch", ss.isChecked());
        editor.apply();
        Toast.makeText(this, "Save Data", Toast.LENGTH_LONG).show();
    }

    private void loadData(){
        String text;
        Boolean switchOnOff;
        SharedPreferences preferences = getSharedPreferences("SharePreference", MODE_PRIVATE);
        text = preferences.getString("text","");
        switchOnOff = preferences.getBoolean("switch", false);

        textView.setText(text);
        ss.setChecked(switchOnOff);
    }
}