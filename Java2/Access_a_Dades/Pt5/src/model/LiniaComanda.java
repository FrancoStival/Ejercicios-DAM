package model;

import java.math.BigDecimal;

public class LiniaComanda {
    private int id;
    private int producteId;
    private int quantitat;
    private BigDecimal preuUnitari;

    public LiniaComanda() {}

    public LiniaComanda(int producteId, int quantitat, BigDecimal preuUnitari) {
        this.producteId = producteId;
        this.quantitat = quantitat;
        this.preuUnitari = preuUnitari;
    }

    public int getId() { return id; }
    public void setId(int id) { this.id = id; }

    public int getProducteId() { return producteId; }
    public void setProducteId(int producteId) { this.producteId = producteId; }

    public int getQuantitat() { return quantitat; }
    public void setQuantitat(int quantitat) { this.quantitat = quantitat; }

    public BigDecimal getPreuUnitari() { return preuUnitari; }
    public void setPreuUnitari(BigDecimal preuUnitari) { this.preuUnitari = preuUnitari; }
}
