import org.junit.jupiter.params.provider.EnumSource;

import java.lang.module.ModuleDescriptor;
import java.util.Scanner;
public class Controller {

    public static void crearCoche(){

        Coche C = Model.crearCoche("ej","ej");
        Coche C2 = Model.getCoche(C.matricula);
        System.out.println(C2.matricula);

    }

    public static void aumentarVelocidad(){

        Coche C = Model.aumentarVelocidad("ej",3);

    }

    public static void disminuirVelocidad(){

        Coche C = Model.disminuirVelocidad("ej1",1);

    }


}