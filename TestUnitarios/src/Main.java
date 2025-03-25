import java.util.Scanner;


public class Main {

    private static final float PRECIO_CAFE = 0.50f; // Precio en euros

    private static final float PRECIO_CHOCOLATE = 0.60f;

    private static final float PRECIO_TE = 0.30f;

    public static int azucar = 0; // Azúcar inicial


    public static void main(String[] args) {

        System.out.println("Bienvenido a la cafetería!");

        System.out.println("Estos son los precios de nuestros productos:");

        precios();



        float dinero = solicitarDinero();

        if (dinero < PRECIO_CAFE) {

            System.out.println("No tienes suficiente dinero para comprar un producto.");

            return;

        }


        int productoSeleccionado = seleccionarProducto();

        if (productoSeleccionado == -1) {

            System.out.println("Selección de producto inválida.");

            return;

        }


        procesoAzucar();

        float cambio = calcularCambio(dinero, productoSeleccionado);

        if (cambio >= 0) {

            System.out.println("Disfruta tu bebida!");

            System.out.printf("La vuelta es de: %.2f euros%n", cambio);

        } else {

            System.out.println("No tienes suficiente dinero para este producto.");

        }


        colocacionVaso();

    }


    static float solicitarDinero() {

        Scanner sc = new Scanner(System.in);

        System.out.print("Introduce el dinero: ");

        return sc.nextFloat();

    }


    static void precios() {

        System.out.println("Precio café: 0.50 euros");

        System.out.println("Precio chocolate: 0.60 euros");

        System.out.println("Precio té: 0.30 euros");

    }


    static int seleccionarProducto() {

        Scanner sc = new Scanner(System.in);

        System.out.println("Selecciona el producto: café(1), chocolate(2), té(3)");

        int result = sc.nextInt();

        return (result >= 1 && result <= 3) ? result : -1; // Retorna -1 si la selección es inválida

    }


    static int procesoAzucar() {

        Scanner sc = new Scanner(System.in);

        System.out.println("Si quieres menos azúcar pulsa (3), si quieres más azúcar pulsa (2), si no quieres azúcar pulsa (1)");

        int result = sc.nextInt();

        switch (result) {

            case 1:

                azucar = 0;

                break;

            case 2:

                azucar += 1; // Incrementar azúcar

                break;

            case 3:

                azucar = Math.max(0, azucar - 1); // Decrementar azúcar, asegurando que no sea negativo

                break;

            default:

                System.out.println("Opción no válida, no se modificará el azúcar.");

        }

        return azucar; // Devolver el nivel de azúcar

    }


    static float calcularCambio(float dinero, int producto) {

        float precioProducto = 0;

        switch (producto) {

            case 1:

                precioProducto = PRECIO_CAFE;

                break;

            case 2:

                precioProducto = PRECIO_CHOCOLATE;

                break;

            case 3:

                precioProducto = PRECIO_TE;

                break;

        }

        return dinero - precioProducto; // Retorna el cambio

    }


    static void colocacionVaso() {

        // Implementa la lógica para la colocación del vaso aquí

        System.out.println("Colocando el vaso...");

    }

    public static void simularEntrada(int input) {
        
    }
}
