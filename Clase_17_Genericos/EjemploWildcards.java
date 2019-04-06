import java.util.ArrayList;

public class EjemploWildcards {
    public static double suma(ArrayList<? extends Number> numeros) {
        double suma = 0;
        for (int i = 0; i < numeros.size(); i++) {
            suma += numeros.get(i).doubleValue();
        }
        return suma;
    }

    public static void main(String[] args) {
        ArrayList<Double> x = new ArrayList<Double>();
        x.add(3.8);
        x.add(3.1);
        System.out.println(suma(x));
    }
}