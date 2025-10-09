package main.java;


import javax.swing.JFrame;



import scenes.Menu;
import scenes.Playing;
import scenes.Settings;

public class Jogo extends JFrame implements Runnable {

    private TelaJogo telaJogo;
    
    private final double FPS_SET = 120.0;
    private final double UPS_SET = 60.0;
    
    
    private int updates;
    private long lastTimeUPS;

    private Thread gamThread;

    
    
    //Classes
    private Render render;
    private Menu menu;
    private Playing playing;
    private Settings settings;

    public Jogo() {

        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setLocationRelativeTo(null);

        initClasses();
        
        add(telaJogo);
        pack();

        setTitle("Jogo Tower Defense");
        
 
        setVisible(true); // <- mover para o final!
    }
    private void initClasses(){

        render = new Render(this);
        telaJogo = new TelaJogo(this);
        menu = new Menu(this);
        playing = new Playing(this);
        settings = new Settings(this);
    }

    

    private void start() {
        gamThread = new Thread(this);
        gamThread.start();
        //lastUpdate = System.nanoTime();
        //lastFrame = System.nanoTime();
        //lastTimeUPS = System.currentTimeMillis();
    }



    private void callUPS() {
        if (System.currentTimeMillis() - lastTimeUPS >= 1000) {
            System.out.println("UPS: "+updates);
            updates = 0;
            lastTimeUPS = System.currentTimeMillis();
        }
        
    }

    private void updateGame() {
        
        //System.out.println("Game Updated");
    }

    public static void main(String[] args) {
        Jogo jogo = new Jogo();
        jogo.telaJogo.initInputs();
        jogo.start();
}

@Override
    public void run() {
        
        double timePerFrame= 1000000000.0 / FPS_SET;
        double timePerUpdate= 1000000000.0 / UPS_SET;
        
        long lastFrame= System.nanoTime();
        long lastUpdate= System.nanoTime();
        
        long lastTimeCheck = System.currentTimeMillis();
        
       
        int frames = 0;
        int updates = 0;

        long now;

        while (true){
            now = System.nanoTime();

            if (now - lastFrame >= timePerFrame) {
                    repaint();
                    lastFrame = now; 
                    frames++;
                }
            

            if (now - lastUpdate >= timePerUpdate) {
                updateGame();
                lastUpdate = now;
                updates++;
            }
            if (System.currentTimeMillis() - lastTimeCheck >= 1000) {
                System.out.println("FPS: "+frames+" | UPS: "+updates);
                frames = 0;
                updates = 0;
                lastTimeCheck = System.currentTimeMillis();
            } 
        }
    }
    //Getters and Setters
    public Render getRender(){
        return render;
    }

    public Menu getMenu(){
        return menu;
    }

    public Playing getPlaying(){
        return playing;
    }
    
    public Settings getSettings(){
        return settings;
    }
}