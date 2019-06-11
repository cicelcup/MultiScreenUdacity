package com.example.miwok;

import android.content.Context;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

public class SimpleFragmentPagerAdapter extends FragmentPagerAdapter {
    private Context mContext;

    SimpleFragmentPagerAdapter(Context context, FragmentManager fm) {
        super(fm);
        mContext = context;
    }

    @Override
    public Fragment getItem(int position) {
        Bundle bundle = new Bundle();
        WordFragment wordFragment = new WordFragment();
        switch (position) {
            case 0:
                bundle.putString("key", Integer.toString(WordAdapter.NUMBERS));
                wordFragment.setArguments(bundle);
                return wordFragment;
            case 1:
                bundle.putString("key", Integer.toString(WordAdapter.NUMBERS));
                wordFragment.setArguments(bundle);
                return wordFragment;
            case 2:
                bundle.putString("key", Integer.toString(WordAdapter.NUMBERS));
                wordFragment.setArguments(bundle);
                return wordFragment;
            default:
                bundle.putString("key", Integer.toString(WordAdapter.NUMBERS));
                wordFragment.setArguments(bundle);
                return wordFragment;
        }
    }

    @Override
    public int getCount() {
        return 4;
    }

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
