import java.util.LinkedList;
import java.util.List;

public class Operatore {
    private static int codiceOperatori = 0;

    private final int codice;
    private String nome;
    private String cognome;
    private List<Telefonata> telefonateRicevute;

    public Operatore() {
        this(null, null);
    }

    public Operatore(String nome, String cognome) {
        this.codice = ++Operatore.codiceOperatori;
        this.nome = nome;
        this.cognome = cognome;

        this.telefonateRicevute = new LinkedList<>();
    }

    public static int getCodiceOperatori() {
        return codiceOperatori;
    }

    public static void setCodiceOperatori(int codiceOperatori) {
        Operatore.codiceOperatori = codiceOperatori;
    }

    public int getCodice() {
        return codice;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getCognome() {
        return cognome;
    }

    public void setCognome(String cognome) {
        this.cognome = cognome;
    }

    public List<Telefonata> getTelefonateRicevute() {
        return telefonateRicevute;
    }

    public void aggiungiTelefonata(Telefonata t) {
        if (!telefonateRicevute.contains(t)) {
            telefonateRicevute.add(t);
        }
    }

    @Override
    public String toString() {
        return codice + " " + cognome + " " + nome;
    }
}
