/* Name of the package of the whole project */
package com.example.miwok;

/*
Libraries imported:
*/

import android.os.Bundle;
import android.support.design.widget.TabLayout;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;

/* APP Compact Activity for supporting old apps designed.Class where start the APP */

public class MainActivity extends AppCompatActivity {

    //Override of the onCreate method in the app compact activity
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //Layout established for the  view (View Pager and Tabs)
        setContentView(R.layout.activity_main);

        //finding the view pager
        ViewPager viewPager = findViewById(R.id.viewpager);

        //Establishing the FragmentPageAdapter
        SimpleFragmentPagerAdapter adapter =
                new SimpleFragmentPagerAdapter(this, getSupportFragmentManager());

        viewPager.setAdapter(adapter);

        //Establishing the Tab Layout
        TabLayout tabLayout = findViewById(R.id.tabs);

        tabLayout.setupWithViewPager(viewPager);

    }

}
