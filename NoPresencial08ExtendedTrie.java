package es.ulpgc.eii.linked;

    /* Aitor Ventura Delgado
     * 01.05.2019
     */
     
public class ExtendedTrie extends Trie {
    public ExtendedTrie() {
        super(); // Llamada al constructor de la clase Trie
    }
    
    /* Método contains:
     * Nos apoyamos del método auxiliar containsaux creado por nosotros mismos,
     * lo que haremos es añadir un espacio a la String pasada por parámetro y
     * el punto de inicio del trie.
     */
    public boolean contains(String s1){
        return containsaux(s1+" ", root);
    }
    
    /* Método auxiliar containsaux:
     * Recorre los nodos comprobando si se encuentra el carácter pedido. Si se
     * encuentra, volvemos a llamar al método recortando un carácter por la izquierda
     * a la String. Si no se encuentra, iremos al nodo alternativo y repetimos el
     * proceso.
     */ 
    private boolean containsaux(String s1, Info root){
        Info aux = root;
        if(aux != null){
            if(s1.charAt(0) == ' ' && aux.c == '*'){
                return true;
            } else {
                if(s1.charAt(0) == aux.c){
                    return containsaux(s1.substring(1), aux.next);
                } else {
                    return containsaux(s1, aux.alt);
                }
            }
        }
        return false;
    }
    
    /* Método count:
     * Nos apoyamos del método auxiliar countaux creado por nosotros mismos, que
     * empiece a contar desde el inicio del trie, y comenzando desde 0 elementos.
     */
    public int count(){
        //  Si el inicio del trie está vacío, no hay palabras, luego devolvemos 0.
        if (root == null){
            return 0;
        }
        return countaux(root, 0);
    }
    
    /* Método auxiliar countaux:
     * Recorre el trie comprobando que su inicio no sea nulo. Si no lo es, comprueba
     * si el carácter se trata de un asterisco (diciendo así que es el final de la
     * palabra). Si lo fuera, incrementamos num, si no lo fuera, movemos el puntero
     * a la palabra alternativa.
     */
    private int countaux(Info root, int num){
        if (root != null){
            if (root.c == '*'){
                return 1 + countaux(root.alt, num);
            } else {
                return countaux(root.next, num) + countaux(root.alt, num);
            }
        }
        return num;
    }
}
