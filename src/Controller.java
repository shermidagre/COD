import java.lang.module.ModuleDescriptor;
import java.util.Scanner;
public class Controller {
    public static void main(String[] args) {
        // Instanciamos la vista y el modelo
        View miView = new View();

        // Crear tres coches
        Model.crearCoche("LaFerrari", "SBC 1234");
        Model.crearCoche("Alpine", "HYU 4567");
        Model.crearCoche("Aston Martin", "FGH 3333");

        // Selecciona un coche
        String matricula = "SBC 1234";

        Scanner sc = new Scanner(System.in);
        int seleccion = sc.nextInt();

        if (seleccion == 0) {

            Model.disminuirVelocidad(matricula, 30);

        } else if (seleccion == 1) {

            Model.aumentarVelocidad(matricula, 30);

        } else {
            System.out.println("Opción no válida");
        }

        // Mostrar resultado
        boolean hecho = miView.muestraVelocidad(matricula, Model.getVelocidad(matricula));
        if (hecho) {
            System.out.println("Operación exitosa.");
        } else {
            System.out.println("Error al mostrar la velocidad.");
        }
    }
    


}