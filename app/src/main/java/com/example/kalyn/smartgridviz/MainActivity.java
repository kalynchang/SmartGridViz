package com.example.kalyn.smartgridviz;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;


public class MainActivity extends ActionBarActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getSupportActionBar().hide();
        setContentView(R.layout.activity_main);
        if (savedInstanceState == null) {
            getSupportFragmentManager().beginTransaction()
                    .add(R.id.LinearLayout, new MenuFragment())
                    .commit();
        }
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up aboutbutton, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    public static class MenuFragment extends Fragment {
        Button aboutbutton;
        Button processbutton;
        Button peoplebutton;
        private final String TAG = MenuFragment.class.getSimpleName();
        /**
         * Displays a Fragment.
         * @param f     The Fragment to be displayed.
         * @param tag   The associated tag that is with the Fragment, usually the class name.
         */
        public void displayFragment(Fragment f, String tag) {
            FragmentTransaction ft = getFragmentManager().beginTransaction()
                    .addToBackStack(tag);
            ft.replace(R.id.LinearLayout, f, tag).commit();
        }

        @Override
        public View onCreateView(LayoutInflater inflater, ViewGroup container,
                                 Bundle savedInstanceState) {
            View rootView = inflater.inflate(R.layout.menufragment_layout, container, false);

            aboutbutton = (Button) rootView.findViewById(R.id.AboutButton);
            aboutbutton.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    // Perform action on click
                    displayFragment(new AboutFragment(), AboutFragment.class.getSimpleName());
                }
            });

            processbutton = (Button) rootView.findViewById(R.id.ProcessButton);
            processbutton.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    // Perform action on click
                    displayFragment(new ProcessFragment(), ProcessFragment.class.getSimpleName());
                }
            });

            peoplebutton = (Button) rootView.findViewById(R.id.PeopleButton);
            peoplebutton.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    // Perform action on click
                    displayFragment(new PeopleFragment(), PeopleFragment.class.getSimpleName());
                }
            });

            return rootView;
        }
    }

    public static class AboutFragment extends Fragment {
        private final String TAG = AboutFragment.class.getSimpleName();
        public View onCreateView(LayoutInflater inflater, ViewGroup container,
                                 Bundle savedInstanceState) {
            View rootView = inflater.inflate(R.layout.aboutfragment_layout, container, false);
            return rootView;
        }

    }

    public static class ProcessFragment extends Fragment {
        private final String TAG = AboutFragment.class.getSimpleName();
        public View onCreateView(LayoutInflater inflater, ViewGroup container,
                                 Bundle savedInstanceState) {
            View rootView = inflater.inflate(R.layout.processfragment_layout, container, false);
            return rootView;
        }

    }

    public static class PeopleFragment extends Fragment {
        private final String TAG = PeopleFragment.class.getSimpleName();
        public View onCreateView(LayoutInflater inflater, ViewGroup container,
                                 Bundle savedInstanceState) {
            View rootView = inflater.inflate(R.layout.peoplefragment_layout, container, false);
            return rootView;
        }

    }
}
