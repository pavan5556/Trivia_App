package com.pavan.triviaapp.ui.main;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentPagerAdapter;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;

import android.os.Bundle;

import com.pavan.triviaapp.R;
import com.pavan.triviaapp.source.model.Question;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    private int currentPosition = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        final QuizViewPager viewPager = findViewById(R.id.viewpager);
        MainViewModel viewModel = new ViewModelProvider(this).get(MainViewModel.class);

        PagerAdapter adapter = new PagerAdapter(getSupportFragmentManager(), FragmentPagerAdapter.BEHAVIOR_RESUME_ONLY_CURRENT_FRAGMENT);
        viewPager.setAdapter(adapter);

        viewModel.getposition().observe(this, new Observer<Boolean>() {
            @Override
            public void onChanged(Boolean aBoolean) {
                currentPosition = viewPager.getCurrentItem() + 1;
                viewPager.setCurrentItem(currentPosition);
            }
        });

//        nextCardview.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View view) {
//                if (currentPosition < questions.size()) {
//                    currentPosition = viewPager.getCurrentItem() + 1;
//                    viewPager.setCurrentItem(currentPosition);
//                }
//                if (currentPosition == questions.size()) {
//                    nextCardview.setVisibility(View.INVISIBLE);
//                }
//            }
//        });

    }
}