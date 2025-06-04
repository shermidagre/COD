public class ObserverRepostarGasolina {
    final static int limitegasolina = 5;

    public static void update(Coche c){
        if (c.gasolina < limitegasolina){
            View.alarmaGasolinaBaja(c.matricula,c.gasolina);
        }
    }
}
