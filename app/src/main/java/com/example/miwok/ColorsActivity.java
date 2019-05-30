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
        colorsWords.add(new Word(getString(R.string.red), "weṭeṭṭi", R.drawable.color_red));
        colorsWords.add(new Word(getString(R.string.mustard_yellow), "chiwiiṭә", R.drawable.color_mustard_yellow));
        colorsWords.add(new Word(getString(R.string.dusty_yellow), "ṭopiisә", R.drawable.color_dusty_yellow));
        colorsWords.add(new Word(getString(R.string.green), "chokokki", R.drawable.color_green));
        colorsWords.add(new Word(getString(R.string.brown), "ṭakaakki", R.drawable.color_brown));
        colorsWords.add(new Word(getString(R.string.gray), "ṭopoppi", R.drawable.color_gray));
        colorsWords.add(new Word(getString(R.string.black), "kululli", R.drawable.color_black));
        colorsWords.add(new Word(getString(R.string.white), "kelelli", R.drawable.color_white));

        WordAdapter itemsAdapter = new WordAdapter(this, colorsWords);

        ListView listView = findViewById(R.id.list);
        listView.setAdapter(itemsAdapter);

    }
}
