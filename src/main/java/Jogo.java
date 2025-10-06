package main.java;

import javax.swing.JFrame;

public class Jogo extends JFrame{

    private TelaJogo telaJogo;

    public Jogo(){
        setSize(640, 640);
        setVisible(true);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setLocationRelativeTo(null);

        telaJogo = new TelaJogo();
        add(telaJogo);
    }
public static void main(String[] args) {
    Jogo jogo = new Jogo();

}
    
}
