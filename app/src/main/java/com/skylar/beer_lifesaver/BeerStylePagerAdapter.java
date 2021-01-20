package com.skylar.beer_lifesaver;

import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentPagerAdapter;

import java.util.ArrayList;

public class BeerStylePagerAdapter extends FragmentPagerAdapter {
    private ArrayList<BeerStyle> mBeerStyles;


    public BeerStylePagerAdapter(FragmentManager fm, ArrayList<BeerStyle> beerStyles){
        super(fm);
        mBeerStyles = beerStyles;
    }

    @Override
    public Fragment getItem(int position) {
        return BeerStyleDetailFragment.newInstance(mBeerStyles.get(position));

    }

    @Override
    public int getCount() {
        return mBeerStyles.size();
    }

    @Override
    public CharSequence getPageTitle(int position) {
        return mBeerStyles.get(position).getMessage();
    }

}