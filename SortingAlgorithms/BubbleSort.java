/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package aps_sorting;

import java.util.Vector;

/**
 *
 * @author uFernando
 */
public class BubbleSort<T extends Comparable<T>> extends BaseSort<T> {
    // Função que implementa o algoritmo BubbleSort
    @Override
    public void Sort() {
        // Aplica um laço sobre todos os items armazenados internamente
        for(int i=0; i<items.size(); i++) {
            // Aplica um laço sobre os item atual do loop anterior para o fim da
            // lista de items armazenados internamente
            for(int j=i+1; j<items.size(); j++) {
                // Armazena o item atual em uma variavel local para facilitar
                // a manipulação
                T tmp = items.get(i);
                // Compara o item "items.get(i)" armazenado em 'tmp', com
                // o item "items.get(j)"
                if(tmp.compareTo(items.get(j)) > 0) {
                    // Caso o item "items.get(i)" armazenado em for menor que
                    // o item "items.get(j)" então trocar os dois de posição
                    items.set(i, items.elementAt(j));
                    items.set(j, tmp);
                }
            }
        }
    }
}
