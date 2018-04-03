package com.example.vita.assignment4part2;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

/**
 * Created by Jacob on 3/20/18.
 */


public class EnterWordActivity extends Activity {
    DatabaseHelper helper = new DatabaseHelper(this);
    public void onSubmitWordClick(View v) {
        Word word = new Word();

        EditText txtWord = findViewById(R.id.txtNewWordInput);
        EditText txtSyn = findViewById(R.id.txtNewSynonym);

        word.setWord(txtWord.getText().toString());
        word.setSynonym(txtSyn.getText().toString());

        helper.insertWord(word);

        Intent i = new Intent(EnterWordActivity.this, EnterWordResultActivity.class);
        this.startActivity(i);
    }


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.enter_word);
    }
}
