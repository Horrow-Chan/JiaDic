package com.jiasaz.jiadictionary.jiadictionary;

import android.app.Fragment;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;


//To do codes remain here

public class NavigationFragment extends Fragment{
    public static final String NAVIGATION_ITEM_NUMBER = "Navigation Item Number";

    //Empty Constructor
    public NavigationFragment(){
    }

    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {

        View rootView = inflater.inflate(R.layout.activity_account, container, false);
        int i = getArguments().getInt(NAVIGATION_ITEM_NUMBER);

        String menu = getResources().getStringArray(R.array.navigation_menu)[i];

        return rootView;
    }
}