/*package of the app*/
package com.example.miwok;

import android.content.Context;
import android.media.AudioManager;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;

import java.util.ArrayList;

//Libraries for the list view that shows the words and the array list for the storage of the information

//Extension of the app compact activity
public class NumbersActivity extends AppCompatActivity {

    private static final String LOG_TAG = NumbersActivity.class.getSimpleName();
    private MediaPlayer mMediaPlayer;
    private AudioManager mAudioManager;

    AudioManager.OnAudioFocusChangeListener afChangeListener = new AudioManager.OnAudioFocusChangeListener() {
        @Override
        public void onAudioFocusChange(int focusChange) {
            if (focusChange == AudioManager.AUDIOFOCUS_LOSS_TRANSIENT || focusChange == AudioManager.AUDIOFOCUS_LOSS_TRANSIENT_CAN_DUCK) {
                mMediaPlayer.pause();
                mMediaPlayer.seekTo(0);
            } else if (focusChange == AudioManager.AUDIOFOCUS_GAIN) {
                mMediaPlayer.start();
            } else if (focusChange == AudioManager.AUDIOFOCUS_LOSS) {
                releaseMediaPlayer();
            }
        }
    };


    private MediaPlayer.OnCompletionListener onCompletionListener = new MediaPlayer.OnCompletionListener() {
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

        mAudioManager = (AudioManager) getSystemService(Context.AUDIO_SERVICE);

        //testing the Log class with an array and a foor loop
        String[] array = new String[3];
        int size = array.length;

        for (int index = 0; index < size; index++) {
            array[index] = "Jorge " + index;
            Log.d(LOG_TAG, array[index]);
        }


        //Array list where is store the words in english, mitowk and with the image to display
        final ArrayList<Word> numbersWords = new ArrayList<Word>();
        numbersWords.add(new Word(getString(R.string.one), "lutti", R.drawable.number_one, R.raw.number_one));
        numbersWords.add(new Word(getString(R.string.two), "otiiko", R.drawable.number_two, R.raw.number_two));
        numbersWords.add(new Word(getString(R.string.three), "tolookosu", R.drawable.number_three, R.raw.number_three));
        numbersWords.add(new Word(getString(R.string.four), "oyyisa", R.drawable.number_four, R.raw.number_four));
        numbersWords.add(new Word(getString(R.string.five), "massokka", R.drawable.number_five, R.raw.number_five));
        numbersWords.add(new Word(getString(R.string.six), "temmokka", R.drawable.number_six, R.raw.number_six));
        numbersWords.add(new Word(getString(R.string.seven), "kenekaku", R.drawable.number_seven, R.raw.number_seven));
        numbersWords.add(new Word(getString(R.string.eight), "kawinta", R.drawable.number_eight, R.raw.number_eight));
        numbersWords.add(new Word(getString(R.string.nine), "wo’e", R.drawable.number_nine, R.raw.number_nine));
        numbersWords.add(new Word(getString(R.string.ten), "na’aacha", R.drawable.number_ten, R.raw.number_ten));


        //work adapter to inflate the layout customize.. This allows to recycle the view improving the performance
        WordAdapter itemsAdapter = new WordAdapter(this,numbersWords);

        //List view where is stored the adapter
        ListView listView = (ListView) findViewById(R.id.list);
        listView.setAdapter(itemsAdapter);

        //Creating the onclick method
        AdapterView.OnItemClickListener mMessageClickedHandler = new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {

                releaseMediaPlayer();

                int result = mAudioManager.requestAudioFocus(afChangeListener, AudioManager.STREAM_MUSIC, AudioManager.AUDIOFOCUS_GAIN_TRANSIENT);

                if (result == AudioManager.AUDIOFOCUS_REQUEST_GRANTED) {
                    //playing the file
                    mMediaPlayer = MediaPlayer.create(NumbersActivity.this, numbersWords.get(position).getmSound());
                    mMediaPlayer.start();

                    mMediaPlayer.setOnCompletionListener(onCompletionListener);
                }

            }
        };

        listView.setOnItemClickListener(mMessageClickedHandler);

    }

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
        if (mMediaPlayer != null) {
            // Regardless of the current state of the media player, release its resources
            // because we no longer need it.
            mMediaPlayer.release();

            // Set the media player back to null. For our code, we've decided that
            // setting the media player to null is an easy way to tell that the media player
            // is not configured to play an audio file at the moment.
            mMediaPlayer = null;

            mAudioManager.abandonAudioFocus(afChangeListener);
        }
    }


}
