package com.pavan.triviaapp.ui.history;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.view.MenuItem;
import android.widget.Toast;

import com.pavan.triviaapp.R;
import com.pavan.triviaapp.source.model.Summary;

import java.util.List;

public class HistoryActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_history);

        RecyclerView recyclerView = findViewById(R.id.history_rv);
        LinearLayoutManager layoutManager = new LinearLayoutManager(this, RecyclerView.VERTICAL, false);
        recyclerView.setLayoutManager(layoutManager);
        final HistoryAdapter adapter = new HistoryAdapter(this);
        recyclerView.setAdapter(adapter);

        getSupportActionBar().setTitle("History");
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        HistoryViewModel viewModel = new ViewModelProvider(this).get(HistoryViewModel.class);

        //Getting SummaryLivedata from Database and updating Recyclerview Adapter.
        viewModel.getAllSummary(this).observe(this, new Observer<List<Summary>>() {
            @Override
            public void onChanged(List<Summary> summaries) {
                if (summaries != null)
                    adapter.update(summaries);
            }
        });
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        if (item.getItemId() == android.R.id.home)
            onBackPressed();
        return super.onOptionsItemSelected(item);
    }
}