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


    public static void  menu() {

        int opcion;
        do {
            Scanner sc = new Scanner(System.in);
            System.out.println("Seleccione una opción:");
            System.out.println("0 - Reducir velocidad");
            System.out.println("1 - Aumentar velocidad");
            System.out.println("2 - Cambiar velocidad");
            System.out.println("3 - Crear coche");

             opcion = sc.nextInt();

            switch (opcion) {
                case 0 -> Controller.disminuirVelocidad();
                case 1 -> Controller.aumentarVelocidad();
                case 2 -> Controller.cambiarVelocidad();
                case 3 -> Controller.crearCoche();
                case 5 -> System.out.println("Saliendo...");
                default -> System.out.println("Opción inválida.");
            }
        } while (opcion != 5);
    }

    public static String Matricula (){
        Scanner sc = new Scanner(System.in);
        System.out.println("Introduce tu matricula");
        String matricula = sc.next();
        return matricula;
    }

    public  static String Modelo (){
        Scanner sc = new Scanner(System.in);
        System.out.println("Introduce el modelo");
        String modelo = sc.next();
        return modelo;
    }

    public static int Velocidad (){
        Scanner sc = new Scanner(System.in);
        System.out.println("Introduce la velocidad");
        int velocidad = sc.nextInt();
        return velocidad;
    }



}
