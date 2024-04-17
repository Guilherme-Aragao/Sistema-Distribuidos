package servico;

import java.rmi.*;
import java.rmi.server.*;

/**
 * Classe Server que configura e inicia o servidor de RMI para operações matemáticas.
 */
public class Server {

    public static void main(String args[]) {
        // Define a política de segurança do sistema para o RMI
        System.setProperty("java.security.policy", "file:///C:/tmp/fabio.policy");

        // Configura o gerenciador de segurança do RMI
        System.setSecurityManager(new RMISecurityManager());

        try {
            // Cria uma instância do servidor de operações matemáticas e registra no RMI Registry
            ImplServer obj = new ImplServer("OppMathServer");
            Naming.rebind("OppMathServer", obj);

            System.out.println("Servidor de Operações Matemáticas Registrado com Sucesso!");
        } catch (Exception e) {
            // Exibe no console a mensagem de erro se ocorrer alguma exceção
            System.out.println("Erro ao registrar o servidor: " + e.getMessage());
        }
    }
}
