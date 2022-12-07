package com.va.vestibularioapp;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import java.time.LocalDate;
import java.time.YearMonth;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;

public class CalendarActivity extends AppCompatActivity implements CalendarAdapter.OnItemListener{
    private TextView txtMesAno;
    private RecyclerView calendarioRecyclerView;
    private LocalDate dataSelecionada;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.calendar);

        inicializarWidgets();
        dataSelecionada = LocalDate.now();
        setMesView();
    }

    private void inicializarWidgets() {
        calendarioRecyclerView = findViewById(R.id.calendarioRecyclerView);
        txtMesAno = findViewById(R.id.txtMesAno);
    }

    private void setMesView() {
        txtMesAno.setText(mesAnoAtual(dataSelecionada));
        ArrayList<String> diasNoMes = diasNoMesArray(dataSelecionada);

        CalendarAdapter calendarAdapter = new CalendarAdapter(diasNoMes, this);
        RecyclerView.LayoutManager layoutManager = new GridLayoutManager(getApplicationContext(), 7);
        calendarioRecyclerView.setAdapter(calendarAdapter);
        calendarioRecyclerView.setLayoutManager(layoutManager);
    }

    private String mesAnoAtual(LocalDate data) {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("MMM yyy");

        return data.format(formatter);
    }

    private ArrayList<String> diasNoMesArray(LocalDate data) {
        ArrayList<String> diasNoMesArray = new ArrayList<>();
        YearMonth anoMes = YearMonth.from(data);

        int diasNoMes = anoMes.lengthOfMonth();

        LocalDate primeiroDoMes = dataSelecionada.withDayOfMonth(1);
        int diaDaSemana = primeiroDoMes.getDayOfWeek().getValue();

        int x = 0;
        for (int i = 1; i <= 42; i++) {
            if (i <= diaDaSemana || i > diasNoMes + diaDaSemana) {
                diasNoMesArray.add("");
                x++;
            } else {
                diasNoMesArray.add(String.valueOf(i - x));
            }
        }

        return diasNoMesArray;
    }

    public void mesAnteriorAction(View view) {
        dataSelecionada = dataSelecionada.minusMonths(1);
        setMesView();
    }

    public void proximoMesAction(View view) {
        dataSelecionada = dataSelecionada.plusMonths(1);
        setMesView();
    }

    @Override
    public void onItemClick(int position, String txtDia) {}

}
