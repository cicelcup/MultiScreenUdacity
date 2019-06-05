/*package of the app*/
package com.example.miwok;

import android.media.MediaPlayer;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

//Libraries for the list view that shows the words and the array list for the storage of the information
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;

import static android.widget.AdapterView.*;

//Extension of the app compact activity
public class ColorsActivity extends AppCompatActivity {

    //Overriding the on create method to open the activity
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //layout to open
        setContentView(R.layout.words);

        //Array list where is store the words in english, mitowk and with the image to display
        final ArrayList<Word> colorsWords = new ArrayList<Word>();

        colorsWords.add(new Word(getString(R.string.red), "weṭeṭṭi", R.drawable.color_red, R.raw.color_red));
        colorsWords.add(new Word(getString(R.string.mustard_yellow), "chiwiiṭә", R.drawable.color_mustard_yellow, R.raw.color_mustard_yellow));
        colorsWords.add(new Word(getString(R.string.dusty_yellow), "ṭopiisә", R.drawable.color_dusty_yellow, R.raw.color_dusty_yellow));
        colorsWords.add(new Word(getString(R.string.green), "chokokki", R.drawable.color_green, R.raw.color_green));
        colorsWords.add(new Word(getString(R.string.brown), "ṭakaakki", R.drawable.color_brown, R.raw.color_brown));
        colorsWords.add(new Word(getString(R.string.gray), "ṭopoppi", R.drawable.color_gray, R.raw.color_gray));
        colorsWords.add(new Word(getString(R.string.black), "kululli", R.drawable.color_black, R.raw.color_black));
        colorsWords.add(new Word(getString(R.string.white), "kelelli", R.drawable.color_white, R.raw.color_white));

        //work adapter to inflate the layout customize.. This allows to recycle the view improving the performance
        WordAdapter itemsAdapter = new WordAdapter(this, colorsWords);

        //List view where is stored the adapter
        ListView listView = findViewById(R.id.list);
        listView.setAdapter(itemsAdapter);

        //Creating the onclick item for handling the click action

        OnItemClickListener mMessageClickedHandler = new OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                //Toast of example
                //Toast toast = Toast.makeText(ColorsActivity.this, colorsWords.get(position).toString(), Toast.LENGTH_SHORT);
                //toast.show();

                //Playing the audio file
                MediaPlayer mediaPlayer = MediaPlayer.create(ColorsActivity.this, colorsWords.get(position).getmSound());
                mediaPlayer.start();
            }
        };

        listView.setOnItemClickListener(mMessageClickedHandler);



    }
}
