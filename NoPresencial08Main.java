import es.ulpgc.eii.linked.Trie;
import es.ulpgc.eii.linked.ExtendedTrie;

public class Main {

    /**
     * @param args
     */
    public static void main(String[] args) {
        ExtendedTrie t = new ExtendedTrie();
        t.insert("agua");
        t.insert("casa");
        t.insert("casamata");
        t.insert("aereo");
        t.insert("rato");
        t.insert("pensamiento");
        t.insert("casandra");
        t.insert("espera");
        
        System.out.println(t.toString());
        // Cuenta el número de palabras en el trie, en este caso 8
        System.out.println(t.count());
        
        System.out.println("Agua: " + t.contains("agua"));
        System.out.println("Aguada: " + t.contains("aguada"));
        System.out.println("Casa: " + t.contains("casa"));
        System.out.println("Perro: " + t.contains("perro"));
        System.out.println("Casamata: " + t.contains("casamata"));
        System.out.println("Cigarro: " + t.contains("cigarro"));
        System.out.println("Casandra: " + t.contains("casandra"));
        System.out.println("Pillo: " + t.contains("pillo"));
        System.out.println("Aereo: " + t.contains("aereo"));
        System.out.println("Aerea: " + t.contains("aerea"));
    }

}
