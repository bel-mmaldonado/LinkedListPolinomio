import java.io.Serializable;
import java.lang.reflect.Array;
import java.util.Iterator;
import java.util.NoSuchElementException;
import java.util.Scanner;

public class Polynomial implements Serializable {

    private Nodo root = null;
    private int size;

    public Polynomial() {
        Termino t = new Termino(0, 0);
        add(t);
    }


    public Polynomial(int coef[]) {
        for (int i = 0; i <= coef.length-1; i++) {
            if (coef[i] != 0) {
                Termino t = new Termino(coef[i], i+1);
                Nodo nuevo = new Nodo(t);
                nuevo.next = root;
                root = nuevo;
                size++;
            } else {
                continue;
            }
        }
    }

    public void add(Termino t) {
        Nodo n = new Nodo(t);
        if (root == null) {
            root = n;
        } else {
            Nodo p = root;
            while (p.next != null) {
                p = p.next;
            }
            p.next = n;
        }

        size++;
    }

    public Polynomial add(Polynomial pol) {

        Nodo p = root;
        Polynomial listSuma = new Polynomial();
        int suma = 0;
        if (this.size() == pol.size()) {
            for (int i = 0; i < pol.size(); i++) {
                suma = (this.getCoefficient(i + 1) + pol.getCoefficient(i + 1));
                Termino termNuevo = new Termino(suma, (i + 1));
                listSuma.add(termNuevo);
            }
            return listSuma;
        } else {
            return listSuma;
        }


    }

    public int getCoefficient(int x){
        if (x < 0 || x > size) {
            throw new NoSuchElementException();
        }
        Nodo p = root;
        for (int i = 0; i <= size; i++) {
            if (p.termino.exponente == x){
                return p.termino.coeficiente;
            }
            p = p.next;
        }
        return -1;
    }

    public void setCoefficient(int x, int coef){
        if (x < 0 || x > size) {
            throw new NoSuchElementException();
        }
        Nodo p = root;
        boolean cambio = false;
        for(int i = 0; i <= size; i++){
            if (p.termino.exponente == x){
                p.termino.coeficiente = coef;
                cambio = true;
                break;
            }
            p = p.next;
        }
    }



    public float valueOf(float x){
        Nodo p = root;
        float total = 0;
        float potencia = 0;
        float exponente = 0;
        while (p != null){
            exponente = p.termino.exponente;
            potencia = (float) Math.pow(x, exponente);
            total += (p.termino.coeficiente* potencia);
            p = p.next;
        }
        return total;
    }

    public boolean equals(Object x){
        if (this == x) return true;
        if (x == null) return false;
        if (getClass() != x.getClass()) return false;
        final Polynomial other = (Polynomial) x;

        Nodo a = other.root;
        Nodo actual = root;
        while(actual != null){
            if (actual.termino.coeficiente != a.termino.coeficiente){
                return false;
            }
            if (actual.termino.exponente != a.termino.exponente){
                return false;
            }
            actual = actual.next;
            a = a.next;

        }
        return true;
    }

    @Override
    public String toString(){
        StringBuilder sb = new StringBuilder("p(x)= ");
        Nodo p = root;
        while (p != null) {
            if (p.termino.exponente > 0) {
                sb.append(p.termino.coeficiente);
                sb.append("x^");
                sb.append((p.termino.exponente));
                sb.append(" + ");
            }
            p = p.next;
        }
        sb.append("0");
        return sb.toString();
    }

    public int size(){
        return size;
    }

    private static class Termino{
        int coeficiente;
        int exponente;

        public Termino(int coeficiente, int exponente) {
            this.coeficiente = coeficiente;
            this.exponente = exponente;
        }
    }


    private static class Nodo{
        Termino termino;
        Nodo next;


        public Nodo(Termino termino) {
            this.termino = termino;
            this.next = null;
        }
    }
}

