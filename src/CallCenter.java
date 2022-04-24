import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class CallCenter {
    private Set<Cliente> clienti;
    private Map<Integer, Operatore> operatori;

    CallCenter() {
        clienti = new HashSet<>();
        operatori = new HashMap<>();
    }

    public boolean aggiungiCliente(Cliente c) {
        return clienti.add(c);
    }

    public boolean eliminaCliente(String codiceFiscale) {
        for (Cliente c : clienti) {
            if (c.getCodiceFiscale().equals(codiceFiscale)) {
                clienti.remove(c);
                return true;
            }
        }
        return false;
    }

    public boolean aggiungiOperatore(Operatore op) {
        if (!operatori.containsKey(op.getCodice())) {
            operatori.put(op.getCodice(), op);
            return true;
        }
        return false;
    }

    public boolean eliminaOperatore(int codice) {
        if (operatori.remove(codice) == null)
            return false;
        return true;
    }

    public void stampaTuttiClienti() {
        for (Cliente c : clienti) {
            System.out.println(c);
            System.out.println("***");
        }
    }

    public void stampaTuttiOperatori() {
        for (int key : operatori.keySet()) {
            System.out.println(operatori.get(key));
            System.out.println("***");
        }
    }

    public void stampaTelefonateDiOperatore(int codice) {
        System.out.println("Telefonate ricevute dall'operatore:");
        for (Telefonata t : operatori.get(codice).getTelefonateRicevute()) {
            System.out.println(t);
            System.out.println("***");
        }
    }

    public void riceviChiamata(Cliente chiamante) {
        System.out.println(chiamante);
        if (chiamante.getUltimaTelefonata() != null)
            System.out.println(chiamante.getUltimaTelefonata());

        Telefonata telefonata = operatoreRiceveTelefonata(chiamante);

        System.out.println("chiamata in corso...");
        telefonata.inizio();

        do {
            System.out.println("inserisci 0 per terminare");
        } while (Input.getOpzione() != 0);

        System.out.println("chiamata terminata");
        telefonata.fine();

    }

    private Telefonata operatoreRiceveTelefonata(Cliente chiamante) {
        int codice = 1 + (int) Math.random() * ((Operatore.getCodiceOperatori() - 1) + 1);

        Telefonata telefonata = new Telefonata(chiamante, operatori.get(codice));
        operatori.get(codice).aggiungiTelefonata(telefonata);

        return telefonata;
    }


    public static void main(String[] args) {
        CallCenter c = new CallCenter();
        c.aggiungiCliente(new Cliente("aaa", "Yang", "Lorenzo", "3948958"));
        c.aggiungiCliente(new Cliente("bbb", "Hu", "Marco", "594803"));
    }
}
