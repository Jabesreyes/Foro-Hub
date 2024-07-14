package foro.hub.api.domain.topico;

import java.time.LocalDateTime;

public record DatosDetallesTopico(
        long id,
        String titulo,
        String mensaje,
        LocalDateTime fechaCreacion,
        Status status,
        String autor,
        String curso
) {
}
