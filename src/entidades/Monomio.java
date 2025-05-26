package entidades;

public class Monomio {
    private int exponente;
    private double coeficiente;

    public Monomio(int exponente, double coeficiente) {
        this.exponente = exponente;
        this.coeficiente = coeficiente;
    }

    public Monomio() {
    }

    public int getExponente() {
        return exponente;
    }

    public void setExponente(int exponente) {
        this.exponente = exponente;
    }

    public double getCoeficiente() {
        return coeficiente;
    }

    public void setCoeficiente(double coeficiente) {
        this.coeficiente = coeficiente;
    }

}
