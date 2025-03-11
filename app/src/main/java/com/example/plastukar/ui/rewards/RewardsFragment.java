package com.example.plastukar.ui.rewards;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.GridLayoutManager;
import com.example.plastukar.data.local.entity.Reward;
import com.example.plastukar.databinding.FragmentRewardsBinding;
import java.util.ArrayList;
import java.util.List;

public class RewardsFragment extends Fragment {
    private FragmentRewardsBinding binding;
    private RewardsAdapter adapter;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        binding = FragmentRewardsBinding.inflate(inflater, container, false);
        
        setupRecyclerView();
        loadDummyRewards(); // Replace with actual data loading
        
        return binding.getRoot();
    }

    private void setupRecyclerView() {
        adapter = new RewardsAdapter(new ArrayList<>());
        binding.rewardsRecyclerView.setLayoutManager(new GridLayoutManager(getContext(), 2));
        binding.rewardsRecyclerView.setAdapter(adapter);
    }

    private void loadDummyRewards() {
        List<Reward> rewards = new ArrayList<>();
        
        Reward reward1 = new Reward("1", "Coffee Voucher", "Free coffee at StarCups", 500);
        reward1.setMerchantName("StarCups");
        reward1.setValidUntil("2025-12-31");
        reward1.setImageUrl("https://example.com/coffee.jpg");
        rewards.add(reward1);

        Reward reward2 = new Reward("2", "Movie Ticket", "Free movie ticket at CineMax", 1000);
        reward2.setMerchantName("CineMax");
        reward2.setValidUntil("2025-12-31");
        reward2.setImageUrl("https://example.com/movie.jpg");
        rewards.add(reward2);

        adapter.updateRewards(rewards);
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        binding = null;
    }
}