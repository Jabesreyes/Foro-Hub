package foro.hub.api.topico;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

import java.time.LocalDateTime;

public record DatosRegistroTopico(
        @NotBlank
        String titulo,
        @NotBlank
        String mensaje,
        @NotNull
        LocalDateTime fecha_creacion,
        @NotNull
        Status status,
        @NotBlank
        String autor,
        @NotBlank
        String curso
) {
}
