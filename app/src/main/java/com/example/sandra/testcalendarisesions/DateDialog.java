package com.example.sandra.testcalendarisesions;

import android.annotation.TargetApi;
import android.app.DatePickerDialog;
import android.app.Dialog;
import android.app.TimePickerDialog;
import android.os.Build;
import android.os.Bundle;
import android.support.v4.app.DialogFragment;
import android.text.format.DateFormat;
import android.widget.TimePicker;

import java.util.Calendar;

/**
 * Fragmento con un diálogo de elección de fechas
 */
@TargetApi(Build.VERSION_CODES.HONEYCOMB)
public class DateDialog extends DialogFragment {

    private DatePickerDialog.OnDateSetListener escuchador;
    public void setOnDateSetListener(DatePickerDialog.OnDateSetListener escuchador) {
        this.escuchador = escuchador;
    }
    @Override
    public Dialog onCreateDialog(Bundle savedInstanceState) {
        Calendar calendario = Calendar.getInstance();
        Bundle args = this.getArguments();
        if (args != null) {
            long fecha = args.getLong("fecha");
            calendario.setTimeInMillis(fecha);
        }
        int anyo = calendario.get(Calendar.YEAR);
        int mes = calendario.get(Calendar.MONTH);
        int dia = calendario.get(Calendar.DAY_OF_MONTH);
        return new DatePickerDialog(getActivity(), escuchador, anyo, mes, dia);
    }
}