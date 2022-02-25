package com.devthread.fitness.UI;

import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.devthread.fitness.R;
import com.devthread.fitness.databinding.FragmentMeasurementBinding;

public class Measurement extends Fragment {
    private FragmentMeasurementBinding binding;
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        binding = FragmentMeasurementBinding.inflate(inflater,container,false);
        View view = binding.getRoot();
        return view;
    }
}