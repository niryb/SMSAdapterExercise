// Adaptador para Vivo (VivoSMSAdapter)
// Conversão dos dados para a API da Vivo e tratamento de exceções.

// passo 1: classe que implementa o SMSSender

package api;

import model.SMS;

public class VivoSMSAdapter implements SMSSender {

    private final VivoService vivoService = new VivoService();

    @Override
    public boolean sendSMS(SMS sms) {
        try {
            String[] msgs = sms.getTexto().split("(?<=\\G.{120})");
            vivoService.enviarSMS(sms.getOrigem(), sms.getDestino(), sms.getTimestamp(), msgs);
            return true;
        } catch (SMSException e) {
            System.out.println("Erro ao enviar SMS pela Vivo: " + e.getMessage());
            return false;
        }
    }
}
