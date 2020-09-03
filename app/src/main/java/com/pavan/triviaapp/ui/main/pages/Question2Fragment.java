package com.pavan.triviaapp.ui.main.pages;

import android.content.Context;
import android.content.SharedPreferences;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProvider;

import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.Toast;

import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.pavan.triviaapp.R;
import com.pavan.triviaapp.ui.main.MainViewModel;

import java.util.ArrayList;
import java.util.List;


public class Question2Fragment extends Fragment {


    private MainViewModel viewModel;

    public Question2Fragment() {
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_question2, container, false);
    }

    private List<String> answers = new ArrayList<>();

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        final CheckBox whitecb = view.findViewById(R.id.checkbox);
        final CheckBox yellowcb = view.findViewById(R.id.checkbox2);
        final CheckBox orangecb = view.findViewById(R.id.checkbox3);
        final CheckBox greencb = view.findViewById(R.id.checkbox4);
        FloatingActionButton nextBtn = view.findViewById(R.id.next_fab_question2);
        viewModel = new ViewModelProvider(requireActivity()).get(MainViewModel.class);

        whitecb.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton compoundButton, boolean b) {
                if (whitecb.isChecked()) {
                    if (!answers.contains("White")) {
                        answers.add("White");
                    }
                } else {
                    answers.remove("White");
                }
            }
        });

        yellowcb.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton compoundButton, boolean b) {
                if (yellowcb.isChecked()) {
                    if (!answers.contains("Yellow")) {
                        answers.add("Yellow");
                    }
                } else {
                    answers.remove("Yellow");
                }
            }
        });

        orangecb.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton compoundButton, boolean b) {
                if (orangecb.isChecked()) {
                    if (!answers.contains("Orange")) {
                        answers.add("Orange");
                    }
                } else {
                    answers.remove("Orange");
                }
            }
        });

        greencb.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton compoundButton, boolean b) {
                if (greencb.isChecked()) {
                    if (!answers.contains("Green")) {
                        answers.add("Green");
                    }
                } else {
                    answers.remove("Green");
                }
            }
        });

        final SharedPreferences preferences = requireContext().getSharedPreferences("trivia", Context.MODE_PRIVATE);

        final MainViewModel viewModel = new ViewModelProvider(requireActivity()).get(MainViewModel.class);

        //Saving Selection in SharedPreferences.
        nextBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (answers.isEmpty()) {
                    Toast.makeText(requireContext(), "Select Answer", Toast.LENGTH_SHORT).show();
                } else {

                    String answer2 = TextUtils.join(", ", answers);
                    preferences.edit().putString("answer2", answer2).apply();
                    viewModel.nextClicked(true);
                }
            }
        });

    }

    @Override
    public void onResume() {
        super.onResume();
        viewModel.setTitle("Question 2");
    }
}