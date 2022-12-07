package com.va.vestibularioapp;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class CalendarAdapter extends RecyclerView.Adapter<CalendarViewHolder> {

    private final ArrayList<String> diasDoMes;
    private final OnItemListener onItemListener;

    public CalendarAdapter(ArrayList<String> diasDoMes, OnItemListener onItemListener) {
        this.diasDoMes = diasDoMes;
        this.onItemListener = onItemListener;
    }

    @NonNull
    @Override
    public CalendarViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(parent.getContext());
        View view = inflater.inflate(R.layout.calendar_cell, parent, false);
        ViewGroup.LayoutParams layoutParams = view.getLayoutParams();
        layoutParams.height = (int) (parent.getHeight() * 0.166666666);

        return new CalendarViewHolder(view, onItemListener);
    }

    @Override
    public void onBindViewHolder(@NonNull CalendarViewHolder holder, int position) {
        holder.diaDoMes.setText(diasDoMes.get(position));
    }

    @Override
    public int getItemCount() {
        return diasDoMes.size();
    }

    public interface OnItemListener {
        void onItemClick(int position, String txtDia);
    }
}
