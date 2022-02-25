package com.devthread.fitness.UI;

import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import android.os.Handler;
import android.os.Looper;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.devthread.fitness.R;
import com.devthread.fitness.databinding.FragmentProfileBinding;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class Profile extends Fragment {
    private FragmentProfileBinding binding;
    ExecutorService executorService = Executors.newSingleThreadExecutor();
    Handler handler = new Handler(Looper.getMainLooper());
    public static Fragment activeFragment;
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        binding = FragmentProfileBinding.inflate(inflater,container,false);
        View view = binding.getRoot();
        binding.settings.setOnClickListener(view1 -> {
            Fragment fragment = new Settings();
            loadFragment(fragment,"Settings");
        });
        return view;
    }
    private void loadFragment(Fragment fragment, String tag) {
        executorService.execute(() -> {
            if (fragment != null) {

                FragmentManager fragmentManager = getActivity().getSupportFragmentManager();
                FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
                fragmentTransaction.replace(R.id.homeContainer, fragment, tag).addToBackStack(tag).commit();

            }
            handler.post(() -> {
                activeFragment = getActivity().getSupportFragmentManager().findFragmentById(R.id.homeContainer);
            });
        });
    }
}