package main.java;


import javax.swing.JFrame;

import helpz.LoadSave;
import managers.TileManager;
import scenes.Menu;
import scenes.Playing;
import scenes.Settings;
import scenes.Editing;

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
    private Editing editing;

    private TileManager tileManager;
    public Jogo() {

        initClasses();
        createDefaultLevel();

        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setLocationRelativeTo(null);

        
        
        add(telaJogo);
        pack();

        setTitle("Jogo Tower Defense");
        
 
        setVisible(true); // <- mover para o final!
    }

    private void createDefaultLevel() {
        int[] arr = new int[400];
        for(int i = 0; i < arr.length; i++){
            
                arr[i] = 0;
            
        }
        LoadSave.CreateLevel("new_level", arr);
    }

    private void initClasses(){

        tileManager = new TileManager();
        render = new Render(this);
        telaJogo = new TelaJogo(this);
        menu = new Menu(this);
        playing = new Playing(this);
        settings = new Settings(this);
        editing = new Editing(this);
    }

    

    private void start() {
        gamThread = new Thread(this);
        gamThread.start();
        //lastUpdate = System.nanoTime();
        //lastFrame = System.nanoTime();
        //lastTimeUPS = System.currentTimeMillis();
    }



    

    private void updateGame() {
        switch (GameStates.gameState) {
            case EDIT:
                
                break;

            case MENU:
                
                break;

            case PLAYING:
                playing.update();
                break;

            case SETTINGS:
                
                break;
        
            default:
                break;
        }
        
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
    public Editing getEditor(){
        return editing;
    }
    public TileManager getTileManager(){
        return tileManager;
    }
}