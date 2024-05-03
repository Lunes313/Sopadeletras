public class Facil {
    //atributos 
    public int optema;
    
    //constructor
    public Facil(int optema) {
        this.optema=optema; 
    }
    
    //creamos una función que retorne un arreglo que contenga las palabras del tema seleccionado
        String[] arrfacil = null;
    public String[] temaF(int optema) {
        if (optema == 1) {
            arrfacil = new String[]{"perro", "gato", "leon", "tigre", "cebra", "mono", "oso", "pato", "pez", "toro"};
        } else if (optema == 2) {
            arrfacil = new String[]{"pizza", "tacos", "papas", "pera", "sopa", "pan", "pollo", "coco", "huevo", "uvas"};
        } else if (optema == 3) {
            arrfacil = new String[]{"rusia", "china", "japon", "peru", "cuba", "iran", "irak", "suiza", "libia"};
        } else if(optema == 4) {
            arrfacil = new String[]{"java", "ruby", "colab", "html", "css", "sql", "perl", "unity", "oop", "git"};
        }
        return arrfacil;
    }
}


