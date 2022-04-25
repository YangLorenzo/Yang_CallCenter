import static java.lang.System.out;

public class Main {
    public static void menu() {
        out.println("1) aggiungi operatore");
        out.println("2) elimina operatore");
        out.println("3) aggiungi cliente");
        out.println("4) elimina cliente");
        out.println("5) ricevi una chiamata");
        out.println("6) telefonate per codice operatore");
        out.println("7) stampa tutti operatori");
        out.println("8) stampa tutti clienti");
        out.println("0) Esc");
    }

    public static void main(String[] args) {
        CallCenter callCenter = new CallCenter();

        int op = -1;
        while (op != 0) {
            menu();
            op = Input.getOpzione();
            switch (op) {
                case 1:
                    if (!callCenter.aggiungiOperatore(Input.creaOperatore()))
                        out.println("l'operatore inserito gia' esiste");
                    out.println();
                    break;
                case 2:
                    if (!callCenter.eliminaOperatore(Input.getCodiceOperatore()))
                        out.println("codice invalido");
                    else out.println("eliminato con successo");

                    out.println();
                    break;
                case 3:
                    if (!callCenter.aggiungiCliente(Input.creaCliente()))
                        out.println("il cliente inserito gia' esiste");
                    out.println();
                    break;
                case 4:
                    if (!callCenter.eliminaCliente(Input.getCodiceFiscale()))
                        out.println("codice fiscale invalido");
                    else
                        out.println("eliminato con successo");
                    out.println();
                    break;
                case 5:
                    if (!callCenter.riceviChiamata(Input.getCodiceFiscale()))
                        out.println("codice fiscale invalido");
                    out.println();
                    break;
                case 6:
                    if (!callCenter.stampaTelefonateDiOperatore(Input.getCodiceOperatore()))
                        out.println("codice dell'operatore invalido");
                    out.println();
                    break;
                case 7:
                    callCenter.stampaTuttiOperatori();
                    out.println();
                    break;
                case 8:
                    callCenter.stampaTuttiClienti();
                    out.println();
                    break;
                default:
                    break;
            }
        }
    }
}
