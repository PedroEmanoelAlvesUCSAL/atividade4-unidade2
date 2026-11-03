package Services;

import Entidades.Contrato;
import Entidades.Parcela;

import java.time.LocalDate;

public class ServicoContrato {
    private ServicoPagamentoOnline servicoPagamentoOnline;

    public ServicoContrato(ServicoPagamentoOnline servicoPagamentoOnline) {
        this.servicoPagamentoOnline = servicoPagamentoOnline;
    }

    public void processarContrato(Contrato contrato, Integer meses){
        double valorSemJuros = contrato.getValorTotal() / meses;

        for(int i = 1; i<= meses; i++){
            LocalDate dataVencimento = contrato.getData().plusMonths(i);

            double juro = servicoPagamentoOnline.juros(valorSemJuros, i);
            double taxa = servicoPagamentoOnline.taxaPagamento(valorSemJuros);
            double valorTotalParcela = valorSemJuros + taxa + juro;

            contrato.getParcelas().add(new Parcela(dataVencimento, valorTotalParcela));

        }
    }
}
