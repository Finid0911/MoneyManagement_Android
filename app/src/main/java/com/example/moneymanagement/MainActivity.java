package com.example.moneymanagement;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentStatePagerAdapter;
import androidx.viewpager.widget.ViewPager;

import android.os.Bundle;
import android.widget.Button;

import com.example.moneymanagement.Views.ViewPagerAdapter;
import com.google.android.material.bottomnavigation.BottomNavigationView;

public class MainActivity extends AppCompatActivity {
    //ok ko
    //ok chu
    //ok nha
    private BottomNavigationView bottomNavigationView;
    private ViewPager viewPager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);





        bottomNavigationView = findViewById(R.id.bottomNavigationView);
        viewPager = findViewById(R.id.view_pager);

        setViewPager();

        bottomNavigationView.setOnNavigationItemSelectedListener((item -> {
            switch (item.getItemId()){
                case R.id.homeMnu:
                    viewPager.setCurrentItem(0);
                    break;
                case R.id.accountsMnu:
                    viewPager.setCurrentItem(1);
                    break;
                case R.id.historyMnu:
                    viewPager.setCurrentItem(2);
                    break;
                case R.id.userMnu:
                    viewPager.setCurrentItem(3);
                    break;
                case R.id.settingMnu:
                    viewPager.setCurrentItem(4);
                    break;
            }
            return true;
        }));




    }

    private void setViewPager(){
        ViewPagerAdapter viewPagerAdapter = new ViewPagerAdapter(getSupportFragmentManager(), FragmentStatePagerAdapter.BEHAVIOR_RESUME_ONLY_CURRENT_FRAGMENT);
        viewPager.setAdapter(viewPagerAdapter);

        viewPager.addOnPageChangeListener(new ViewPager.OnPageChangeListener() {
            @Override
            public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {

            }

            @Override
            public void onPageSelected(int position) {
                switch (position){
                    case 0:
                        bottomNavigationView.getMenu().findItem(R.id.homeMnu).setChecked(true);
                        break;
                    case 1:
                        bottomNavigationView.getMenu().findItem(R.id.accountsMnu).setChecked(true);
                        break;
                    case 2:
                        bottomNavigationView.getMenu().findItem(R.id.historyMnu).setChecked(true);
                        break;
                    case 3:
                        bottomNavigationView.getMenu().findItem(R.id.userMnu).setChecked(true);
                        break;
                    case 4:
                        bottomNavigationView.getMenu().findItem(R.id.settingMnu).setChecked(true);
                        break;
                }
            }

            @Override
            public void onPageScrollStateChanged(int state) {

            }
        });
    }
}