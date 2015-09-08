package com.jiasaz.jiadictionary.jiadictionary;

import android.app.FragmentManager;
import android.app.FragmentTransaction;
import android.app.Fragment;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    //create toolbar object to be used as action bar
    private Toolbar toolbar;
    private DrawerLayout mDrawerLayout;

    private String[] menuTitle;
    private CharSequence mTitle;
    private ListView mDrawerList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        //create a toolbar instead of actionbar because of android material design and update requirements
        toolbar = (Toolbar) findViewById(R.id.app_bar);
        setSupportActionBar(toolbar);

        //Possible Error ? don't know how to fix "Yet"
        getSupportActionBar().setDisplayShowHomeEnabled(true);

        //Navigation list items
        //get string array for the menu
        menuTitle = getResources().getStringArray(R.array.navigation_menu);
        mDrawerLayout = (DrawerLayout) findViewById(R.id.drawer_layout);
        mDrawerList = (ListView) findViewById(R.id.list_item_navigation);
        mDrawerLayout = (DrawerLayout) findViewById(R.id.drawer_layout);

        mDrawerList.setAdapter(new ArrayAdapter<String>(this,R.layout.support_simple_spinner_dropdown_item,menuTitle));
        mDrawerList.setOnItemClickListener(new DrawerItemClickListener());
        //create a navigation drawer object and pass the navigation drawer fragment to it
        NavigationDrawerFragment drawerFragment;
        drawerFragment = (NavigationDrawerFragment) getSupportFragmentManager().findFragmentById(R.id.fragement_navigation_drawer);
        drawerFragment.setUp(R.id.fragement_navigation_drawer,(DrawerLayout)findViewById(R.id.drawer_layout),toolbar);
        Log.i("ACTIVITY MAIN ON CREAT","ON CREATE");
    }

//    this class is responsible for the clicking of navigation drawer list items
    private class DrawerItemClickListener implements ListView.OnItemClickListener {

        @Override
        public void onItemClick(AdapterView parent, View view, int position, long id) {
            //selectItem(position);

            TextView tv = (TextView) findViewById(R.id.tv);
            tv.setText("The position is " + position);

            if (position == 1){
                switchContent(new FragmentTest());
            }else if (position == 3){
                switchContent(new Setting());
            }

            mDrawerList.setItemChecked(position,true);
            setTitle(menuTitle[position]);
            mDrawerLayout.closeDrawers();
        }
    }

    public void switchContent(Fragment fragment){
        FragmentManager fragmentManager = getFragmentManager();
        FragmentTransaction transaction = fragmentManager.beginTransaction();
        transaction.replace(R.id.contenttobereplaced,fragment);
        transaction.commit();
    }


    public void setTitle(CharSequence title) {
        mTitle = title;
        toolbar.setTitle(mTitle);
    }
}