package com.example.moneymanagement.viewModel;

import android.content.Context;

import androidx.databinding.BaseObservable;
import androidx.databinding.ObservableField;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.moneymanagement.Model.Account;
import com.example.moneymanagement.adapter.AccountAdapter;

import java.util.List;

public class AccountViewModel extends BaseObservable{
    public static Context mcontext;
    private AccountAdapter accountAdapter;
    public static double total = 0;
    public ObservableField<String> printTotal = new ObservableField<>();

    // Firebase adapter <- Recycle_Account (setconfig())
    public void setConfig(RecyclerView recyclerView, Context context, List<Account> accounts, List<String> keys){
        mcontext = context;
        accountAdapter = new AccountAdapter(accounts, keys);
        recyclerView.setLayoutManager(new LinearLayoutManager(context));
        recyclerView.setAdapter(accountAdapter);
        accountAdapter.notifyDataSetChanged();
        for(Account account : accountAdapter.getAccList()){
            total+=Double.parseDouble(account.getMoney());
        }
        printTotal.set(String.valueOf(total));
        System.out.println(total);
        System.out.println(printTotal);
    }


}
