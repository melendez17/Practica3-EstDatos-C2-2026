# Aplicación del Min Heap en el algoritmo de Dijkstra

El **algoritmo de Dijkstra** es uno de los algoritmos más utilizados para encontrar el camino más corto desde un nodo origen hacia todos los demás nodos de un grafo cuyos pesos son no negativos.

Durante su ejecución, el algoritmo necesita seleccionar constantemente el nodo pendiente con la **menor distancia conocida**. Es aquí donde entra esta nueva estructura que conocí en este proyecto, ya que para realizar esta operación de manera eficiente, se utiliza una estructura de datos denominada **Min Heap (Montículo Mínimo)**, la cual mantiene siempre el elemento de menor prioridad en la raíz.

## Por qué o donde se utiliza un Min Heap?

Sin un Min Heap, el algoritmo tendría que recorrer toda la colección de nodos pendientes para encontrar cuál posee la distancia más pequeña, lo que implica un mayor costo computacional.

Al utilizar un Min Heap:

- El nodo con la menor distancia siempre se encuentra en la raíz.
- Obtener el siguiente nodo a procesar es mucho más eficiente.
- La estructura se reorganiza automáticamente cada vez que se inserta o elimina un elemento.

Esta implementación del Min Heap proporciona las operaciones necesarias para mantener organizada la cola de prioridad utilizada por el algoritmo de Dijkstra.

| Método | Descripción |
|---------|-------------|
| `insertar()` | Inserta un nuevo elemento en el montículo y ejecuta `upHeapify()` para mantener la propiedad del Min Heap. |
| `eliminarMin()` | Extrae el elemento con menor prioridad (la raíz) y ejecuta `downHeapify()` para reorganizar el montículo. |
| `peek()` | Permite consultar el elemento mínimo sin eliminarlo. |
| `heapify)` | Convierte una colección de datos en un Min Heap válido. |
| `upHeapify()` | Reubica un elemento hacia arriba cuando su prioridad es menor que la de su padre. |
| `downHeapify()` | Reubica un elemento hacia abajo cuando la propiedad del Min Heap deja de cumplirse después de una eliminación. |

## Cómo funciona?

Supongamos que las distancias conocidas son:

| Nodo | Distancia |
|------|----------:|
| A | 0 |
| B | 8 |
| C | 3 |
| D | 15 |
| E | 6 |

Estas distancias pueden organizarse en un Min Heap como el siguiente:

```text
          C(3)
         /    \
      E(6)    B(8)
      /
   D(15)
```

Como el nodo con menor distancia siempre se encuentra en la raíz, el algoritmo de Dijkstra puede seleccionarlo inmediatamente para procesarlo con solo llamar el peek() o eliminando el primero o mínimo 

Cada vez que se encuentra un camino más corto hacia un nodo:

1. Se actualiza su distancia.
2. El nodo se reorganiza dentro del Min Heap mediante `upHeapify()`.
3. El siguiente nodo a procesar siempre será el que tenga la menor distancia.

Cuando se elimina el nodo mínimo, el último elemento ocupa temporalmente la raíz y `downHeapify()` reorganiza nuevamente el montículo para conservar la propiedad del Min Heap.

El uso de un Min Heap mejora significativamente la eficiencia del algoritmo de Dijkstra, ya que evita realizar una búsqueda lineal del nodo con la menor distancia en cada iteración.

Gracias a esta estructura, las operaciones de inserción, eliminación y reorganización son eficientes, permitiendo que el algoritmo resuelva problemas de rutas y caminos mínimos incluso en grafos de gran tamaño.
