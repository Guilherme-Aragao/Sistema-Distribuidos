/**
 * Classe Client que interage com um serviço remoto para realizar operações matemáticas.
 */
package cliente;

import java.io.*;
import java.rmi.*;

import servico.Operacao;

public class Client {
    public static void main(String args[]) {
        // Configura o gerenciador de segurança e a política de segurança para RMI
        System.setSecurityManager(new RMISecurityManager());
        System.setProperty("java.security.policy", "file:///C:/Users/botel/eclipse-workspace/unievaRMI/fabio.policy");

        try {
            // Localiza o serviço remoto de operações matemáticas
            Operacao opp = (Operacao) Naming.lookup("OppMathServer");

            System.out.println("Objeto de Operações Matemáticas localizado.");

            // Parse dos argumentos para definir o tipo de operação e os operandos
            int tipoOperacao = Integer.parseInt(args[0]);
            int a = Integer.parseInt(args[1]);
            int b = Integer.parseInt(args[2]);
            int resultado = 0;

            // Executa a operação baseada no tipo informado
            if (tipoOperacao == 1) {
                resultado = opp.Soma(a, b);
                System.out.println("Executando soma.");
            } else if (tipoOperacao == 2) {
                resultado = opp.Produto(a, b);
                System.out.println("Executando produto.");
            }

            // Exibe o resultado da operação
            System.out.println("Resultado = " + resultado);
        } catch (Exception e) {
            System.err.println("Erro durante a execução: " + e.getMessage());
        } finally {
            // Encerra a aplicação após a execução
            System.exit(0);
        }
    } // fim do método main
} // fim da classe Client
