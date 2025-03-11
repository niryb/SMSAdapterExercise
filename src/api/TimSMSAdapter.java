// Adaptador para TIM
// Implementa a Interface SMSSender e adapta a API da TIM

package api;

import model.SMS;

public class TimSMSAdapter implements SMSSender {

    @Override
    public boolean sendSMS(SMS sms) {
        // Verifica se o texto da mensagem está vazio
        if (sms.getTexto() == null || sms.getTexto().trim().isEmpty()) {
            System.out.println("Erro: A mensagem não pode estar vazia.");
            return false; // Retorna false para indicar falha no envio
        }

        // Se a mensagem não estiver vazia, prossegue com o envio
        System.out.println("Tim SMS - " + sms.getTimestamp());
        System.out.println("-------------------");
        System.out.println("From: " + sms.getOrigem());
        System.out.println("To  : " + sms.getDestino());
        System.out.println("-------------------");
        System.out.println(sms.getTexto());
        System.out.println();
        return true; // Retorna true para indicar sucesso no envio
    }
}
