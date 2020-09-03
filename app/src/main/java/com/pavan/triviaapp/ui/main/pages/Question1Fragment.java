package com.pavan.triviaapp.ui.main.pages;

import android.content.Context;
import android.content.SharedPreferences;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProvider;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.LinearLayout;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;

import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.pavan.triviaapp.R;
import com.pavan.triviaapp.ui.main.MainViewModel;

import java.util.ArrayList;
import java.util.List;


public class Question1Fragment extends Fragment {


    private MainViewModel viewModel;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_question1, container, false);
    }

    private String answer = "Sachin Tendulkar";

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        final RadioGroup radioGroup = view.findViewById(R.id.radiogroup);
        FloatingActionButton nextfab = view.findViewById(R.id.next_fab_question1);
        viewModel = new ViewModelProvider(requireActivity()).get(MainViewModel.class);

        radioGroup.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup radioGroup, int i) {
                switch (i) {
                    case R.id.radioButton:
                        answer = "Sachin Tendulkar";
                        break;
                    case R.id.radioButton2:
                        answer = "Virat Kolli";
                        break;
                    case R.id.radioButton3:
                        answer = "Adam Gilchirst";
                        break;
                    case R.id.radioButton4:
                        answer = "Jacques Kallis";
                        break;
                }
            }
        });

        final SharedPreferences preferences = requireActivity().getSharedPreferences("trivia", Context.MODE_PRIVATE);

        //Saving the selection in SharedPreferences
        nextfab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                preferences.edit().putString("answer1", answer).apply();
                viewModel.nextClicked(true);
            }
        });
    }

    @Override
    public void onResume() {
        super.onResume();
        viewModel.setTitle("Question 1");
    }
}