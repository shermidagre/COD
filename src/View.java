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
        Scanner sc = new Scanner(System.in);
        System.out.println("Seleccione una opción:");
        System.out.println("0 - Reducir velocidad");
        System.out.println("1 - Aumentar velocidad");
        System.out.println("2 - Crear coche");
        int opcion = sc.nextInt();

        if(opcion == 0){

            Controller.disminuirVelocidad();

        } else if (opcion ==1) {

            Controller.aumentarVelocidad();

        }
        else if (opcion == 2){

            Controller.crearCoche();

        }
        else {
            System.out.println("Seleciona una opcion valida");
        }
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



}
