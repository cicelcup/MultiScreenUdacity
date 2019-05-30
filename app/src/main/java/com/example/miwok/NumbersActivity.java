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
        numbersWords.add(new Word(getString(R.string.one), "lutti", R.drawable.number_one));
        numbersWords.add(new Word(getString(R.string.two), "otiiko", R.drawable.number_two));
        numbersWords.add(new Word(getString(R.string.three), "tolookosu", R.drawable.number_three));
        numbersWords.add(new Word(getString(R.string.four), "oyyisa", R.drawable.number_four));
        numbersWords.add(new Word(getString(R.string.five), "massokka", R.drawable.number_five));
        numbersWords.add(new Word(getString(R.string.six), "temmokka", R.drawable.number_six));
        numbersWords.add(new Word(getString(R.string.seven), "kenekaku", R.drawable.number_seven));
        numbersWords.add(new Word(getString(R.string.eight), "kawinta", R.drawable.number_eight));
        numbersWords.add(new Word(getString(R.string.nine), "wo’e", R.drawable.number_nine));
        numbersWords.add(new Word(getString(R.string.ten), "na’aacha", R.drawable.number_ten));


        WordAdapter itemsAdapter = new WordAdapter(this,numbersWords);

        ListView listView = (ListView) findViewById(R.id.list);

        listView.setAdapter(itemsAdapter);

    }

}
