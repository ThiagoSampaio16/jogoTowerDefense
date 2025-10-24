package updatehandlers;

import main.java.Jogo;
import main.java.GameStates;

public class SettingsUpdateHandler extends AbstractUpdateHandler {

    public SettingsUpdateHandler(Jogo jogo) {
        super(jogo, GameStates.SETTINGS);
    }

    @Override
    protected void doUpdate() {
        // Adicione qualquer lógica de atualização da tela de Configurações aqui.
    }
}