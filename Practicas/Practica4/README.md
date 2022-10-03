# **Práctica 4** 🚀🛸

**Equipo: Los Peaky Blinders**

319089660 - Bonilla Reyes Dafne

319053315 - Castañón Maldonado Carlos Emilio

319210536 - García Ponce José Camilo

---

## **Uso**

- Compilar desde `src/`:

```
javac *.java Ships/*.java ShipComponents/*.java ShipComponents/ShipComponentsFactory/*.java
```

- Correr desde `src/`:

```
java Practica4
```

- Generar documentación desde `src/`:

```
javadoc -d docs *.java Ships/*.java ShipComponents/*.java ShipComponents/ShipComponentsFactory/*.java
```

## **- Explicación**

<div align="justify">
Para iniciar el programa, primero es necesario compilar y ejecutar el programa. Después, los pasos para ordenar se mostrarán en terminal. 
        
Si se quiere generar la documentación, esto sería con el comando dado arriba, y luego, los archivos se generarán en el directorio llamado docs.
</div>

---

## **- Implementación**

<div align="justify">
Para este proyecto decidimos usar los tres patrones de diseño, para (en nuestra opinión) facilitar como funcionan las cosas. 
Empecemos con Abstract Factory, usamos este patrón para poder crear fabricas para cada tipo de componente que tienen las naves, como hay varios tipos de componentes, y cada uno con diferentes versiones, pensamos que usar este patrón seria la mejor opción para así poder solo crear fabricas de cada tipo de componente y faciliar crearlos componentes que ya están definidos como se crean. 
Luego usamos Builder para poder construir las naves dependiendo de lo que los clientes quieran, elegimos este patrón ya que nos da la posibilidad de crear las naves por pasos, y así podemos preguntarle al cliente como quiere se cree su nave paso por paso. Además nuestros builders para las naves tienen un atributo de fabrica de componentes para poder construir los componentes que quiera el cliente. 
Y por ultimo usamos Factory para poder facilitarnos la creación de las naves del catalogo. Esto ya que, las naves del catalogo siempre serán las mismas, es decir, ya tenemos unos pasos para crearlas igual, por lo tanto decidimos que estas fabricas tuvieran un atributo de un constructor de naves, con lo cual podemos fabricar toda la nave con un solo método y sabemos que siempre saldrán naves iguales o ya predefinidas.

</div>
