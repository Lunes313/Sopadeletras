public class Medio {
    //atributos 
    public int optema;

    //constructor
    public Medio(int optema) {
        this.optema=optema; 
    }
    
    //creamos una función que retorne un arreglo que contenga las palabras del tema seleccionado
    public String[] temaM(int optema) {
        String[] arrme = null;
        if (optema == 1) {
            arrme = new String[]{"ballena", "camello", "delfín", "elefante", "jirafa", "colibrí", "gaviota", "paloma", "pingüino", "tortuga","canguro","jabalí", "condor", "avestruz"};
        } else if (optema == 2) {
            arrme = new String[]{"girasol", "azalea", "tulipan", "lirio", "orquidea", "violeta", "clavel", "azucena", "magnolia","gardenia", "margarita", "jazmin", "lavanda", "narciso"};
        } else if (optema == 3) {
            arrme = new String[]{"planeta", "estrella", "cometa", "galaxia", "nebulosa", "satelite", "universo", "eclipse", "cosmos", "orbita", "espacial", "gravedad","BigBang"};
        } else if (optema == 4) {
            arrme = new String[]{"alemania", "colombia", "ecuador", "francia", "holanda", "italia", "mexico", "suecia", "turquia", "uruguay", "portugal", "belgica", "brasil", "panama"};
        }
        return arrme;
    }
}