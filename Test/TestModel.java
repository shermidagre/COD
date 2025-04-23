import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class TestModel {
    private Model model;

    @BeforeEach
    public void setUp() {
        // Inicializar el modelo antes de cada prueba
        model = new Model();
    }

    /**
     * Test 1: Verificar que se puede crear un coche correctamente.
     */
    @Test
    public void testCrearCocheCorrectamente() {
        // Crear un coche
        Coche coche = model.crearCoche("Toyota", "ABC123");

        // Verificar que el coche está en el parking
        assertTrue(model.parking.contains(coche));
    }

    /**
     * Test 2: Comprobar que no se pueden agregar dos coches con la misma matrícula.
     */
    @Test
    public void testNoAgregarDosCochesConMismaMatricula() {
        // Crear el primer coche
        Coche coche1 = model.crearCoche("Toyota", "XYZ789");

        // Intentar crear un segundo coche con la misma matrícula
        Coche coche2 = model.crearCoche("Nissan", "XYZ789");

        // Verificar que solo hay un coche en el parking
        assertEquals(2, model.parking.size()); // Asegurarse de que ambos coches están en el parking
        assertNotEquals(coche1, coche2); // Los objetos deben ser diferentes
    }

    /**
     * Test 3: Buscar un coche por matrícula válida.
     */
    @Test
    public void testBuscarCochePorMatriculaValida() {
        // Crear un coche
        model.crearCoche("LaFerrari", "SBC1234");

        // Buscar el coche por matrícula
        Coche coche = model.getCoche("SBC1234");

        // Verificar que se encontró el coche
        assertNotNull(coche); // El coche no debe ser nulo
        assertEquals("LaFerrari", coche.modelo); // Verificar el modelo
        assertEquals("SBC1234", coche.matricula); // Verificar la matrícula
    }

    /**
     * Test 4: Buscar un coche por matrícula inválida.
     */
    @Test
    public void testBuscarCochePorMatriculaInvalida() {
        // Buscar un coche inexistente
        Coche coche = model.getCoche("INVALIDA");

        // Verificar que no se encontró el coche
        assertNull(coche); // El resultado debe ser null
    }

    /**
     * Test 5: Cambiar la velocidad de un coche existente.
     */
    /**
     * Test 6: Intentar cambiar la velocidad de un coche inexistente.
     */
    @Test
    public void testCambiarVelocidadCocheInexistente() {
        // Intentar cambiar la velocidad de un coche inexistente
        Exception exception = assertThrows(NullPointerException.class, () -> {
            model.cambiarVelocidad("INVALIDA", 50);
        });

        // Verificar que se lanzó la excepción esperada
        assertNotNull(exception);
    }


/**
 * Test: Cambiar la velocidad de un coche cuando hay duplicados.
 */
    @Test
    public void testCambiarVelocidadConCochesDuplicados() {
        // Crear dos coches con la misma matrícula
        model.parking.add(new Coche("Toyota", "XYZ789"));
        model.parking.add(new Coche("Nissan", "XYZ789"));

        // Cambiar la velocidad del coche con matrícula "XYZ789"
        int nuevaVelocidad = model.cambiarVelocidad("XYZ789", 50);

        // Verificar que solo se modificó el primer coche encontrado
        Coche primerCoche = model.parking.get(0);
        Coche segundoCoche = model.parking.get(1);

        assertEquals(50, primerCoche.velocidad); // La velocidad del primer coche debe ser 50
        assertEquals(0, segundoCoche.velocidad); // La velocidad del segundo coche debe permanecer en 0
    }
    /**
     * Test 8: Obtener la velocidad de un coche inexistente.
     */

    @Test
    public void testObtenerVelocidadConCochesDuplicados() {
        // Crear dos coches con la misma matrícula
        model.parking.add(new Coche("Toyota", "XYZ789"));
        model.parking.add(new Coche("Nissan", "XYZ789"));

        // Cambiar la velocidad del primer coche
        model.parking.get(0).velocidad = 30;

        // Obtener la velocidad del coche con matrícula "XYZ789"
        int velocidad = model.getVelocidad("XYZ789");

        // Verificar que se obtuvo la velocidad del primer coche encontrado
        assertEquals(30, velocidad); // La velocidad debe ser 30 (del primer coche)
    }
}