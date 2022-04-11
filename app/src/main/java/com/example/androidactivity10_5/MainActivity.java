package com.example.androidactivity10_5;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Button btn = (Button) findViewById(R.id.btn_plus);
        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                EditText edt1 = (EditText) findViewById(R.id.edit1);
                EditText edt2 = (EditText) findViewById(R.id.edit2);

                Intent intent = new Intent(getApplicationContext(), SecondActivity.class);
                intent.putExtra("num1", Integer.parseInt(edt1.getText().toString()));
                intent.putExtra("num2", Integer.parseInt(edt2.getText().toString()));
                startActivityForResult(intent, 101);
            }
        });
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (requestCode == 101) {
            if (resultCode == RESULT_OK) {
                int hap = data.getIntExtra("Hap", 0);
                Toast.makeText(getApplicationContext(), "합계 : " + hap, Toast.LENGTH_SHORT).show();
            }
        }
    }
}