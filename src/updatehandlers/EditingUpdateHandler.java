package updatehandlers;

import main.java.Jogo;
import main.java.GameStates;

public class EditingUpdateHandler extends AbstractUpdateHandler {

    public EditingUpdateHandler(Jogo jogo) {
        super(jogo, GameStates.EDIT);
    }

    @Override
    protected void doUpdate() {
        // Adicione a lógica de atualização do Editor aqui (ex: animação de ferramentas).
    }
}