package controller;

import fateczl.Lista.model.Lista;
import model.Musica;

import javax.swing.*;

public class PlayerController {
    public PlayerController() {
        super();
    }

    public void adicionarMusica(Lista<Musica> L, String Musica) throws Exception {

        String[] split = Musica.split(";");
        Musica music = new Musica(split[0], split[1], Integer.parseInt(split[2]));

        if (L.isEmpty()) {
            L.addFirst(music);
        } else {
            L.addLast(music);
        }
    }

    public void removeMusica(Lista<Musica> L, int posicao) throws Exception {
        if (L.isEmpty()) {
            throw new Exception("Lista está vazia!");
        } else {
            String confirm = JOptionPane.showInputDialog("Deseja realmente remover a música:\n" + L.get(posicao) + "\n1- Sim\n2- Não");
            if (confirm.equals("1")) {
                System.out.println(L.get(posicao) + " foi removida!");
                L.remove(posicao);
            }else if(confirm.equals("2")) {
                //it will just end the method
            }else {
                JOptionPane.showMessageDialog(null, "Valor inválido tente novamente.");
                removeMusica(L,posicao);
            }
        }
    }

    public void executaMusica(Lista<Musica> L) throws Exception {
        if (L.isEmpty()) {
            throw new Exception("Lista está vazia!");
        } else {
            for (int i = 0; i < L.size(); i++) {
                System.out.println("Now playing: " + L.get(i));
                Musica music = L.get(i);
                Thread.sleep(music.duracao * 1000L);
            }
            System.out.println("Fim da execução");
        }
    }
}
