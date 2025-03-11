// Modelo de Dados (SMS)

package model;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;


public class SMS {
    private String destino;
    private String origem;
    private String texto;
    private LocalDateTime timestamp;

    public SMS(String origem, String destino, String texto) {
        this.origem = origem;
        this.destino = destino;
        this.texto = texto;
        this.timestamp = LocalDateTime.now();
    }

    public String getTimestamp() {
        DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy/MM/dd HH:mm:ss");
        return timestamp.format(dtf);
    }

    public String getDestino() {
        return destino;
    }

    public void setDestino(String destino) {
        this.destino = destino;
    }

    public String getOrigem() {
        return origem;
    }

    public void setOrigem(String origem) {
        this.origem = origem;
    }

    public String getTexto() {
        return texto;
    }

    public void setTexto(String texto) {
        this.texto = texto;
    }

}
