package classroom_07;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.Locale;
import java.util.Scanner;

public class Classroom_07 {

    public static void main(String[] args) {
        Calendar data = Calendar.getInstance();

        data.set(1993, Calendar.FEBRUARY, 03);
        System.out.println("Data sem formato: " + data.getTime());

//        Formatando Datas
        DateFormat formatador = DateFormat.getDateInstance();
        System.out.println("Data Formatada: " + formatador.format(data.getTime()));

//        Formatando Hora
        DateFormat hora = DateFormat.getTimeInstance();
        System.out.println("Hora formatada: " + hora.format(data.getTime()));

        DateFormat dataHora = DateFormat.getDateTimeInstance();
        System.out.println("Data e Hora formatada: " + dataHora.format(data.getTime()));

        Date hoje = new Date();

        System.out.println("\nData de hoje Formatada: " + formatador.format(hoje));
        System.out.println("Hora de hoje formatada: " + hora.format(hoje));
        System.out.println("Data e Hora de hoje formatada: " + dataHora.format(hoje));

        formatador = DateFormat.getDateInstance(DateFormat.FULL);
        System.out.println("Data completa padrão SO: " + formatador.format(hoje));

        formatador = DateFormat.getDateInstance(DateFormat.MEDIUM);
        System.out.println("Data sem dia da semana padrão SO: " + formatador.format(hoje));

        formatador = DateFormat.getDateInstance(DateFormat.SHORT);
        System.out.println("Data curta padrão SO: " + formatador.format(hoje));

        System.out.println("Data Forçada BR: " + data.get(Calendar.DAY_OF_MONTH) + "/"
                + (data.get(Calendar.DAY_OF_MONTH) + 1) + "/" + data.get(Calendar.YEAR));

        SimpleDateFormat formatadorSimples = new SimpleDateFormat("'dia' dd/MM/yy', às' hh:mm'h'");//mm == minutos MM = mês
        System.out.println("Data com formato personalizado: " + formatadorSimples.format(hoje));

        Locale brasil = new Locale("pt", "br");
        Locale italia = Locale.ITALIAN;
        Locale usa = Locale.US;
        Locale japao = Locale.JAPANESE;
        Locale korea = Locale.KOREAN;
        Locale franca = Locale.FRENCH;

        DateFormat formatoBrasil = DateFormat.getDateInstance(DateFormat.FULL, brasil);
        DateFormat formatoItalia = DateFormat.getDateInstance(DateFormat.FULL, italia);
        DateFormat formatoUs = DateFormat.getDateInstance(DateFormat.FULL, usa);

        System.out.println("Data Brasil: " + formatoBrasil.format(hoje));
        System.out.println("Data Itália: " + formatoItalia.format(hoje));
        System.out.println("Data EUA: " + formatoUs.format(hoje));

//        Exercicio anivesario
        DateFormat formatoJapao = DateFormat.getDateInstance(DateFormat.FULL, japao);
        DateFormat formatoKorea = DateFormat.getDateInstance(DateFormat.FULL, korea);
        DateFormat formatoFranca = DateFormat.getDateInstance(DateFormat.FULL, franca);
        System.out.println("\n");
        System.out.println("Data aniversario formato Japão: " + formatoJapao.format(data.getTime()));
        System.out.println("Data aniversario formato Korea: " + formatoKorea.format(data.getTime()));
        System.out.println("Data aniversario formato França: " + formatoFranca.format(data.getTime()));
        System.out.println("\n");

//        exercicio 2
        Scanner leia = new Scanner(System.in);
        System.out.print("Digite um dia: ");
        int dia = leia.nextInt();
        System.out.print("Digite o mes: ");
        int mes = leia.nextInt() - 1;

        System.out.print("Digite o horario: ");
        int hora1 = leia.nextInt();
        System.out.print("Digite o minutos: ");
        int min = leia.nextInt();

        SimpleDateFormat formatadorSimples2 = new SimpleDateFormat("'dia do Evento: 'EEEE dd/MM/yy', às' hh:mm'h'");//mm == minutos MM = mês EEEE dia da semana
        data.set(2022, mes, dia, hora1, min);
        System.out.println("Data Agendada: " + formatadorSimples2.format(data.getTime()));

    }

}
