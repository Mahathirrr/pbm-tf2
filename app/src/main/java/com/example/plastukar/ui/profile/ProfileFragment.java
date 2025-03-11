package com.example.plastukar.ui.profile;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;

import com.bumptech.glide.Glide;
import com.example.plastukar.data.local.entity.Achievement;
import com.example.plastukar.data.local.entity.Transaction;
import com.example.plastukar.databinding.FragmentProfileBinding;

import java.util.ArrayList;
import java.util.List;

public class ProfileFragment extends Fragment {
    private FragmentProfileBinding binding;
    private TransactionAdapter transactionAdapter;
    private AchievementAdapter achievementAdapter;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        binding = FragmentProfileBinding.inflate(inflater, container, false);
        
        setupProfile();
        setupRecyclerViews();
        loadDummyData();
        
        return binding.getRoot();
    }

    private void setupProfile() {
        // Load profile image
        Glide.with(this)
            .load("https://example.com/profile.jpg")
            .circleCrop()
            .into(binding.profileImage);

        // Set user info
        binding.userName.setText("John Doe");
        binding.userEmail.setText("john.doe@example.com");
        binding.totalPoints.setText("1,234 pts");
        binding.plasticCollected.setText("5.2 kg");
        binding.userLevel.setText("Level 5");

        // Setup progress to next level
        binding.levelProgress.setMax(100);
        binding.levelProgress.setProgress(60);
        binding.levelProgressText.setText("60/100 XP to Level 6");
    }

    private void setupRecyclerViews() {
        // Achievements
        achievementAdapter = new AchievementAdapter(new ArrayList<>());
        binding.achievementsRecyclerView.setLayoutManager(
            new LinearLayoutManager(getContext(), LinearLayoutManager.HORIZONTAL, false));
        binding.achievementsRecyclerView.setAdapter(achievementAdapter);

        // Transactions
        transactionAdapter = new TransactionAdapter(new ArrayList<>());
        binding.transactionsRecyclerView.setLayoutManager(new LinearLayoutManager(getContext()));
        binding.transactionsRecyclerView.setAdapter(transactionAdapter);
    }

    private void loadDummyData() {
        // Load achievements
        List<Achievement> achievements = new ArrayList<>();
        Achievement achievement1 = new Achievement("1", "First Drop", "Make your first plastic deposit", 100);
        achievement1.setIconUrl("https://example.com/achievement1.png");
        achievement1.setUnlocked(true);
        achievements.add(achievement1);

        Achievement achievement2 = new Achievement("2", "Eco Warrior", "Collect 10kg of plastic", 500);
        achievement2.setIconUrl("https://example.com/achievement2.png");
        achievement2.setProgress(52);
        achievement2.setTargetProgress(100);
        achievements.add(achievement2);

        achievementAdapter.updateAchievements(achievements);

        // Load transactions
        List<Transaction> transactions = new ArrayList<>();
        Transaction transaction1 = new Transaction("1", "user1", "DEPOSIT", 100);
        transaction1.setDescription("Plastic bottle deposit");
        transaction1.setPlasticWeight(0.5);
        transaction1.setPlasticType("PET");
        transactions.add(transaction1);

        Transaction transaction2 = new Transaction("2", "user1", "REDEEM", -50);
        transaction2.setDescription("Coffee voucher redemption");
        transactions.add(transaction2);

        transactionAdapter.updateTransactions(transactions);
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        binding = null;
    }
}