package com.example.moneymanagement.ui.history;

import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.RecyclerView;

import android.text.Editable;
import android.text.TextWatcher;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.EditText;

import android.widget.Spinner;
import android.widget.TextView;

import com.example.moneymanagement.model.Expense;
import com.example.moneymanagement.R;
import java.util.ArrayList;

/**
 * A simple {@link Fragment} subclass.
 * Use the  factory method to
 * create an instance of this fragment.
 */
public class HistoryFragment extends Fragment {

    private TextView incometxt, outtxt;

    private EditText eSearch;
    private ArrayList<Expense> list;
    private RecyclerView recyclerView;
    public boolean checked = false;

    private Spinner spSapXep;
    private int lastSelected = -1;


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_history, container, false);
        recyclerView = view.findViewById(R.id.rvTransactionHistory);
        eSearch = view.findViewById(R.id.edtSearch);
        incometxt = view.findViewById(R.id.inTxt);
        outtxt = view.findViewById(R.id.exTxt);
        spSapXep = view.findViewById(R.id.spinner2);
        String[] options = {"Tăng dần", "Giảm dần"};
        ArrayAdapter<String> adapter = new ArrayAdapter<>(getActivity(), android.R.layout.simple_spinner_dropdown_item, options);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spSapXep.setAdapter(adapter);

        spSapXep.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                lastSelected = position;
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });

        eSearch.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                if(checked == false){
                    searchExpense(s.toString());
                }
                if(checked == true){
                    searchIncome(s.toString());
                }
            }

            @Override
            public void afterTextChanged(Editable s) {

            }
        });



        incometxt.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                checked = true;
            }
        });
        outtxt.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                checked = false;
            }
        });

        return view;
    }

    public void searchIncome(String text){
       /* ArrayList<Transaction> search = new ArrayList<>();
        ArrayList<String> searchKey = new ArrayList<>();
        for(String k : IncomeVIewModel.ks){
            searchKey.add(k);
        }
        for(Transaction ts : IncomeVIewModel.income){
            if(ts.getCategory().toLowerCase().contains(text.toLowerCase())){
                search.add(ts);
            }
            else if(ts.getMoney().contains(text.toString())){
                search.add(ts);
            }
            else if(ts.getAccount().toLowerCase().contains(text.toLowerCase())){
                search.add(ts);
            }
        }
        incomeAdapter.setDataList(search, searchKey);
        incomeAdapter.notifyDataSetChanged();
        recyclerView.setAdapter(incomeAdapter);*/
    }

    public void searchExpense(String text){
        /*ArrayList<Transaction> search = new ArrayList<>();
        ArrayList<String> searchKey = new ArrayList<>();
        for(String k : ExpendViewModel.ks){
            searchKey.add(k);
        }
        for(Transaction ts : ExpendViewModel.expense){
            if(ts.getCategory().toLowerCase().contains(text.toLowerCase())){
                search.add(ts);
            }
            else if(ts.getMoney().contains(text.toString())){
                search.add(ts);
            }
            else if(ts.getAccount().toLowerCase().contains(text.toLowerCase())){
                search.add(ts);
            }
        }
        transactionAdapter.setDataList(search, searchKey);
        transactionAdapter.notifyDataSetChanged();
        recyclerView.setAdapter(transactionAdapter);*/
    }

}

