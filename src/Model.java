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
        if (getCoche(matricula) != null) {
            throw new IllegalArgumentException("Ya existe un coche con matrícula: " + matricula);
        }
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
        for (Coche e : parking) {
            if (e.matricula.equals(matricula)) {
                return e;
            }
        }
        return null;
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

    public static int aumentarVelocidad(String matricula, Integer v) {
        Coche c = getCoche(matricula);
        if (c != null) {
            c.velocidad += v;
            return c.velocidad;
        }
        return -1;
    }

    public static int disminuirVelocidad(String matricula, Integer v) {
        Coche c = getCoche(matricula);
        if (c != null) {
            c.velocidad -= v;
            return c.velocidad;
        }
        return -1;
    }

    public static int getVelocidad(String matricula) {
        Coche c = getCoche(matricula);
        return (c != null) ? c.velocidad : -1;
    }
}