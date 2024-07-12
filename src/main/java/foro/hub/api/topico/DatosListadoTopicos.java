package foro.hub.api.topico;

import java.time.LocalDateTime;

public record DatosListadoTopicos(String titulo, String mensaje, LocalDateTime fecha_creacion, Status status, String autor, String curso) {
    public DatosListadoTopicos(Topico topico){
        this(topico.getTitulo(), topico.getMensaje(), topico.getFecha_creacion(), topico.getStatus(), topico.getAutor(), topico.getCurso());
    }
}
