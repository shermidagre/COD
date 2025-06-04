import org.junit.jupiter.params.provider.EnumSource;

import java.util.ArrayList;

public class Controller {



    public static String crearCoche(){

            String modelo = View.Modelo();
            String matricula = View.Matricula();
            Coche nuevo = Model.crearCoche(modelo, matricula);
            return nuevo.matricula;
    }

    public static void aumentarVelocidad() {
        String matricula = View.Matricula();
        int cantidad = View.Velocidad();
        boolean comprobacion = Model.aumentarVelocidad(matricula, cantidad);
        if (comprobacion) {
            Integer v = Model.getVelocidad(matricula);
            View.mostrarVelocidad(matricula, v);
        } else {
            View.mostrarError("Coche no encontrado.");
        }
    }

    public static void disminuirVelocidad() {
        String matricula = View.Matricula();
        int cantidad = View.Velocidad();
        boolean comprobacion = Model.disminuirVelocidad(matricula, cantidad);
        if (comprobacion) {
            Integer v = Model.getVelocidad(matricula);
            View.mostrarVelocidad(matricula, v);
        } else {
            View.mostrarError("Coche no encontrado.");
        }
    }

        public static void cambiarVelocidad() {
                String matricula = View.Matricula();
                int nuevaVelocidad = View.Velocidad();
                boolean comprobacion = Model.cambiarVelocidad(matricula, nuevaVelocidad);
                if (comprobacion) {
                    Integer v = Model.getVelocidad(matricula);
                    View.mostrarVelocidad(matricula, v);
                } else {
                    View.mostrarError("Coche no encontrado.");
                }
            }

    public static void mostrarCoches() {
        View.mostrarListaCoches(Model.parking);

    }

    public  static void mostrarCocheIndividual(){

        String matricula = View.Matricula();
        Coche c = Model.getCochePorMatricula(matricula);
        if (c != null){
            View.mostrarCocheIndividual(c);
        }
        else {
            View.mostrarError("Coche no encontrado.");
        }

    }
    public static void avanzar(){
        String matricula = View.Matricula();
        int nuevos_metros = View.MetrosRecorridos();
        boolean comprobacion = Model.avanzar(matricula, nuevos_metros);
        if (comprobacion) {
            Integer m = Model.getMetros(matricula);
            View.mostrarDistancia(matricula, m);
        } else {
            View.mostrarError("Coche no encontrado.");
        }
    }

    public static void repostar(){
        String matricula = View.Matricula();
        int ngasolina = View.gasolinaRepostar();
        boolean comprobacion = Model.repostar(matricula, ngasolina);
        if (comprobacion) {
            Integer g = Model.getGasolina(matricula);
            View.mostrarGasolina(matricula,g);
        } else {
            View.mostrarError("Coche no encontrado.");
        }
    }



}




