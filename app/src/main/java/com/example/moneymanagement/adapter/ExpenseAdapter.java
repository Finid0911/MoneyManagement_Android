package com.example.moneymanagement.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.moneymanagement.databinding.ExpenseItemBinding;
import com.example.moneymanagement.databinding.IncomeItemBinding;
import com.example.moneymanagement.model.Expense;
import com.example.moneymanagement.model.Income;
import com.example.moneymanagement.ui.accounts.AccountAdapter;

import java.util.List;

public class ExpenseAdapter extends RecyclerView.Adapter<ExpenseAdapter.ExpenseViewHolder>{

    private Context context;
    private List<Expense> expenseList;
    private AccountAdapter.Dialog dialog;

    public interface Dialog{
        void onClick(int pos);
    }

    public ExpenseAdapter(Context context, List<Expense> expenseList) {
        this.context = context;
        this.expenseList = expenseList;
    }

    @NonNull
    @Override
    public ExpenseAdapter.ExpenseViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        ExpenseItemBinding viewBinding = ExpenseItemBinding.inflate(LayoutInflater.from(parent.getContext()), parent, false);
        return new ExpenseAdapter.ExpenseViewHolder(viewBinding);
    }

    @Override
    public void onBindViewHolder(@NonNull ExpenseAdapter.ExpenseViewHolder holder, int position) {
        holder.binding.txtAccount.setText(expenseList.get(position).getAccount());
        holder.binding.txtCategory.setText(expenseList.get(position).getCategory());
        holder.binding.txtMoney.setText(expenseList.get(position).getMoney());
        holder.binding.txtAccount.setText(expenseList.get(position).getAccount());
        holder.binding.txtDate.setText(expenseList.get(position).getDate());
        holder.binding.imgExpense.setImageResource(Integer.parseInt(expenseList.get(position).getImgId()));
        final Expense expense = expenseList.get(position);
        holder.binding.expenseLayout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String account = holder.binding.txtAccount.getText().toString();
                String category = holder.binding.txtCategory.getText().toString();
                Toast.makeText(context, account + " - " + category, Toast.LENGTH_SHORT).show();
            }
        });
    }

    @Override
    public int getItemCount() {
        return expenseList.size();
    }

    public class ExpenseViewHolder extends RecyclerView.ViewHolder {

        private ExpenseItemBinding binding;

        public ExpenseViewHolder(@NonNull ExpenseItemBinding binding) {
            super(binding.getRoot());
            this.binding = binding;
        }

    }
}
