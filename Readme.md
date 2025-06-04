
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
## Diagrama de Secuencia con Observer EXAMEN

# Pensamiento previo a realizar el examen (2 parte, observer)

### He implementado la misma logica que tenia ya hecha de un observer parecido, so simplemente no hay mucho nad mas que añadir
### Segundo, al fin y al cabo una comparacion en el observerRepostar de que cuando la gasolina es <10 pues manda un mensaje en la view, en este caso no le he pasado parametros de matricula ni gasolina ya que no son pedidos

## Luego cree el marmaid con la logica que tenia ya echa, pero sin poner los otros observers que tenia

# Comprobado todo, y finiquitau, gracias por el gift damian :D

```mermaid
sequenceDiagram
    title Notificación con Observer al Cambiar Velocidad y Gasolina

    participant View
    participant Controller
    participant Model
    participant ObserverRepostar


    View-->>Controller: Selecciona opción "Repostar"
    Controller->>View: Matricula()
    activate View
    View-->>Controller: Devuelve matrícula
    deactivate View

    Controller->>View: gasolinaRepostar()
    activate View
    View-->>Controller: Devuelve cantidad de gasolina
    deactivate View

    Controller->>Model: repostar(matricula, ngasolina)
    activate Model
        Model->>Model: getCoche(matricula)
        Model->>Model: c.gasolina += ngasolina
        Model->>Model: notifyObservers(c)
            Model->>ObserverRepostar: update(c)
                ObserverRepostar->>View: Repostar()
    Model-->>Controller: true
    deactivate Model

    Controller->>View: mostrarGasolina(matricula, gasolina)
    activate View
    View->>View: Muestra nivel de gasolina
    deactivate View
```

## FURRULA :

![Pruebaqueva.png](Pruebaqueva.png)

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

```mermaid
sequenceDiagram
title Notificación con Observer al Cambiar Velocidad y Gasolina

    participant View
    participant Controller
    participant Model
    participant ObserverLimite
    participant ObserverRepostarGasolina

    View->>Controller: Selecciona opción "Aumentar Velocidad"
    Controller->>View: Matricula()
    activate View
    View-->>Controller: Devuelve matrícula
    deactivate View

    Controller->>View: Velocidad()
    activate View
    View-->>Controller: Devuelve cantidad a aumentar
    deactivate View

    Controller->>Model: aumentarVelocidad(matricula, cantidad)
    activate Model
        Model->>Model: getCoche(matricula)
        Model->>Model: c.velocidad += cantidad
        Model->>Model: notifyObservers(c)
            Model->>ObserverLimite: update(c)
                ObserverLimite->>View: alarmaInfraccionVelocidad()
            Model->>ObserverRepostarGasolina: update(c)
                ObserverRepostarGasolina->>View: alarmaGasolinaBaja()
    Model-->>Controller: true
    deactivate Model

    Controller->>View: mostrarVelocidad(matricula, velocidad)
    activate View
    View->>View: Muestra nueva velocidad
    deactivate View


    View->>Controller: Selecciona opción "Repostar"
    Controller->>View: Matricula()
    activate View
    View-->>Controller: Devuelve matrícula
    deactivate View

    Controller->>View: gasolinaRepostar()
    activate View
    View-->>Controller: Devuelve cantidad de gasolina
    deactivate View

    Controller->>Model: repostar(matricula, ngasolina)
    activate Model
        Model->>Model: getCoche(matricula)
        Model->>Model: c.gasolina += ngasolina
        Model->>Model: notifyObservers(c)
            Model->>ObserverRepostarGasolina: update(c)
                ObserverRepostarGasolina->>View: alarmaGasolinaBaja()
            Model->>ObserverLimite: update(c)
                ObserverLimite->>View: alarmaInfraccionVelocidad()
    Model-->>Controller: true
    deactivate Model

    Controller->>View: mostrarGasolina(matricula, gasolina)
    activate View
    View->>View: Muestra nivel de gasolina
    deactivate View

```