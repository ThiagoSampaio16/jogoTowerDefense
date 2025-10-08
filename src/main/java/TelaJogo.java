package main.java;

import javax.swing.JPanel;
import java.awt.Dimension;
import java.awt.Graphics;


public class TelaJogo extends JPanel {

    private Jogo jogo;
    private Dimension size;

    private long lastTime = System.currentTimeMillis();
    private int frames = 0;

    



    public TelaJogo(Jogo jogo) {
        this.jogo = jogo;

        setPanelSize();
        
    }

    private void setPanelSize() {
        size = new Dimension(640, 640);
        setMinimumSize(size);
        setPreferredSize(size);
        setMaximumSize(size);


    }
    
    
    @Override
    public void paintComponent(Graphics g) {
        super.paintComponent(g);

        
        jogo.getRender().render(g);
    }
}
