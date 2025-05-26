package servicios;

import entidades.Nodo;
import entidades.Polinomio;

public class ServicioPolinomio {

    public static Polinomio sumar(Polinomio p1, Polinomio p2) {
        Polinomio pR = new Polinomio();

        Nodo actual1 = p1.getCabeza();
        Nodo actual2 = p2.getCabeza();

        while (actual1 != null || actual2 != null) {
            Nodo nR = null;
            if (actual1 != null && actual2 != null && actual1.getExponente() == actual2.getExponente()) {
                if (actual1.getCoeficiente() + actual2.getCoeficiente() != 0) {
                    nR = new Nodo(actual1.getExponente(), actual1.getCoeficiente() + actual2.getCoeficiente());
                }
                actual1 = actual1.siguiente;
                actual2 = actual2.siguiente;
            } else if (actual2 == null || (actual1 != null && actual1.getExponente() < actual2.getExponente())) {
                nR = new Nodo(actual1.getExponente(), actual1.getCoeficiente());
                actual1 = actual1.siguiente;
            } else {
                nR = new Nodo(actual2.getExponente(), actual2.getCoeficiente());
                actual2 = actual2.siguiente;
            }
            if (nR != null) {
                pR.agregar(nR);
            }
        }
        return pR;
    }

    public static Polinomio restar(Polinomio p1, Polinomio p2) {
        Polinomio pR = new Polinomio();
        Nodo actual1 = p1.getCabeza();
        Nodo actual2 = p2.getCabeza();

        while (actual1 != null || actual2 != null) {
            Nodo nR = null;
            if (actual1 != null && actual2 != null && actual1.getExponente() == actual2.getExponente()) {
                double resta = actual1.getCoeficiente() - actual2.getCoeficiente();
                if (Math.abs(resta) >= 1e-10) {
                    nR = new Nodo(actual1.getExponente(), resta);
                }
                actual1 = actual1.siguiente;
                actual2 = actual2.siguiente;
            } else if (actual2 == null || (actual1 != null && actual1.getExponente() > actual2.getExponente())) {
                nR = new Nodo(actual1.getExponente(), actual1.getCoeficiente());
                actual1 = actual1.siguiente;
            } else {
                nR = new Nodo(actual2.getExponente(), -1 * actual2.getCoeficiente());
                actual2 = actual2.siguiente;
            }
            if (nR != null) {
                pR.agregar(nR);
            }
        }

        pR.limpiarCeros(); // Elimina cualquier término con coeficiente despreciable
        return pR;
    }

    public static Polinomio multiplicar(Polinomio p1, Polinomio p2) {
        Polinomio pR = new Polinomio();

        Nodo actual1 = p1.getCabeza();
        while (actual1 != null) {
            Nodo actual2 = p2.getCabeza();
            while (actual2 != null) {
                int exponente = actual1.getExponente() + actual2.getExponente();
                double coeficiente = actual1.getCoeficiente() * actual2.getCoeficiente();
                pR.agregar(new Nodo(exponente, coeficiente));
                actual2 = actual2.siguiente;
            }
            actual1 = actual1.siguiente;
        }
        return pR;
    }
    
    //AGRAGAR METODO PARA DIVIDIR
    public static Polinomio dividir(Polinomio dividendo, Polinomio divisor) {
        if (divisor.getCabeza() == null) {
            throw new ArithmeticException("División por cero (polinomio nulo)");
        }

        Polinomio cociente = new Polinomio();
        Polinomio resto = dividendo.clonar();

        Nodo cabezaDivisor = divisor.getCabeza();

        while (resto.getCabeza() != null &&
            resto.getCabeza().getExponente() >= cabezaDivisor.getExponente()) {

            Nodo cabezaResto = resto.getCabeza();

            int expCociente = cabezaResto.getExponente() - cabezaDivisor.getExponente();
            double coefCociente = cabezaResto.getCoeficiente() / cabezaDivisor.getCoeficiente();

            if (Math.abs(coefCociente) < 1e-10) {
                break;
            }

            Nodo terminoCociente = new Nodo(expCociente, coefCociente);
            cociente.agregar(terminoCociente);

            // Multiplicamos el divisor por el nuevo término del cociente
            Polinomio multiplicado = new Polinomio();
            Nodo actual = divisor.getCabeza();
            while (actual != null) {
                int nuevoExp = actual.getExponente() + expCociente;
                double nuevoCoef = actual.getCoeficiente() * coefCociente;
                multiplicado.agregar(new Nodo(nuevoExp, nuevoCoef));
                actual = actual.siguiente;
            }
            // Restamos el producto del resto
            resto = restar(resto, multiplicado);
        }
        return cociente; 
    }

    




}
