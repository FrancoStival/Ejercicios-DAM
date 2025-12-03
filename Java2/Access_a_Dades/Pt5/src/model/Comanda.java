package model;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

public class Comanda {
    private int id;
    private int clientId;
    private BigDecimal total = BigDecimal.ZERO;
    private List<LiniaComanda> linies = new ArrayList<>();

    public Comanda() {}

    public Comanda(int clientId) {
        this.clientId = clientId;
    }

    public int getId() { return id; }
    public void setId(int id) { this.id = id; }

    public int getClientId() { return clientId; }
    public void setClientId(int clientId) { this.clientId = clientId; }

    public BigDecimal getTotal() { return total; }
    public void setTotal(BigDecimal total) { this.total = total; }

    public List<LiniaComanda> getLinies() { return linies; }
    public void setLinies(List<LiniaComanda> linies) { this.linies = linies; }

    public void afegirLinia(LiniaComanda l) { linies.add(l); }
}
