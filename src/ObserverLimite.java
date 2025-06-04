public class ObserverLimite {
    final static int limiteve = 120;

    public static void update(Coche c){
        if (c.velocidad > limiteve){
            View.alarmaInfraccionVelocidad(c.matricula,c.velocidad);
        }
    }
}
