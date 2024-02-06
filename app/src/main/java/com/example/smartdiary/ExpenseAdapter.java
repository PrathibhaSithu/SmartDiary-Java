package com.example.smartdiary;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.TextureView;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;
import java.util.List;

public class ExpenseAdapter extends RecyclerView.Adapter<ExpenseAdapter.MyViewHolder>{

    private Context context;
    private OnItemClick onItemClick;
    private List<ExpenseModel> expenseModelList;

    public ExpenseAdapter(Context context, OnItemClick onItemClick) {
        this.context = context;
        expenseModelList = new ArrayList<>();
        this.onItemClick=onItemClick;
    }
    public void add(ExpenseModel expenseModel){
        expenseModelList.add(expenseModel);
        notifyDataSetChanged();
    }
    public void clear(){
        expenseModelList.clear();
        notifyDataSetChanged();
    }

    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.expense_row, parent, false);
        return new MyViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder holder, int position) {
        ExpenseModel expenseModel = expenseModelList.get(position);
        holder.noteR.setText(expenseModel.getNote());
        holder.catR.setText(expenseModel.getCategory());
        holder.amountR.setText(String.valueOf(expenseModel.getAmount()));

        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                onItemClick.onClick(expenseModel);
            }
        });
    }

    @Override
    public int getItemCount() {
        return expenseModelList.size();
    }

    public class MyViewHolder extends RecyclerView.ViewHolder {

        private TextView noteR, catR, amountR, dateR;

        public MyViewHolder(@NonNull View itemView) {
            super(itemView);
            noteR = itemView.findViewById(R.id.noteR);
            catR = itemView.findViewById(R.id.catR);
            amountR = itemView.findViewById(R.id.amountR);
            dateR = itemView.findViewById(R.id.dateR);
        }
}

}
