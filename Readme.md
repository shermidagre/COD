# Flujo de Trabajo con Git y Ramas Colaborativas

Este documento describe un flujo de trabajo en Git utilizando ramas para múltiples colaboradores y la integración de cambios mediante `merge` y `squash`.

#### Tuve que simular el trabajo de merge squash sin ser otro colaborador ya que a estas alturas es un poco dificil jajaj, he buscado comandos y lo he probado, esta interesante

## Inicialización del Repositorio

```bash
git init
```

## Creación de Ramas para Colaboradores

Se crean ramas individuales para cada colaborador y una rama principal de líder:

```bash
git checkout -b colaborador1
git checkout -b colaborador2
git checkout -b lider
```

## Trabajo del Colaborador 1

1. Creación y modificación de un archivo:

```bash
touch archivo1.txt
echo "Cambios del colaborador 1" >> archivo1.txt
```

2. Agregar y confirmar los cambios:

```bash
git add archivo1.txt
git commit -m "Commit del colaborador 1"
```

3. Hacer más cambios y confirmarlos:

```bash
echo "Más cambios del colaborador 1" >> archivo1.txt
git add archivo1.txt
git commit -m "Otro commit del colaborador 1"
```

## Trabajo del Colaborador 2

1. Cambio a la rama del colaborador 2:

```bash
git checkout colaborador2
```

2. Creación y modificación de un archivo:

```bash
touch archivo2.txt
echo "Cambios del colaborador 2" >> archivo2.txt
```

3. Agregar y confirmar los cambios:

```bash
git add archivo2.txt
git commit -m "Commit del colaborador 2"
```

## Integración de Cambios por el Líder

1. Cambio a la rama del líder:

```bash
git checkout lider
```

2. Fusionar los cambios de los colaboradores:

```bash
git merge colaborador1
git merge colaborador2
```

## Uso de `squash` para Mantener un Historial Limpio

1. Creación de una rama para squash:

```bash
git checkout -b lider-squash
```

2. Fusionar con `squash` los cambios de cada colaborador:

```bash
git merge --squash colaborador1
git commit -m "Merge de colaborador 1 con squash"

git merge --squash colaborador2
git commit -m "Merge de colaborador 2 con squash"
```

## Visualización del Historial

Para visualizar el historial de commits en un formato gráfico:

```bash
git log --oneline --graph --all
```

---
Este flujo de trabajo permite organizar y consolidar los cambios de múltiples colaboradores de manera estructurada en Git.

