import java.util.Scanner;

public class Personalizado {
    static Scanner sc = new Scanner(System.in);
    //atributos
    public int tamano;
    public int cantidad;

    //constructor
    public Personalizado(int tamano, int cantidad) {
        this.tamano=tamano; 
        this.cantidad=cantidad; 
    }
    //creamos una función para que se guarden las palabras en la sopa de letra personalizada
    public String[] ingresarPalabras(int cantidad) {
        //creamos el arreglo donde se van a depositar las palabras
        String [] palabras = new String[cantidad];
        //utilizamos un for para ir recorriendo el arreglo e ingresar las palabras
        for(int i = 0; i<cantidad;i++){
            System.out.println("Ingrese palabra");
            String palabrita= sc.nextLine();
            if(palabrita.length()>tamano){
                System.out.println("La palabra es muy grande");
                i--;
                continue;
            }
            //si la palabra es menor al tamaño de la sopa de letra agregamos la palabra
            palabras[i]=palabrita;
        }
        return palabras;
    }

}