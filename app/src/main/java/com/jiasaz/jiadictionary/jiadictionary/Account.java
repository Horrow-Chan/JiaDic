package com.jiasaz.jiadictionary.jiadictionary;

import android.app.Fragment;
import android.app.FragmentManager;
import android.app.FragmentTransaction;
import android.media.Image;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;
import android.widget.Toast;

public class Account extends Fragment implements View.OnClickListener {

    private ImageButton imageButton;
    private View myView;
    @Override
    public View onCreateView(LayoutInflater inflater,ViewGroup view,Bundle savedInstance){
        myView = inflater.inflate(R.layout.account_fragment,view,false);
        setHasOptionsMenu(true);
        imageButton = (ImageButton) myView.findViewById(R.id.image_button_next_account);
        imageButton.setOnClickListener(this);
        return myView;
    }

    @Override
    public void onClick(View v) {
        if (R.id.image_button_next_account == v.getId()) {
           Toast.makeText(getActivity(),"Hello WOrld",Toast.LENGTH_SHORT).show();
        }
    }

    @Override
    public void onCreateOptionsMenu(Menu menu,MenuInflater menuInflater){
        menu.clear();
        getActivity().getMenuInflater().inflate(R.menu.add_account,menu);
        super.onCreateOptionsMenu(menu,menuInflater);
    }
}
