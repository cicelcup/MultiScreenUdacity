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

        familyWords.add(new Word(getString(R.string.father), "әpә", R.drawable.family_father));
        familyWords.add(new Word(getString(R.string.mother), "әṭa", R.drawable.family_mother));
        familyWords.add(new Word(getString(R.string.son), "angsi", R.drawable.family_son));
        familyWords.add(new Word(getString(R.string.daughter), "tune", R.drawable.family_daughter));
        familyWords.add(new Word(getString(R.string.older_brother), "taachi", R.drawable.family_older_brother));
        familyWords.add(new Word(getString(R.string.younger_brother), "chalitti", R.drawable.family_younger_brother));
        familyWords.add(new Word(getString(R.string.older_sister), "teṭe", R.drawable.family_older_sister));
        familyWords.add(new Word(getString(R.string.younger_sister), "kolliti", R.drawable.family_younger_sister));
        familyWords.add(new Word(getString(R.string.grandmother), "ama", R.drawable.family_grandmother));
        familyWords.add(new Word(getString(R.string.grandfather), "paapa", R.drawable.family_grandfather));

        WordAdapter itemsAdapter = new WordAdapter(this, familyWords);

        ListView listView = findViewById(R.id.list);
        listView.setAdapter(itemsAdapter);
    }
}
