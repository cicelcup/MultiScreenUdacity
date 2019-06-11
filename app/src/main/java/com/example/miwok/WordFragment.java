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
public class WordFragment extends Fragment {

    int option;

    //Getting the name of the activity for using for the log (testing uses)
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


    public WordFragment() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        //layout to open
        View rootView = inflater.inflate(R.layout.words, container, false);

        Bundle bundle = getArguments();
        option = Integer.parseInt(bundle.getString("key"));
        
        super.onCreate(savedInstanceState);


        //getting the audio from the system
        mAudioManager = (AudioManager)
                getActivity().getSystemService(Context.AUDIO_SERVICE);

        WordAdapter itemsAdapter;
        final ArrayList<Word> words = new ArrayList<>();


        switch (option) {
            case WordAdapter.COLORS:

                addingColorWords(words);

        /*work adapter to inflate the layout customize
        This allows to recycle the view improving the performance*/
                itemsAdapter = new WordAdapter(getActivity(), words,
                        WordAdapter.COLORS);
                break;

            case WordAdapter.FAMILY:
                addingFamilyWords(words);


        /*work adapter to inflate the layout customize..
        This allows to recycle the view improving the performance*/
                itemsAdapter = new WordAdapter(getActivity(), words,
                        WordAdapter.FAMILY);
                break;

            case WordAdapter.NUMBERS:
                addingNumbersWords(words);

        /*work adapter to inflate the layout customize.
        This allows to recycle the view improving the performance*/
                itemsAdapter = new WordAdapter(getActivity(), words,
                        WordAdapter.NUMBERS);
                break;

            default:
                addingPhrasesWords(words);

        /*work adapter to inflate the layout customize.
        This allows to recycle the view improving the performance*/
                itemsAdapter = new WordAdapter(getActivity(), words,
                        WordAdapter.PHRASES);
                break;
        }


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
                                    words.get(position).getSound());
                            mMediaPlayer.start();

                            mMediaPlayer.setOnCompletionListener(onCompletionListener);
                        }

                    }
                };

        listView.setOnItemClickListener(mMessageClickedHandler);


        return rootView;


    }

    private void addingColorWords(ArrayList<Word> words) {
        /*Array list where is store the words in english, mitowk, with the image to display and
        the sound of the file*/

        words.add(new Word(getString(R.string.red), "weṭeṭṭi", R.drawable.color_red,
                R.raw.color_red));
        words.add(new Word(getString(R.string.mustard_yellow), "chiwiiṭә",
                R.drawable.color_mustard_yellow, R.raw.color_mustard_yellow));
        words.add(new Word(getString(R.string.dusty_yellow), "ṭopiisә",
                R.drawable.color_dusty_yellow, R.raw.color_dusty_yellow));
        words.add(new Word(getString(R.string.green), "chokokki", R.drawable.color_green,
                R.raw.color_green));
        words.add(new Word(getString(R.string.brown), "ṭakaakki", R.drawable.color_brown,
                R.raw.color_brown));
        words.add(new Word(getString(R.string.gray), "ṭopoppi", R.drawable.color_gray,
                R.raw.color_gray));
        words.add(new Word(getString(R.string.black), "kululli", R.drawable.color_black,
                R.raw.color_black));
        words.add(new Word(getString(R.string.white), "kelelli", R.drawable.color_white,
                R.raw.color_white));
    }

    private void addingFamilyWords(ArrayList<Word> words) {
        //Array list where are the words in english, mitowk, the image to display and the audio
        words.add(new Word(getString(R.string.father), "әpә", R.drawable.family_father,
                R.raw.family_father));
        words.add(new Word(getString(R.string.mother), "әṭa", R.drawable.family_mother,
                R.raw.family_mother));
        words.add(new Word(getString(R.string.son), "angsi", R.drawable.family_son,
                R.raw.family_son));
        words.add(new Word(getString(R.string.daughter), "tune", R.drawable.family_daughter,
                R.raw.family_daughter));
        words.add(new Word(getString(R.string.older_brother), "taachi",
                R.drawable.family_older_brother, R.raw.family_older_brother));
        words.add(new Word(getString(R.string.younger_brother), "chalitti",
                R.drawable.family_younger_brother, R.raw.family_younger_brother));
        words.add(new Word(getString(R.string.older_sister), "teṭe", R.drawable.family_older_sister,
                R.raw.family_older_sister));
        words.add(new Word(getString(R.string.younger_sister), "kolliti",
                R.drawable.family_younger_sister, R.raw.family_younger_sister));
        words.add(new Word(getString(R.string.grandmother), "ama", R.drawable.family_grandmother,
                R.raw.family_grandmother));
        words.add(new Word(getString(R.string.grandfather), "paapa",
                R.drawable.family_grandfather, R.raw.family_grandfather));
    }

    private void addingNumbersWords(ArrayList<Word> words) {
//Array list where are the words in english, mitowk, the image to display and the sound
        words.add(new Word(getString(R.string.one), "lutti", R.drawable.number_one,
                R.raw.number_one));
        words.add(new Word(getString(R.string.two), "otiiko", R.drawable.number_two,
                R.raw.number_two));
        words.add(new Word(getString(R.string.three), "tolookosu", R.drawable.number_three,
                R.raw.number_three));
        words.add(new Word(getString(R.string.four), "oyyisa", R.drawable.number_four,
                R.raw.number_four));
        words.add(new Word(getString(R.string.five), "massokka",
                R.drawable.number_five, R.raw.number_five));
        words.add(new Word(getString(R.string.six), "temmokka", R.drawable.number_six,
                R.raw.number_six));
        words.add(new Word(getString(R.string.seven), "kenekaku", R.drawable.number_seven,
                R.raw.number_seven));
        words.add(new Word(getString(R.string.eight), "kawinta", R.drawable.number_eight,
                R.raw.number_eight));
        words.add(new Word(getString(R.string.nine), "wo’e", R.drawable.number_nine,
                R.raw.number_nine));
        words.add(new Word(getString(R.string.ten), "na’aacha", R.drawable.number_ten,
                R.raw.number_ten));
    }

    private void addingPhrasesWords(ArrayList<Word> words) {
//Array list where is store the words in english, Miwok word and audio
        words.add(new Word(getString(R.string.where_are_you_going), "minto wuksus",
                R.raw.phrase_where_are_you_going));
        words.add(new Word(getString(R.string.what_is_your_name), "tinnә oyaase'nә",
                R.raw.phrase_what_is_your_name));
        words.add(new Word(getString(R.string.my_name_is), "oyaaset...",
                R.raw.phrase_my_name_is));
        words.add(new Word(getString(R.string.how_are_you_feeling), "michәksәs?",
                R.raw.phrase_how_are_you_feeling));
        words.add(new Word(getString(R.string.i_m_feeling_good), "kuchi achit",
                R.raw.phrase_im_feeling_good));
        words.add(new Word(getString(R.string.are_you_coming), "әәnәs'aa?",
                R.raw.phrase_are_you_coming));
        words.add(new Word(getString(R.string.yes_I_m_coming), "hәә’ әәnәm",
                R.raw.phrase_yes_im_coming));
        words.add(new Word(getString(R.string.i_m_coming), "әәnәm",
                R.raw.phrase_im_coming));
        words.add(new Word(getString(R.string.let_s_go), "yoowutis",
                R.raw.phrase_lets_go));
        words.add(new Word(getString(R.string.come_here), "әnni'nem",
                R.raw.phrase_come_here));
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
