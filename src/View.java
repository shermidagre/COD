import java.sql.SQLOutput;
import java.util.Scanner ;
/**
 * Clase encargada de la interacción con el usuario
 */
public class View {
    /**
     * Muestra la velocidad de un coche
     * @param matricula del coche
     * @param v velocidad
     * @return true si se ha mostrado correctamente
     */
    public boolean muestraVelocidad(String matricula, Integer v){
        System.out.println(matricula + ": " + v + "km/hr");
        return true;
    }

    Scanner sc = new Scanner(System.in);
    public int menu() {
        System.out.println("Seleccione una opción:");
        System.out.println("0 - Reducir velocidad");
        System.out.println("1 - Aumentar velocidad");
        return sc.nextInt();
    }

}
