// Fachada para Envio de SMS (FachadaSMS)

package service;

import api.SMSSender;
import api.SMSSenderFactory;
import model.SMS;

public class FachadaSMS {
    public static void enviarMensagem (String origem, String destino, String texto) {
        SMSSender sender = SMSSenderFactory.getSender(destino);
        SMS sms = new SMS(origem, destino, texto);
        boolean sucesso = sender.sendSMS(sms);

        if (sucesso) {
            exibirInformacoesSMS(sms, getOperadora(destino));

        }
        else {
            System.out.println("Falha no envio da mensagem");
        }
    }

    private static void exibirInformacoesSMS(SMS sms, String operadora) {
        System.out.println("Timestamp: " + sms.getTimestamp());
        System.out.println("From: " + sms.getOrigem());
        System.out.println("To: " + sms.getDestino());
        System.out.println("Mensagem: " + sms.getTexto());
        System.out.println("Mensagem enviada com sucesso para o número da operadora " + operadora);
    }

    private static String getOperadora(String destino) {
        String csp = destino.substring(0, 2); //extrai o CSP do número de destino
        switch (csp) {
            case "41":
                return "TIM";
            case "15":
                return "VIVO";
            default:
                return "Operadora desconhecida";
        }
    }
}


