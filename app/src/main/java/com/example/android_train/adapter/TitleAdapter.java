package com.example.android_train.adapter;

import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentPagerAdapter;

import java.util.List;

/**
 * @author 65667
 */
public class TitleAdapter extends FragmentPagerAdapter {

    private FragmentManager fragmentManager;
    private List<Fragment>fragments;
    private String[] titles;

    public TitleAdapter(FragmentManager fm,List<Fragment> fragments,String[] titles) {
        super(fm);
        fragmentManager = fm;
        this.fragments = fragments;
        this.titles = titles;
    }

    @NonNull
    @Override
    public Object instantiateItem(@NonNull ViewGroup container, int position) {
        Fragment fragment = (Fragment) super.instantiateItem(container, position);
        this.fragmentManager.beginTransaction().show(fragment).commit();
        return fragment;
    }

    @Override
    public void destroyItem(@NonNull ViewGroup container, int position, @NonNull Object object) {
        Fragment fragment =fragments.get(position);
        this.fragmentManager.beginTransaction().hide(fragment).commit();
    }

    @NonNull
    @Override
    public Fragment getItem(int position) {
        return fragments.get(position);
    }

    @Override
    public int getCount() {
        return fragments.size();
    }

    @Nullable
    @Override
    public CharSequence getPageTitle(int position) {
        if (position >= titles.length){
            return null;
        }else {
            return titles[position];
        }
    }
}
