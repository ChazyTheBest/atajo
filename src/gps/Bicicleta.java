package gps;

import java.util.Arrays;
import java.util.List;

/**
 * Bicicleta class
 *
 * @Java IES Severo Ochoa @2.0
 */
public class Bicicleta
{
    private int ruedas;
    private boolean luces;
    private String marca;

    Bicicleta(int ruedas, boolean luces, String marca)
    {
        this.ruedas = ruedas;
        this.luces = luces;
        this.marca = marca;
    }

    public static void main(String[] abc)
    {
        new Bicicleta(2, false, "Orbea").go();
    }

    String rutaCorta(List<Integer> camino1, List<Integer> camino2, List<Integer> camino3)
    {
        int a = camino1.stream().mapToInt(Integer::intValue).sum();
        int b = camino2.stream().mapToInt(Integer::intValue).sum();
        int c = camino3.stream().mapToInt(Integer::intValue).sum();
        String corto, plural = "Los caminos más cortos son: caminos %d y %d.";

        // all are equal
        if (a == b && a == c)
        {
            corto = "Todos los caminos son iguales.";
        }
        // 1 and 2 are the shortest
        else if (a == b && a < c)
        {
            corto = String.format(plural, 1, 2);
        }
        // 1 and 3 are the shortest
        else if (a == c && a < b)
        {
            corto = String.format(plural, 1, 3);
        }
        // 2 and 3 are the shortest
        else if (b == c && b < a)
        {
            corto = String.format(plural, 2, 3);
        }
        // one of the three is the shortest
        else
        {
            corto = String.format("El camino más corto es: camino %d.", a < b && a < c ? 1 : b < c ? 2 : 3);
        }

        return corto;
    }

    void go()
    {
        List<Integer> camino1 = Arrays.asList( 12, 34, 21, 46, 25 );
        List<Integer> camino2 = Arrays.asList( 24, 1, 5, 64, 10, 15, 21 );
        List<Integer> camino3 = Arrays.asList( 1, 5, 6, 7, 8, 10, 20, 46, 104 );

        System.out.print(rutaCorta(camino1, camino2, camino3));
    }
}
