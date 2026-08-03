import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        //Instanciamos el objeto clase minheap
        MinHeap heap = new MinHeap();
        //Instanciamos el scanner para las entradas
        Scanner scanner = new Scanner(System.in);
        //Variable para controlar el menú y la opción, inicializada en -1 para evitar errores
        int opcion = -1;


        System.out.println("==============================================");
        System.out.println("       SISTEMA DE MIN-HEAP (MONTÍCULO)        ");
        System.out.println("==============================================");

        while (opcion != 0) {  //ciclo que se repetira con el menú hasta que eligan salir que es el 0
            menu(); //llamamos al menú
            //Pedimos al usuario un número
            System.out.print("Seleccione una opción: ");
            try {
                opcion = Integer.parseInt(scanner.nextLine());
            } catch (NumberFormatException e) {
                System.out.println("\n Error: Por favor ingrese un número válido.");
                continue;
            }

            //Hacemos al validación de la opción
            switch (opcion) {
                case 1: //INSERTAR
                    //solicitamos el dato a ingresar
                    System.out.print("\nIngrese el valor a insertar: ");
                    try {
                        int valor = Integer.parseInt(scanner.nextLine());
                        heap.insertar(valor); //llamamos a la función de insertar definida en el minheap
                        System.out.println("Valor " + valor + " insertado correctamente.");
                    } catch (NumberFormatException e) {
                        System.out.println(" Error: Debe ingresar un número entero.");
                    }
                    break;

                case 2: //Eliminar la cima
                    Integer min = heap.eliminarMin(); //llamamos al función de eliminarMin que nos eliminaba el primer valor/cima
                    if (min != null) {
                        System.out.println("\n Mínimo eliminado (cima): " + min);
                    } else {
                        System.out.println("\n El montículo está vacío.");
                    }
                    break;

                case 3: //Nos permite ver el número que está en la cima
                    Integer cima = heap.peek(); //llamamos nuestra función peek
                    if (cima != null) {
                        System.out.println("\n Cima actual: " + cima);
                    } else {
                        System.out.println("\n El montículo está vacío.");
                    }
                    break;

                case 4: //Nos permite hacer la función del heapify que era que de una serie de números que nos dan cree una nueva lista y los ordene
                    System.out.print("\nIngrese valores enteros separados por comas (ej: 9,3,7,1): ");
                    String entrada = scanner.nextLine();
                    String[] partes = entrada.split(","); //dividimos la entrada que nos dan dividida por comas (ya que tiene todo junto) en un array llamado partes
                    List<Integer> lista = new ArrayList<>(); //Creamos la lista temporal donde se van a acumular los enteros convertidos
                    try {
                        for (String p : partes) {
                            lista.add(Integer.parseInt(p.trim())); //añadimos cada elemento de la lista "partes" en en array "lista" que es el temporal
                        }
                        heap.heapify(lista); //llamamos nuestra función heapify enviandole la nueva lista de números temporal
                        System.out.println(" Arreglo transformado a MinHeap con éxito.");
                    } catch (NumberFormatException e) {
                        System.out.println(" Error: Asegúrese de ingresar solo números separados por comas.");
                    }
                    break;

                case 5: //imprimimos el monticulo completo
                    System.out.println();
                    heap.mostrarMonticulo();
                    break;

                case 0:
                    System.out.println("\n ¡Saliendo del programa! Hasta luego.");
                    break;

                default:
                    System.out.println("\n Opcion inválida. Por favor intente de nuevo.");
            }
        }
        scanner.close();
    }

    //Imprimir el Menu
    private static void menu() {
        System.out.println("\n---------------- MENU ----------------");
        System.out.println("1. Insertar elemento");
        System.out.println("2. Eliminar valor mínimo (eliminarMin)");
        System.out.println("3. Ver valor mínimo/cima (peek)");
        System.out.println("4. Cargar y ordenar un arreglo (heapify)");
        System.out.println("5. Mostrar estado del MinHeap");
        System.out.println("0. Salir");
        System.out.println("--------------------------------------");
    }
}