
# Pensamiento previo a realizar el examen

### La verdad simplemente he pensado en implementar el avanzar igual al que subir de velocidad ya que es lo mismo porque estas añadiendo por lo cual, este sigue la misma estructura
### Segundo, al fin y al cabo la gasolina va de la misma manera ya que la estas subiendo al repostar 

## Para la funcion de avanzar sigue todo igual, simplemente utilizo el view.matricula y el view.metrosRecorridos
## La funcion repostar solo pide la matricula y la gasolina a repostar y , a este metodo tambien le añadi el coger la gasolina dle model para asi poder realizar lo de bajar la gasolina en funcion a los metros recorridos

## Añadi todo al menu con sus opciones , al fin y al cabo fue todo seguir la misma estructura que tenian los otros metodos

# Comprobado todo, :D


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

## Diagrama de Secuencia con Observer
