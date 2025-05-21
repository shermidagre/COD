# Arquitectura MVC

Aplicación que trabaja con objetos coches, modifica la velocidad y la muestra

---
## Diagrama de clases:

```mermaid
classDiagram
    class Coche {
        -String matricula
        -String modelo
        -int velocidad
        +Coche(String modelo, String matricula)
    }

    class Model {
        -ArrayList<Coche> parking
        +crearCoche(String modelo, String matricula) : Coche
        +getCoche(String matricula) : Coche
        +cambiarVelocidad(String matricula, int nuevaVelocidad) : boolean
        +aumentarVelocidad(String matricula, int cantidad) : boolean
        +disminuirVelocidad(String matricula, int cantidad) : boolean
        +getVelocidad(String matricula) : Integer
        +getCochePorMatricula(String matricula) : Coche
    }

    class Controller {
        +static crearCoche() : String
        +static aumentarVelocidad()
        +static disminuirVelocidad()
        +static cambiarVelocidad()
        +static mostrarCoches()
        +static mostrarCocheIndividual()
    }

    class View {
        +static Scanner sc
        +static menu()
        +static Matricula() : String
        +static Modelo() : String
        +static Velocidad() : int
        +static mostrarVelocidad(String, int)
        +static mostrarMensaje(String)
        +static mostrarError(String)
        +static mostrarCocheIndividual(Coche)
        +static mostrarListaCoches(ArrayList<Coche>)
    }

    Coche "1" <-- "1..n" Model : está en
    Controller --> Model : usa
    Controller --> View : usa
      
```

---

## Diagrama de Secuencia


```mermaid
sequenceDiagram
participant View
participant Controller
participant Model

    View->>Controller: Selecciona opcion 3
    Controller->>View: Modelo()
    activate View
    View-->>Controller: Devuelve el modelo
    deactivate View
    
    Controller->>View: Matricula()
    activate View
    View-->>Controller: Devuelve la matricula
    deactivate View
    
    Controller->>Model: crearCoche(modelo, matricula)
    activate Model
    Model->>Model: parking.add(coche)
    Model-->>Controller: Coche creado !!
    deactivate Model
    
    Controller->>View: Devuelve la matricula
    activate View
    View->>View: muestra mensaje y vuelve al menú
    deactivate View
    
    View->>Controller: Selecciona opcion 4
    Controller->>Model: Model.parking
    activate Model
    Model-->>Controller: Devuelve la lista de coches
    deactivate Model
    Controller-->>View: mostrarListaCoches(lista)
    activate View
    alt En caso de que no haya coches en el parking
    View->>View: Manda mensaje de que no hay coches
    else 
        loop mostrarListaCoches(ArrayList<Coche> lista) 
            View->>View: mostrarcocheindividual(c)
        end
        end
    deactivate View
    
    
```
