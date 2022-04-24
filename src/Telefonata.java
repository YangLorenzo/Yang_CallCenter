import java.time.LocalDateTime;

public class Telefonata {
    private Cliente cliente;
    private Operatore operatore;

    private LocalDateTime dataOra_inizio;
    private LocalDateTime dataOra_fine;

    public Telefonata(Cliente cliente, Operatore operatore) {
        this.cliente = cliente;
        this.operatore = operatore;

        this.dataOra_inizio = null;
        this.dataOra_fine = null;
    }

    public void inizio() {
        this.dataOra_inizio = LocalDateTime.now();
    }

    public void fine() {
        this.dataOra_fine = LocalDateTime.now();
    }

    @Override
    public String toString() {
        return dataOra_fine + " - " + dataOra_fine + "\n" +
                "operatore della telefonata: " + operatore;
    }
}
