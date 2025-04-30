import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class TestModel {

    @BeforeEach
    public void setUp() {
        Model.parking.clear(); // Limpiar entre tests
    }

    @Test
    public void testCrearCocheCorrectamente() {
        Coche coche = Model.crearCoche("Toyota", "ABC123");
        assertTrue(Model.parking.contains(coche));
        assertEquals("Toyota", coche.modelo);
        assertEquals("ABC123", coche.matricula);
        assertEquals(0, coche.velocidad);
    }

    @Test
    public void testNoAgregarDosCochesConMismaMatricula() {
        Model.crearCoche("Toyota", "XYZ789");

        assertThrows(IllegalArgumentException.class, () -> {
            Model.crearCoche("Nissan", "XYZ789");
        });

        assertEquals(1, Model.parking.size());
    }

    @Test
    public void testCambiarVelocidadCocheExistente() {
        Model.crearCoche("LaFerrari", "SBC1234");
        int nuevaVelocidad = Model.cambiarVelocidad("SBC1234", 60);
        assertEquals(60, nuevaVelocidad);
        assertEquals(60, Model.getVelocidad("SBC1234"));
    }

    @Test
    public void testBuscarCochePorMatriculaInvalida() {
        Coche coche = Model.getCoche("INVALIDA");
        assertNull(coche);
    }
}