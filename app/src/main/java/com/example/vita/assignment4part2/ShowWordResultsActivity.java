package com.example.vita.assignment4part2;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.View;
import android.widget.TextView;

/**
 * Created by Jacob on 3/20/18.
 */

public class ShowWordResultsActivity extends Activity {

    DatabaseHelper db = new DatabaseHelper(this);

    public void gotoMain(View v) {
        this.startActivity(new Intent(ShowWordResultsActivity.this, MainActivity.class));
    }


    String word;
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        this.setContentView(R.layout.show_word_results);
        String passedWord = "";
        Intent intent = getIntent();
        Bundle b = intent.getExtras();
        if (b != null){
            passedWord = word = b.get("word").toString();
        }

        Word word = db.getWord(passedWord);

        ((TextView)findViewById(R.id.txtShowWord)).setText(word.getWord());
        ((TextView)findViewById(R.id.txtShowSynonym)).setText(word.getSynonym());
    }
}
