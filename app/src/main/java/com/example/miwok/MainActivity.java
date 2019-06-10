/* Name of the package of the whole project */
package com.example.miwok;

/*
Libraries imported:
Intent for opening a new activity
*/

import android.os.Bundle;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;

/* APP Compact Activity for supporting old apps designed. */
/* View for support the view component for the click event */

/* class where start the APP * / */
public class MainActivity extends AppCompatActivity {

    //Override of the onCreate method in the app compact activity
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //Layout established for the  view
        setContentView(R.layout.activity_main);

        ViewPager viewPager = findViewById(R.id.viewpager);

        SimpleFragmentPagerAdapter adapter =
                new SimpleFragmentPagerAdapter(getSupportFragmentManager());

        viewPager.setAdapter(adapter);

    }

}
