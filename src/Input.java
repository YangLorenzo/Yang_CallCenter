import java.util.Scanner;

import static java.lang.System.out;

public class Input {
    private static Scanner in = new Scanner(System.in);

    public static int getOpzione() {
        int op;
        while (true) {
            try {
                out.print("cosa vuoi fare? ");
                op = in.nextInt();
                if ((op < 1 || op > 8) && op != 0) throw new IllegalArgumentException();
                return op;
            } catch (IllegalArgumentException e) {
                out.println("numero invalido");
            }
        }
    }

    public static Cliente creaCliente() {
        Cliente c = new Cliente();
        out.println("***Cliente***");
        out.print("codice fiscale: ");
        c.setCodiceFiscale(in.next());
        out.print("cognome: ");
        c.setCognome(in.next());
        out.print("nome: ");
        c.setNome(in.next());

        while (true) {
            try {
                out.print("numero di telefono: ");
                c.setTelefono(in.next());
                break;
            } catch (IllegalArgumentException e) {
                out.println(e.getMessage());
            }
        }

        return c;
    }

    public static Operatore creaOperatore() {
        Operatore op = new Operatore();
        out.println("***Operatore***");
        out.print("cognome: ");
        op.setCognome(in.next());
        out.print("nome: ");
        op.setNome(in.next());

        return op;
    }

    public static int getCodiceOperatore() {
        out.print("inserisci il codice dell'operatore: ");
        return in.nextInt();
    }

    public static String getCodiceFiscale() {
        out.print("inserisci il codice fiscale: ");
        return in.next();
    }

}
