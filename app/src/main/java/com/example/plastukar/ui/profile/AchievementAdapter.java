package com.example.plastukar.ui.profile;

import android.view.LayoutInflater;
import android.view.ViewGroup;
import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;
import com.bumptech.glide.Glide;
import com.example.plastukar.data.local.entity.Achievement;
import com.example.plastukar.databinding.ItemAchievementBinding;
import java.util.List;

public class AchievementAdapter extends RecyclerView.Adapter<AchievementAdapter.AchievementViewHolder> {
    private List<Achievement> achievements;

    public AchievementAdapter(List<Achievement> achievements) {
        this.achievements = achievements;
    }

    @NonNull
    @Override
    public AchievementViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        ItemAchievementBinding binding = ItemAchievementBinding.inflate(
            LayoutInflater.from(parent.getContext()), parent, false);
        return new AchievementViewHolder(binding);
    }

    @Override
    public void onBindViewHolder(@NonNull AchievementViewHolder holder, int position) {
        Achievement achievement = achievements.get(position);
        holder.bind(achievement);
    }

    @Override
    public int getItemCount() {
        return achievements.size();
    }

    public void updateAchievements(List<Achievement> newAchievements) {
        this.achievements = newAchievements;
        notifyDataSetChanged();
    }

    static class AchievementViewHolder extends RecyclerView.ViewHolder {
        private final ItemAchievementBinding binding;

        AchievementViewHolder(ItemAchievementBinding binding) {
            super(binding.getRoot());
            this.binding = binding;
        }

        void bind(Achievement achievement) {
            binding.achievementTitle.setText(achievement.getTitle());
            binding.achievementDescription.setText(achievement.getDescription());
            binding.pointsReward.setText("+" + achievement.getPointsReward() + " pts");

            if (achievement.isUnlocked()) {
                binding.achievementProgress.setVisibility(ViewGroup.GONE);
                binding.achievementProgressText.setVisibility(ViewGroup.GONE);
                binding.unlockedIcon.setVisibility(ViewGroup.VISIBLE);
            } else {
                binding.achievementProgress.setVisibility(ViewGroup.VISIBLE);
                binding.achievementProgressText.setVisibility(ViewGroup.VISIBLE);
                binding.unlockedIcon.setVisibility(ViewGroup.GONE);
                binding.achievementProgress.setMax(achievement.getTargetProgress());
                binding.achievementProgress.setProgress(achievement.getProgress());
                binding.achievementProgressText.setText(
                    achievement.getProgress() + "/" + achievement.getTargetProgress()
                );
            }

            Glide.with(binding.getRoot())
                .load(achievement.getIconUrl())
                .circleCrop()
                .into(binding.achievementIcon);
        }
    }
}