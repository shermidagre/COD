public class Main {

    public static void main(String[] args) {

        PersonajeDragonBall goku = new PersonajeDragonBall("Goku", 100, 500);

        goku.realizarAtaqueEspecial();

        goku.aumentarEnergia(50);

        goku.cambiarTransformacion("Super Saiyan");

        System.out.println(goku);

        System.out.println("Hello dragon ball");
        personaxesecundario personaxesecundario1=new personaxesecundario();
        System.out.println("Hola"+personaxesecundario1.nome);

    }

}
class PersonajeDragonBall {

    private String nombre;

    private int poderAtaque;

    private int nivelEnergia;

    private String transformacion;


    public PersonajeDragonBall(String nombre, int poderAtaque, int nivelEnergia) {

        this.nombre = nombre;

        this.poderAtaque = poderAtaque;

        this.nivelEnergia = nivelEnergia;

        this.transformacion = "Normal";

    }


    public void realizarAtaqueEspecial() {

        System.out.println(nombre + " realiza un ataque especial con poder de ataque: " + poderAtaque * 2);

    }


    public void aumentarEnergia(int cantidad) {

        nivelEnergia += cantidad;

        System.out.println(nombre + " ha aumentado su nivel de energía a: " + nivelEnergia);

    }


    public void cambiarTransformacion(String nuevaTransformacion) {

        transformacion = nuevaTransformacion;

        System.out.println(nombre + " se ha transformado en: " + transformacion);

    }


    @Override

    public String toString() {

        return "Personaje: " + nombre + ", Poder de Ataque: " + poderAtaque + ", Nivel de Energía: " + nivelEnergia + ", Transformación: " + transformacion;

    }

}