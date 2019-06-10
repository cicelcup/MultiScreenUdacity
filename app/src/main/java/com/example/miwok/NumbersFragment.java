package com.example.miwok;


import android.content.Context;
import android.media.AudioManager;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ListView;

import java.util.ArrayList;

/**
 * A simple {@link Fragment} subclass.
 */
public class NumbersFragment extends Fragment {

    //Getting the name of the activity for using for the log (testing uses)
    private static final String LOG_TAG = NumbersActivity.class.getSimpleName();
    private MediaPlayer mMediaPlayer; //media player variable
    private AudioManager mAudioManager; //Audio Manager from the system

    //Listening the audio system
    AudioManager.OnAudioFocusChangeListener afChangeListener = new AudioManager.OnAudioFocusChangeListener() {
        @Override
        public void onAudioFocusChange(int focusChange) {
            //losing the audio for a short time
            if (focusChange == AudioManager.AUDIOFOCUS_LOSS_TRANSIENT ||
                    focusChange == AudioManager.AUDIOFOCUS_LOSS_TRANSIENT_CAN_DUCK) {
                mMediaPlayer.pause();
                mMediaPlayer.seekTo(0);
                //gain the audio
            } else if (focusChange == AudioManager.AUDIOFOCUS_GAIN) {
                mMediaPlayer.start();
                //losing the audio and releasing the file
            } else if (focusChange == AudioManager.AUDIOFOCUS_LOSS) {
                releaseMediaPlayer();
            }
        }
    };

    //listening the completion of the audio file
    private MediaPlayer.OnCompletionListener onCompletionListener = new MediaPlayer.OnCompletionListener() {
        @Override
        public void onCompletion(MediaPlayer mp) {
            releaseMediaPlayer();
        }
    };


    public NumbersFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        //layout to open
        View rootView = inflater.inflate(R.layout.words, container, false);


        super.onCreate(savedInstanceState);


        //getting the audio from the system
        mAudioManager = (AudioManager)
                getActivity().getSystemService(Context.AUDIO_SERVICE);

        //Array list where are the words in english, mitowk, the image to display and the sound
        final ArrayList<Word> numbersWords = new ArrayList<>();
        numbersWords.add(new Word(getString(R.string.one), "lutti", R.drawable.number_one,
                R.raw.number_one));
        numbersWords.add(new Word(getString(R.string.two), "otiiko", R.drawable.number_two,
                R.raw.number_two));
        numbersWords.add(new Word(getString(R.string.three), "tolookosu", R.drawable.number_three,
                R.raw.number_three));
        numbersWords.add(new Word(getString(R.string.four), "oyyisa", R.drawable.number_four,
                R.raw.number_four));
        numbersWords.add(new Word(getString(R.string.five), "massokka",
                R.drawable.number_five, R.raw.number_five));
        numbersWords.add(new Word(getString(R.string.six), "temmokka", R.drawable.number_six,
                R.raw.number_six));
        numbersWords.add(new Word(getString(R.string.seven), "kenekaku", R.drawable.number_seven,
                R.raw.number_seven));
        numbersWords.add(new Word(getString(R.string.eight), "kawinta", R.drawable.number_eight,
                R.raw.number_eight));
        numbersWords.add(new Word(getString(R.string.nine), "wo’e", R.drawable.number_nine,
                R.raw.number_nine));
        numbersWords.add(new Word(getString(R.string.ten), "na’aacha", R.drawable.number_ten,
                R.raw.number_ten));

        /*work adapter to inflate the layout customize.
        This allows to recycle the view improving the performance*/
        WordAdapter itemsAdapter = new WordAdapter(getActivity(), numbersWords);

        //List view where is stored the adapter
        ListView listView = rootView.findViewById(R.id.list);
        listView.setAdapter(itemsAdapter);

        //Creating the onclick method
        AdapterView.OnItemClickListener mMessageClickedHandler =
                new AdapterView.OnItemClickListener() {
                    @Override
                    public void onItemClick(AdapterView<?> parent, View view, int position, long id) {

                        releaseMediaPlayer(); //releasing the audio file

                        int result = mAudioManager.requestAudioFocus(afChangeListener,
                                AudioManager.STREAM_MUSIC, AudioManager.AUDIOFOCUS_GAIN_TRANSIENT);

                        //getting the audio focus
                        if (result == AudioManager.AUDIOFOCUS_REQUEST_GRANTED) {
                            //playing the file
                            mMediaPlayer = MediaPlayer.create(getActivity(),
                                    numbersWords.get(position).getSound());
                            mMediaPlayer.start();

                            mMediaPlayer.setOnCompletionListener(onCompletionListener);
                        }

                    }
                };

        listView.setOnItemClickListener(mMessageClickedHandler);


        return rootView;


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

            mAudioManager.abandonAudioFocus(afChangeListener);//releasing the system's audio
        }
    }

    @Override
    public void onStop() {
        super.onStop();
        releaseMediaPlayer();
    }
}
