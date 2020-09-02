package com.pavan.triviaapp.ui.history;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.pavan.triviaapp.R;
import com.pavan.triviaapp.source.model.Summary;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

public class HistoryAdapter extends RecyclerView.Adapter<HistoryAdapter.ViewHolder> {

    private List<Summary> summaries;
    private Context context;

    public HistoryAdapter(Context context) {
        this.context = context;
        summaries = new ArrayList<>();
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.viewholder_history, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {

        Summary summary = summaries.get(position);
        holder.gameno.setText("Game " + (position + 1)+" : ");
        SimpleDateFormat sdf = new SimpleDateFormat("dd MMMM hh:mm a");
        Calendar calendar = Calendar.getInstance();
        calendar.setTimeInMillis(summary.getTimestamp());
        holder.gametime.setText(sdf.format(calendar.getTime()));
        holder.name.setText(summary.getName());
        holder.answer1.setText(summary.getAnswer1());
        holder.answer2.setText(summary.getAnswer2());
    }

    @Override
    public int getItemCount() {
        return summaries.size();
    }

    public void update(List<Summary> summaryList) {
        summaries.clear();
        summaries.addAll(summaryList);
        notifyDataSetChanged();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {

        private TextView gameno, gametime, name, answer1, answer2;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            gameno = itemView.findViewById(R.id.gameno_viewholder);
            gametime = itemView.findViewById(R.id.gametime_vh);
            name = itemView.findViewById(R.id.name_vh);
            answer1 = itemView.findViewById(R.id.answer1_vh);
            answer2 = itemView.findViewById(R.id.answer2_vh);
        }
    }
}
