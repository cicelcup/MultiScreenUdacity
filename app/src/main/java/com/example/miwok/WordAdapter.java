/*Class adapter for recycling the view in the list view*/

package com.example.miwok; //package of the project

//libraries imported
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;

/*public class as an extension of the array adapter*/

public class WordAdapter extends ArrayAdapter<Word> {
    //Color Constants
    static final int COLORS = 1;
    static final int FAMILY = 2;
    static final int NUMBERS = 3;
    static final int PHRASES = 4;
    /*Constructor with three attributes, one for the context, another one with the list of words.
    and the color of the activity*/
    private int mColorBackground;

    WordAdapter(Context context, ArrayList<Word> listOfWords, int color) {
        super(context, 0, listOfWords); //Initialing the constructor of three parameters
        mColorBackground = color;
    }

    //Overriding the get view method. Including item's position, the current view and the parent
    @Override
    public View getView(int position, View convertView, ViewGroup parent) {

        View currentView = convertView;

        if (currentView == null) { //inflating the layout if the current view is null
            //Inflating the list_item view
            currentView = LayoutInflater.from(getContext()).inflate(R.layout.list_item, parent,
                    false);
        }

        //which fragment is calling the WordAdapter required for setting the color of the layout


        switch (mColorBackground) {
            case COLORS:
                currentView.setBackgroundColor(getContext().getResources().getColor
                        (R.color.category_colors));
                break;

            case FAMILY:
                currentView.setBackgroundColor(getContext().getResources().getColor
                        (R.color.category_family));
                break;

            case NUMBERS:
                currentView.setBackgroundColor(getContext().getResources().getColor
                        (R.color.category_numbers));
                break;

            case PHRASES:
                currentView.setBackgroundColor(getContext().getResources().getColor
                        (R.color.category_phrases));
                break;

            default:
                break;
        }

        //getting the item of the word array
        Word currentWord = getItem(position);

        //setting the miwok word
        TextView miwokWord = currentView.findViewById(R.id.miwok_word_view);
        miwokWord.setText(currentWord.getMiwokWord());

        //setting the english word
        TextView defaultWord = currentView.findViewById(R.id.default_word_view);
        defaultWord.setText(currentWord.getDefaultWord());

        //setting the image... If it's false that means there's not image into the constructor
        ImageView imageView = currentView.findViewById(R.id.imageWords);

        if (currentWord.hasImage()) {
            imageView.setImageResource(currentWord.getImageResourceId());
            imageView.setVisibility(View.VISIBLE);
        } else {
            imageView.setVisibility(View.GONE);
        }

        return currentView;
    }
}
