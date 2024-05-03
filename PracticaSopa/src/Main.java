import java.util.ArrayList;
import java.util.Scanner;

public class Main {
    //se crea un objeto de la clase Scanner statico para poder ser usado en todas las funciones
    static Scanner sc = new Scanner(System.in);

  //en el main invocamos a la función menu la cual permite ejecutar el codigo
    public static void main(String[] args) {
        menu();
    }

    //función menu
    private static void menu() {
        //se muestra el menú principal, el cual permite seleccionar si se desea personalizar la sopa de letras o seleccionar un nivel de dificultad
            System.out.println("¿Deseas hacer tu sopa de letras personalizada? \n 1. Si \n 2. No");
            int opcionPersonalizar = sc.nextInt();
            //se valida que la opción ingresada sea valida
            opcionPersonalizar = opcionPvalida(opcionPersonalizar);
            //si la opción es 1 se llama a la función de personalizar, si es 2 se llama a la función de nivel
            if(opcionPersonalizar == 1) {
                crearsopaPersonalizada();
            }else if (opcionPersonalizar == 2){
                crearsopaNivel();
            }
    }
    //función que permite personalizar la sopa de letras
    private static void crearsopaPersonalizada() {
        System.out.println("Ingresa el tamaño de tu sopa de letras n*n: ");
        int tamano = sc.nextInt();
        System.out.println("¿Cuántas palabras deseas ingresar?");
        int cantidad = sc.nextInt();
        //valida que la cantidad de palabras sea acorde al tamaño ingresado
        cantidad = cantidadValida(cantidad, tamano);
        //llama a la clase facil para inicializarla
        Personalizado listaPersonalizada = new Personalizado(tamano , cantidad);
        //llena un arreglo con el arreglo retornado de la clase personalizado donde se guardan las palabras
        String[] listaPalabras = listaPersonalizada.ingresarPalabras(cantidad);
        //crea una sopa con base en el tamaño del arreglo y las palabras
        Sopa sopaP = new Sopa(tamano, listaPalabras);
        //genera un juego
        generarJuego(sopaP, 0);
    }

    //función que permite seleccionar el nivel de dificultad para crear la sopa
    private static void crearsopaNivel() {
        System.out.println("Ingresa la dificultad:\n 1. Facil \n 2. Medio \n 3. Dificil \n 4. Salir");
        int opcion = sc.nextInt();
        generarLista(opcion);
    }

    //función que permite generar la lista de palabras para la sopa de letras
    private static void generarLista(int opcion) {
        switch (opcion) {
            case 1:
                System.out.println("Facil");
                System.out.println("Ingresa el tema: \n 1. Animales \n 2.Comida \n 3.Paises \n 4. Programación");
                int optema = sc.nextInt();
                //valida que el número ingresado para el tema sea valido
                optema = temavalido(optema);
                //llama a la clase facil para inicializarla
                Facil facil = new Facil(optema);
                //llena un arreglo con el arreglo retornado de la clase facil
                String[] listaPalabras = facil.temaF(optema);
                //crea una sopa de tamaño 10X10 con la lista de palabras llenada
                Sopa sopaF = new Sopa(10, listaPalabras);
                //genera el juego con los parametros de la sopa y la opció´n ingresada
                generarJuego(sopaF, opcion);
                break;
            case 2:
                System.out.println("Medio");
                System.out.println("Ingresa el tema: \n 1. Animales \n 2.Flores \n 3.Universo \n 4.Paises");
                optema = sc.nextInt();
                optema = temavalido(optema);
                Medio medio = new Medio(optema);
                listaPalabras = medio.temaM(optema);
                Sopa sopaM = new Sopa(15, listaPalabras);
                generarJuego(sopaM, opcion);
                break;
            case 3:
                System.out.println("Dificil");
                System.out.println("Ingresa el tema: \n 1. Animales \n 2.Filósofos \n 3.Medicina \n 4. Comida");
                optema = sc.nextInt();
                optema = temavalido(optema);
                Dificil dificil = new Dificil(optema);
                listaPalabras = dificil.temaD(optema);
                Sopa sopaD = new Sopa(20, listaPalabras);
                generarJuego(sopaD, opcion);
                break;
            case 4:
                //si la opción es 4 se sale del programa
                System.out.println("Salir");
                break;
            default:
                //si la opción no es valida se vuelve a llamar a la función de manera recursiva
                System.out.println("Opcion no valida");
                generarLista(opcion);
        }
    }

    //funcion para generar el juego
    private static void generarJuego(Sopa sopa, int opcion) {
        //llena un arreglo con las palabras que contiene la sopa luego de rellenarla
        ArrayList<String> palabras = sopa.rellenarSopa(opcion);
        //muestra la sopa de letras y la guarda
        String[][] juego = sopa.mostrarJuego();
        //crea un juego con la sopa de letras y las palabras
        Juego juegoSopa = new Juego(juego, palabras, opcion);
        //inicia el juego
        juegoSopa.jugar();

    }
    //función para validar si el número ingresado en el tema es valido
    private static int temavalido(int tema) {
        if(tema < 1 || tema > 4){
            System.out.println("Opcion no valida");
            System.out.println("Ingrese el tema: ");
            tema=sc.nextInt();
            //si el numero no es valido la funcion se retorna a si misma con el nuevo valor ingresado
            return temavalido(tema);
        }
        return tema;
    }

    //funcion que permite verificar si el número ingresado en la cantidad es valido
    private static int cantidadValida(int cantidad, int tamano) {
        if(cantidad < 1 || cantidad > tamano){
            System.out.println("Cantidad no valida, Su cantidad debe ser menor o igual al tamaño de la sopa de letras");
            System.out.println("¿Cuántas palabras deseas ingresar?");
            cantidad = sc.nextInt();
            //si el numero no es valido la funcion se retorna a si misma con el nuevo valor ingresado
            return cantidadValida(cantidad, tamano);
        }
        return cantidad;
    }
    //función que permite verificar si el número ingresado en la pregunta de personalización es valido
    private static int opcionPvalida(int opcionPersonalizar) {
        if(opcionPersonalizar != 1 && opcionPersonalizar != 2){
            System.out.println("Opcion no valida");
            System.out.println("¿Deseas hacer tu sopa de letras personalizada? \n 1. Si \n 2. No");
            opcionPersonalizar = sc.nextInt();
            //si el numero no es valido la funcion se retorna a si misma con el nuevo valor ingresado
            return opcionPvalida(opcionPersonalizar);
        }
        return opcionPersonalizar;
    }

}
