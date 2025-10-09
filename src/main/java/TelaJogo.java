package main.java;

import javax.swing.JPanel;

import inputs.KeyboardListner;
import inputs.MyMouseListener;

import java.awt.Dimension;
import java.awt.Graphics;



public class TelaJogo extends JPanel {

    private Jogo jogo;
    private Dimension size;

    private long lastTime = System.currentTimeMillis();
    private int frames = 0;

    private MyMouseListener myMouseListener;
    private KeyboardListner keyboardListner;

    
    


    public TelaJogo(Jogo jogo) {
        this.jogo = jogo;

        setPanelSize();
        
    }


    public void initInputs() {
        myMouseListener = new MyMouseListener(jogo);
        keyboardListner = new KeyboardListner();
        
        this.addMouseListener(myMouseListener);
        this.addMouseMotionListener(myMouseListener);
        this.addKeyListener(keyboardListner);

        requestFocus(); // <- Muito importante para o KeyListener funcionar!
        
    }

    private void setPanelSize() {
        size = new Dimension(640, 740);
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
