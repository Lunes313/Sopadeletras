import java.util.ArrayList;
import java.util.Scanner;
import java.util.Timer;
import java.util.TimerTask;

public class Juego {
    //atributos
    public String[][] sopa;
    public ArrayList<String> palabras;
    public ArrayList<String> posicionesP;
    public int opcion;
    public int tamano;

    //constructor
    public Juego(String[][] sopa, ArrayList<String> palabras,int opcion) {
        this.sopa = sopa;
        this.palabras = palabras;
        this.opcion = opcion;
        this.posicionesP = new ArrayList<>();
        this.tamano = sopa.length;
    }

    //metodos
    //funcion para buscar las palabras de la sopa usando el algoritmo de busqueda (DSF)
    // algoritmo inspirado de:
    // 1. https://www.apascualco.com/algoritmos/busqueda-en-profundidad-depth-first-search-dfs/
    // 2. https://www.techiedelight.com/es/depth-first-search/

    public void buscarPalabras() {
        //recorre la lista de palabras que tiene la sopa
        for (String palabra : palabras) {
            //recorre la sopa de letras
            for (int i = 0; i < tamano; i++) {
                for (int j = 0; j <= tamano - palabra.length(); j++) {
                    //si la palabra se encuentra horizontalmente se agrega a la lista de posiciones
                    if (buscarHorizontal(palabra, i, j)) {
                        posicionesP.add("(" + i + ", " + j + ") - (" + i + ", " + (j + palabra.length() - 1) + ")");

                    }
                    //si la palabra se encuentra horizontalmente de manera inversa se agrega a la lista de posiciones
                    if (buscarHorizontalInversa(palabra, i, j)) {
                        posicionesP.add("(" + i + ", " + (j + palabra.length() - 1) + ") - (" + i + ", " + j + ")");
                    }
                }
            }
            //recorre la sopa de letras
            for (int i = 0; i <= tamano - palabra.length(); i++) {
                for (int j = 0; j < tamano; j++) {
                    //si la palabra se encuentra verticalmente se agrega a la lista de posiciones
                    if (buscarVertical(palabra, i, j)) {
                        posicionesP.add("(" + i + ", " + j + ") - (" + (i + palabra.length() - 1) + ", " + j + ")");
                    }
                    //si la palabra se encuentra verticalmente de manera inversa se agrega a la lista de posiciones
                    if (buscarVerticalInversa(palabra, i, j)) {
                        posicionesP.add("(" + (i + palabra.length() - 1) + ", " + j + ") - (" + i + ", " + j + ")");
                    }
                }
            }
            //recorre la sopa de letras
            for (int i = 0; i <= tamano - palabra.length(); i++) {
                for (int j = 0; j <= tamano - palabra.length(); j++) {
                    //si la palabra se encuentra en diagonal se agrega a la lista de posiciones
                    if (buscarDiagonal(palabra, i, j)) {
                        posicionesP.add("(" + i + ", " + j + ") - (" + (i + palabra.length() - 1) + ", " + (j + palabra.length() - 1) + ")");
                    }
                    //si la palabra se encuentra en diagonal de manera inversa se agrega a la lista de posiciones
                    if (buscarDiagonalInversa(palabra, i, j)) {
                        //se agrega la posicion, iniciado desde la ultima hasta la primera para guardarlo de manera inversa
                        posicionesP.add("(" + (i + palabra.length() - 1) + ", " + (j + palabra.length() - 1) + ") - (" + i + ", " + j +  ")");
                    }
                }
            }
        }
    }

    //funcion para buscar la palabra horizontalmente
    private boolean buscarHorizontal(String palabra, int fila, int columnaInicio) {
        //recorre la palabra
        for (int i = 0; i < palabra.length(); i++) {
            //si la letra de la sopa en la fila y columna especificada no es igual a la de la palabra retorna falso
            if (sopa[fila][columnaInicio + i].charAt(0) != palabra.charAt(i)) {
                return false;
            }
        }
        return true;
    }

    //funcion para buscar la palabra horizontalmente de manera inversa
    private boolean buscarHorizontalInversa(String palabra, int fila, int columnaInicio) {
        for (int i = 0; i < palabra.length(); i++) {
            //si la letra de la sopa en la fila y columna recorrindola de manera inversa no es igual a la de la palabra retorna falso
            if (sopa[fila][columnaInicio + palabra.length() - 1 - i].charAt(0) != palabra.charAt(i)) {
                return false;
            }
        }
        return true;
    }

    //funcion para buscar la palabra verticalmente
    private boolean buscarVertical(String palabra, int filaInicio, int columna) {
        for (int i = 0; i < palabra.length(); i++) {
            //si la letra de la sopa en la fila y columna especificada no es igual a la de la palabra retorna falso
            if (sopa[filaInicio + i][columna].charAt(0) != palabra.charAt(i)) {
                return false;
            }
        }
        return true;
    }

    //funcion para buscar la palabra verticalmente de manera inversa
    private boolean buscarVerticalInversa(String palabra, int filaInicio, int columna) {
        for (int i = 0; i < palabra.length(); i++) {
            //si la letra de la sopa en la fila recorrida de manera inversa y columna no es igual a la de la palabra retorna falso
            if (sopa[filaInicio + palabra.length() - 1 - i][columna].charAt(0) != palabra.charAt(i)) {
                return false;
            }
        }
        return true;
    }

    //funcion para buscar la palabra en diagonal
    private boolean buscarDiagonal(String palabra, int filaInicio, int columnaInicio) {
        //recorre la palabra
        for (int i = 0; i < palabra.length(); i++) {
            //si la letra de la sopa en la fila y columna especificada no es igual a la de la palabra retorna falso
            if (sopa[filaInicio + i][columnaInicio + i].charAt(0) != palabra.charAt(i)) {
                return false;
            }
        }
        return true;
    }

    //funcion para buscar la palabra en diagonal de manera inversa
    private boolean buscarDiagonalInversa(String palabra, int filaInicio, int columnaInicio) {
        for (int i = 0; i < palabra.length(); i++) {
            //si la letra de la sopa en la fila y columna recorridas de manera inversa no es igual a la de la palabra retorna falso
            if (sopa[filaInicio + palabra.length() - 1 - i][columnaInicio + palabra.length() - 1 - i].charAt(0) != palabra.charAt(i)) {
                return false;
            }
        }
        return true;
    }

    public void jugar(){
        //se llama la funcion buscar palabras
        buscarPalabras();
        //se crea un scanner para leer la entrada del usuario
        Scanner sc = new Scanner(System.in);
        //se crea un contador de tiempo
        int tiempo = 0;
        //se genera un tiempo especifico dependiendo del nivel que haya ingresado el usuario
        if(opcion == 1){
            //se imprime el tiempo que tiene el usuario para jugar, (facil, 400 segundos)
            System.out.println("Tienes 400 segundos para encontrar cada palabra");
            tiempo = 400;
        }else if(opcion == 2){
            //se imprime el tiempo que tiene el usuario para jugar, (medio, 450 segundos)
            System.out.println("Tienes 450 segundos para encontrar cada palabra");
            tiempo = 450;
        }else if(opcion == 3){
            //se imprime el tiempo que tiene el usuario para jugar, (dificil, 500 segundos)
            System.out.println("Tienes 500 segundos para encontrar cada palabra");
            tiempo = 500;
        }else if(opcion == 0){
            //se imprime el tiempo que tiene el usuario para jugar, (personalizado, 30 segundos por palabra)
            tiempo = palabras.size()*30;
            System.out.println("Tienes "+ tiempo +" segundos para encontrar cada palabra");
        }
        //se crea un arreglo de enteros para guardar el tiempo restante
        //si el fuera guardado en una variable int no seria posible modificarla dentro de un Timer
        int[] segundos = {tiempo};
        //se crea un timer para contar el tiempo
        Timer timer = new Timer();
        //se crea un timerTask para contar el tiempo
        TimerTask task = new TimerTask() {
            @Override
            public void run() {
                //se resta un segundo al tiempo restante
                segundos[0]--;
                //si el tiempo restante es 0 se cancela el timer
                if (segundos[0] <= 0) {
                    timer.cancel();
                }
            }
        };
        //se programa el timer para que se ejecute cada segundo
        timer.schedule(task, 0, 1000);
        //se inicializan las variables para contar las palabras encontradas y los errores
        int encontradas = 0;
        int errores = 0;
        //mientras el tiempo restante sea mayor a 0 y no se hayan encontrado todas las palabras
        while(segundos[0] > 0 && encontradas < palabras.size()){
            //se imprime el tiempo restante
            System.out.println("Tiempo restante: "+ segundos[0] + " segundos");
            //se pide al usuario que ingrese la posicion inicial y final de la palabra
            System.out.println("ingrese la posicion inicial de la palabra (fila columna): ");
            //se resta uno a la fila y columna que ingrese el usuario para que sea acorde a la matriz
            int fila = sc.nextInt()-1;
            int columna = sc.nextInt()-1;
            //se pide al usuario que ingrese la posicion final de la palabra
            System.out.println("ingrese la posicion final de la palabra (fila columna): ");
            //se resta uno a la fila y columna que ingrese el usuario para que sea acorde a la matriz
            int fila2 = sc.nextInt()-1;
            int columna2 = sc.nextInt()-1;
            //se crea un string con la posicion inicial y final de la palabra
            String posicionString = "(" + fila + ", " + columna + ") - (" + fila2 + ", " + columna2 + ")";
            //si la lista de posiciones de las palabras contiene la posicion ingresada por el usuario
            if(posicionesP.contains(posicionString)){
                //se aumenta el contador de palabras encontradas
                encontradas++;
                //se imprime que se encontro la palabra
                System.out.println("Encontraste una palabra");
                //se elimina la posicion de la palabra encontrada de la lista de posiciones
                posicionesP.remove(posicionString);
            }else{
                //si la lista de posiciones de las palabras no contiene la posicion ingresada por el usuario se aumenta el contador de errores
                System.out.println("No encontrado, intenta de nuevo");
                errores++;
            }
            
        }
        //se guarda el tiempo restante en una variable para poder utilizarlo si se encontraron todas las palabras y el tiempo no se acabo
        int tiempoRestante = segundos[0];
        //se crea una variable que contenga el puntaje del usuario
        int p = puntaje(encontradas, errores, segundos);
        //se cierra el scanner
        sc.close();
        //se imprime el tiempo restante, las palabras encontradas, los errores y el puntaje
        if(tiempoRestante == 0){
            System.out.println("Se acabó el tiempo");
        }else{
            System.out.println("Tiempo restante: "+ tiempoRestante + " segundos");
        }
        if(encontradas == palabras.size()){
            System.out.println("Todas las palabras fueron encontradas");
        }else{
            System.out.println("Palabras encontradas: "+ encontradas + " de " + palabras.size());
            System.out.println("Las palabras faltantes se encontraban en las posiciones:");
            for(String posicion: posicionesP){
                System.out.println(posicion);
            }
        }
        System.out.println("Errores:" + errores);
        System.out.println("Puntaje: "+ p);
    }

    //funcion para calcular el puntaje del usuario
    public int puntaje(int encontradas, int errores, int[] segundos){
        //el puntaje se calcula multiplicando las palabras encontradas por 10, restando los errores por 2 y sumando el tiempo restante por 10
        int p = encontradas*10 - errores*2 + segundos[0]*10;
        //se retorna el puntaje
        return p;
    }
}