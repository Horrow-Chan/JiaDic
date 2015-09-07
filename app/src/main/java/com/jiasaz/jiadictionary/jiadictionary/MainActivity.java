package com.jiasaz.jiadictionary.jiadictionary;

import android.app.FragmentManager;
import android.content.Intent;
import android.app.Fragment;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;

public class MainActivity extends AppCompatActivity {

    //create toolbar object to be used as action bar
    private Toolbar toolbar;
    private String[] mTitle;
    private CharSequence charSequenceTitle;
    private DrawerLayout mDrawerLayout;
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
        mTitle = getResources().getStringArray(R.array.navigation_menu);
        mDrawerLayout = (DrawerLayout) findViewById(R.id.drawer_layout);
        mDrawerList = (ListView) findViewById(R.id.list_item_navigation);

        mDrawerList.setAdapter(new ArrayAdapter<String>(this,R.layout.support_simple_spinner_dropdown_item,mTitle));
        mDrawerList.setOnItemClickListener(new DrawerItemClickListener());

        //create a navigation drawer object and pass the navigation drawer fragment to it
        NavigationDrawerFragment drawerFragment;
        drawerFragment = (NavigationDrawerFragment) getSupportFragmentManager().findFragmentById(R.id.fragement_navigation_drawer);
        drawerFragment.setUp(R.id.fragement_navigation_drawer,(DrawerLayout)findViewById(R.id.drawer_layout),toolbar);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    public void newActivity(View view){
        Intent i = new Intent(this,Account.class);
        startActivity(i);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        //code remain here

        return super.onOptionsItemSelected(item);
    }
    //this class is responsible for the clicking of navigation drawer list items
    private class DrawerItemClickListener implements ListView.OnItemClickListener {

        @Override
        public void onItemClick(AdapterView parent, View view, int position,long id){
            selectItem(position);
        }

        //swap the fragments in the main content
        private void selectItem(int position){
            //code needs to be done here
            Fragment fragment = new NavigationFragment();
            Bundle args = new Bundle();
            args.putInt(NavigationFragment.NAVIGATION_ITEM_NUMBER, position);
            fragment.setArguments(args);

            FragmentManager fragmentManager = getFragmentManager();
            fragmentManager.beginTransaction().replace(R.id.main_content,fragment).commit();

            //Update selected Item and Title and close drawer
            mDrawerList.setItemChecked(position,true);
            setTitle(mTitle[position]);
            mDrawerLayout.closeDrawer(mDrawerList);
        }

        public void setTitle(CharSequence title) {
            charSequenceTitle = title;
            toolbar.setTitle(charSequenceTitle);
        }
    }
}