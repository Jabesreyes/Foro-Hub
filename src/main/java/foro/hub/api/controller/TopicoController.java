package foro.hub.api.controller;

import foro.hub.api.topico.DatosListadoTopicos;
import foro.hub.api.topico.DatosRegistroTopico;
import foro.hub.api.topico.Topico;
import foro.hub.api.topico.TopicoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.web.PageableDefault;
import org.springframework.web.bind.annotation.*;



@RestController
@RequestMapping("/topicos")
public class TopicoController {

    @Autowired
    private TopicoRepository topicoRepository;

    @PostMapping
    public void registrarTopico(@RequestBody DatosRegistroTopico datosRegistroTopico){
        System.out.println("llego correctamente");
        System.out.println(datosRegistroTopico);

        // Buscar si ya existe un Topico con el mismo titulo o mensaje
        if (topicoRepository.findByTituloOrMensaje(datosRegistroTopico.titulo(), datosRegistroTopico.mensaje()).isEmpty()){
            topicoRepository.save(new Topico(datosRegistroTopico));
            System.out.println("Topico registrado exitosamente");
        }else{
            System.out.println("Ya existe un Topico con el mismo titulo o mensaje, no se puede guardar.");
        }
    }

    @GetMapping
    public Page<DatosListadoTopicos> listadoTopicos(@PageableDefault(size=10) Pageable paginacion){
        return topicoRepository.findAll(paginacion).map(DatosListadoTopicos::new);
    }
}
