import static java.lang.System.out;

public class Main {
    public static void menu() {
        out.println("1) aggiungi operatore");
        out.println("2) elimina operatore");
        out.println("3) aggiungi cliente");
        out.println("4) elimina cliente");
        out.println("5) telefonate per codice operatore");
        out.println("6) stampa tutti operatori");
        out.println("7) stampa tutti clienti");
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
                    break;
                case 2:
                    if (!callCenter.eliminaOperatore(Input.getCodiceOperatore()))
                        out.println("codice invalido");
                    break;
                case 3:
                    if (!callCenter.aggiungiCliente(Input.creaCliente()))
                        out.println("il cliente inserito gia' esiste");
                    break;
                case 4:
                    if (!callCenter.eliminaCliente(Input.getCodiceFiscale()))
                        out.println("codice fiscale invalido");
                    break;
                case 5:
                    callCenter.stampaTelefonateDiOperatore(Input.getCodiceOperatore());
                    break;
                case 6:
                    callCenter.stampaTuttiOperatori();
                    break;
                case 7:
                    callCenter.stampaTuttiClienti();
                    break;
                default:
                    break;
            }
        }
    }
}
