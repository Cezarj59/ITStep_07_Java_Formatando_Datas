package homework_07;

import java.text.DateFormat;
import java.util.Calendar;
import java.util.Locale;
import java.util.Scanner;

public class Homework_07 {

    static Scanner leia = new Scanner(System.in);

    public static void main(String[] args) {
        recebeValor();
    }

    private static void recebeValor() {
        System.out.print("Informe o valor do Boleto: ");
        double valorDoBoleto = leia.nextDouble();

        System.out.println("Informe a data de vencimento do Boleto.");
        System.out.print("Informe o dia: ");
        int diaDeVencimento = leia.nextInt();
        System.out.print("Informe o mês: ");
        int mesDeVencimento = leia.nextInt() - 1;
        int diasAtraso = diasDeAtraso(diaDeVencimento, mesDeVencimento);

        if (dataBoleto(diaDeVencimento, mesDeVencimento)) {
            System.out.println("Dias para o vencimento: " + diasAtraso);
            System.out.println("Valor a ser pago: " + valorDoBoleto);

        } else {

            double percentual = 2.0 / 100.0;
            double total = valorDoBoleto + (percentual * valorDoBoleto) * diasAtraso;

            System.out.println("Valor do Boleto: " + valorDoBoleto);

            System.out.println("Total de juros: " + (total - valorDoBoleto));
            System.out.println("Valor a ser pago: " + total);
        }

    }

    private static boolean dataBoleto(int diaDeVencimento, int mesDeVencimento) {
        Calendar hoje = Calendar.getInstance();
        Calendar data = Calendar.getInstance();

        Locale brasil = new Locale("pt", "br");
        DateFormat formatoBrasil = DateFormat.getDateInstance(DateFormat.FULL, brasil);

        data.set(data.get(Calendar.YEAR), mesDeVencimento, diaDeVencimento);

        System.out.println("Data de vencimento: " + formatoBrasil.format(data.getTime()));

        int diaAtual = hoje.get(Calendar.DAY_OF_MONTH);
        int mesAtual = hoje.get(Calendar.MONTH);

        if (diaAtual <= diaDeVencimento && mesAtual <= mesDeVencimento) {
            return true;
        } else {
            return false;
        }
    }

    private static int diasDeAtraso(int diaParam, int mesParam) {
        Calendar hoje = Calendar.getInstance();
        Calendar data = Calendar.getInstance();

        data.set(Calendar.DAY_OF_MONTH, diaParam);
        data.set(Calendar.MONTH, mesParam);

        int diaDoAno = data.get(Calendar.DAY_OF_YEAR);
        int diaDoAnoAtual = hoje.get(Calendar.DAY_OF_YEAR);

        if (diaDoAno < diaDoAnoAtual) {
            int aux = diaDoAnoAtual;
            diaDoAnoAtual = diaDoAno;
            diaDoAno = aux;
        }
        int resultado = diaDoAno - diaDoAnoAtual;

        return resultado;

    }
}
