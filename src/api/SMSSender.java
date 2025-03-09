// Interface:
// Contrato para envio de mensagens

package api;

import model.SMS;

public interface SMSSender {

    public boolean sendSMS(SMS sms);
}
