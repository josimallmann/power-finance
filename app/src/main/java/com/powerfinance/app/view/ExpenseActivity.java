package com.powerfinance.app.view;

import android.os.Bundle;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.powerfinance.app.R;
import com.powerfinance.app.model.Expense;

import java.util.ArrayList;
import java.util.List;

public class ExpenseActivity extends AppCompatActivity {

    private List<Expense> expenseList;
    private ExpenseAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_expense);

        expenseList = new ArrayList<>();
        // Exemplo: adicionando dados
        expenseList.add(new Expense("Aluguel", 1200.00, "2025-07-22"));
        expenseList.add(new Expense("Internet", 150.00, "2025-07-22"));
        expenseList.add(new Expense("Supermercado", 350.50, "2025-07-22"));

        RecyclerView recyclerView = findViewById(R.id.rvExpenses);

        recyclerView.setLayoutManager(new LinearLayoutManager(this));

        adapter = new ExpenseAdapter(expenseList, new ExpenseAdapter.OnExpenseClickListener() {
            @Override
            public void onExpenseClick(int position) {
                Expense exp = expenseList.get(position);
                Toast.makeText(ExpenseActivity.this, "Selecionado: " + exp.getDescription(), Toast.LENGTH_SHORT).show();
            }
        });

        recyclerView.setAdapter(adapter);
    }
}
