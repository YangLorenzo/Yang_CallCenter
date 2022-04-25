import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class CallCenter {
    private Map<String, Cliente> clienti;
    private Map<Integer, Operatore> operatori;

    CallCenter() {
        clienti = new HashMap<>();
        operatori = new HashMap<>();
    }

    public void aggiungiCliente(Cliente c) throws IllegalArgumentException {
        if (clienti.containsKey(c.getCodiceFiscale()))
            throw new IllegalArgumentException("cliente gia' esiste");
        clienti.put(c.getCodiceFiscale(), c);
    }

    public void eliminaCliente(String codiceFiscale) throws IllegalArgumentException {
        if (clienti.remove(codiceFiscale) == null)
            throw new IllegalArgumentException("codice fiscale invalido");
    }

    public void aggiungiOperatore(Operatore op) throws IllegalArgumentException {
        if (operatori.containsKey(op.getCodice()))
            throw new IllegalArgumentException("operatore gia' esiste");
        operatori.put(op.getCodice(), op);
    }

    public void eliminaOperatore(int codice) throws IllegalArgumentException {
        if (operatori.remove(codice) == null)
            throw new IllegalArgumentException("codice invalido");
    }

    public void stampaTuttiClienti() {
        if (!clienti.isEmpty()) {
            System.out.println("***");
            for (String key : clienti.keySet()) {
                System.out.println(clienti.get(key));
                System.out.println("***");
            }
        } else
            System.out.println("nessun cliente");
    }

    public void stampaTuttiOperatori() {
        if (!operatori.isEmpty()) {
            System.out.println("***");
            for (int key : operatori.keySet()) {
                System.out.println(operatori.get(key));
                System.out.println("***");
            }
        } else
            System.out.println("nessun operatore");
    }

    public void stampaTelefonateDiOperatore(int codice) throws IllegalArgumentException {
        Operatore op = operatori.get(codice);
        if (op == null) throw new IllegalArgumentException("codice dell'operatore invalido");

        System.out.println("Telefonate ricevute dall'operatore:");

        List<Telefonata> telefonate = op.getTelefonateRicevute();
        if (telefonate.isEmpty())
            System.out.println("nessuna telefonata");
        else {
            System.out.println("***");
            for (Telefonata t : telefonate) {
                System.out.println(t);
                System.out.println("***");
            }
        }
    }

    public void riceviChiamata(String codiceFiscale) throws IllegalArgumentException {
        Cliente chiamante = clienti.get(codiceFiscale);
        if (chiamante == null) throw new IllegalArgumentException("codice fiscale invalido");

        System.out.println(chiamante);
        if (chiamante.getUltimaTelefonata() != null)
            System.out.println(chiamante.getUltimaTelefonata());

        Telefonata telefonata = operatoreRiceveTelefonata(chiamante);
        if (telefonata == null) throw new IllegalArgumentException("Call Center non ha ancora nessun operatore");

        System.out.println("chiamata in corso...");
        telefonata.inizio();

        do {
            System.out.println("inserisci 0 per terminare");
        } while (Input.getOpzione() != 0);

        System.out.println("chiamata terminata");
        telefonata.fine();
    }

    private Telefonata operatoreRiceveTelefonata(Cliente chiamante) {
        if (operatori.isEmpty())
            return null;

        int codice = (int) Math.random() * (Operatore.getCodiceOperatori());
        Telefonata telefonata = new Telefonata(chiamante, operatori.get(codice));
        operatori.get(codice).aggiungiTelefonata(telefonata);

        return telefonata;
    }
}
