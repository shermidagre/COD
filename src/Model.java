import java.util.ArrayList;

/**
 * Clase encargada de manejar los datos
 */
public class Model {
    static ArrayList<Coche> parking = new ArrayList<>();

    /**
     * Crea un coche y lo mete en el parking
     * @param modelo del coche
     * @param matricula identificador unico
     * @return el coche creado
     */

    public static Coche crearCoche(String modelo, String matricula) {
        Coche aux = new Coche(modelo, matricula);
        parking.add(aux);
        return aux;
    }

    /**
     * Busca coche segun matricula
     * @param matricula a buscar
     * @return coche o null si no existe
     */

    public static Coche getCoche(String matricula) {
        Coche aux = null;
        for (Coche e : parking) {
            if (e.matricula.equals(matricula)) {
                aux = e;
            }
        }
        return aux;
    }

    /**
     * Cambia la velocidad de un coche
     * @param matricula
     * @param v nueva velocidad
     * @return velocidad modificada
     */
    /**
     * Cambia la velocidad de un coche
     * @param matricula
     * @param v nueva velocidad
     * @return velocidad modificada
     */
    public static int cambiarVelocidad(String matricula, Integer v) {
        Coche c = getCoche(matricula);
        if (c != null) {
            c.velocidad = v;
            return c.velocidad;
        }
        return -1; // Error: coche no encontrado
    }

    public static void aumentarVelocidad(String matricula, Integer v) {
        Coche c = getCoche(matricula);
        if (c != null) {
            c.velocidad += v;
            return c.velocidad;
        }
        return aumentarVelocidad("a",5);
    }

    public static void disminuirVelocidad(String matricula, Integer v) {
        Coche c = getCoche(matricula);
        if (c != null) {
            c.velocidad -= v;
            return c.velocidad;
        }
        return disminuirVelocidad("v",1);
    }

    public static Object getVelocidad(String matricula) {
        return getCoche(matricula).velocidad;
    }
}