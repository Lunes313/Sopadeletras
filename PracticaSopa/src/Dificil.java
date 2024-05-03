public class Dificil {
    //atributos 
    public int optema;

    //constructor
    public Dificil(int optema) {
        this.optema=optema; 
    }
    //creamos una función que retorne un arreglo que contenga las palabras del tema seleccionado
    public String[] temaD(int optema) {
        String[] arrme = null;
        if (optema == 1) {
            arrme = new String[]{"ballenajorobada", "cocodrilo", "elefantemarino", "leopardos", "pangolingigante", "tortugacarey", "delfindelamazonas", "cachalote","dragondecomodo","pandarojo", "vaquitamarina", "tarantula", "pingüinoemperador",
             "dinosaurio", "ornitorrinco", "tiburontoro", "sanguijuela", "murcielago", "saltamontes"};
        } else if (optema == 2) {
            arrme = new String[]{"aristoteles", "nietzsche", "wittgenstein", "foucault","simonedebeauvoir", "baudrillard", "immanuelkant", "renedescartes", "paulsartre", "albertcamus", "anaximenes", "sanagustin", "tomasdeaquino", "anaximandro", "parmenides", "protagoras", "pitagoras", "maquiavelo"};
        } else if (optema == 3) { 
            arrme = new String[]{"otorrinolaringologo", "neurocirujano", "cardiologo", "nefrologo", "gastroenterologo", "endocrinologo", "hematologo", "neumologo", "oftalmologo", "ginecologo", "traumatologo", 
            "dermatologo", "psiquiatra", "radiologo", "anestesiologo", "cirujanogeneral","reumatologo", "epidemiologo", "toxicologo", "nutriologo"};
        } else if (optema == 4) {
            arrme = new String[]{"pastaalpesto", "paellavalenciana", "tacosalpastor", "polloalanaranja", "albondigas", "arrozchino", "tortadepescado", "medialuna", "arrozconleche", "jamonserrano", "pandejamon", "hamburguesa", "pizzamargarita", "tortaenvinada" , "champiñones", "volcandechocolate", "tresleches"};
        }
        return arrme;
    }
}