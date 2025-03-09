// Classe Principal (AppSMSNotification)
// Ponto de entrada do programa. FachadaSMS para enviar a mensagem.

import service.FachadaSMS;

public class AppSMSNotification {

    public static void main(String[] args)  {
		/*
		SMSSender sender = new TimSMSAdapter();
		
		SMS message = new SMS("83988885544","83988221133","Bom dia. Seu boleto ja esta disponivel para pagamento");
		
		sender.sendSMS(message);	
		*/
        String origem = "1583988885544";
        String destino = "1583988221133";
        String texto = "Bom dia. Esse mês temos vários itens com desconto de até 40%. Aproveite!!!!";

        FachadaSMS.enviarMensagem(origem, destino, texto);
    }
}
