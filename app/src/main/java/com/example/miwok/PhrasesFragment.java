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
public class PhrasesFragment extends Fragment {

    private MediaPlayer mMediaPlayer; //media for play the files
    private AudioManager mAudioManager; //Audio manager from the system

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
                //losing the audio
            } else if (focusChange == AudioManager.AUDIOFOCUS_LOSS) {
                releaseMediaPlayer();
            }
        }
    };

    //Listening to the audio to finish
    private MediaPlayer.OnCompletionListener onCompletionListener = new MediaPlayer.OnCompletionListener() {
        @Override
        public void onCompletion(MediaPlayer mp) {
            releaseMediaPlayer();
        }
    };


    public PhrasesFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.words, container, false);


        super.onCreate(savedInstanceState);


        //Setting the audio manager
        mAudioManager = (AudioManager)
                getActivity().getSystemService(Context.AUDIO_SERVICE);

        //Array list where is store the words in english, Miwok word and audio
        final ArrayList<Word> phrasesWords = new ArrayList<>();
        phrasesWords.add(new Word(getString(R.string.where_are_you_going), "minto wuksus",
                R.raw.phrase_where_are_you_going));
        phrasesWords.add(new Word(getString(R.string.what_is_your_name), "tinnә oyaase'nә",
                R.raw.phrase_what_is_your_name));
        phrasesWords.add(new Word(getString(R.string.my_name_is), "oyaaset...",
                R.raw.phrase_my_name_is));
        phrasesWords.add(new Word(getString(R.string.how_are_you_feeling), "michәksәs?",
                R.raw.phrase_how_are_you_feeling));
        phrasesWords.add(new Word(getString(R.string.i_m_feeling_good), "kuchi achit",
                R.raw.phrase_im_feeling_good));
        phrasesWords.add(new Word(getString(R.string.are_you_coming), "әәnәs'aa?",
                R.raw.phrase_are_you_coming));
        phrasesWords.add(new Word(getString(R.string.yes_I_m_coming), "hәә’ әәnәm",
                R.raw.phrase_yes_im_coming));
        phrasesWords.add(new Word(getString(R.string.i_m_coming), "әәnәm",
                R.raw.phrase_im_coming));
        phrasesWords.add(new Word(getString(R.string.let_s_go), "yoowutis",
                R.raw.phrase_lets_go));
        phrasesWords.add(new Word(getString(R.string.come_here), "әnni'nem",
                R.raw.phrase_come_here));

        /*work adapter to inflate the layout customize.
        This allows to recycle the view improving the performance*/
        WordAdapter itemsAdapter = new WordAdapter(getActivity(), phrasesWords);

        //List view where is stored the adapter
        ListView listView = rootView.findViewById(R.id.list);
        listView.setAdapter(itemsAdapter);

        //Setting the listener of the click item
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {

                releaseMediaPlayer();
                //requesting the audio focus
                int result = mAudioManager.requestAudioFocus(afChangeListener,
                        AudioManager.STREAM_MUSIC, AudioManager.AUDIOFOCUS_GAIN_TRANSIENT);

                //gain the audio focus
                if (result == AudioManager.AUDIOFOCUS_REQUEST_GRANTED) {
                    mMediaPlayer = MediaPlayer.create(getActivity(),
                            phrasesWords.get(position).getSound());
                    mMediaPlayer.start();

                    mMediaPlayer.setOnCompletionListener(onCompletionListener);
                }

            }
        });


        return rootView;
    }

    @Override
    public void onStop() {
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

            mAudioManager.abandonAudioFocus(afChangeListener);//releasing the audio focus
        }
    }

}