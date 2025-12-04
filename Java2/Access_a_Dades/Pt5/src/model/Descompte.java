package model;

import java.math.BigDecimal;

public class Descompte {
    private int id;
    private int producteId;
    private String tipus;
    private BigDecimal valor;

    public Descompte() {}

    public Descompte(int id, int producteId, String tipus, BigDecimal valor) {
        this.id = id;
        this.producteId = producteId;
        this.tipus = tipus;
        this.valor = valor;
    }

    public int getId() { return id; }
    public void setId(int id) { this.id = id; }

    public int getProducteId() { return producteId; }
    public void setProducteId(int producteId) { this.producteId = producteId; }

    public String getTipus() { return tipus; }
    public void setTipus(String tipus) { this.tipus = tipus; }

    public BigDecimal getValor() { return valor; }
    public void setValor(BigDecimal valor) { this.valor = valor; }
}
