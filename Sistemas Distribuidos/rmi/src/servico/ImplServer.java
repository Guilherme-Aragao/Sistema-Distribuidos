package servico;

import java.rmi.*;
import java.rmi.server.UnicastRemoteObject;

/**
 * Implementação do servidor que fornece serviços de operações matemáticas.
 * Esta classe implementa a interface Operacao e estende UnicastRemoteObject para permitir o acesso remoto.
 */
public class ImplServer extends UnicastRemoteObject implements Operacao {

    /**
     * Construtor que cria uma instância do servidor de operações matemáticas.
     * 
     * @param name Nome do servidor.
     * @throws RemoteException Se ocorrer um erro de comunicação durante a chamada de método remoto.
     */
    public ImplServer(String name) throws RemoteException {
        super();  // Chama o construtor da superclasse UnicastRemoteObject
        System.out.println("Servidor de Operações Matemáticas criado!");
    }

    /**
     * Realiza a soma de dois inteiros.
     * 
     * @param varA Primeiro operando.
     * @param varB Segundo operando.
     * @return O resultado da soma.
     */
    public int Soma(int varA, int varB) {
        int soma = varA + varB;
        return soma;
    }

    /**
     * Realiza o produto de dois inteiros.
     * 
     * @param varA Primeiro operando.
     * @param varB Segundo operando.
     * @return O resultado do produto.
     */
    public int Produto(int varA, int varB) {
        int produto = varA * varB;
        return produto;
    }

}
