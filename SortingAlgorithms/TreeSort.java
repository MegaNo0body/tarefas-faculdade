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
public class TreeSort<T extends Comparable<T>> extends BaseSort<T> {
    // Variavel que armazena a arvore binaria com os valores ordenados
    private BinaryTreeNode<T> root = null;

    // Função que traversa os items da arvore binaria na ordem: In-Order
    // A ordem In-Order traversa os items do lado esquerdo, seus valores,
    // a raiz, e depois o lado direito sempre da esquerda para a direita.
    private void inOrderSort(BinaryTreeNode<T> node) {
        // Se o nó passado no parametro for nulo, é porque acabou os elementos
        // na sub-arvore
        if (node == null) {
            // Saimos
            return;
        }
        // Traversamos nos elementos da esquerda
        inOrderSort(node.getLeft());
        // Adicionamos o valor do nó atual no vetor resultante
        items.add(node.getValue());
        // Traversamos nos elementos da direita
        inOrderSort(node.getRight());
    }

    // Função que executa a implementação do algoritmo BinaryTreeNode
    @Override
    public void Sort() {
        // A raiz da nossa arvore binaria é limpa antes de executar a ordenação
        root = null;
        // Faz um laço em todos os elementos armazenados internamente
        for(T i : items) {
            // E adiciona os mesmos na arvore binaria
            // Caso a arvore binaria não é nula inserimos o valor na arvore já
            // existente, caso contrario, cria uma arvore binaria nova
            if (root != null) {
                // Insere elemento na arvore já existente
                root.Insert(i);
            } else {
                // Cria uma nova arvore binaria
                root = new BinaryTreeNode(i);
            }                    
        }
        // Reseta a variavel "items" para um vetor novo, para inseriormos os
        // items ordenados da arvore binaria
        items = new Vector<T>();
        // Insere elementos no vetor de resultado
        inOrderSort(root);
    }
}