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
public class FamilyFragment extends Fragment {

    private MediaPlayer mMediaPLayer; //MediaPlayer Component
    private AudioManager mAudioManager; //Audio Manager for requesting audio

    //Listening the audio from the system
    AudioManager.OnAudioFocusChangeListener afChangeListener = new AudioManager.OnAudioFocusChangeListener() {
        @Override
        public void onAudioFocusChange(int focusChange) {
            //Lost audio in a short time
            if (focusChange == AudioManager.AUDIOFOCUS_LOSS_TRANSIENT ||
                    focusChange == AudioManager.AUDIOFOCUS_LOSS_TRANSIENT_CAN_DUCK) {
                mMediaPLayer.pause();
                mMediaPLayer.seekTo(0);
                //Gain the audio
            } else if (focusChange == AudioManager.AUDIOFOCUS_GAIN) {
                mMediaPLayer.start();
                //complete lost the audio
            } else if (focusChange == AudioManager.AUDIOFOCUS_LOSS) {
                releaseMediaPlayer();
            }
        }
    };

    //Listening the audio to see when it's completed
    private MediaPlayer.OnCompletionListener onCompletionListener = new MediaPlayer.OnCompletionListener() {
        @Override
        public void onCompletion(MediaPlayer mp) {
            releaseMediaPlayer();
        }
    };


    public FamilyFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.words, container, false);


        super.onCreate(savedInstanceState);


        //setting the audio manager of the system
        mAudioManager = (AudioManager)
                getActivity().getSystemService(Context.AUDIO_SERVICE);

        //Array list where are the words in english, mitowk, the image to display and the audio
        final ArrayList<Word> familyWords = new ArrayList<>();

        familyWords.add(new Word(getString(R.string.father), "әpә", R.drawable.family_father,
                R.raw.family_father));
        familyWords.add(new Word(getString(R.string.mother), "әṭa", R.drawable.family_mother,
                R.raw.family_mother));
        familyWords.add(new Word(getString(R.string.son), "angsi", R.drawable.family_son,
                R.raw.family_son));
        familyWords.add(new Word(getString(R.string.daughter), "tune", R.drawable.family_daughter,
                R.raw.family_daughter));
        familyWords.add(new Word(getString(R.string.older_brother), "taachi",
                R.drawable.family_older_brother, R.raw.family_older_brother));
        familyWords.add(new Word(getString(R.string.younger_brother), "chalitti",
                R.drawable.family_younger_brother, R.raw.family_younger_brother));
        familyWords.add(new Word(getString(R.string.older_sister), "teṭe", R.drawable.family_older_sister,
                R.raw.family_older_sister));
        familyWords.add(new Word(getString(R.string.younger_sister), "kolliti",
                R.drawable.family_younger_sister, R.raw.family_younger_sister));
        familyWords.add(new Word(getString(R.string.grandmother), "ama", R.drawable.family_grandmother,
                R.raw.family_grandmother));
        familyWords.add(new Word(getString(R.string.grandfather), "paapa",
                R.drawable.family_grandfather, R.raw.family_grandfather));

        /*work adapter to inflate the layout customize..
        This allows to recycle the view improving the performance*/
        WordAdapter itemsAdapter = new WordAdapter(getActivity(), familyWords,
                WordAdapter.BACKGROUND_FAMILY);

        //List view where is stored the adapter
        ListView listView = rootView.findViewById(R.id.list);
        listView.setAdapter(itemsAdapter);

        //Creating the onclick method
        AdapterView.OnItemClickListener mMessageClickedHandler =
                new AdapterView.OnItemClickListener() {
                    @Override
                    public void onItemClick(AdapterView<?> parent, View view, int position, long id) {

                        releaseMediaPlayer(); //releasing the audio resources

                        //requesting the audio of the system
                        int result = mAudioManager.requestAudioFocus(afChangeListener,
                                AudioManager.STREAM_MUSIC, AudioManager.AUDIOFOCUS_GAIN_TRANSIENT);

                        if (result == AudioManager.AUDIOFOCUS_REQUEST_GRANTED) {
                            //Playing the file
                            mMediaPLayer = MediaPlayer.create(getActivity(),
                                    familyWords.get(position).getSound());
                            mMediaPLayer.start();

                            mMediaPLayer.setOnCompletionListener(onCompletionListener);
                        }

                    }
                };

        listView.setOnItemClickListener(mMessageClickedHandler);
        return rootView;
    }

    @Override
    public void onStop() {
        super.onStop();
        releaseMediaPlayer();
    }

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

            mAudioManager.abandonAudioFocus(afChangeListener);
        }
    }

}
