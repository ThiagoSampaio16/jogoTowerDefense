package updatehandlers;

import main.java.Jogo;
import main.java.GameStates;

public abstract class AbstractUpdateHandler implements IUpdateHandler {
    protected IUpdateHandler nextHandler;
    protected Jogo jogo;
    protected GameStates responsibleState;

    public AbstractUpdateHandler(Jogo jogo, GameStates state) {
        this.jogo = jogo;
        this.responsibleState = state;
    }

    @Override
    public IUpdateHandler setNext(IUpdateHandler handler) {
        this.nextHandler = handler;
        return handler;
    }

    // A implementação padrão do handleUpdate: verifica o estado, executa o
    // trabalho, ou passa para o próximo.
    @Override
    public boolean handleUpdate() {
        if (GameStates.gameState == responsibleState) {
            doUpdate(); // Chama o método concreto para fazer o trabalho
            return true;
        } else if (nextHandler != null) {
            return nextHandler.handleUpdate(); // Passa para o próximo
        }
        return false; // Não tratado e fim da cadeia
    }

    // Método abstrato que as subclasses devem implementar com a lógica de
    // atualização.
    protected abstract void doUpdate();
}