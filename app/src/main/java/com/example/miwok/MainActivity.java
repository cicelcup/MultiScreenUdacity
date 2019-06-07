/* Name of the package of the whole project */
package com.example.miwok;

/*
Libraries imported:
Intent for opening a new activity
*/

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.TextView;

/* APP Compact Activity for supporting old apps designed. */
/* View for support the view component for the click event */

/* class where start the APP * / */
public class MainActivity extends AppCompatActivity {

    //Override of the onCreate method in the app compact activity
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //Layout established for the first view
        setContentView(R.layout.activity_main);

        //Text view for colors. It's need it for creating the click event
        TextView colorsView = findViewById(R.id.colors);

        /*Setting the click listener overriding the onclick listener of view
        object (looking it into the layout)*/
        colorsView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //Creating a new intent into Main Activity related to the new class and starting it
                Intent colorsIntent = new Intent(MainActivity.this,
                        ColorsActivity.class);
                //colorsIntent.putExtra("test","Jorge Augusto");
                startActivity(colorsIntent);
            }
        });


        //Text view for family for creating the click event (looking it into the layout)
        TextView familyView = findViewById(R.id.family);

        //Setting the click listener overriding the onclick listener of view object
        familyView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent familyIntent = new Intent(MainActivity.this,
                        FamilyActivity.class);
                startActivity(familyIntent);
            }
        });

        //Text view for numbers. It's need it for creating the click event
        TextView numbersView = findViewById(R.id.numbers);

        //Setting the click listener overriding the onclick listener of view object
        numbersView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent numbersIntent = new Intent(MainActivity.this,
                        NumbersActivity.class);
                startActivity(numbersIntent);
            }
        });


        //Text view for phrases. It's need it for creating the click event
        TextView phrasesView = findViewById(R.id.phrases);

        //Setting the click listener overriding the onclick listener of view object
        phrasesView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent phrasesIntent = new Intent(MainActivity.this,
                        PhrasesActivity.class);
                startActivity(phrasesIntent);
            }
        });
    }

}
