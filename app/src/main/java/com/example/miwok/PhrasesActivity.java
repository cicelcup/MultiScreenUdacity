/*package of the app*/
package com.example.miwok;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

//Libraries for the list view that shows the words and the array list for the storage of the information
import android.widget.ListView;
import java.util.ArrayList;

//Extension of the app compact activity
public class PhrasesActivity extends AppCompatActivity {

    //Overriding the on create method to open the activity
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //layout to open
        setContentView(R.layout.words);

        //Array list where is store the words in english and mitow
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

        //work adapter to inflate the layout customize.. This allows to recycle the view improving the performance
        WordAdapter itemsAdapter = new WordAdapter(this, phrasesWords);

        //List view where is stored the adapter
        ListView listView = findViewById(R.id.list);
        listView.setAdapter(itemsAdapter);
    }
}
