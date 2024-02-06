package com.example.smartdiary;

import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import com.example.smartdiary.databinding.ActivityAddExpenseBinding;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.firestore.FirebaseFirestore;

import java.util.Calendar;
import java.util.UUID;

public class AddExpenseActivity extends AppCompatActivity {
    ActivityAddExpenseBinding binding;
    private String type;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityAddExpenseBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        type = getIntent().getStringExtra("type");
        if(type.equals("Income")){
            binding.incomeR.setChecked(true);
        }
        else {
            binding.expenseR.setChecked(true);
        }

        binding.incomeR.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                type = "Income";
            }
        });

        binding.expenseR.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                type = "Expense";
            }
        });
        binding.savebtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                createExpense();
            }
        });
    }

    private void createExpense() {
        String expenseId = UUID.randomUUID().toString();
        String amount = binding.amount.getText().toString();
        String note = binding.note.getText().toString();
        String category = binding.cat.getText().toString();
        String type;

        boolean incomeRChecked = binding.incomeR.isChecked();

        if(incomeRChecked){
            type = "Income";
        }
        else {
            type = "Expense";
        }

        if(amount.trim().length()==0){
            Toast.makeText(this, "Please enter amount", Toast.LENGTH_SHORT).show();
            return;
        }
        ExpenseModel expenseModel = new ExpenseModel(expenseId, note, category, type, Long.parseLong(amount), Calendar.getInstance().getTimeInMillis(),
                FirebaseAuth.getInstance().getUid());

        FirebaseFirestore
                .getInstance()
                .collection("expenses")
                .document(expenseId)
                .set(expenseModel);
        finish();
    }
}