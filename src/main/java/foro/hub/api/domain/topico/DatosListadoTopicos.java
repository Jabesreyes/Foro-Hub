package foro.hub.api.domain.topico;

import java.time.LocalDateTime;

public record DatosListadoTopicos(Long id, String titulo, String mensaje, LocalDateTime fecha, Status status, String autor, String curso) {
    public DatosListadoTopicos(Topico topico){
        this(topico.getId(), topico.getTitulo(), topico.getMensaje(), topico.getFecha(), topico.getStatus(), topico.getAutor(), topico.getCurso());
    }
}
