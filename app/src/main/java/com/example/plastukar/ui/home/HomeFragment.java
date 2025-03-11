package com.example.plastukar.ui.home;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.fragment.app.Fragment;

import com.example.plastukar.databinding.FragmentHomeBinding;

public class HomeFragment extends Fragment {
    private FragmentHomeBinding binding;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        binding = FragmentHomeBinding.inflate(inflater, container, false);
        
        setupDashboard();
        setupChallenges();
        
        return binding.getRoot();
    }

    private void setupDashboard() {
        // TODO: Load user stats and achievements
    }

    private void setupChallenges() {
        // TODO: Load daily and weekly challenges
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        binding = null;
    }
}