package com.example.plastukar.ui.profile;

import android.view.LayoutInflater;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.plastukar.R;
import com.example.plastukar.data.local.entity.Transaction;
import com.example.plastukar.databinding.ItemTransactionBinding;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Locale;

public class TransactionAdapter extends RecyclerView.Adapter<TransactionAdapter.TransactionViewHolder> {
    private List<Transaction> transactions;
    private final SimpleDateFormat dateFormat = new SimpleDateFormat("dd MMM yyyy, HH:mm", Locale.getDefault());

    public TransactionAdapter(List<Transaction> transactions) {
        this.transactions = transactions;
    }

    @NonNull
    @Override
    public TransactionViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        ItemTransactionBinding binding = ItemTransactionBinding.inflate(
                LayoutInflater.from(parent.getContext()), parent, false);
        return new TransactionViewHolder(binding);
    }

    @Override
    public void onBindViewHolder(@NonNull TransactionViewHolder holder, int position) {
        Transaction transaction = transactions.get(position);
        holder.bind(transaction);
    }

    @Override
    public int getItemCount() {
        return transactions.size();
    }

    public void updateTransactions(List<Transaction> newTransactions) {
        this.transactions = newTransactions;
        notifyDataSetChanged();
    }

    static class TransactionViewHolder extends RecyclerView.ViewHolder {
        private final ItemTransactionBinding binding;
        private final SimpleDateFormat dateFormat = new SimpleDateFormat("dd MMM yyyy, HH:mm", Locale.getDefault());

        TransactionViewHolder(ItemTransactionBinding binding) {
            super(binding.getRoot());
            this.binding = binding;
        }

        void bind(Transaction transaction) {
            binding.transactionTitle.setText(transaction.getDescription());
            binding.transactionDate.setText(dateFormat.format(new Date(transaction.getTimestamp())));

            String pointsText = transaction.getType().equals("DEPOSIT")
                    ? "+" + transaction.getPoints() + " pts"
                    : "-" + transaction.getPoints() + " pts";

            binding.transactionPoints.setText(pointsText);
            binding.transactionPoints.setTextColor(
                    itemView.getContext().getColor(
                            transaction.getType().equals("DEPOSIT") ? R.color.success : R.color.error
                    )
            );

            if (transaction.getType().equals("DEPOSIT")) {
                binding.transactionDetails.setText(
                        String.format(
                                Locale.getDefault(),
                                "%.1f kg of %s at %s",
                                transaction.getPlasticWeight(),
                                transaction.getPlasticType(),
                                transaction.getLocation()
                        )
                );
                binding.transactionDetails.setVisibility(ViewGroup.VISIBLE);
            } else {
                binding.transactionDetails.setVisibility(ViewGroup.GONE);
            }

            binding.transactionStatus.setText(transaction.getStatus());
            binding.transactionStatus.setTextColor(
                    itemView.getContext().getColor(
                            transaction.getStatus().equals("COMPLETED") ? R.color.success : R.color.warning
                    )
            );
        }
    }
}
