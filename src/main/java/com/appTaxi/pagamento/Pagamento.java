package com.appTaxi.pagamento;

public class Pagamento {
    private Long id;
    private Long id_prenotazione;
    private float importo;
    private String stato;

    public Pagamento(Long id, Long id_prenotazione, float importo, String stato) {
        this.id = id;
        this.id_prenotazione = id_prenotazione;
        this.importo = importo;
        this.stato = stato;
    }

    public Pagamento() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getId_prenotazione() {
        return id_prenotazione;
    }

    public void setId_prenotazione(Long id_prenotazione) {
        this.id_prenotazione = id_prenotazione;
    }

    public float getImporto() {
        return importo;
    }

    public void setImporto(float importo) {
        this.importo = importo;
    }

    public String getStato() {
        return stato;
    }

    public void setStato(String stato) {
        this.stato = stato;
    }

    @Override
    public String toString() {
        return "Pagamento{" +
                "id=" + id +
                ", id_prenotazione=" + id_prenotazione +
                ", importo=" + importo +
                ", stato=" + stato +
                '}';
    }
}
