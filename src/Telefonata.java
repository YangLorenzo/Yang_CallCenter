import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

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
        return dataOra_inizio.toLocalDate().format(DateTimeFormatter.ofPattern("dd LLLL yyyy")) + " "
                + dataOra_inizio.toLocalTime().format(DateTimeFormatter.ofPattern("HH:mm")) + " - "
                + dataOra_fine.toLocalTime().format(DateTimeFormatter.ofPattern("HH:mm")) + "\n"
                + "chiamante: " + cliente + "\n"
                + "operatore: " + operatore;
    }
}
