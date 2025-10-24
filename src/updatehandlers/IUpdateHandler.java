package updatehandlers;

public interface IUpdateHandler {
    // Define o próximo manipulador na cadeia e o retorna (para encadeamento
    // fluente).
    IUpdateHandler setNext(IUpdateHandler handler);

    // Método para tratar a requisição de atualização.
    boolean handleUpdate();
}