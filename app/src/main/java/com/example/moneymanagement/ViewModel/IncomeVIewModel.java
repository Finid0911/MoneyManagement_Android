package com.example.moneymanagement.ViewModel;

import android.content.Context;

import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.moneymanagement.Model.Transaction;
import com.example.moneymanagement.adapter.IncomeAdapter;

import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class IncomeVIewModel {
    public static Context mcontext;
    private IncomeAdapter incomeAdapter;
    public static List<Transaction> income;
    public static List<String> ks;

    public void setConfig(RecyclerView recyclerView, Context context, List<Transaction> transactions, List<String> keys, int position){
        mcontext = context;
        incomeAdapter = new IncomeAdapter(transactions, keys);
        recyclerView.setLayoutManager(new LinearLayoutManager(context));
        recyclerView.setAdapter(incomeAdapter);
        List<Transaction> datalist = incomeAdapter.getIncome();
        List<String> k = incomeAdapter.getKey();
        if (position==1){
            Collections.sort(datalist, new Comparator<Transaction>() {
                @Override
                public int compare(Transaction e1, Transaction e2) {
                    return Integer.compare(Integer.parseInt(e1.getMoney()),Integer.parseInt(e2.getMoney()));
                }
            });
        }
        if (position==2){
            Collections.sort(datalist, new Comparator<Transaction>() {
                @Override
                public int compare(Transaction e1, Transaction e2) {
                    return Integer.compare(Integer.parseInt(e2.getMoney()),Integer.parseInt(e1.getMoney()));
                }
            });
        }
        income = datalist;
        ks = k;
        incomeAdapter.notifyDataSetChanged();
    }

/*
    class TransactionItemView extends RecyclerView.ViewHolder{

        private String key;
        private TextView tCategory;
        private TextView tAccount;
        private TextView tMoney;
        private TextView tDate;
        private ImageView tImg;

        public TransactionItemView(ViewGroup parent) {
            super(LayoutInflater.from(mcontext).inflate(R.layout.income_item, parent, false));
            tCategory = (TextView) itemView.findViewById(R.id.txtCategory);
            tAccount = (TextView) itemView.findViewById(R.id.txtAccount);
            tMoney = (TextView) itemView.findViewById(R.id.txtMoney);
            tDate = (TextView) itemView.findViewById(R.id.txtDate);
            tImg = (ImageView) itemView.findViewById(R.id.imgIncome);

            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    Intent intent = new Intent(mcontext, IncomeDetail.class);
                    intent.putExtra("key", key);
                    //intent.putExtra("id", tId.getText().toString());
                    intent.putExtra("name", tAccount.getText().toString());
                    intent.putExtra("category", tCategory.getText().toString());
                    intent.putExtra("money", tMoney.getText().toString());
                    intent.putExtra("date", tDate.getText().toString());
                    intent.putExtra("imgId", tImg.getDrawable().toString());

                    mcontext.startActivity(intent);
                }
            });

        }
        public void bind(Transaction transaction, String key){
            this.key = key;
            tCategory.setText(transaction.getCategory());
            tAccount.setText(transaction.getAccount());
            tMoney.setText(transaction.getMoney() + " đ");
            tDate.setText(transaction.getDate());
            tImg.setImageResource(transaction.getImgId());
        }

    }
*/

/*
    public class TransactionAdapter extends RecyclerView.Adapter<Recycle_Income.TransactionItemView>{

        private List<Transaction> transactionList;
        private List<String> key;

        public TransactionAdapter(List<Transaction> transactionList, List<String> key) {
            this.transactionList = transactionList;
            this.key = key;
        }

        @NonNull
        @Override
        public Recycle_Income.TransactionItemView onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
            return new Recycle_Income.TransactionItemView(parent);
        }

        @Override
        public void onBindViewHolder(@NonNull Recycle_Income.TransactionItemView holder, int position) {
            holder.bind(transactionList.get(position), key.get(position));

        }

        @Override
        public int getItemCount() {
            return transactionList.size();
        }
    }
*/
}
