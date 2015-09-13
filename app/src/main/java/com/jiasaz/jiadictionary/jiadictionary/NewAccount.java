package com.jiasaz.jiadictionary.jiadictionary;

import android.app.Fragment;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;

public class NewAccount extends Fragment {

    View view;
    Menu menu;
    @Override
    public View onCreateView(LayoutInflater inflater,ViewGroup viewGroup,Bundle savedInstance){
        view =inflater.inflate(R.layout.new_account_fragment,viewGroup,false);
        setHasOptionsMenu(true);

        return  view;
    }

    @Override
    public void onCreateOptionsMenu(Menu menu,MenuInflater inflater) {
        menu.clear(); // clears all menu items..
        getActivity().getMenuInflater().inflate(R.menu.menu_main, menu);
        super.onCreateOptionsMenu(menu, inflater);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item){
        if ( item.getItemId() ==  R.id.close){

        }
        return true;
    }
}