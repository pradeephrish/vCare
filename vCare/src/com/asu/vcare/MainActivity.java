package com.asu.vcare;


import java.util.List;

import android.app.Activity;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.support.annotation.DrawableRes;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.widget.DrawerLayout;
import android.app.ActionBar;
import android.content.Intent;
import android.support.v7.app.ActionBarActivity;
import android.text.Html;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;
import android.widget.TextView;

import com.asu.dao.DAOManager;
import com.asu.models.Events;
import com.asu.session.CurrentSession;
import com.parse.PushService;


public class MainActivity extends ActionBarActivity
        implements NavigationDrawerFragment.NavigationDrawerCallbacks {
	
    /**
     * Fragment managing the behaviors, interactions and presentation of the navigation drawer.
     */
    private NavigationDrawerFragment mNavigationDrawerFragment;

    /**
     * Used to store the last screen title. For use in {@link #restoreActionBar()}.
     */
    private CharSequence mTitle;
    private ListView listView;
    private DAOManager dao;
    
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
     // getIntent().getExtras().getString("name");
       String name = CurrentSession.getUser().getName();
       TextView textView = (TextView) findViewById(R.id.txtName); 
       textView.setText("Hi, "+name);
        
	ActionBar actionBar = getActionBar();
	actionBar.setBackgroundDrawable(getResources().getDrawable(R.drawable.banner));
	actionBar.setDisplayShowTitleEnabled(false);
	actionBar.setIcon(new ColorDrawable(getResources().getColor(android.R.color.transparent)));

	 //Receive Push Notification
        PushService.setDefaultPushCallback(this, MainActivity.class);
        
        
        mNavigationDrawerFragment = (NavigationDrawerFragment)
                getSupportFragmentManager().findFragmentById(R.id.navigation_drawer);
        mTitle = getTitle();

        // Set up the drawer.
        mNavigationDrawerFragment.setUp(
                R.id.navigation_drawer,
                (DrawerLayout) findViewById(R.id.drawer_layout));
       
        
        /*ParseObject testObject = new ParseObject("TestHello");
        testObject.put("test", "hello");
        testObject.saveInBackground();*/
        Button orgBtn =(Button)findViewById(R.id.btnOrganize);
        orgBtn.setOnClickListener(new View.OnClickListener() {
			
			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				 Intent i = new Intent(MainActivity.this, CreateOrganization.class);
				 startActivity(i);
			}
		});
       
		
        List<Events> events = new DAOManager().get(CurrentSession.getUser().getMobileNumber());
		String datum[] = new String[events.size()];
		String desc[] = new String[events.size()];
		Integer evtImage [] = new Integer[events.size()];
		for(int i=0; i<events.size();i++){
			
			Events event = events.get(i);
			datum[i] = event.getEventName();
			desc[i] = event.getEventDescription();
			evtImage[i] = R.drawable.event;			   	    
						
		}
		
		CustomList adapter = new CustomList(this, datum, desc, evtImage);
		listView = (ListView)findViewById(R.id.listView);
		listView.setAdapter(adapter);

    }

    @Override
    public void onNavigationDrawerItemSelected(int position) {
        // update the main content by replacing fragments
        FragmentManager fragmentManager = getSupportFragmentManager();
        fragmentManager.beginTransaction()
                .replace(R.id.container, PlaceholderFragment.newInstance(position + 1))
                .commit();
    }

    public void onSectionAttached(int number) {
        switch (number) {
            case 0:
                mTitle = getString(R.string.section_me);
                break;
            case 1:
                mTitle = getString(R.string.section_events);
                break;
            case 2:
                mTitle = getString(R.string.section_organize);
                break;
            case 3:
                mTitle = getString(R.string.section_share);
                break;
            case 4:
            	mTitle = getString(R.string.section_challenge);
                break;
            case 5:
                mTitle = getString(R.string.section_settings);
                break;
        }
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        if (!mNavigationDrawerFragment.isDrawerOpen()) {
            // Only show items in the action bar relevant to this screen
            // if the drawer is not showing. Otherwise, let the drawer
            // decide what to show in the action bar.
            getMenuInflater().inflate(R.menu.main, menu);
       
            return true;
        }
        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();
       
        return super.onOptionsItemSelected(item);
    }

    /**
     * A placeholder fragment containing a simple view.
     */
    public static class PlaceholderFragment extends Fragment {
        /**
         * The fragment argument representing the section number for this
         * fragment.
         */
        private static final String ARG_SECTION_NUMBER = "section_number";

        /**
         * Returns a new instance of this fragment for the given section
         * number.
         */
        public static PlaceholderFragment newInstance(int sectionNumber) {
            PlaceholderFragment fragment = new PlaceholderFragment();
            Bundle args = new Bundle();
            args.putInt(ARG_SECTION_NUMBER, sectionNumber);
            fragment.setArguments(args);
            return fragment;
        }

        public PlaceholderFragment() {
        }

        @Override
        public View onCreateView(LayoutInflater inflater, ViewGroup container,
                Bundle savedInstanceState) {
            View rootView = inflater.inflate(R.layout.fragment_main, container, false);
            return rootView;
        }

        @Override
        public void onAttach(Activity activity) {
            super.onAttach(activity);
            ((MainActivity) activity).onSectionAttached(
                    getArguments().getInt(ARG_SECTION_NUMBER));
        }
    }

}
