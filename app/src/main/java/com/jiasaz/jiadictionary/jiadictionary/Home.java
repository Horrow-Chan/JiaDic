package com.jiasaz.jiadictionary.jiadictionary;

import android.app.Fragment;
import android.graphics.Color;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.GridView;
import android.widget.ImageButton;
import android.widget.SimpleCursorAdapter;
import android.widget.Spinner;
import android.widget.Toast;

public class Home extends Fragment implements View.OnClickListener{

    View view;
    SimpleCursorAdapter mAdapter;
    Spinner spinner1;
    Spinner spinner2;
    ImageButton imageButton;

    @Override
    public View onCreateView(LayoutInflater inflater,ViewGroup viewGroup,Bundle savedInstance){


        view = inflater.inflate(R.layout.home_fragment, viewGroup, false);

        spinner1 = assignSpinnerItem(R.id.language_selection_1);
        spinner2 =assignSpinnerItem(R.id.language_selection_2);

        imageButton = (ImageButton) view.findViewById(R.id.swap_input);
        imageButton.setOnClickListener(this);


        int[] letterID = {R.id.letter_1,R.id.button_2,R.id.letter_3,
                R.id.letter_4,R.id.letter_5,R.id.letter_6,R.id.letter_7,
                R.id.letter_8,R.id.letter_9,R.id.letter_10,R.id.letter_11,
                R.id.letter_12,R.id.letter_13,R.id.letter_14,R.id.letter_15,
                R.id.letter_16,R.id.letter_17,R.id.letter_18,R.id.letter_19,
                R.id.letter_20,R.id.letter_21,R.id.letter_22,R.id.letter_23,
                R.id.letter_24,R.id.letter_25,R.id.letter_26};
        String letters[] = {"A","B","C","D","E","F","G","H","I","J","K","L","M","N"
                ,"O","P","Q","R","S","T","U","V","W","X","Y","Z"};

        for (int i = 0; i < 26; i++)
            setButtons(letterID[i],letters[i]);
        return view;
    }

    //Method to initialize the buttons with colors
    private void setButtons(int id,String text){
        Button button = (Button) view.findViewById(id);
        button.setText(text);
        button.setTextColor(Color.WHITE);
    }


    //method that initialize a spinner with items based on the ID
    private Spinner assignSpinnerItem(int languageSelection){
        Spinner spinner = (Spinner) view.findViewById(languageSelection);
        ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(getActivity(),
                R.array.languages,R.layout.spinner_item);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinner.setAdapter(adapter);
        return spinner;
    }

    //get spinner position
    protected int getPosition(Spinner spinner){
        return (int) spinner.getSelectedItemPosition();
    }

    @Override
    public void onClick(View v) {
        int view = v.getId();

        //Handles the swaping of Spinner Item
        if(view == R.id.swap_input){
            int x = getPosition(spinner1);
            int y = getPosition(spinner2);
            spinner1.setSelection(y);
            spinner2.setSelection(x);
        }

    }
}
