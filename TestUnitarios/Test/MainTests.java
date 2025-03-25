
import static org.junit.jupiter.api.Assertions.assertEquals;


import org.junit.jupiter.api.DisplayName;

import org.junit.jupiter.api.Test;

import org.junit.jupiter.params.ParameterizedTest;

import org.junit.jupiter.params.provider.CsvSource;


class MainTests {


    @Test

    @DisplayName("Calcular cambio con suficiente dinero para café")

    void testCalcularCambioCafe() {

        float dinero = 1.00f; // 1 euro

        int producto = 1; // Café

        float expectedCambio = 0.50f; // 1.00 - 0.50

        assertEquals(expectedCambio, Main.calcularCambio(dinero, producto), "El cambio debe ser 0.50 euros");

    }


    @Test

    @DisplayName("Calcular cambio con suficiente dinero para chocolate")

    void testCalcularCambioChocolate() {

        float dinero = 1.00f; // 1 euro

        int producto = 2; // Chocolate

        float expectedCambio = 0.40f; // 1.00 - 0.60

        assertEquals(expectedCambio, Main.calcularCambio(dinero, producto), "El cambio debe ser 0.40 euros");

    }


    @Test

    @DisplayName("Calcular cambio con suficiente dinero para té")

    void testCalcularCambioTe() {

        float dinero = 0.50f; // 50 centavos

        int producto = 3; // Té

        float expectedCambio = 0.20f; // 0.50 - 0.30

        assertEquals(expectedCambio, Main.calcularCambio(dinero, producto), "El cambio debe ser 0.20 euros");

    }


    @ParameterizedTest(name = "Ajustar azúcar: {0} -> {1}")

    @CsvSource({

            "1, 0", // No azúcar

            "2, 1", // Más azúcar

            "3, 0"  // Menos azúcar

    })

    void testProcesoAzucar(int input, int expectedAzucar) {

        Main.azucar = 0; // Reiniciar el nivel de azúcar antes de la prueba

        // Simular la entrada del usuario

        Main.simularEntrada(input);

        assertEquals(expectedAzucar, Main.procesoAzucar(), "El nivel de azúcar debe ser " + expectedAzucar);

    }

}