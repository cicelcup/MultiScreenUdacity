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
public class FamilyActivity extends AppCompatActivity {

    //Overriding the on create method to open the activity
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //layout to open
        setContentView(R.layout.words);

        //Array list where is store the words in english, mitowk and with the image to display
        final ArrayList<Word> familyWords = new ArrayList<Word>();

        familyWords.add(new Word(getString(R.string.father), "әpә", R.drawable.family_father, R.raw.family_father));
        familyWords.add(new Word(getString(R.string.mother), "әṭa", R.drawable.family_mother, R.raw.family_mother));
        familyWords.add(new Word(getString(R.string.son), "angsi", R.drawable.family_son, R.raw.family_son));
        familyWords.add(new Word(getString(R.string.daughter), "tune", R.drawable.family_daughter, R.raw.family_daughter));
        familyWords.add(new Word(getString(R.string.older_brother), "taachi", R.drawable.family_older_brother, R.raw.family_older_brother));
        familyWords.add(new Word(getString(R.string.younger_brother), "chalitti", R.drawable.family_younger_brother, R.raw.family_younger_brother));
        familyWords.add(new Word(getString(R.string.older_sister), "teṭe", R.drawable.family_older_sister, R.raw.family_older_sister));
        familyWords.add(new Word(getString(R.string.younger_sister), "kolliti", R.drawable.family_younger_sister, R.raw.family_younger_sister));
        familyWords.add(new Word(getString(R.string.grandmother), "ama", R.drawable.family_grandmother, R.raw.family_grandmother));
        familyWords.add(new Word(getString(R.string.grandfather), "paapa", R.drawable.family_grandfather, R.raw.family_grandfather));

        //work adapter to inflate the layout customize.. This allows to recycle the view improving the performance
        WordAdapter itemsAdapter = new WordAdapter(this, familyWords);

        //List view where is stored the adapter
        ListView listView = findViewById(R.id.list);
        listView.setAdapter(itemsAdapter);

        //Creating the onclick method
        AdapterView.OnItemClickListener mMessageClickedHandler = new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                //Playing the file
                MediaPlayer mediaPlayer = MediaPlayer.create(FamilyActivity.this, familyWords.get(position).getmSound());
                mediaPlayer.start();
            }
        };

        listView.setOnItemClickListener(mMessageClickedHandler);
    }
}
