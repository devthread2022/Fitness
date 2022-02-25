package com.devthread.fitness.UI;

import android.app.Dialog;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;

import com.devthread.fitness.R;
import com.devthread.fitness.databinding.FragmentSettingsBinding;

public class Settings extends Fragment {
    private FragmentSettingsBinding binding;
    Dialog height,weight,distance,energy;
    LinearLayout heightCancel,weightCancel,distanceCancel,energyCancel;
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        binding = FragmentSettingsBinding.inflate(inflater,container,false);
        View view = binding.getRoot();
        height = new Dialog(getContext());
        height.setContentView(R.layout.height_layout);
        height.getWindow().setLayout(ViewGroup.LayoutParams.MATCH_PARENT,ViewGroup.LayoutParams.WRAP_CONTENT);
        height.getWindow().setBackgroundDrawable(new ColorDrawable(Color.TRANSPARENT));
        height.getWindow().getAttributes().windowAnimations = R.style.confirmDialog;
        height.getWindow().setGravity(Gravity.CENTER);
        heightCancel = height.findViewById(R.id.dismiss);
        weight = new Dialog(getContext());
        weight.setContentView(R.layout.weight_layout);
        weight.getWindow().setLayout(ViewGroup.LayoutParams.MATCH_PARENT,ViewGroup.LayoutParams.WRAP_CONTENT);
        weight.getWindow().setBackgroundDrawable(new ColorDrawable(Color.TRANSPARENT));
        weight.getWindow().getAttributes().windowAnimations = R.style.confirmDialog;
        weight.getWindow().setGravity(Gravity.CENTER);
        weightCancel = weight.findViewById(R.id.dismiss);
        binding.height.setOnClickListener(view1 -> {
            height.show();
        });
        heightCancel.setOnClickListener(view1 -> {
            height.dismiss();
        });
        binding.weight.setOnClickListener(view1 -> {
            weight.show();
        });
        weightCancel.setOnClickListener(view1 -> {
            weight.dismiss();
        });
        distance = new Dialog(getContext());
        distance.setContentView(R.layout.distance_layout);
        distance.getWindow().setLayout(ViewGroup.LayoutParams.MATCH_PARENT,ViewGroup.LayoutParams.WRAP_CONTENT);
        distance.getWindow().setBackgroundDrawable(new ColorDrawable(Color.TRANSPARENT));
        distance.getWindow().getAttributes().windowAnimations = R.style.confirmDialog;
        distance.getWindow().setGravity(Gravity.CENTER);
        distanceCancel = distance.findViewById(R.id.dismiss);
        binding.distance.setOnClickListener(view1 -> {
            distance.show();
        });
        distanceCancel.setOnClickListener(view1 -> {
            distance.dismiss();
        });
        energy = new Dialog(getContext());
        energy.setContentView(R.layout.energy_layout);
        energy.getWindow().setLayout(ViewGroup.LayoutParams.MATCH_PARENT,ViewGroup.LayoutParams.WRAP_CONTENT);
        energy.getWindow().setBackgroundDrawable(new ColorDrawable(Color.TRANSPARENT));
        energy.getWindow().getAttributes().windowAnimations = R.style.confirmDialog;
        energy.getWindow().setGravity(Gravity.CENTER);
        energyCancel = energy.findViewById(R.id.dismiss);
        binding.energy.setOnClickListener(view1 -> {
            energy.show();
        });
        energyCancel.setOnClickListener(view1 -> {
            energy.dismiss();
        });
        return view;
    }
}