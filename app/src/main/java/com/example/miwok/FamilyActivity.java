package com.example.miwok;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ListView;

import java.util.ArrayList;

public class FamilyActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.words);

        ArrayList<Word> familyWords = new ArrayList<Word>();

        familyWords.add(new Word(getString(R.string.father), "әpә"));
        familyWords.add(new Word(getString(R.string.mother), "әṭa"));
        familyWords.add(new Word(getString(R.string.son), "angsi"));
        familyWords.add(new Word(getString(R.string.daughter), "tune"));
        familyWords.add(new Word(getString(R.string.older_brother), "taachi"));
        familyWords.add(new Word(getString(R.string.younger_brother), "chalitti"));
        familyWords.add(new Word(getString(R.string.older_sister), "teṭe"));
        familyWords.add(new Word(getString(R.string.younger_sister), "kolliti"));
        familyWords.add(new Word(getString(R.string.grandmother), "ama"));
        familyWords.add(new Word(getString(R.string.grandfather), "paapa"));

        WordAdapter itemsAdapter = new WordAdapter(this, familyWords);

        ListView listView = findViewById(R.id.list);
        listView.setAdapter(itemsAdapter);
    }
}
