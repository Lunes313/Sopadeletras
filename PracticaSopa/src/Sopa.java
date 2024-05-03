import java.util.ArrayList;

public class Sopa {
    //atributos
    public int tamano;
    public String[] palabras;
    public ArrayList<String> lista = new ArrayList<String>();
    public String[][] sopa = new String[tamano][tamano];
    
    //constructor
    public Sopa(int tamano, String[] palabras) {
        this.tamano = tamano;
        this.palabras = palabras;
        this.sopa = new String[tamano][tamano];

    }

    //metodos
    //función para agregar palabras de forma horizontal
    public boolean horizontal(String palabra) {
        //se inicializa la variable palabraAgregada en false
            boolean palabraAgregada = false;
            //se genera un número aleatorio para la fila y columna
                int fila = (int) (Math.random() * tamano);
                int columna = (int) (Math.random() * (tamano - palabra.length() + 1));
                //se inicializa la variable puedeAgregar en true
                    boolean puedeAgregar = true;
                    //recorremos la palabra
                    for (int i = 0; i < palabra.length(); i++) {
                        //preguntamos si la posición es diferente de null y es diferente a la letra de la palabra en la posición correspondiente
                        if (sopa[fila][columna + i] != null && !sopa[fila][columna + i].equals(""+palabra.charAt(i))){
                            //si la condicion cumple puedeAgregar se vuelve false y se rompe el ciclo
                            puedeAgregar = false;
                            break;
                        }
                    }

                    if(!puedeAgregar){
                        //se guarda la columna en una variable
                        int col = columna;
                        //se recorre la columna para encontrar una posición donde se pueda agregar la palabra
                        for (columna = 0; columna <= tamano - palabra.length(); columna++) {
                            if (columna != col) {
                                puedeAgregar = true;
                                //repetimos el ciclo para verificar si se puede agregar la palabra
                                for (int i = 0; i < palabra.length(); i++) {
                                    if (sopa[fila][columna + i] != null && !sopa[fila][columna + i].equals(""+palabra.charAt(i))) {
                                        puedeAgregar = false;
                                        break;
                                    }
                                }
                                //si se puede agregar en una de la columnas se rompe el ciclo
                                if(puedeAgregar){
                                    break;
                                }
                            }
                        }
                    }
                    if (puedeAgregar) {
                        //si se puede agregar se recorre la palabra y se agrega a la sopa
                        for (int i = 0; i < palabra.length(); i++) {
                            sopa[fila][columna + i] = "" + palabra.charAt(i);
                        }
                        palabraAgregada = true;
                    }
            //retornamos la variable palabraAgregada
            return palabraAgregada;
    }

    //función para agregar palabras de forma vertical
    public boolean vertical(String palabra){
        //Se realiza el mismo procedimiento que en la función horizontal pero comprobando verticalmente
        boolean palabraAgregada = false;
            int columna = (int) (Math.random() * tamano);
            int fila = (int) (Math.random() * (tamano - palabra.length() + 1));
                boolean puedeAgregar = true;
                for(int i = 0; i < palabra.length(); i++) {
                    if(sopa[fila + i][columna] != null && !sopa[fila + i][columna].equals(""+palabra.charAt(i))){
                        puedeAgregar = false;
                            break;
                    }
                }
                if(!puedeAgregar){
                    int fil = fila;
                    for (fila = 0; fila <= tamano - palabra.length(); fila++) {
                        if (fila != fil) {
                            puedeAgregar = true;
                            for (int i = 0; i < palabra.length(); i++) {
                                if (sopa[fila + i][columna] != null && !sopa[fila + i][columna].equals(""+palabra.charAt(i))) {
                                    puedeAgregar = false;
                                    break;
                                }
                            }
                            if(puedeAgregar){
                                break;
                            }
                        }
                    }
                }
                if (puedeAgregar) {
                    for (int i = 0; i < palabra.length(); i++) {
                        sopa[fila+i][columna] = "" + palabra.charAt(i);
                    }
                    palabraAgregada = true;
                }
        return palabraAgregada;
    }

    //función para agregar palabras de horizontal inversa
  public boolean horizontalin(String palabra) {
        //Se realiza el mismo procedimiento que en la función horizontal
            boolean palabraAgregada = false;
                int fila = (int) (Math.random() * tamano);
                int columna = (int) (Math.random() * (tamano - palabra.length() + 1));
                if (columna + palabra.length() <= tamano) {
                    boolean puedeAgregar = true;
                    for (int i = 0; i < palabra.length(); i++) {
                        //se pregunta si la posición es diferente de null y si es diferente a la letra de la palabra pero recorriendola al reves
                        if (sopa[fila][columna + i] != null && !sopa[fila][columna + i].equals(""+palabra.charAt(palabra.length()-1-i))) {
                            puedeAgregar = false;
                            break;
                        }
                    }
                    
                    if(!puedeAgregar){
                        int col = columna;
                        for (columna = 0; columna <= tamano - palabra.length(); columna++) {
                            if (col != columna) {
                                puedeAgregar = true;
                                for (int i = 0; i < palabra.length(); i++) {
                                    if (sopa[fila][columna + i] != null && !sopa[fila][columna + i].equals(""+palabra.charAt(palabra.length()-1-i))) {
                                        puedeAgregar = false;
                                        break;
                                    }
                                }
                                if(puedeAgregar){
                                    break;
                                }
                            }
                        }
                    }
                    if (puedeAgregar) {
                        //si se puede agregar se recorre la palabra al reves y se agrega a la sopa
                        for (int i = 0; i < palabra.length(); i++) {
                            sopa[fila][columna + i] = "" + palabra.charAt(palabra.length()-1-i);
                        }
                        palabraAgregada = true;
                    }
                }
            return palabraAgregada;
    }

    //función para agregar palabras de forma vertical inversa
    public boolean verticalin(String palabra){
        //Se realiza el mismo procedimiento que en la función vertical
        boolean palabraAgregada = false;
            int columna = (int) (Math.random() * tamano);
            int fila = (int) (Math.random() * (tamano - palabra.length() + 1));    
            if (fila + palabra.length()<=tamano) {
                boolean puedeAgregar = true;
                for(int i = 0; i < palabra.length(); i++) {
                    //se pregunta si la posición es diferente de null y si es diferente a la letra de la palabra pero recorriendola al reves
                    if(sopa[fila + i][columna] != null && !sopa[fila + i][columna].equals(""+palabra.charAt(palabra.length()-1-i))){
                            puedeAgregar = false;
                            break;
                    }
                }
                
                if(!puedeAgregar){
                    int fil = fila;
                    for (fila = 0; fila <= tamano - palabra.length(); fila++) {
                        if (fil != fila) {
                            puedeAgregar = true;
                            for (int i = 0; i < palabra.length(); i++) {
                                if (sopa[fila + i][columna] != null && !sopa[fila + i][columna].equals(""+palabra.charAt(palabra.length()-1-i))) {
                                    puedeAgregar = false;
                                    break;
                                }
                            }
                            if(puedeAgregar){
                                break;
                            }
                        }
                    }
                }
                if (puedeAgregar) {
                    //si se puede agregar se recorre la palabra al reves y se agrega a la sopa
                    for (int i = 0; i < palabra.length(); i++) {
                    sopa[fila+i][columna] = "" + palabra.charAt(palabra.length()-1-i);
                    }
                    palabraAgregada = true;
                }
            }
        return palabraAgregada;
    }

    //función para agregar palabras de forma diagonal
    public boolean diagonal(String palabra) {
        //se inicializa la variable palabraAgregada como false
         boolean palabraAgregada = false;
            //se generan números aleatorios para la fila y columna esta ves comprobando que los dos sean numeros en los que se puede agregar la palabra
            int columna = (int) (Math.random() *(tamano - palabra.length() + 1));
            int fila = (int) (Math.random() * (tamano - palabra.length() + 1));
                boolean puedeAgregar = true;
                //se recorre la palabra
                for(int i = 0; i < palabra.length(); i++) {
                    //se pregunta si la condicion es verdadera esta ves comprobando en diagonal
                    if(sopa[fila + i][columna + i] != null && !sopa[fila + i][columna + i].equals(""+palabra.charAt(i))){
                        //si la condición se cumple puedeAgregar se vuelve false y se rompe el ciclo
                        puedeAgregar = false;
                        break;
                    }
                }
                if (puedeAgregar) {
                    //si se puede agregar se recorre la palabra y se agrega a la sopa
                    for (int i = 0; i < palabra.length(); i++) {
                        sopa[fila+i][columna +i] = "" + palabra.charAt(i);
                    }
                    palabraAgregada = true;
                }
        return palabraAgregada;
    }

    //función para agregar palabras de forma diagonal inversa
    public boolean diagonalin(String palabra) {
        //se realiza el mismo procedimiento que en la función diagonal
         boolean palabraAgregada = false;
            int columna = (int) (Math.random() *(tamano - palabra.length() + 1));
            int fila = (int) (Math.random() * (tamano - palabra.length() + 1));   
            if (fila + palabra.length()<=tamano && columna + palabra.length()<=tamano) {
                boolean puedeAgregar = true;
                for(int i = 0; i < palabra.length(); i++) {
                    //se pregunta si la condicion es verdadera para la palabra pero recorriendola al reves
                    if(sopa[fila + i][columna + i] != null && !sopa[fila + i][columna + i].equals(""+palabra.charAt(palabra.length()-1-i))){
                        puedeAgregar = false;
                            break;
                    }
                }
                if (puedeAgregar) {
                    //si se puede agregar se recorre la palabra al reves y se agrega a la sopa
                    for (int i = 0; i < palabra.length(); i++) {
                        sopa[fila+i][columna +i] = "" + palabra.charAt(palabra.length()-1-i);
                    }
                    palabraAgregada = true;
                } 
            }
        return palabraAgregada;
    }

    //metodo para rellenar la sopa de letras
    public ArrayList<String> rellenarSopa(int opcion) {
        //se cambia el valor de la variable opcion para que las posiciones sean acordes a la dificultad d ela sopa
        if(opcion == 1){
            //si la opcion es 1 (facil) se cambia a 2 para horizontal y vertical
            opcion = 2;
        }else if(opcion == 2){
            //si la opcion es 2 (medio) se cambia a 3 para horizontal, vertical y diagonal
            opcion = 3;
        }else{
            //si la opcion es 3 o 0 (dificil o personalizada) se cambia a 6 para todas las posiciones
            opcion = 6;
        }
        //se recorre el arreglo de palabras
        for(String palabra: palabras){
            //se llama a la función añadirPalabra y se guarda el valor en la variable añadida
            Boolean anadida = anadirPalabra(palabra, opcion);
            //se pregunta si la palabra fue añadida
            if(anadida){
                //si fue añadida se agrega a la lista
                lista.add(palabra);
            }
        }
        //se recorre la sopa luego de agregar todas las palabras
        for (int i = 0; i < tamano; i++) {
            for (int j = 0; j < tamano; j++) {
                //se pregunta si la posición es null
                if (sopa[i][j] == null) {
                    //si es null se agrega una letra aleatoria en la posición
                    //logica buscada
                    sopa[i][j] = "" + (char) (Math.random() * 26 + 'a');
                }
            }
        }
        //retornamos la lista de palabras
        return lista;
    }

    //función para agregar palabras de forma aleatoria
    public boolean anadirPalabra(String palabra, int opcion) {
        //se inicializa la variable palabraAgregada en false
        boolean palabraAgregada = false;
        //se realiza un ciclo para intentar agregar la palabra 100 veces mientras aun no haya sido agregada
        // esto aumenta la probabilidad de que sea agregada a la sopa sin tener que obligarla a agregarse si no cabe en alguna posicion
        for (int i = 0; i < 100 && !palabraAgregada; i++) {
            //se genera un número aleatorio para la orientación dependiendo de la dificultad de la sopa
            int orientacion = (int)(Math.random()*opcion);
            //se pregunta por la orientación y se llama a la función correspondiente
            switch (orientacion) {
                case 0:
                    //se llama a la función y se guarda el valor en la variable palabraAgregada, luego rompemos el switch
                    palabraAgregada = horizontal(palabra);
                    break;
                case 1:
                    palabraAgregada = vertical(palabra);
                    break;
                case 2:
                    palabraAgregada = diagonal(palabra);
                    break;
                case 3:
                    palabraAgregada = horizontalin(palabra);
                    break;
                case 4:
                    palabraAgregada = verticalin(palabra);
                    break;
                case 5:
                    palabraAgregada = diagonalin(palabra);
                    break;
            }
        }
        //retornamos la variable palabraAgregada
        return palabraAgregada;
    }

    //metodo para mostrar la sopa de letras
    public String[][] mostrarJuego() {
        //se imprimen los numeros de las columnas para que sea mas facil de entender para el usuario
        System.out.print(" | ");
        for(int i = 0; i<tamano; i++){
            System.out.print((i+1) + " | ");
        }
        //se imprime una linea para separar los numeros de las letras
        System.out.println();
        for(int k=0; k<=tamano; k++){
            System.out.print("____"); 
        }
        //se imprime la sopa de letras separada por lineas
        System.out.println();
        for(int i =0; i<tamano; i++){
            //antes de imprimir la fila se imprime el numero de la fila
            System.out.print(i+1 + " | ");
            for(int j=0; j<tamano;j++){
                System.out.print(sopa[i][j]+" | ");
            }
            System.out.println();
            for(int k=0; k<=tamano; k++){
                System.out.print("____"); 
            }
            System.out.println();
        }
        //se imprime la lista de palabras que contiene la sopa para que el usuario las busque
        int contador = 1;
        for(String palabra: lista){
            System.out.println(contador + ". " + palabra);
            contador++;
        }
        //retornamos la sopa
        return sopa;
    }
}



