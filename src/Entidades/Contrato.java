package Entidades;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class Contrato {
    private Integer numero;
    private Date data;
    private Double valorTotal;

    private List<Parcela> parcelas = new ArrayList<>();

    public Contrato(Integer numero, Date data, Double valorTotal) {
        this.numero = numero;
        this.data = data;
        this.valorTotal = valorTotal;
    }

    public List<Parcela> getParcelas() {
        return parcelas;
    }

    public Integer getNumero() {
        return numero;
    }

    public Date getData() {
        return data;
    }

    public Double getValorTotal() {
        return valorTotal;
    }

    public void addParcela(Parcela parcela){
        parcelas.add(parcela);
    }

    public void removeParcela(Parcela parcela){
        parcelas.remove(parcela);
    }
}
