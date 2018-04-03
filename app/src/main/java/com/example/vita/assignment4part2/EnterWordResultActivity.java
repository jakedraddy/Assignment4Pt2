package com.example.vita.assignment4part2;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;

/**
 * Created by Jacob on 3/20/18.
 */

public class EnterWordResultActivity extends AppCompatActivity {

    public void btnOkClick(View v) {
        this.startActivity(new Intent(EnterWordResultActivity.this, MainActivity.class));
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.enter_word_result);
    }
}
