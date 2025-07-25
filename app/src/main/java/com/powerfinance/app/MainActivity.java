package com.seu.pacote;

import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.Spinner;
import androidx.appcompat.app.AppCompatActivity;

import java.util.ArrayList;
import java.util.Calendar;

import java.util.List;
import com.powerfinance.app.R;


public class MainActivity extends AppCompatActivity {

    private Spinner spinnerMonth;
    private Spinner spinnerYear;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main); // Certifique-se que o XML está em res/layout/activity_main.xml

        spinnerMonth = findViewById(R.id.spinnerMonth);
        spinnerYear = findViewById(R.id.spinnerYear);

        setupMonthSpinner();
        setupYearSpinner();
    }

    private void setupMonthSpinner() {
        String[] months = new String[] {
                "Janeiro", "Fevereiro", "Março", "Abril",
                "Maio", "Junho", "Julho", "Agosto",
                "Setembro", "Outubro", "Novembro", "Dezembro"
        };

        ArrayAdapter<String> adapter = new ArrayAdapter<>(
                this, android.R.layout.simple_spinner_item, months);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinnerMonth.setAdapter(adapter);

        // Seleciona o mês atual
        int currentMonth = Calendar.getInstance().get(Calendar.MONTH);
        spinnerMonth.setSelection(currentMonth);
    }

    private void setupYearSpinner() {
        int currentYear = Calendar.getInstance().get(Calendar.YEAR);
        List<String> years = new ArrayList<>();
        for (int year = currentYear - 10; year <= currentYear + 10; year++) {
            years.add(String.valueOf(year));
        }

        ArrayAdapter<String> adapter = new ArrayAdapter<>(
                this, android.R.layout.simple_spinner_item, years);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinnerYear.setAdapter(adapter);

        // Seleciona o ano atual (posição 10 pois começa em currentYear - 10)
        spinnerYear.setSelection(10);
    }

    // Método para pegar o mês e ano selecionados
    public String getSelectedMonth() {
        return spinnerMonth.getSelectedItem().toString();
    }

    public String getSelectedYear() {
        return spinnerYear.getSelectedItem().toString();
    }
}
