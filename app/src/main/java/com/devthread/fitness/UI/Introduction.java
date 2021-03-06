package com.devthread.fitness.UI;

import android.content.Intent;
import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import android.os.Handler;
import android.os.Looper;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.devthread.fitness.Home;
import com.devthread.fitness.R;
import com.devthread.fitness.databinding.FragmentIntroductionBinding;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class Introduction extends Fragment {
    private FragmentIntroductionBinding binding;
    ExecutorService executorService = Executors.newSingleThreadExecutor();
    Handler handler = new Handler(Looper.getMainLooper());
    public static Fragment activeFragment;
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        binding = FragmentIntroductionBinding.inflate(inflater,container,false);
        View view = binding.getRoot();
        binding.previous.setOnClickListener(view1 -> {
            Fragment fragment = new About();
            loadFragment(fragment,"About");
        });
        binding.next.setOnClickListener(view1 -> {
            startActivity(new Intent(getActivity(), Home.class));
        });
        return view;
    }
    private void loadFragment(Fragment fragment, String tag) {
        executorService.execute(() -> {
            if (fragment != null) {

                FragmentManager fragmentManager = getActivity().getSupportFragmentManager();
                FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
                fragmentTransaction.replace(R.id.introContainer, fragment, tag).addToBackStack(tag).commit();

            }
            handler.post(() -> {
                activeFragment = getActivity().getSupportFragmentManager().findFragmentById(R.id.introContainer);
            });
        });
    }
}