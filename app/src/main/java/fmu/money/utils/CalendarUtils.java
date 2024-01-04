package fmu.money.utils;

import java.util.Calendar;

/** Contém funções estáticas para conversão de objetos <code>Calendar</code> em datas / horas de vários formatos */
public class CalendarUtils {
    /** Retorna uma string DD/MM/AAAA dado um Calendar contendo a data.
     */
    public static String getDataString(Calendar data){
        int dia = data.get(Calendar.DAY_OF_MONTH);
        int mes = data.get(Calendar.MONTH) + 1;
        int ano = data.get(Calendar.YEAR);

        String dataString = dia + "/" + mes + "/"+ ano;

        return dataString;
    }
}
