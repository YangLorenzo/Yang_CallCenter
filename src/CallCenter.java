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

    public boolean aggiungiCliente(Cliente c) {
        if (!clienti.containsKey(c)) {
            clienti.put(c.getCodiceFiscale(), c);
            return true;
        }
        return false;
    }

    public boolean eliminaCliente(String codiceFiscale) {
        return clienti.remove(codiceFiscale) == null ? false : true;
    }

    public boolean aggiungiOperatore(Operatore op) {
        if (!operatori.containsKey(op.getCodice())) {
            operatori.put(op.getCodice(), op);
            return true;
        }
        return false;
    }

    public boolean eliminaOperatore(int codice) {
        return operatori.remove(codice) == null ? false : true;
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

    public boolean stampaTelefonateDiOperatore(int codice) {
        Operatore op = operatori.get(codice);
        if (op == null) return false;

        System.out.println("Telefonate ricevute dall'operatore:");

        List<Telefonata> telefonate = operatori.get(codice).getTelefonateRicevute();
        if (telefonate.isEmpty())
            System.out.println("nessuna telefonata");
        else {
            System.out.println("***");
            for (Telefonata t : telefonate) {
                System.out.println(t);
                System.out.println("***");
            }
        }
        return true;
    }

    public boolean riceviChiamata(String codiceFiscale) {
        Cliente chiamante = clienti.get(codiceFiscale);
        if (chiamante == null) return false;

        System.out.println(chiamante);
        if (chiamante.getUltimaTelefonata() != null)
            System.out.println(chiamante.getUltimaTelefonata());

        Telefonata telefonata = operatoreRiceveTelefonata(chiamante);
        if (telefonata == null) return false;

        System.out.println("chiamata in corso...");
        telefonata.inizio();

        do {
            System.out.println("inserisci 0 per terminare");
        } while (Input.getOpzione() != 0);

        System.out.println("chiamata terminata");
        telefonata.fine();
        return true;
    }

    private Telefonata operatoreRiceveTelefonata(Cliente chiamante) {
        if (operatori.isEmpty())
            return null;

        int codice = 1 + (int) Math.random() * ((Operatore.getCodiceOperatori() - 1) + 1);

        Telefonata telefonata = new Telefonata(chiamante, operatori.get(codice));
        operatori.get(codice - 1).aggiungiTelefonata(telefonata);

        return telefonata;
    }
}
