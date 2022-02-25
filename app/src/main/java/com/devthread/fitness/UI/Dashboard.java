package com.devthread.fitness.UI;

import android.app.Dialog;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import android.os.Handler;
import android.os.Looper;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;

import com.devthread.fitness.R;
import com.devthread.fitness.databinding.FragmentDashboardBinding;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class Dashboard extends Fragment {
    private FragmentDashboardBinding binding;
    ExecutorService executorService = Executors.newSingleThreadExecutor();
    Handler handler = new Handler(Looper.getMainLooper());
    public static Fragment activeFragment;
    Dialog information;
    LinearLayout dismiss;
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        binding = FragmentDashboardBinding.inflate(inflater,container,false);
        View view = binding.getRoot();
        information = new Dialog(getContext());
        information.setContentView(R.layout.info_layout);
        information.getWindow().setLayout(ViewGroup.LayoutParams.MATCH_PARENT,ViewGroup.LayoutParams.WRAP_CONTENT);
        information.getWindow().setBackgroundDrawable(new ColorDrawable(Color.TRANSPARENT));
        information.getWindow().getAttributes().windowAnimations = R.style.confirmDialog;
        information.getWindow().setGravity(Gravity.CENTER);
        dismiss = information.findViewById(R.id.dismiss);
        binding.info.setOnClickListener(view1 -> {
            information.show();
        });
        dismiss.setOnClickListener(view1 -> {
            information.dismiss();
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