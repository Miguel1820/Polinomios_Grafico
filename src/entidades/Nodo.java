package entidades;

public class Nodo {
    private int exponente;
    private double coeficiente;
    public Nodo siguiente;

    public Nodo(int exponente, double coeficiente) {
        this.exponente = exponente;
        this.coeficiente = coeficiente;
    }

    public Nodo() {
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
