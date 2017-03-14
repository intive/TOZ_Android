package com.intive.toz;


import android.os.Bundle;
import android.support.annotation.NonNull;
import com.hannesdorfmann.mosby.mvp.MvpActivity;

import com.intive.toz.common.view.navigationTabs.NavigationTabsFragment;
import com.intive.toz.common.view.navigationTabs.NavigationTabsView;
import com.intive.toz.common.view.navigationTabs.NavigationTabsPresenter;
import com.intive.toz.common.view.navigationTabs.ViewPagerAdapter;

import android.support.design.widget.TabLayout;
import android.support.v4.view.ViewPager;
import android.support.v7.widget.Toolbar;


public class MainActivity extends MvpActivity<NavigationTabsView, NavigationTabsPresenter> implements  NavigationTabsView{


    private Toolbar toolbar;
    private TabLayout tabLayout;
    private ViewPager viewPager;
    private ViewPagerAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initViews();
        getPresenter().loadNavigationTabs();
        getPresenter().loadNavigationTabsIcons();
    }

    @NonNull
    @Override
    public NavigationTabsPresenter createPresenter() {
        return new NavigationTabsPresenter();
    }

    private void initViews() {
        toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        viewPager = (ViewPager) findViewById(R.id.viewpager);
        tabLayout = (TabLayout) findViewById(R.id.tabs);
        tabLayout.setupWithViewPager(viewPager);
        adapter = new ViewPagerAdapter(getSupportFragmentManager());
    }

    @Override
    public void showNavigationTabsForGuest() {
        adapter.addFragment(new NavigationTabsFragment().newInstance("One"), getResources().getString(R.string.navigation_tab_neews));
        adapter.addFragment(new NavigationTabsFragment().newInstance("Two"), getResources().getString(R.string.navigation_tab_gallery));
        viewPager.setAdapter(adapter);
    }

    @Override
    public void showNavigationTabsForLoggedInUser() {
        adapter.addFragment(new NavigationTabsFragment().newInstance("One"), getResources().getString(R.string.navigation_tab_neews));
        adapter.addFragment(new NavigationTabsFragment().newInstance("Two"), getResources().getString(R.string.navigation_tab_gallery));
        adapter.addFragment(new NavigationTabsFragment().newInstance("Three"), getResources().getString(R.string.navigation_tab_schedule));
        adapter.addFragment(new NavigationTabsFragment().newInstance("Four"), getResources().getString(R.string.navigation_tab_account));
        viewPager.setAdapter(adapter);
    }

    @Override
    public void shownTabsIconsForGuest() {
        tabLayout.getTabAt(0).setIcon(R.mipmap.ic_launcher);
        tabLayout.getTabAt(1).setIcon(R.mipmap.ic_launcher);
    }

    @Override
    public void showTabsIconsForLoggedInUser() {
        tabLayout.getTabAt(0).setIcon(R.mipmap.ic_launcher);
        tabLayout.getTabAt(1).setIcon(R.mipmap.ic_launcher);
        tabLayout.getTabAt(2).setIcon(R.mipmap.ic_launcher);
        tabLayout.getTabAt(3).setIcon(R.mipmap.ic_launcher);
    }
}
