package com.example.miwok;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;

public class WordAdapter extends ArrayAdapter<Word> {
    public WordAdapter(Context context, ArrayList<Word> listOfWords) {
        super(context, 0, listOfWords);
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {

        View currentView = convertView;

        if (currentView == null) {
            currentView = LayoutInflater.from(getContext()).inflate(R.layout.list_item, parent, false);
        }

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


        Word currentWord = getItem(position);

        TextView miworkWord = (TextView) currentView.findViewById(R.id.miwok_word_view);
        miworkWord.setText(currentWord.getmMiwokWord());

        TextView defaultWord = (TextView) currentView.findViewById(R.id.default_word_view);
        defaultWord.setText(currentWord.getmDefaultWord());

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
