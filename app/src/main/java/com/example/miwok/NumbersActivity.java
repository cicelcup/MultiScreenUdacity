package com.example.miwok;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.LinearLayout;
import android.widget.TextView;

import java.util.ArrayList;

public class NumbersActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_numbers);

        ArrayList<String> numbers = new ArrayList<String>();
        numbers.add(getString(R.string.one));
        numbers.add(getString(R.string.two));
        numbers.add(getString(R.string.three));
        numbers.add(getString(R.string.four));
        numbers.add(getString(R.string.five));
        numbers.add(getString(R.string.six));
        numbers.add(getString(R.string.seven));
        numbers.add(getString(R.string.eight));
        numbers.add(getString(R.string.nine));
        numbers.add(getString(R.string.ten));

        LinearLayout listOfNumbers = findViewById(R.id.layout_id);

        for (int index = 0; index < numbers.size(); index++) {
            TextView numberElement = new TextView(this);
            numberElement.setText(numbers.get(index));
            listOfNumbers.addView(numberElement);
        }
    }

}
