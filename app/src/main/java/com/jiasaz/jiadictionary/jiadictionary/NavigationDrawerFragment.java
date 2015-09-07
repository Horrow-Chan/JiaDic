package com.jiasaz.jiadictionary.jiadictionary;


import android.content.Context;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.support.v7.widget.Toolbar;

public class NavigationDrawerFragment extends android.support.v4.app.Fragment {

    //public constant that will be the name of the file we use in shared preference
    public static final String PREF_FILE_NAME="testpref";
    //To save/load to preference we need a key which is this one below
    public static final String KEY_USER_LEARNED_DRAWER ="user_learned_drawer";
    private ActionBarDrawerToggle mDrawerToggle;
    private DrawerLayout mDrawerLayout;
    //indicate weather user is aware of existance of navigation drawer or not
    private boolean mUserLearnedDrawer;
    private boolean mFromSavedInstance;
    //used to get a layout
    private View containerView;

    public NavigationDrawerFragment() {
        // Required empty public constructor
    }


    // To know if app was started by user before
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        mUserLearnedDrawer = Boolean.valueOf(readToPreferences(getActivity(),KEY_USER_LEARNED_DRAWER,"false"));
        if (savedInstanceState != null){
            //if its not null it means the object is being created first time and its not back from rotation
            mFromSavedInstance = true;
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_navigation_drawer, container, false);
    }


    // main method used for handling navigation drawer layout
    // take the navigation drawer fragment id, the drawer layout and the toolbar which is used in case of action bar
    public void setUp(int fragmentId,DrawerLayout drawerLayout,Toolbar toolbar){

        containerView = getActivity().findViewById(fragmentId);
        mDrawerLayout = drawerLayout;
        mDrawerToggle = new ActionBarDrawerToggle(getActivity(),drawerLayout,toolbar,R.string.open_drawer,R.string.close_drawer){
            @Override
            public void onDrawerOpened(View drawerView) {
                if (!mUserLearnedDrawer){
                    mUserLearnedDrawer= true;
                    saveToPreferences(getActivity(),KEY_USER_LEARNED_DRAWER,mUserLearnedDrawer+"");
                }

                getActivity().invalidateOptionsMenu();
            }

            @Override
            public void onDrawerClosed(View drawerView) {
                getActivity().invalidateOptionsMenu();
            }
        };

        if (!mUserLearnedDrawer && !mFromSavedInstance){
           mDrawerLayout.openDrawer(containerView);
        }

        mDrawerLayout.setDrawerListener(mDrawerToggle);
        mDrawerLayout.post(new Runnable() {
            @Override
            public void run() {
                mDrawerToggle.syncState();
            }
        });
    }//end of setUp method


    //write to shared Preferenceas
    public static void saveToPreferences(Context context,String preferencesName,String preferencesValue){
        SharedPreferences sharedPreferences = context.getSharedPreferences(PREF_FILE_NAME,context.MODE_PRIVATE);
        SharedPreferences.Editor editor = sharedPreferences.edit();
        editor.putString(preferencesName,preferencesValue);
        editor.apply();
    }

    //read from sharedPreference
    public static String readToPreferences(Context context,String preferencesName,String defaultValue){
        SharedPreferences sharedPreferences = context.getSharedPreferences(PREF_FILE_NAME,context.MODE_PRIVATE);
        return sharedPreferences.getString(preferencesName,defaultValue);
    }
}
