package com.pavan.triviaapp.ui.main;

import android.content.Context;
import android.content.SharedPreferences;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.pavan.triviaapp.R;
import com.pavan.triviaapp.source.model.Summary;

import java.util.Calendar;


public class SummaryFragment extends Fragment {


    private String name;
    private String ans1;
    private String ans2;

    public SummaryFragment() {
        // Required empty public constructor
    }

    public static SummaryFragment newInstance() {
        return new SummaryFragment();

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_summary, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        final TextView answer1 = view.findViewById(R.id.answer1_summary);
        final TextView answer2 = view.findViewById(R.id.answer2_summary);
        final TextView nametv = view.findViewById(R.id.name_tv_summary);
        Button finishbtn = view.findViewById(R.id.finish_button);
        final MainViewModel viewModel = new ViewModelProvider(requireActivity()).get(MainViewModel.class);

        SharedPreferences preferences = requireContext().getSharedPreferences("trivia", Context.MODE_PRIVATE);
        viewModel.getName(preferences).observe(requireActivity(), new Observer<String>() {
            @Override
            public void onChanged(String s) {
                name = s;
                nametv.setText("Hello " + name);
            }
        });

        viewModel.getAnswer1(preferences).observe(requireActivity(), new Observer<String>() {
            @Override
            public void onChanged(String s) {
                ans1 = s;
                answer1.setText(ans1);
            }
        });

        viewModel.getAnswer2(preferences).observe(requireActivity(), new Observer<String>() {
            @Override
            public void onChanged(String s) {
                ans2 = s;
                answer2.setText(ans2);
            }
        });

        finishbtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Summary summary = new Summary();
                summary.setName(name);
                summary.setAnswer1(ans1);
                summary.setAnswer2(ans2);
                Calendar calendar = Calendar.getInstance();
                summary.setTimestamp(calendar.getTimeInMillis());
                viewModel.saveMatch(summary,requireActivity());

                requireActivity().finish();

            }
        });
    }
}