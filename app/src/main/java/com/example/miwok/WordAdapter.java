package com.example.miwok;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import java.util.ArrayList;

public class WordAdapter extends ArrayAdapter<Word> {
    public WordAdapter(Context context, ArrayList<Word> listOfWords) {
        super(context, 0,listOfWords);
    }

    @Override
    public View getView(int position,  View convertView,  ViewGroup parent) {

        View currentView = convertView;

        if (currentView == null){
            currentView = LayoutInflater.from(getContext()).inflate(R.layout.list_item,parent,false);
        }

        Word currentWord = getItem(position);

        TextView miworkWord = (TextView) currentView.findViewById(R.id.miwok_word_view);
        miworkWord.setText(currentWord.getmMiwokWord());

        TextView defaultWord = (TextView) currentView.findViewById(R.id.default_word_view);
        defaultWord.setText(currentWord.getmDefaultWord());

        return currentView;
    }
}
