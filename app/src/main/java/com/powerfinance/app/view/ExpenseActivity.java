package com.powerfinance.app.view;

import android.os.Bundle;
import android.widget.TextView;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.recyclerview.widget.RecyclerView;

import com.google.android.material.button.MaterialButton;
import com.powerfinance.app.R;

public class ExpenseActivity extends AppCompatActivity {

    private Toolbar toolbar;
    private RecyclerView rvExpenses;
    private TextView tvTotalPagar, tvPago;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_expense);

        // Referência aos componentes da UI
        toolbar = findViewById(R.id.toolbarExpense);
        setSupportActionBar(toolbar);

        rvExpenses = findViewById(R.id.rvExpenses);
        tvTotalPagar = findViewById(R.id.tvTotalPagar);
        tvPago = findViewById(R.id.tvPago);


     
    }
}
