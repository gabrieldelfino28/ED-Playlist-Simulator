/*
 * Autor: Gabriel Delfino
 * Data: 17/10/2023 DD/MM/YYYY format
 * Java utilizado: JDK 17
 * Objetivo: Simulador de Playlists de Música
 */

package view;

import controller.PlayerController;
import fateczl.Lista.model.Lista;
import model.Musica;

import javax.swing.*;

public class Main {

    public static void main(String[] args) {
        // write your code here
        Lista<Musica> L = new Lista<>();
        PlayerController player = new PlayerController();
        String Menu = "";
        boolean isRunning = true;
        do {
            Menu = JOptionPane.showInputDialog("""
                    Simulador de Playlist de Música
                    1- Inserir Música
                    2- Remover Música
                    3- Executar Playlist
                    9- Fim""");
            try {
                switch (Menu) {
                    case "1" -> {
                        String nomeMusica = JOptionPane.showInputDialog("Informe o nome da música");
                        String artista = JOptionPane.showInputDialog("Informe o nome do artista");
                        int duracao = Integer.parseInt(JOptionPane.showInputDialog("Informe a duracao da música (em seg)"));

                        String Musica = nomeMusica + ";" + artista + ";" + duracao;
                        player.adicionarMusica(L, Musica);
                    }
                    case "2" -> {
                        int pos = Integer.parseInt(JOptionPane.showInputDialog("Informe uma posição para remover a música"));
                        player.removeMusica(L, pos);
                    }
                    case "3" -> player.executaMusica(L);
                    case "9" -> isRunning = false;
                    default -> JOptionPane.showMessageDialog(null, "Valor inválido, tente novamente");
                }
            } catch (Exception e) {
                JOptionPane.showMessageDialog(null, e.getMessage());
                System.err.println(e.getMessage());
            }
        } while (isRunning);
    }
}
