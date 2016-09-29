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
public class ThreadSort<T extends Comparable<T>> implements Runnable {
    private BaseSort<T> sorter;
    private javax.swing.JLabel statusLabel;
    private javax.swing.JTextArea resultTextArea;
    
    // Constroi a classe e armazena os objetos que armazenarão valores e classe.
    public ThreadSort(BaseSort<T> sorter, javax.swing.JLabel statusLabel, javax.swing.JTextArea resultTextArea, T[] values) {
        this.sorter = sorter;
        this.statusLabel = statusLabel;
        this.resultTextArea = resultTextArea;
        this.sorter.Insert(values);
    }
    
    // Executa o metodo de ordenação, e atualiza o label de estado. No final
    // da execução ele adiciona o conteudo ordenado no campo destinado.
    @Override
    public void run() {
        statusLabel.setText("Processando...");
        resultTextArea.setText("Por favor aguarde");
        long time = sorter.Measure();
        statusLabel.setText("Tempo de processamento: "+time+"ms");
        Vector<T> result = sorter.Result();
        resultTextArea.setText("");
        for(T i : result)
            resultTextArea.append(i+"\n");
    }
}
