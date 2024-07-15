package foro.hub.api.controller;

import foro.hub.api.domain.topico.*;
import io.swagger.v3.oas.annotations.security.SecurityRequirement;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponentsBuilder;

import java.net.URI;
import java.util.Optional;


@RestController
@RequestMapping("/topicos")
@SecurityRequirement(name = "bearer-key")
public class TopicoController {

    @Autowired
    private TopicoRepository topicoRepository;

    @PostMapping
    public ResponseEntity registrarTopico(@RequestBody DatosRegistroTopico datosRegistroTopico, UriComponentsBuilder uriComponentsBuilder){
        if (topicoRepository.findByTituloOrMensaje(datosRegistroTopico.titulo(), datosRegistroTopico.mensaje()).isEmpty()){
            Topico topico = topicoRepository.save(new Topico(datosRegistroTopico));
            URI url = uriComponentsBuilder.path("/topicos/{id}").buildAndExpand(topico.getId()).toUri();
            return ResponseEntity.created(url).body(topico);

        }else{
            System.out.println("Ya existe un Topico con el mismo titulo o mensaje, no se puede guardar.");
        }
        return null;
    }

    @GetMapping
    public ResponseEntity<Page<DatosListadoTopicos>> listadoTopicos(@PageableDefault(size=10, sort = "fecha", direction = Sort.Direction.ASC) Pageable paginacion){
        return ResponseEntity.ok(topicoRepository.findAll(paginacion).map(DatosListadoTopicos::new));
    }

    @GetMapping("/{id}")
    public ResponseEntity<DatosDetallesTopico> obtenerTopico(@PathVariable Long id) {
        var topico = topicoRepository.findById(id);
        if (topico.isPresent()) {
            return ResponseEntity.ok(new DatosDetallesTopico(
                    topico.get().getId(),
                    topico.get().getTitulo(),
                    topico.get().getMensaje(),
                    topico.get().getFecha(),
                    topico.get().getStatus(),
                    topico.get().getAutor(),
                    topico.get().getCurso()
            ));
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @PutMapping("/{id}")
    public ResponseEntity<DatosDetallesTopico> actualizarTopico(@PathVariable Long id, @RequestBody DatosActualizacionTopico datosActualizacionTopico) {
        Optional<Topico> topicoOptional = topicoRepository.findById(id);
        if (topicoOptional.isPresent()) {
            Topico topico = topicoOptional.get();
            topico.setTitulo(datosActualizacionTopico.titulo());
            topico.setMensaje(datosActualizacionTopico.mensaje());
            topico.setFecha(datosActualizacionTopico.fecha());
            topico.setStatus(datosActualizacionTopico.status());
            topico.setAutor(datosActualizacionTopico.autor());
            topico.setCurso(datosActualizacionTopico.curso());
            topicoRepository.save(topico);
            return ResponseEntity.ok(new DatosDetallesTopico(topico.getId(), topico.getTitulo(), topico.getMensaje(), topico.getFecha(), topico.getStatus(), topico.getAutor(), topico.getCurso()));
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> eliminarTopico(@PathVariable Long id) {
        Optional<Topico> topicoOptional = topicoRepository.findById(id);
        if (topicoOptional.isPresent()) {
            topicoRepository.deleteById(id);
            return ResponseEntity.noContent().build();
        } else {
            return ResponseEntity.notFound().build();
        }
    }

}
