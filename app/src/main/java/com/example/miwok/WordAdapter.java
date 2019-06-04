/*Class adapter for recycling the view in the list view*/

package com.example.miwok; //package of the project

//libraries need it
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
    //Constructor with two atributes, one for the contest and another one with the list of words...
    public WordAdapter(Context context, ArrayList<Word> listOfWords) {
        super(context, 0, listOfWords); //Initialing the constructor of three parameters
    }

    //Overriding the get view method. Included position of the item, the current view and the parent
    @Override
    public View getView(int position, View convertView, ViewGroup parent) {

        View currentView = convertView;

        if (currentView == null) { //inflating the layout if the currentview is null
            //Inflating the list_item view
            currentView = LayoutInflater.from(getContext()).inflate(R.layout.list_item, parent, false);
        }

        //which class is calling the WordAdapter required for setting the color of the layout
        String whichClass = getContext().getClass().getSimpleName();

        switch (whichClass) {
            case "ColorsActivity":
                currentView.setBackgroundColor(getContext().getResources().getColor(R.color.category_colors));
                break;

            case "FamilyActivity":
                currentView.setBackgroundColor(getContext().getResources().getColor(R.color.category_family));
                break;

            case "NumbersActivity":
                currentView.setBackgroundColor(getContext().getResources().getColor(R.color.category_numbers));
                break;

            case "PhrasesActivity":
                currentView.setBackgroundColor(getContext().getResources().getColor(R.color.category_phrases));
                break;

            default:
                break;
        }


        //getting the item of the word array
        Word currentWord = getItem(position);

        //setting the miwok word
        TextView miwokWord = (TextView) currentView.findViewById(R.id.miwok_word_view);
        miwokWord.setText(currentWord.getmMiwokWord());

        //setting the english word
        TextView defaultWord = (TextView) currentView.findViewById(R.id.default_word_view);
        defaultWord.setText(currentWord.getmDefaultWord());

        //setting the image... If it's false that means there's not image into the constructor
        ImageView imageView = (ImageView) currentView.findViewById(R.id.imageWords);

        if (currentWord.hasImage() != false) {
            imageView.setImageResource(currentWord.getmImageResourceId());
            imageView.setVisibility(View.VISIBLE);
        } else {
            imageView.setVisibility(View.GONE);
        }

        return currentView;
    }
}
