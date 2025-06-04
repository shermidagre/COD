public class ObserverRepostarGasolina {
    final static int limitegasolina = 10;

    public static void update(Coche c){
        if (c.gasolina < limitegasolina){
            View.alarmaGasolinaBaja(c.matricula,c.gasolina);
        }
    }
}
