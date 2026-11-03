package Services;

public interface ServicoPagamentoOnline {
    Double taxaPagamento(Double montante);
    Double juros(Double montante, Integer mes);
}
