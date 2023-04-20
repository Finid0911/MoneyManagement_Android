package com.example.moneymanagement.Views;

import android.content.res.Configuration;
import android.content.res.Resources;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;

import android.util.DisplayMetrics;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;

import com.example.moneymanagement.R;

import java.util.Locale;

public class SettingFragment extends Fragment {
    TextView tvSelect, tvOutput;
    RadioGroup rgLanguage;
    RadioButton rbEnglish, rbVn;
    private View rootView;

    /*private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    private String mParam1;
    private String mParam2;

    public SettingFragment() {
        // Required empty public constructor
    }

    public static SettingFragment newInstance(String param1, String param2) {
        SettingFragment fragment = new SettingFragment();
        Bundle args = new Bundle();
        args.putString(ARG_PARAM1, param1);
        args.putString(ARG_PARAM2, param2);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            mParam1 = getArguments().getString(ARG_PARAM1);
            mParam2 = getArguments().getString(ARG_PARAM2);
        }
    }*/

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        rootView = inflater.inflate(R.layout.fragment_setting, container, false);

        tvSelect = rootView.findViewById(R.id.textView6);
        rgLanguage = rootView.findViewById(R.id.rg_language);
        rbEnglish = rootView.findViewById(R.id.rb_english);
        rbVn = rootView.findViewById(R.id.rb_vn);
        tvOutput = rootView.findViewById(R.id.logoutBtn);

        rgLanguage.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup radioGroup, int i) {
                switch (i) {
                    case R.id.rb_english:
                        String language = "en";
                        setLocale(language);
                        break;
                    case R.id.rb_vn:
                        setLocale("vn");
                        break;
                }
            }
        });

        return rootView;
    }


    private void setLocale(String language) {

//Initialize resources
        Resources resources = getResources();
//Initialize metrics
        DisplayMetrics metrics = resources.getDisplayMetrics();
//Initialize configuration
        Configuration configuration = resources.getConfiguration();
//Initialize locale
        configuration.locale = new Locale(language);
//Update configuration
        resources.updateConfiguration(configuration, metrics);
//Notify configuration
        onConfigurationChanged(configuration);
    }

    @Override
    public void onConfigurationChanged(@NonNull Configuration newConfig) {
        super.onConfigurationChanged(newConfig);
//Set strings from resources
        tvSelect.setText(R.string.language_setting);
        rbEnglish.setText(R.string.en);
        rbVn.setText(R.string.vn);

        tvOutput.setText(R.string.en);
        tvOutput.setText(R.string.vn);
        tvOutput.setText(R.string.language_setting);
        tvOutput.setText(R.string.all_category);
        tvOutput.setText(R.string.about);
        tvOutput.setText(R.string.log_out);
        tvOutput.setText(R.string.setting);
    }

}



