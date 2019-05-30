package com.example.miwok;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.widget.ListView;
import java.util.ArrayList;

public class NumbersActivity extends AppCompatActivity {

    private static final String LOG_TAG = NumbersActivity.class.getSimpleName();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.words);

        String[] array = new String[10];
        int size = array.length;

        for (int index = 0; index < size; index++) {
            array[index] = "Jorge " + index;
            Log.d(LOG_TAG, array[index]);
        }

        ArrayList<Word> numbersWords = new ArrayList<Word>();
        numbersWords.add(new Word(getString(R.string.one), "lutti"));
        numbersWords.add(new Word(getString(R.string.two), "otiiko"));
        numbersWords.add(new Word(getString(R.string.three), "tolookosu"));
        numbersWords.add(new Word(getString(R.string.four), "oyyisa"));
        numbersWords.add(new Word(getString(R.string.five), "massokka"));
        numbersWords.add(new Word(getString(R.string.six), "temmokka"));
        numbersWords.add(new Word(getString(R.string.seven), "kenekaku"));
        numbersWords.add(new Word(getString(R.string.eight), "kawinta"));
        numbersWords.add(new Word(getString(R.string.nine), "wo’e"));
        numbersWords.add(new Word(getString(R.string.ten), "na’aacha"));


        WordAdapter itemsAdapter = new WordAdapter(this,numbersWords);

        ListView listView = (ListView) findViewById(R.id.list);

        listView.setAdapter(itemsAdapter);

    }

}
