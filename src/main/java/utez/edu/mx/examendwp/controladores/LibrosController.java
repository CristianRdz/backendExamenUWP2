package utez.edu.mx.examendwp.controladores;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import utez.edu.mx.examendwp.modelos.Libros;
import utez.edu.mx.examendwp.servicios.LibrosServicio;
import utez.edu.mx.examendwp.utiles.Response;

import java.util.List;

@Controller
@RequestMapping("/api/libros")
@CrossOrigin(origins = {"*"})
public class LibrosController {
    @Autowired
    LibrosServicio service;

    @GetMapping("/")
    public ResponseEntity<Response<List<Libros>>> getAll() {
        return new ResponseEntity<>(this.service.getAll(), HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Response<Libros>> getById(@PathVariable("id") String id) {
        return new ResponseEntity<>(this.service.getById(id), HttpStatus.OK);
    }

    @GetMapping("/autor")
    public ResponseEntity<Response<List<Libros>>> getOrdenadoPorAutor() {
        return new ResponseEntity<>(this.service.getOrdenadoPorAutor(), HttpStatus.OK);
    }

    @GetMapping("/fecha")
    public ResponseEntity<Response<List<Libros>>> getFechaPublicacion() {
        return new ResponseEntity<>(this.service.getPorFechaPublicacion(), HttpStatus.OK);
    }

    @GetMapping("/imagen")
    public ResponseEntity<Response<List<Libros>>> getConImagen() {
        return new ResponseEntity<>(this.service.getConImagen(), HttpStatus.OK);
    }

    @PostMapping("/")
    public ResponseEntity<Response<Libros>> inset(@RequestBody Libros Libros) {
        return new ResponseEntity<>(this.service.insert(Libros), HttpStatus.CREATED);
    }

    @PutMapping("/")
    public ResponseEntity<Response<Libros>> update(@RequestBody Libros Libros) {
        return new ResponseEntity<>(this.service.update(Libros), HttpStatus.CREATED);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Response<Libros>> delete(@PathVariable("id") String id) {
        return new ResponseEntity<>(this.service.delete(id), HttpStatus.CREATED);
    }
}
