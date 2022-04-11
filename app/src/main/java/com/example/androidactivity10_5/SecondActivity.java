package com.example.androidactivity10_5;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import androidx.annotation.Nullable;

public class SecondActivity extends Activity {
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.second_activity);

        setTitle("SecondActivity");

        Intent inIntent = getIntent();
        final int hapValue = ((Intent) inIntent).getIntExtra("num1",0) +
                ((Intent) inIntent).getIntExtra("num2",0);

        Button btnReturn = (Button) findViewById(R.id.returnbtn);
        btnReturn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent outIntent = new Intent(getApplicationContext(),
                        MainActivity.class);
                outIntent.putExtra("Hap", hapValue);
                setResult(RESULT_OK, outIntent);
                finish();
            }
        });
    }
}
