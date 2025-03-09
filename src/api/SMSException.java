// Exceção Personalizada:
// Usada para lidar com erros na API da vivo

package api;

public class SMSException extends Exception {
    private static final long serialVersionUID = 1L;

    public SMSException(String str) {
        super( str );
    }
}
