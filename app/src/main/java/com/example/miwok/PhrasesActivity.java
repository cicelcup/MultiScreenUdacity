/*package of the app*/
package com.example.miwok;

import android.media.MediaPlayer;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

//Libraries for the list view that shows the words and the array list for the storage of the information
import android.view.View;
import android.widget.AdapterView;
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
        final ArrayList<Word> phrasesWords = new ArrayList<Word>();
        phrasesWords.add(new Word(getString(R.string.where_are_you_going), "minto wuksus", R.raw.phrase_where_are_you_going));
        phrasesWords.add(new Word(getString(R.string.what_is_your_name), "tinnә oyaase'nә", R.raw.phrase_what_is_your_name));
        phrasesWords.add(new Word(getString(R.string.my_name_is), "oyaaset...", R.raw.phrase_my_name_is));
        phrasesWords.add(new Word(getString(R.string.how_are_you_feeling), "michәksәs?", R.raw.phrase_how_are_you_feeling));
        phrasesWords.add(new Word(getString(R.string.i_m_feeling_good), "kuchi achit", R.raw.phrase_im_feeling_good));
        phrasesWords.add(new Word(getString(R.string.are_you_coming), "әәnәs'aa?", R.raw.phrase_are_you_coming));
        phrasesWords.add(new Word(getString(R.string.yes_I_m_coming), "hәә’ әәnәm", R.raw.phrase_yes_im_coming));
        phrasesWords.add(new Word(getString(R.string.i_m_coming), "әәnәm", R.raw.phrase_im_coming));
        phrasesWords.add(new Word(getString(R.string.let_s_go), "yoowutis", R.raw.phrase_lets_go));
        phrasesWords.add(new Word(getString(R.string.come_here), "әnni'nem", R.raw.phrase_come_here));

        //work adapter to inflate the layout customize.. This allows to recycle the view improving the performance
        WordAdapter itemsAdapter = new WordAdapter(this, phrasesWords);

        //List view where is stored the adapter
        ListView listView = findViewById(R.id.list);
        listView.setAdapter(itemsAdapter);

        AdapterView.OnItemClickListener mMessageClickedHandler = new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                MediaPlayer mediaPlayer = MediaPlayer.create(PhrasesActivity.this, phrasesWords.get(position).getmSound());
                mediaPlayer.start();
            }
        };

        listView.setOnItemClickListener(mMessageClickedHandler);
    }
}
