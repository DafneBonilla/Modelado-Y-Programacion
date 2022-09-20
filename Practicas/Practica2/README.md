# **Práctica 2** 🤖🍔

**Equipo: Los Peaky Blinders**

319089660 - Bonilla Reyes Dafne

319053315 - Castañón Maldonado Carlos Emilio

319210536 - García Ponce José Camilo

---

## **Uso**

- Compilar desde `src/`:

```
javac *.java Dishes/*.java Menus/*.java Robots/*.java
```

- Correr desde `src/`:

```
java Practica2 <nombre>
```

- Generar documentación desde `src/`:

```
javadoc -d docs *.java Dishes/*.java Menus/*.java Robots/*.java
```

## **- Explicación**

<div align="justify">
Para iniciar el programa, primero es necesario compilar y ejecutar el programa escribiendo el nombre del cliente después de Practica2/. Después, los pasos para ordenar un platillo son los siguientes:

1. Se activa al robot.
2. Se pone a caminar al robot.
3. Se pide que se atienda al cliente.
4. Si es necesario se pide el menú.
5. Se pide que se atienda para poder ordenar.
6. Se manda a cocinar al robot.
7. Se pone a cocinar al robot.
8. Se pide que se entregue la comida.
   
Si se quiere generar la documentación, esto sería con el comando dado arriba, y luego, los archivos se generarán en el directorio llamado docs.
</div>

----------------------------------------------------------------

## **- Implementación**

<div align="justify">
Para poder facilitar la forma en la que se muestra el menú al cliente, elegimos usar el patrón de Iterator. Después, en la parte de las hamburguesas usamos el patrón Template para así poder hacer que ciertas hamburguesas hagan ciertos pasos (principalmente cocinar la carne) de la mejor manera.

Por último, usamos State para que el robot tenga la capacidad de poder hacer las mismas acciones, pero de maneras diferentes dependiendo del punto de la ejecución en el que se encuentre.

Además, para la parte del menú de opciones, intentamos ponerlas en un orden lógico, sin embargo, hay
una en particular que quedó extraña: mostrar menú.
</div>
