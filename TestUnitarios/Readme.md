# Cafetería - Proyecto de Simulación


Este proyecto es una simulación de una cafetería que permite a los usuarios seleccionar productos, ajustar la cantidad de azúcar y calcular el cambio. La aplicación está diseñada para ser interactiva y fácil de usar.


## Estructura del Proyecto


El proyecto está organizado de la siguiente manera:


## Funcionalidades


- **Selección de Productos**: Los usuarios pueden elegir entre café, chocolate y té.

- **Ajuste de Azúcar**: Los usuarios pueden ajustar la cantidad de azúcar en su bebida.

- **Cálculo de Cambio**: La aplicación calcula el cambio que se debe devolver al usuario.


## Pruebas


Se han implementado pruebas unitarias para asegurar que la lógica de la aplicación funcione correctamente. Las pruebas se encuentran en la clase `MainTests.java` y cubren los siguientes aspectos:


1. **Cálculo de Cambio**: Se verifican los métodos que calculan el cambio devuelto al usuario según el producto seleccionado y el dinero ingresado.

2. **Ajuste de Azúcar**: Se prueban los métodos que permiten ajustar la cantidad de azúcar en la bebida, asegurando que el nivel de azúcar se modifique correctamente según la entrada del usuario.


### Razones para Implementar Pruebas


- **Verificación de Funcionalidad**: Las pruebas aseguran que cada método de la clase `Main` funcione como se espera, lo que ayuda a identificar errores y comportamientos inesperados.

- **Facilidad de Mantenimiento**: Al tener pruebas automatizadas, es más fácil realizar cambios en el código sin temor a romper funcionalidades existentes. Las pruebas pueden ejecutarse después de cada cambio para verificar que todo siga funcionando correctamente.

- **Documentación del Comportamiento**: Las pruebas actúan como una forma de documentación del comportamiento esperado de la aplicación. Cualquier desarrollador que lea las pruebas puede entender rápidamente cómo se espera que funcione la aplicación.
