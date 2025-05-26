package polinomios;

public class Nodo {

    double coeficiente;
    int exponente;
    Nodo siguiente;

    public Nodo(double coeficiente, int exponente) {
        this.coeficiente = coeficiente;
        this.exponente = exponente;
    }

    public void actualizar(double coeficiente, int exponente) {
        this.coeficiente = coeficiente;
        this.exponente = exponente;
    }
}
