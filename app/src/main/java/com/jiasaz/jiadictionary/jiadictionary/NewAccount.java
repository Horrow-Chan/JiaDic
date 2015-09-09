package com.jiasaz.jiadictionary.jiadictionary;

import android.app.Fragment;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

public class NewAccount extends Fragment {


    @Override
    public View onCreateView(LayoutInflater inflater,ViewGroup viewGroup,Bundle savedInstance){
        return inflater.inflate(R.layout.new_account_fragment,viewGroup,false);
    }
}
