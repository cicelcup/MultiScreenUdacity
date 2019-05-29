package com.example.miwok;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ListView;

import java.util.ArrayList;

public class PhrasesActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.words);

        ArrayList<Word> phrasesWords = new ArrayList<Word>();
        phrasesWords.add(new Word(getString(R.string.where_are_you_going), "minto wuksus"));
        phrasesWords.add(new Word(getString(R.string.what_is_your_name), "tinnә oyaase'nә"));
        phrasesWords.add(new Word(getString(R.string.my_name_is), "oyaaset..."));
        phrasesWords.add(new Word(getString(R.string.how_are_you_feeling), "michәksәs?"));
        phrasesWords.add(new Word(getString(R.string.i_m_feeling_good), "kuchi achit"));
        phrasesWords.add(new Word(getString(R.string.are_you_coming), "әәnәs'aa?"));
        phrasesWords.add(new Word(getString(R.string.yes_I_m_coming), "hәә’ әәnәm"));
        phrasesWords.add(new Word(getString(R.string.i_m_coming), "әәnәm"));
        phrasesWords.add(new Word(getString(R.string.let_s_go), "yoowutis"));
        phrasesWords.add(new Word(getString(R.string.come_here), "әnni'nem"));

        WordAdapter itemsAdapter = new WordAdapter(this, phrasesWords);

        ListView listView = findViewById(R.id.list);
        listView.setAdapter(itemsAdapter);
    }
}
