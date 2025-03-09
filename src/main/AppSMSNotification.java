package main;

import service.FachadaSMS;
import translation.Translator;
import java.util.Scanner;

public class AppSMSNotification {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Solicita o número de origem
        System.out.print("Digite o número de origem (formato CSP DDD PPPPP SSSS): ");
        String origem = scanner.nextLine();

        // Solicita o número de destino
        System.out.print("Digite o número de destino (formato CSP DDD PPPPP SSSS): ");
        String destino = scanner.nextLine();

        // Valida os números de telefone
        if (origem.length() != 13 || destino.length() != 13) {
            System.out.println("Número de telefone inválido. O formato deve ser CSP DDD PPPPP SSSS.");
            scanner.close();
            return;
        }

        // Solicita a mensagem
        System.out.print("Digite a mensagem: ");
        String texto = scanner.nextLine();

        // Valida a mensagem
        if (texto.isEmpty()) {
            System.out.println("A mensagem não pode estar vazia.");
            scanner.close();
            return;
        }

        // Pergunta se o usuário deseja traduzir a mensagem
        System.out.print("Deseja traduzir a mensagem para o inglês? (s/n): ");
        String traduzir = scanner.nextLine();
        if (traduzir.equalsIgnoreCase("s")) {
            try {
                texto = Translator.translate("pt", "en", texto); // Traduz de português para inglês
            } catch (Exception e) {
                System.out.println("Erro ao traduzir a mensagem: " + e.getMessage());
                // Decide o que fazer em caso de erro (por exemplo, continuar com o texto original)
            }
        }

        // Fecha o scanner
        scanner.close();

        // Envia a mensagem usando a FachadaSMS
        FachadaSMS.enviarMensagem(origem, destino, texto);
    }
}