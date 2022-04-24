import java.util.Objects;

public class Cliente {
    private String codiceFiscale;
    private String nome;
    private String cognome;

    private String telefono;
    private Telefonata ultimaTelefonata;

    public Cliente() {
        this(null, null, null, null);
    }

    public Cliente(String codiceFiscale, String nome, String cognome, String telefono) {
        this.codiceFiscale = codiceFiscale;
        this.nome = nome;
        this.cognome = cognome;
        this.setTelefono(telefono);
        this.ultimaTelefonata = null;
    }

    public String getCodiceFiscale() {
        return codiceFiscale;
    }

    public void setCodiceFiscale(String codiceFiscale) {
        this.codiceFiscale = codiceFiscale;
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

    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) throws IllegalArgumentException {
        if (!telefono.matches("[0-9]+"))
            throw new IllegalArgumentException("numero di telefono invalido");
        this.telefono = telefono;
    }

    public Telefonata getUltimaTelefonata() {
        return ultimaTelefonata;
    }

    public void setUltimaTelefonata(Telefonata ultimaTelefonata) {
        this.ultimaTelefonata = ultimaTelefonata;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Cliente cliente = (Cliente) o;
        return codiceFiscale.equals(cliente.codiceFiscale);
    }

    @Override
    public int hashCode() {
        return Objects.hash(codiceFiscale);
    }

    @Override
    public String toString() {
        return codiceFiscale + " " + cognome + " " + nome + "\n"
                + telefono;
    }

    public static void main(String[] args) {
        Cliente c = new Cliente("aefea434554", "lorenzo", "yang", "339");
        System.out.println(c.getCodiceFiscale());
    }
}
