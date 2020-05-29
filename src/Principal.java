import java.util.Scanner;

public class Principal {
    public static void main(String[] args) {
        System.out.println("Manejo de polinomios a traves de LinkedLists");
        System.out.println("Se creara un polinomio a partir de un arreglo predeterminado");

        int[] array = {1, 3, 5};

        // 2) Crear polinomio a partir de un array.
        Polynomial p = new Polynomial(array);
        System.out.println(p.toString());

        // 3) Suma de dos polinomios.
        System.out.println("___________________________________________________________");
        System.out.println("Al polinomio creado le sumaremos otro polinomio.");
        int[] array1 = {5, 10, 4};

        Polynomial pol = new Polynomial(array1);
        System.out.println("Polinomio a sumar: ");
        System.out.println(pol.toString());
        Polynomial sumaP = p.add(pol);
        if (sumaP.size() == 1){
            System.out.println("Los polinomios no se pudieron sumar. Debe ingresar polinomios de igual grado.");
        }
        else{
            String muestra = sumaP.toString();
            System.out.println("Resultado: ");
            System.out.println(muestra);
        }

        // 4) Implementar metodo para obtener el coeficiente del grado x.
        System.out.println("___________________________________________________________");
        Scanner ingreso = new Scanner(System.in);
        System.out.println("Ingrese el grado del termino que desea hallar el coeficiente: ");
        int x = ingreso.nextInt();
        int co = p.getCoefficient(x);
        System.out.println("Valor del coeficiente de grado " + x + ": " + co);

        // 5) Implementar metodo para setear un nuevo coeficiente a cierto grado.
        System.out.println("___________________________________________________________");
        System.out.println("Ingrese el grado del termino que desea setear: ");
        int grado = ingreso.nextInt();
        System.out.println("Ingrese el coeficiente: ");
        int coe = ingreso.nextInt();
        p.setCoefficient(grado,coe);
        System.out.println("El polinomio ha sido modificado");
        System.out.println(p.toString());


        // 6) Calcular y retornar el valor del polinomio en el punto x.
        System.out.println("___________________________________________________________");
        System.out.println("Ingrese el valor de x: ");
        float valorX = ingreso.nextFloat();
        float valorPolinomio = p.valueOf(valorX);
        System.out.println("El valor del polinomio en el punto " + valorX + " es " + valorPolinomio);

        // 7)
        System.out.println("___________________________________________________________");
        System.out.println("Comparacion del polinomio con un objeto (por ejemplo: pol): ");
        boolean s = p.equals(pol);
        System.out.println("Comparacion: " + s);

        // 8) Mostrar polinomio como String.
        System.out.println("___________________________________________________________");
        System.out.println("Polinomio creado a partir del array");
        String cad = p.toString();
        System.out.println(cad);
    }
}
