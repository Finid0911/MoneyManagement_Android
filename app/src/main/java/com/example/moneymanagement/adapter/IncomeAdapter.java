package com.example.moneymanagement.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.moneymanagement.R;
import com.example.moneymanagement.databinding.IncomeItemBinding;
import com.example.moneymanagement.model.Account;
import com.example.moneymanagement.model.Income;
import com.example.moneymanagement.ui.accounts.AccountAdapter;

import java.util.List;

public class IncomeAdapter extends RecyclerView.Adapter<IncomeAdapter.IncomeViewHolder>{

    private Context context;
    private List<Income> incomeList;
    private AccountAdapter.Dialog dialog;

    public interface Dialog{
        void onClick(int pos);
    }

    public IncomeAdapter(Context context, List<Income> incomeList) {
        this.context = context;
        this.incomeList = incomeList;
    }

    @NonNull
    @Override
    public IncomeViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        IncomeItemBinding viewBinding = IncomeItemBinding.inflate(LayoutInflater.from(parent.getContext()), parent, false);
        return new IncomeViewHolder(viewBinding);
    }

    @Override
    public void onBindViewHolder(@NonNull IncomeViewHolder holder, int position) {
        holder.binding.txtAccount.setText(incomeList.get(position).getAccount());
        holder.binding.txtCategory.setText(incomeList.get(position).getCategory());
        holder.binding.txtMoney.setText(incomeList.get(position).getMoney());
        holder.binding.txtAccount.setText(incomeList.get(position).getAccount());
        holder.binding.txtDate.setText(incomeList.get(position).getDate());
        holder.binding.imgIncome.setImageResource(Integer.parseInt(incomeList.get(position).getImgId()));
    }

    @Override
    public int getItemCount() {
        return incomeList.size();
    }

    public class IncomeViewHolder extends RecyclerView.ViewHolder{
        private IncomeItemBinding binding;

        public IncomeViewHolder(@NonNull IncomeItemBinding binding) {
            super(binding.getRoot());
            this.binding = binding;

        }
    }
}
