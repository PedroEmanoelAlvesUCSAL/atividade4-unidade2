package Entidades;

import java.util.Date;

public class Parcela {
    private Date data;
    private Double valor;

    public Parcela(Date data, Double valor) {
        this.data = data;
        this.valor = valor;
    }

    public Date getData() {
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
