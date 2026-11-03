package Aplicacao;

import Entidades.Contrato;
import Entidades.Parcela;
import Services.ServicoContrato;
import Services.ServicoPaypal;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Date;
import java.util.Locale;
import java.util.Scanner;

public class Programa {

    public static void main(String[] args) {

        Locale.setDefault(Locale.US);
        Scanner sc = new Scanner(System.in);
        DateTimeFormatter fmt = DateTimeFormatter.ofPattern("dd/MM/yyyy");

        System.out.println("Entre com os dados do contrato:");
        System.out.print("Número: ");
        int numero = sc.nextInt();
        System.out.print("Data (dd/MM/yyyy): ");
        LocalDate data = LocalDate.parse(sc.next(), fmt);
        System.out.print("Valor do contrato: ");
        double valorTotal = sc.nextDouble();

        Contrato contrato = new Contrato(numero, data, valorTotal);

        System.out.print("Entre com o número de parcelas: ");
        int n = sc.nextInt();

        ServicoPaypal servicoPaypal = new ServicoPaypal();
        ServicoContrato servicoContrato = new ServicoContrato(servicoPaypal);
        servicoContrato.processarContrato(contrato, n);

        System.out.println("\nParcelas:");
        for (Parcela parcela : contrato.getParcelas()) {
            System.out.println(parcela);
        }


        System.out.println("\nCálculos (1% juro simples mensal + 2% taxa de pagamento):");
        double cotaBasica = valorTotal / n;

        for (int i = 1; i <= n; i++) {
            double juro = servicoPaypal.juros(cotaBasica, i);
            double comJuros = cotaBasica + juro;
            double valorFinal = comJuros + servicoPaypal.taxaPagamento(comJuros);

            System.out.println("Parcela #" + i + ":");
            System.out.printf(Locale.US, "%.0f + 1%% * %d = %.0f%n", cotaBasica, i, comJuros);
            System.out.printf(Locale.US, "%.0f + 2%% = %.2f%n%n", comJuros, valorFinal);
        }
    }
}