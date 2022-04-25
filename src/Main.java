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

            try {
                switch (op) {
                    case 1:
                        callCenter.aggiungiOperatore(Input.creaOperatore());
                        break;
                    case 2:
                        callCenter.eliminaOperatore(Input.getCodiceOperatore());
                        break;
                    case 3:
                        callCenter.aggiungiCliente(Input.creaCliente());
                        break;
                    case 4:
                        callCenter.eliminaCliente(Input.getCodiceFiscale());
                        break;
                    case 5:
                        callCenter.riceviChiamata(Input.getCodiceFiscale());
                        break;
                    case 6:
                        callCenter.stampaTelefonateDiOperatore(Input.getCodiceOperatore());
                        break;
                    case 7:
                        callCenter.stampaTuttiOperatori();
                        break;
                    case 8:
                        callCenter.stampaTuttiClienti();
                        break;
                    default:
                        break;
                }
                out.println();

            } catch (IllegalArgumentException e) {
                out.println(e.getMessage());
                out.println();
            }
        }
    }
}
