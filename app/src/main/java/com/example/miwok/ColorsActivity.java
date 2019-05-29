package com.example.miwok;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ListView;

import java.util.ArrayList;

public class ColorsActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.words);

        ArrayList<Word> colorsWords = new ArrayList<Word>();
        colorsWords.add(new Word(getString(R.string.red), "weṭeṭṭi"));
        colorsWords.add(new Word(getString(R.string.mustard_yellow), "chiwiiṭә"));
        colorsWords.add(new Word(getString(R.string.dusty_yellow), "ṭopiisә"));
        colorsWords.add(new Word(getString(R.string.green), "chokokki"));
        colorsWords.add(new Word(getString(R.string.brown), "ṭakaakki"));
        colorsWords.add(new Word(getString(R.string.gray), "ṭopoppi"));
        colorsWords.add(new Word(getString(R.string.black), "kululli"));
        colorsWords.add(new Word(getString(R.string.white), "kelelli"));

        WordAdapter itemsAdapter = new WordAdapter(this, colorsWords);

        ListView listView = findViewById(R.id.list);
        listView.setAdapter(itemsAdapter);

    }
}
