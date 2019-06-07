/*package of the app*/
package com.example.miwok;

/*Libraries Imported*/

import android.content.Context;
import android.media.AudioManager;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;

import java.util.ArrayList;

import static android.widget.AdapterView.OnItemClickListener;

//Extension of the app compact activity
public class ColorsActivity extends AppCompatActivity {

    private MediaPlayer mMediaPLayer; //MediaPlayer Component
    private AudioManager mAudioManager; //AudioManager to request the focus of the audio

    /*OnAudio Focus Manager need it to request the audio from the system*/
    AudioManager.OnAudioFocusChangeListener afChangeListener = new AudioManager.OnAudioFocusChangeListener() {
        @Override
        public void onAudioFocusChange(int focusChange) {
            //Lost the audio for a short time
            if (focusChange == AudioManager.AUDIOFOCUS_LOSS_TRANSIENT ||
                    focusChange == AudioManager.AUDIOFOCUS_LOSS_TRANSIENT_CAN_DUCK) {
                mMediaPLayer.pause();
                mMediaPLayer.seekTo(0); //restarting the audio
                //Gain the audio from the system
            } else if (focusChange == AudioManager.AUDIOFOCUS_GAIN) {
                mMediaPLayer.start();
                //complete lost the focus
            } else if (focusChange == AudioManager.AUDIOFOCUS_LOSS) {
                releaseMediaPlayer();
            }
        }
    };

    //Listening the audio to know when it finish
    private MediaPlayer.OnCompletionListener onCompletionListener =
            new MediaPlayer.OnCompletionListener() {
        @Override
        public void onCompletion(MediaPlayer mp) {
            releaseMediaPlayer();
        }
    };

    //Overriding the on create method to open the activity
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //layout to open
        setContentView(R.layout.words);

        //Audio Manager initiating requesting the audio system
        mAudioManager = (AudioManager) getSystemService(Context.AUDIO_SERVICE);

        /*Array list where is store the words in english, mitowk, with the image to display and
        the sound of the file*/
        final ArrayList<Word> colorsWords = new ArrayList<>();

        colorsWords.add(new Word(getString(R.string.red), "weṭeṭṭi", R.drawable.color_red,
                R.raw.color_red));
        colorsWords.add(new Word(getString(R.string.mustard_yellow), "chiwiiṭә",
                R.drawable.color_mustard_yellow, R.raw.color_mustard_yellow));
        colorsWords.add(new Word(getString(R.string.dusty_yellow), "ṭopiisә",
                R.drawable.color_dusty_yellow, R.raw.color_dusty_yellow));
        colorsWords.add(new Word(getString(R.string.green), "chokokki", R.drawable.color_green,
                R.raw.color_green));
        colorsWords.add(new Word(getString(R.string.brown), "ṭakaakki", R.drawable.color_brown,
                R.raw.color_brown));
        colorsWords.add(new Word(getString(R.string.gray), "ṭopoppi", R.drawable.color_gray,
                R.raw.color_gray));
        colorsWords.add(new Word(getString(R.string.black), "kululli", R.drawable.color_black,
                R.raw.color_black));
        colorsWords.add(new Word(getString(R.string.white), "kelelli", R.drawable.color_white,
                R.raw.color_white));

        /*work adapter to inflate the layout customize
        This allows to recycle the view improving the performance*/
        WordAdapter itemsAdapter = new WordAdapter(this, colorsWords);

        //List view where is stored the adapter
        ListView listView = findViewById(R.id.list);
        listView.setAdapter(itemsAdapter);

        //Creating the onclick item for handling the click action
        OnItemClickListener mMessageClickedHandler = new OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {

                releaseMediaPlayer(); //releasing the audio

                //Requesting the audio file
                int result = mAudioManager.requestAudioFocus(afChangeListener,
                        AudioManager.STREAM_MUSIC, AudioManager.AUDIOFOCUS_GAIN_TRANSIENT);

                //Playing the audio file
                if (result == AudioManager.AUDIOFOCUS_REQUEST_GRANTED) {
                    mMediaPLayer = MediaPlayer.create(ColorsActivity.this,
                            colorsWords.get(position).getSound());
                    mMediaPLayer.start();
                    mMediaPLayer.setOnCompletionListener(onCompletionListener);
                }


            }
        };

        listView.setOnItemClickListener(mMessageClickedHandler);

        //Toast of example
        //Toast toast = Toast.makeText(ColorsActivity.this, getIntent().getStringExtra("test"),
        // Toast.LENGTH_SHORT);
        //toast.show();

    }

    //code when the activity Stop
    @Override
    protected void onStop() {
        super.onStop();
        releaseMediaPlayer();
    }

    /**
     * Code Snippet from Udacity
     * Clean up the media player by releasing its resources.
     */
    private void releaseMediaPlayer() {
        // If the media player is not null, then it may be currently playing a sound.
        if (mMediaPLayer != null) {
            // Regardless of the current state of the media player, release its resources
            // because we no longer need it.
            mMediaPLayer.release();

            // Set the media player back to null. For our code, we've decided that
            // setting the media player to null is an easy way to tell that the media player
            // is not configured to play an audio file at the moment.
            mMediaPLayer = null;

            mAudioManager.abandonAudioFocus(afChangeListener); //releasing the audio focus
        }
    }
}
