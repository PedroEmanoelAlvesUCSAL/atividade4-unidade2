package Entidades;

import java.time.LocalDate;
import java.util.Date;

public class Parcela {
    private LocalDate data;
    private Double valor;

    public Parcela(LocalDate data, Double valor) {
        this.data = data;
        this.valor = valor;
    }

    public LocalDate getData() {
        return data;
    }

    public Double getValor() {
        return valor;
    }

    @Override
    public String toString() {
        return data + " - " + String.format("%.2f", valor);
    }
}
