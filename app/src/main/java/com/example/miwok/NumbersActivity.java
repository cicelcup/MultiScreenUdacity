package com.example.miwok;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import java.util.ArrayList;

public class NumbersActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_numbers);

        ArrayList<Word> words = new ArrayList<Word>();
        words.add(new Word(getString(R.string.one), "lutti"));
        words.add(new Word(getString(R.string.two), "otiiko"));
        words.add(new Word(getString(R.string.three), "tolookosu"));
        words.add(new Word(getString(R.string.four), "oyyisa"));
        words.add(new Word(getString(R.string.five), "massokka"));
        words.add(new Word(getString(R.string.six), "temmokka"));
        words.add(new Word(getString(R.string.seven), "kenekaku"));
        words.add(new Word(getString(R.string.eight), "kawinta"));
        words.add(new Word(getString(R.string.nine), "wo’e"));
        words.add(new Word(getString(R.string.ten), "na’aacha"));


        WordAdapter itemsAdapter = new WordAdapter(this,words);

        ListView listView = (ListView) findViewById(R.id.list);

        listView.setAdapter(itemsAdapter);

    }

}
