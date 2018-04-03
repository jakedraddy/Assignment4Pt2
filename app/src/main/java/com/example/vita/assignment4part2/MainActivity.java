package com.example.vita.assignment4part2;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

public class MainActivity extends Activity {
    public void onSynonymClick(View v) {
        if (v.getId() == R.id.btnGetWord) {
            EditText word = findViewById(R.id.txtInputWord);

            if (word.getText().toString().equals("")) {
                word.setActivated(true);
                word.setBackgroundColor(0xFFDDAAAA);
            } else {
                Intent i = new Intent(MainActivity.this, ShowWordResultsActivity.class);
                i.putExtra("word", word.getText().toString());
                this.startActivity(i);
            }
        }
    }


    public void onEnterValuesClick(View v) {
        if (v.getId()==R.id.btnSetValues) {
            this.startActivity(new Intent(MainActivity.this, EnterWordActivity.class));
        }
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }
}
