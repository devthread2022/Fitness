package com.devthread.fitness;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;

import android.annotation.SuppressLint;
import android.os.AsyncTask;
import android.os.Bundle;
import android.view.View;

import com.devthread.fitness.UI.Browse;
import com.devthread.fitness.UI.Dashboard;
import com.devthread.fitness.UI.Journal;
import com.devthread.fitness.UI.Profile;
import com.devthread.fitness.databinding.ActivityHomeBinding;

public class Home extends AppCompatActivity {
    final FragmentManager fm = getSupportFragmentManager();
    private ActivityHomeBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityHomeBinding.inflate(getLayoutInflater());
        View view = binding.getRoot();
        setContentView(view);
        Fragment fragment = new Dashboard();
        loadFragment(fragment);
        binding.home.setOnClickListener(view1 -> {
            Fragment fragment1 = new Dashboard();
            loadFragment(fragment1);
        });
        binding.journal.setOnClickListener(view1 -> {
            Fragment fragment1 = new Journal();
            loadFragment(fragment1);
        });
        binding.browse.setOnClickListener(view1 -> {
            Fragment fragment1 = new Browse();
            loadFragment(fragment1);
        });
        binding.profile.setOnClickListener(view1 -> {
            Fragment fragment1 = new Profile();
            loadFragment(fragment1);
        });
    }
    @SuppressLint("StaticFieldLeak")
    private void loadFragment(final Fragment featureFragment) {
        new AsyncTask<Void, Void, Void>() {
            @Override
            protected Void doInBackground(Void... params) {
                if (featureFragment!=null)
                {
                    fm.beginTransaction().replace(R.id.homeContainer, featureFragment, "featureFragment").addToBackStack("featureFragment").commit();
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