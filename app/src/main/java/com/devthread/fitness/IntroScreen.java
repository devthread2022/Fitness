package com.devthread.fitness;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;

import android.annotation.SuppressLint;
import android.os.AsyncTask;
import android.os.Bundle;

import com.devthread.fitness.UI.About;

public class IntroScreen extends AppCompatActivity {
    final FragmentManager fm = getSupportFragmentManager();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_intro_screen);
        Fragment fragment = new About();
        loadFragment(fragment);
    }
    @SuppressLint("StaticFieldLeak")
    private void loadFragment(final Fragment featureFragment) {
        new AsyncTask<Void, Void, Void>() {
            @Override
            protected Void doInBackground(Void... params) {
                if (featureFragment!=null)
                {
                    fm.beginTransaction().replace(R.id.introContainer, featureFragment, "featureFragment").addToBackStack("featureFragment").commit();
                }
                return null;
            }

            @Override
            protected void onPostExecute(Void aVoid) {
                super.onPostExecute(aVoid);
            }
        }.execute();

    }
}