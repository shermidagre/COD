public class ObserverRepostar {
    final static int limitegasolina = 10;

    public static void update(Coche c){
        if (c.gasolina < limitegasolina){
            View.Repostar();
        }
    }
}
