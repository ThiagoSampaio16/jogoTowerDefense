package updatehandlers;

import main.java.Jogo;
import main.java.GameStates;

public class MenuUpdateHandler extends AbstractUpdateHandler {

    public MenuUpdateHandler(Jogo jogo) {
        super(jogo, GameStates.MENU);
    }

    @Override
    protected void doUpdate() {
        //lógica de atualização do menu(ex: animações de fundo)
        // Se não houver lógica, a chamada pode ser omitida ou a cadeia tratada de forma diferente.
        // Deixamos vazio para seguir o comportamento original do switch, mas ele ainda consome o evento.
    }
}