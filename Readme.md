# Arquitectura MVC

Aplicación que trabaja con objetos coches, modifica la velocidad y la muestra

---
## Diagrama de clases:

```mermaid
classDiagram
    class Coche {
        String: matricula
        String: modelo
        Integer: velocidad
    }
      class Controller{
          +main()
      }
      class View {+muestraVelocidad(String, Integer)}
      class Model {
          ArrayList~Coche~: parking
          +crearCoche(String, String, String)
          +getCoche(String)
          +cambiarVelocidad(String, Integer)
          +getVelocidad(String)
      }
    Controller "1" *-- "1" Model : association
    Controller "1" *-- "1" View : association
    Model "1" *-- "1..n" Coche : association
      
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
    Controller-->View: mostrarListaCoches(lista)
    activate View
    alt En caso de que no haya coches en el parking
    View->>View: Manda mensaje de que no hay coches
    else 
        loop mostrarListaCoches(ArrayList<Coche> lista) 
            View->>View: mostrarcocheindividual(c)
        end
        end
    
    
    
```
