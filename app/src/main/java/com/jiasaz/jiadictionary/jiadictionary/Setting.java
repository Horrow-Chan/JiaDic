package com.jiasaz.jiadictionary.jiadictionary;

import android.app.Fragment;
import android.media.Image;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

public class Setting extends Fragment {


    public View onCreateView(LayoutInflater inflater,ViewGroup view,Bundle savedInstance){
        return inflater.inflate(R.layout.setting_fragment,view, false);
    }
}