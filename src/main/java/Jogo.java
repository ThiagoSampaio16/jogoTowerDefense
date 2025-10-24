package main.java;

import javax.swing.JFrame;
import helpz.LoadSave;
import managers.TileManager;
import scenes.Menu;
import scenes.Playing;
import scenes.Settings;
import scenes.Editing;
import updatehandlers.*; // Importa as novas classes de manipuladores

public class Jogo extends JFrame implements Runnable {
    private TelaJogo telaJogo;
    private final double FPS_SET = 120.0;
    private final double UPS_SET = 60.0;
    private Thread gamThread;
    // Classes de Jogo
    private Render render;
    private Menu menu;
    private Playing playing;
    private Settings settings;
    private Editing editing;
    private TileManager tileManager;
    // NOVO: Cabeça da Cadeia de Responsabilidade para o Update
    private IUpdateHandler updateChainHead;

    // Construtor privado (Mantido do padrão Facade)
    private Jogo() {
        initClasses();
        createDefaultLevel();
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        add(telaJogo);
        pack();
        setTitle("Jogo Tower Defense");
    }

    // MÉTODO FACADE (Mantido)
    public static void startApplication() {
        Jogo jogo = new Jogo();
        jogo.telaJogo.initInputs();
        jogo.setVisible(true);
        jogo.start();
    }

    private void createDefaultLevel() {
        int[] arr = new int[400];
        for (int i = 0; i < arr.length; i++) {
            arr[i] = 0;
        }
        LoadSave.CreateLevel("new_level", arr);
    }

    // initClasses() modificado para montar a Cadeia de Responsabilidade
    private void initClasses() {
        tileManager = new TileManager();
        render = new Render(this);
        telaJogo = new TelaJogo(this);
        menu = new Menu(this);
        playing = new Playing(this);
        settings = new Settings(this);
        editing = new Editing(this);
        // Montagem da Cadeia de Responsabilidade
        IUpdateHandler playingHandler = new PlayingUpdateHandler(this);
        IUpdateHandler menuHandler = new MenuUpdateHandler(this);
        IUpdateHandler settingsHandler = new SettingsUpdateHandler(this);
        IUpdateHandler editingHandler = new EditingUpdateHandler(this);
        // Define a ordem da cadeia (a ordem não é crítica, pois o estado determina o
        // consumo)
        this.updateChainHead = playingHandler;
        playingHandler.setNext(menuHandler)
                .setNext(settingsHandler)
                .setNext(editingHandler);
    }

    private void start() {
        gamThread = new Thread(this);
        gamThread.start();
    }

    // MÉTODO updateGame() REFATORADO: AGORA CHAMA A CADEIA
    private void updateGame() {
        // Envia a requisição de atualização para o primeiro Handler da cadeia.
        updateChainHead.handleUpdate();
        // O antigo bloco 'switch (GameStates.gameState)' foi substituído pela cadeia.
    }

    public static void main(String[] args) {
        startApplication();
    }

    @Override
    public void run() {
        double timePerFrame = 1000000000.0 / FPS_SET;
        double timePerUpdate = 1000000000.0 / UPS_SET;
        long lastFrame = System.nanoTime();
        long lastUpdate = System.nanoTime();
        long lastTimeCheck = System.currentTimeMillis();
        int frames = 0;
        int updates = 0;
        long now;
        while (true) {
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
                System.out.println("FPS: " + frames + " | UPS: " + updates);
                frames = 0;
                updates = 0;
                lastTimeCheck = System.currentTimeMillis();
            }
        }
    }

    // Getters
    public Render getRender() {
        return render;
    }

    public Menu getMenu() {
        return menu;
    }

    public Playing getPlaying() {
        return playing;
    }

    public Settings getSettings() {
        return settings;
    }

    public Editing getEditor() {
        return editing;
    }

    public TileManager getTileManager() {
        return tileManager;
    }
}