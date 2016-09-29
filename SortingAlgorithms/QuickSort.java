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
public class QuickSort<T extends Comparable<T>> extends BaseSort<T> {
    // Função que implementa o algoritmo QuickSort
    private void DoSort(int start, int end) {
        // Quando start é menor que end, significa que é necessario a ordenação
        // caso contrario, já esta ordenado
        if(start < end) {
            // Criamos o pivot usando o start
            int pivot = start;
            int i = end;
            // Salvamos o pivot em uma variavel para acessar facilmente suas
            // propriedades
            T save = items.elementAt(pivot);
            // Fazemos um laço enquanto o pivot for menor que a variavel I
            while(pivot < i) {
                // Comparamos o elemento I com o elemento pivot armazenado na
                // variavel save
                if(save.compareTo(items.elementAt(i)) > 0) {
                    // Se a comparação resultar true então trocamos os elementos
                    // pivot e i de lugar
                    items.set(pivot, items.elementAt(i));
                    // E o pivot se torna o elemento I
                    pivot = i;
                    // E o elemento I se torna o start + 1
                    i = start + 1;
                    // Fazemos um laco para enquanto o pivot for menor que I
                    // ordenar os elementos, com a intenção de manter elementos
                    // maiores que o pivot no lado direito, e menores no lado
                    // esquerdo
                    while(pivot > i) {
                        // Comparamos o elemento na posição I com o pivot
                        if(save.compareTo(items.elementAt(i)) < 0) {
                            // Dependendo do resultado trocamos eles de posição
                            // e mudamos o pivot para I
                            // e I para o end
                            // com a intenção de manter o PIVOT no meio, e
                            // elementos menores a esquerda e
                            // elementos maiores a direita
                            items.set(pivot, items.elementAt(i));
                            pivot = i;
                            i = end;
                            break;
                        } else {
                            // Continuamos procurando elementos melhores para
                            // serem pivot
                            i++;
                        }
                    }                    
                } else {
                    // Continuamos procurando elementos melhores para serem pivot
                    i--;
                }
            }
            // Trocamos a posição pivot e save
            items.set(pivot, save);
            // Executamos a ordenação no lado esquerdo do pivot
            // recursivamente
            DoSort(start, pivot-1);
            // Executamos a ordenação no lado direito do pivot
            // recursivamente
            DoSort(pivot+1, end);
        }
    }
    
    // Função que executa a implementação do algoritmo QuickSort
    @Override
    public void Sort() {
        DoSort(0, items.size()-1);
    }
}
