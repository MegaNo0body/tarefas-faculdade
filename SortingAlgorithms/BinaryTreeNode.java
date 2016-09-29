/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package aps_sorting;

/**
 *
 * @author uFernando
 */
public class BinaryTreeNode<T extends Comparable<T>> {
    // Cada nó tem seu lado direito e esquerdo, para armazenar valores menores e
    // maiores.
    // No lado esquerdo são armazenados valores menores
    private BinaryTreeNode<T> left = null;
    // No lado direito são armazenados valores maiores
    private BinaryTreeNode<T> right = null;
    // O valor do nó atual
    private T value;
    
    // Construtor, cria um nó com o valor dado
    public BinaryTreeNode(T value) {
        this.value = value;
    }

    // Retorna o valor do nó
    public T getValue() {
        return value;
    }
    
    // Retorna o nó da esquerda, uma sub-arvore
    public BinaryTreeNode<T> getLeft() {
        return left;
    }

    // Seta o nó da esquerda, uma sub-arvore com o valor dado
    public void setLeft(BinaryTreeNode<T> left) {
        this.left = left;
    }

    // Retorna o nó da direita, uma sub-arvore
    public BinaryTreeNode<T> getRight() {
        return right;
    }

    // Seta o nó da direita, uma sub-arvore com o valor dado
    public void setRight(BinaryTreeNode<T> right) {
        this.right = right;
    }
    
    // Insere um elemento no nó atual
    public void Insert(T value) {
        // Se o elemento que está sendo inserido for menor que o elemento atual
        // insere no lado esquerdo da arvore, caso contrario no lado direito da
        // arvore
        if(this.value.compareTo(value) > 0) {
            if(this.left == null) {
                // Se o lado esquerdo da arvore for nulo, então cria um novo nó
                // no lado esquerdo
                this.left = new BinaryTreeNode(value);
            } else {
                // Caso contrario faz com que o lado esquerdo já existente
                // insira o novo elemento
                this.left.Insert(value);
            }
        } else { 
            if(this.right == null) {
                // Se o lado direito da arvore for nulo, então cria um novo nó
                // no lado direito
                this.right = new BinaryTreeNode(value);
            } else {
                // Caso contrario faz com que o lado direito já existente
                // insira o novo elemento
                this.right.Insert(value);
            }            
        }
    }
}
