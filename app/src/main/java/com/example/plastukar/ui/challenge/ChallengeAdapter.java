package com.example.plastukar.ui.challenge;

import android.view.LayoutInflater;
import android.view.ViewGroup;
import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;
import com.example.plastukar.data.local.entity.Challenge;
import com.example.plastukar.databinding.ItemChallengeBinding;
import java.util.List;

public class ChallengeAdapter extends RecyclerView.Adapter<ChallengeAdapter.ChallengeViewHolder> {
    private List<Challenge> challenges;

    public ChallengeAdapter(List<Challenge> challenges) {
        this.challenges = challenges;
    }

    @NonNull
    @Override
    public ChallengeViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        ItemChallengeBinding binding = ItemChallengeBinding.inflate(
            LayoutInflater.from(parent.getContext()), parent, false);
        return new ChallengeViewHolder(binding);
    }

    @Override
    public void onBindViewHolder(@NonNull ChallengeViewHolder holder, int position) {
        Challenge challenge = challenges.get(position);
        holder.bind(challenge);
    }

    @Override
    public int getItemCount() {
        return challenges.size();
    }

    public void updateChallenges(List<Challenge> newChallenges) {
        this.challenges = newChallenges;
        notifyDataSetChanged();
    }

    static class ChallengeViewHolder extends RecyclerView.ViewHolder {
        private final ItemChallengeBinding binding;

        ChallengeViewHolder(ItemChallengeBinding binding) {
            super(binding.getRoot());
            this.binding = binding;
        }

        void bind(Challenge challenge) {
            binding.challengeTitle.setText(challenge.getTitle());
            binding.challengeDescription.setText(challenge.getDescription());
            binding.pointsReward.setText(challenge.getPointsReward() + " pts");
            binding.progressBar.setMax(challenge.getTargetProgress());
            binding.progressBar.setProgress(challenge.getProgress());
            binding.progressText.setText(
                challenge.getProgress() + "/" + challenge.getTargetProgress()
            );
        }
    }
}