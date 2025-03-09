// Fábrica de Envio de SMS (SMSSenderFactory)
// Escolhe automaticamente o adaptador correto com base no código da operadora.

package api;

public class SMSSenderFactory {
    public static SMSSender getSender(String phoneNumber) {
        String csp = phoneNumber.substring(0, 2);
        return switch (csp) {
            case "41" -> new TimSMSAdapter();
            case "15" -> new VivoSMSAdapter();
            default -> throw new IllegalArgumentException("Operadora não suportada");
        };
    }

}
