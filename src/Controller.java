import org.junit.jupiter.params.provider.EnumSource;

import java.lang.module.ModuleDescriptor;
import java.util.Scanner;
public class Controller {

    public static String crearCoche(){

        String modelo = View.Modelo();
        String matricula = View.Matricula();
        return

    }

    public static void aumentarVelocidad(){

        Coche C = Model.aumentarVelocidad("ej",3);

    }

    public static void disminuirVelocidad(){

        Coche C = Model.disminuirVelocidad("ej1",1);

    }

    public static void cambiarVelocidad(){

        Coche C = Model.cambiarVelocidad("ej",30);

    }


}