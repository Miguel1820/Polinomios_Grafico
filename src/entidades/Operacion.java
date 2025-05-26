package entidades;

import java.util.List;

public class Operacion {
    private String tipo;
    private List<Monomio> polinomio1;
    private List<Monomio> polinomio2;
    private List<Monomio> resultado;

    public Operacion(String tipo, List<Monomio> polinomio1, List<Monomio> polinomio2, List<Monomio> resultado) {
        this.tipo = tipo;
        this.polinomio1 = polinomio1;
        this.polinomio2 = polinomio2;
        this.resultado = resultado;
    }

    public Operacion() {
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public List<Monomio> getPolinomio1() {
        return polinomio1;
    }

    public void setPolinomio1(List<Monomio> polinomio1) {
        this.polinomio1 = polinomio1;
    }

    public List<Monomio> getPolinomio2() {
        return polinomio2;
    }

    public void setPolinomio2(List<Monomio> polinomio2) {
        this.polinomio2 = polinomio2;
    }

    public List<Monomio> getResultado() {
        return resultado;
    }

    public void setResultado(List<Monomio> resultado) {
        this.resultado = resultado;
    }

}
