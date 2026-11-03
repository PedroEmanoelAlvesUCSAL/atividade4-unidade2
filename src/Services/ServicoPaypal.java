package Services;

public class ServicoPaypal implements ServicoPagamentoOnline {

    @Override
    public Double taxaPagamento(Double montante) {
        return montante * 0.02;
    }

    @Override
    public Double juros(Double montante, Integer mes) {
        return montante * 0.01 * mes;
    }
}