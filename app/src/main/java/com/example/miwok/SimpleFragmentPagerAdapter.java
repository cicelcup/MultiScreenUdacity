package com.example.miwok;

/*Libraries imported*/
import android.content.Context;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

public class SimpleFragmentPagerAdapter extends FragmentPagerAdapter {
    private Context mContext; //Context where the page adapter works

    SimpleFragmentPagerAdapter(Context context, FragmentManager fm) {
        super(fm);
        mContext = context;
    }

    @Override
    public Fragment getItem(int position) {
        //bundle for sending information from the fragment pager adapter
        Bundle bundle = new Bundle();
        //new fragment
        WordFragment wordFragment = new WordFragment();
        switch (position) {
            case 0: //First View. Numbers
                bundle.putString("key", Integer.toString(WordAdapter.NUMBERS));
                wordFragment.setArguments(bundle);
                return wordFragment;
            case 1: //Second View. Family
                bundle.putString("key", Integer.toString(WordAdapter.FAMILY));
                wordFragment.setArguments(bundle);
                return wordFragment;
            case 2: //Third View. Colors.
                bundle.putString("key", Integer.toString(WordAdapter.COLORS));
                wordFragment.setArguments(bundle);
                return wordFragment;
            default: //Last View. Phrases
                bundle.putString("key", Integer.toString(WordAdapter.PHRASES));
                wordFragment.setArguments(bundle);
                return wordFragment;
        }
    }

    /*Indicates the amount of views into the FragmentPageAdapter*/
    @Override
    public int getCount() {
        return 4;
    }

    /*Indicates the titles of each tabs*/
    @Override
    public CharSequence getPageTitle(int position) {
        switch (position) {
            case 0:
                return mContext.getString(R.string.category_numbers);
            case 1:
                return mContext.getString(R.string.category_family);
            case 2:
                return mContext.getString(R.string.category_colors);
            default:
                return mContext.getString(R.string.category_phrases);
        }

    }
}
