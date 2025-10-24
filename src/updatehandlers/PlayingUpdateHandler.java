package updatehandlers;

import main.java.Jogo;
import main.java.GameStates;

public class PlayingUpdateHandler extends AbstractUpdateHandler {
    public PlayingUpdateHandler(Jogo jogo) {
        super(jogo, GameStates.PLAYING);
    }

    @Override
    protected void doUpdate() {
        // Ação de atualização para o estado PLAYING
        jogo.getPlaying().update();
    }
}