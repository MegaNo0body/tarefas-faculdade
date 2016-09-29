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
public abstract class BaseSort<T extends Comparable<T>> {
    // Variavel que armazena os dados que serão ordenados
    protected Vector<T> items = null;
    
    // Função abstrata que executa a implementação de ordenação
    abstract public void Sort();
    
    // Função que retorna os valores ordenados
    public Vector<T> Result()  {
        return items;
    }

    // Função que adiciona um valor para o armazenamento interno, futuros dados
    // que serão ordenados.
    public void Insert(T value) {
        if(items == null) {
            items = new Vector<T>();
        }
        items.add(value);
    }    
    
    // Função ajudante que insere valores de vetor simples
    public void Insert(T[] values) {
        for (T i : values) {
            Insert(i);
        }
    }
        
    // Função ajudante que insere valores de um objeto vetor
    public void Insert(Vector<T> values) {
        for (T i : values) {
            Insert(i);
        }
    }    
    
    // Função que limpa os valores armazenados internos, para ordenar com outros
    // valores.
    public void Clear() {
        items = null;
    }    
    
    // Função que executa a implementação de ordenação e retorna o tempo
    // de execução em milisegundos
    public long Measure() {
        long s = System.currentTimeMillis();
        Sort();
        return System.currentTimeMillis() - s;
    }
}
