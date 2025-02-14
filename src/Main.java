public class Main {

    public static void main(String[] args) {

        int variable; // Declaramos la variable anteriormente

        System.out.println("Hello dragon ball"); // Establecemos menaje por pantalla
        personaxesecundario personaxesecundario1=new personaxesecundario();//Declaramos un nuevo personaje llamado mutenroy dentro de personaxesecundario
        personaxesecundario personaxeprincipal= new personaxesecundario("Goku"); //Declaramos un nuevo nombre gracia a la funcion de new string nome dentro de personaxe secundario
        variable = personaxesecundario1.perdervida(15); //Metemos la vida perdida en una variable
        System.out.println("Hola "+personaxesecundario1.nome); //LLamamos al personaje de personaxesecundario
        System.out.println("Vidas personaxesecundario "+personaxesecundario1.vida); //LLamamos unicamente a la vida perdida
        System.out.println("Vidas personaxesecunadario "+variable); //LLamamos a la variable con la vida perdida

        //test 1 mas vida que daño
        personaxesecundario1.setVida(1000);
        int danho = 100;
        int resperada = 900; // Respues esperda de 900
        int vidares = personaxesecundario1.perdervida(danho);
        if (vidares == resperada){
            System.out.println("Test 1: ok");
        }
        else {
            System.out.println("Test 1: fallo");
        }
        //test2 mas daño que vida
        personaxesecundario1.setVida(1000);
        int danho2 = 1100;
        int resperada2 = 0; // Respuesta esperada de 0
        int vidares2 = personaxesecundario1.perdervida(danho2);
        if (vidares2 == resperada2){
            System.out.println("Test 2: ok");
        }
        else {
            System.out.println("Test 2: fallo");
        }

        //test3 Daño negativo desde getVida

        personaxesecundario1.getVida();
        int danho3 =-100;
        int resperada3 = personaxesecundario1.getVida(); // La vida deberia ser 900
        int vidares3 = personaxesecundario1.perdervida(danho3);
        if (vidares3 == resperada3){ //900=900
            System.out.println("Test 3: ok");
        }
        else {
            System.out.println("Test 3: fallo");
        }

        //test4 Daño negativo
        personaxesecundario1.setVida(100);
        int danho4 = -900;
        int resperada4 = 100; //La vida deberia de ser de 100
        int vidares4 = personaxesecundario1.perdervida(danho4);
        if (vidares4 == resperada4){
            System.out.println("Test 4: ok");
        }
        else {
            System.out.println("Test 4: fallo");
        }

        // Test 5: Daño de 0
        personaxesecundario1.setVida(500);

        int danho5 = 0;

        int resperada5 = 500; // La vida debería seguir siendo 500

        int vidares5 = personaxesecundario1.perdervida(danho5);

        if (vidares5 == resperada5) {

            System.out.println("Test 5: ok");

        } else {

            System.out.println("Test 5: fallo");

        }


    }

}
