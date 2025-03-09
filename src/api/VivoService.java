// Adaptador para Vivo
// Converte os dados para o formato exigido pela API da vivo e Exceções

package api;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class VivoService {

    public void enviarSMS(String origem, String destino, LocalDateTime time, String[] msgs) throws SMSException {
        DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy/MM/dd HH:mm:ss");

        if (msgs.length == 0) {
            throw new SMSException("Mensagem vazia. Nao e possivel o envio");
        }

        // Verifica e trunca cada parte da mensagem para 120 caracteres
        for (int i = 0; i < msgs.length; i++) {
            if (msgs[i].length() > 120) {
                msgs[i] = msgs[i].substring(0, 120); // Trunca a mensagem
                System.out.println("Aviso: Parte da mensagem foi truncada para 120 caracteres.");
            }
        }

        System.out.println("Vivo SMS");
        System.out.println("Enviado em " + dtf.format(time));
        System.out.println("-------------------");
        System.out.println("From: " + origem + " To " + destino);
        System.out.println("-------------------");

        for (int i = 0; i < msgs.length; i++) {
            System.out.println(msgs[i]);
        }
        System.out.println();
    }
}
