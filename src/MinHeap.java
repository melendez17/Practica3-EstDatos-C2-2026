import java.util.ArrayList;
import java.util.List;

public class MinHeap {
    private ArrayList<Integer> monticulo; //El "array" o lista que nos va a permitir guardar los números, es decir esté va a ser nuestro monticulo, por eso le pongo de nombre monticulo

    //Constructor
    public MinHeap() {
        this.monticulo = new ArrayList<>();
    }

    //"Getters" específicos segun las operaciones que necesitamos
    //Segun las formulas dadas en las instrucciones de esta manera podemos averiguar el indice del padre
    private int getPadre(int i) {
        return (i - 1) / 2;
    }

    //Segun las formulas, con este averiguamos el indice del hijo izquierdo
    private int getHijoIzquierdo(int i) {
        return 2 * i + 1;
    }

    //Segun las formulas, con este averiguamos el indice del hijo derecho
    private int getHijoDerecho(int i) {
        return 2 * i + 2;
    }

    private void intercambiar(int i, int j) {
        //primero guardamos temporalmente el valor que hay en i
        int temp = monticulo.get(i);
        //intercambiamos el valor que hay en i con el que hay en j
        monticulo.set(i, monticulo.get(j));
        //a j ahora le asignamos el valor temporal que era i
        monticulo.set(j, temp);
    }

    // Métodos Principales del MinHeap
    public void insertar(int valor) {
        //primero lo agregamos al final de la lista
        monticulo.add(valor);
        //hacemos el llamado al upheapify
        upHeapify(monticulo.size() - 1); //le enviamos a upheapify que es recursivo el último valor que tenemos (el que acabamos de ingresar) para que lo ordene haciendolo subir
    }

    //La función peek nos va a dar el valor que esté arriba arriba del monticulo
    public Integer peek() {
        if (monticulo.isEmpty()) { //primero validamos que el monticulo contenga elementos
            return null; //si está vacía, tira null
        }
        return monticulo.get(0); //Si no estaba vacía, vamos a devolver el elemento que esté en la cima que es la posición 0 en este caso
    }
    //Eliminar el elemento que esté en la cima (que es el valor mínimo)
    public Integer eliminarMin() {
        //Validamos que no esté vacío
        if (monticulo.isEmpty()) {
            return null;
        }

        //Capturamos el valor mínimo osea el que está en la cima y lo guardamos en min
        int min = monticulo.get(0);
        //Eliminamos el último valor de la lista y lo almacenamos temporalmente en la variable ultimoElemento
        int ultimoElemento = monticulo.remove(monticulo.size() - 1);

        //Verificamos que la lista no quede vacía
        if (!monticulo.isEmpty()) {
            monticulo.set(0, ultimoElemento); //en la cima vamos a poner el último valor que había
            downHeapify(0); //Reorganizamos la estructura pero desde la cima hasta abajo con el downheapify
        }

        return min; //Devolvemos el valor que eliminamos

        //De esta manera eliminamos el valor minimo que era el que estaba en la cima, en la posición 0 para posteriormente poner el último elemento de la lista de primero, y luego reordenarlos.
    }

    //Es reemplazar cualquier cosa que tengamos por una lista nueva que nos ingresen como parametro y además ordenarla
    public void heapify(List<Integer> lista) {
        this.monticulo = new ArrayList<>(lista);
        // Se aplica downHeapify recursivo desde el último nodo hacia la cima
        for (int i = (monticulo.size() / 2) - 1; i >= 0; i--) {
            downHeapify(i);
        }
    }

    // Reorganizamos el arbol pero ya no de arriba a abajo sino ahora de abajo hacia arriba, lo que esté de último vamos a ver hasta donde puede/debe escalar
    private void upHeapify(int i) {
        //Primero comprobamos que el valor que estamos intentando subir no sea la cima, es decir que sea mayor que 0, de lo contrario ya estaría arriba y que el elemento que estamos recibiendo como i sea menor que el padre para que cumpla con el minheap, de lo contrario no debería subir
        if (i > 0 && monticulo.get(i) < monticulo.get(getPadre(i))) { //Si la condición se cumple:
            intercambiar(i, getPadre(i)); //Vamos a hacer el intercambio entre i y su padre
            upHeapify(getPadre(i)); //Hacemos la función recursiva pero ahora con el padre (que sería el valor inicial, solo que ya lo subimos/intercambiamos) para ver si necesita seguir subiendo
        }
    }

    //Reorganizamos pero ahora de abajo a arriba
    private void downHeapify(int i) { //i como el nodo que se va a evaluar
        int menor = i; //Asumimos que i es el más pequeño y lo guardamnos en menor
        int izq = getHijoIzquierdo(i); //Obtenemos el hijo izquierdo
        int der = getHijoDerecho(i); //Obtenemos el hijo derecho

        // Si el hijo izquierdo existe y su valor es menor que el actual elemento menor
        if (izq < monticulo.size() && monticulo.get(izq) < monticulo.get(menor)) {
            // Actualizamos el índice del menor para apuntar al hijo izquierdo
            menor = izq;
        }

        // Si el hijo derecho existe y su valor es menor que el actual elemento menor
        if (der < monticulo.size() && monticulo.get(der) < monticulo.get(menor)) {
            // Actualizamos el índice del menor para apuntar al hijo izquierdo
            menor = der;
        }

        // Si el menor de los tres nodos no es el nodo inicial 'i'
        if (menor != i) {
            // Intercambia el nodo actual con el hijo de menor valor
            intercambiar(i, menor);
            // Llamada recursiva con el nuevo índice del hijo intercambiado
            downHeapify(menor);
        }
    }

    //Imprimimos el monticulo
    public void mostrarMonticulo() {
        System.out.println("Estado actual del MinHeap: " + monticulo);
    }
}