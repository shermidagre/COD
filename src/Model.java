import java.util.ArrayList;

/**
 * Clase encargada de manejar los datos
 */
public class Model {
    public static ArrayList<Coche> parking = new ArrayList<>();

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
        for (Coche c : parking) {
            if (c.matricula.equals(matricula)) {
                return c;
            }
        }
        return null;
    }
    public static Coche getGasolina(Integer gasolina) {
        for (Coche c : parking) {
            if (c.gasolina.equals(gasolina)) {
                return c;
            }
        }
        return null;
    }


    /**
     * Cambia la velocidad de un coche
     * @return velocidad modificada
     */
    /**
     * Cambia la velocidad de un coche


     */

    public static void notifyObservers(Coche coche) {
        ObserverRepostarGasolina.update(coche);
        ObserverLimite.update(coche);
        ObserverRepostar.update(coche); //añadimos a el notify observers para posteriormente llamarlo en repostar
    }
    public static boolean cambiarVelocidad(String matricula, int nuevaVelocidad) {
        Coche c = getCoche(matricula);
        if (c != null) {
            c.velocidad = nuevaVelocidad;
            notifyObservers(getCoche(matricula));
            return true;
        }

        return false;
    }

    public static boolean aumentarVelocidad(String matricula, int cantidad) {
        Coche c = getCoche(matricula);
        if (c != null) {
            c.velocidad += cantidad;
            notifyObservers(getCoche(matricula));
            return true;
        }
        return false;
    }
    public static boolean avanzar(String matricula,int nuevos_metros){
        Coche c = getCoche(matricula);
        if (c != null){
            double litrosNecesarios = nuevos_metros / 100.0;

            if (c.gasolina >= litrosNecesarios) {
                c.metros += nuevos_metros;
                c.gasolina -= (int) litrosNecesarios;
                notifyObservers(c); // Notificamos cambios
                return true;
            } else {
                View.mostrarError("Gasolina insuficiente para recorrer " + nuevos_metros + " metros.");
                return false;
            }
        }
        return false;
    }

    public static boolean repostar(String matricula,int ngasolina
    ){
        Coche c = getCoche(matricula);
        if (c != null){
            c.gasolina += ngasolina;
            notifyObservers(getCoche(matricula)); //Como por ejemplo se llama aqui
            return  true;
        }
        return false;
    }

    public static boolean disminuirVelocidad(String matricula, int cantidad) {
        return aumentarVelocidad(matricula, -cantidad); // Reusamos lógica
    }

    public static Integer getVelocidad(String matricula) {
        Coche c = getCoche(matricula);
        return c != null ? c.velocidad : null;
    }

    public static Integer getMetros(String matricula){
        Coche c = getCoche(matricula);
        return c!= null ? c.metros : null;
    }

    public static Coche getCochePorMatricula(String matricula) {
        return getCoche(matricula);
    }

    public static Integer getGasolina(String matricula){
        Coche c = getCoche(matricula);
        return c != null ? c.gasolina : null;
    }
}



