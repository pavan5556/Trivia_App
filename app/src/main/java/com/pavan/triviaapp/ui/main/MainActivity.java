package com.pavan.triviaapp.ui.main;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentPagerAdapter;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;

import android.os.Bundle;

import com.pavan.triviaapp.R;

public class MainActivity extends AppCompatActivity {

    private int currentPosition = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        //Extended ViewPager to override touchevents.
        final QuizViewPager viewPager = findViewById(R.id.viewpager);
        MainViewModel viewModel = new ViewModelProvider(this).get(MainViewModel.class);

        PagerAdapter adapter = new PagerAdapter(getSupportFragmentManager(), FragmentPagerAdapter.BEHAVIOR_RESUME_ONLY_CURRENT_FRAGMENT);
        viewPager.setAdapter(adapter);

        //OnClick next button increase the current position of ViewPager.
        viewModel.getposition().observe(this, new Observer<Boolean>() {
            @Override
            public void onChanged(Boolean aBoolean) {
                currentPosition = viewPager.getCurrentItem() + 1;
                viewPager.setCurrentItem(currentPosition);
            }
        });

        //Setting title of Appbar with respect to Fragment shown.
        viewModel.getTitle().observe(this, new Observer<String>() {
            @Override
            public void onChanged(String title) {
                getSupportActionBar().setTitle(title);
            }
        });

    }
}