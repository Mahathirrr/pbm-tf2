package com.example.plastukar.ui.rewards;

import android.view.LayoutInflater;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.example.plastukar.data.local.entity.Reward;
import com.example.plastukar.databinding.ItemRewardBinding;

import java.util.List;

public class RewardsAdapter extends RecyclerView.Adapter<RewardsAdapter.RewardViewHolder> {
    private List<Reward> rewards;

    public RewardsAdapter(List<Reward> rewards) {
        this.rewards = rewards;
    }

    @NonNull
    @Override
    public RewardViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        ItemRewardBinding binding = ItemRewardBinding.inflate(
            LayoutInflater.from(parent.getContext()), parent, false);
        return new RewardViewHolder(binding);
    }

    @Override
    public void onBindViewHolder(@NonNull RewardViewHolder holder, int position) {
        Reward reward = rewards.get(position);
        holder.bind(reward);
    }

    @Override
    public int getItemCount() {
        return rewards.size();
    }

    public void updateRewards(List<Reward> newRewards) {
        this.rewards = newRewards;
        notifyDataSetChanged();
    }

    static class RewardViewHolder extends RecyclerView.ViewHolder {
        private final ItemRewardBinding binding;

        RewardViewHolder(ItemRewardBinding binding) {
            super(binding.getRoot());
            this.binding = binding;
        }

        void bind(Reward reward) {
            binding.rewardTitle.setText(reward.getTitle());
            binding.rewardDescription.setText(reward.getDescription());
            binding.pointsCost.setText(reward.getPointsCost() + " pts");
            binding.merchantName.setText(reward.getMerchantName());
            binding.validUntil.setText("Valid until: " + reward.getValidUntil());

            Glide.with(binding.getRoot())
                .load(reward.getImageUrl())
                .centerCrop()
                .into(binding.rewardImage);

            binding.getRoot().setOnClickListener(v -> {
                // TODO: Implement reward details/redemption
            });
        }
    }
}