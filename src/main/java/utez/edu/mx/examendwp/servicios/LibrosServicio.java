package utez.edu.mx.examendwp.servicios;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import utez.edu.mx.examendwp.modelos.Libros;
import utez.edu.mx.examendwp.modelos.LibrosRepositorio;
import utez.edu.mx.examendwp.utiles.Response;


import java.sql.SQLException;
import java.util.List;

@Service
public class LibrosServicio {

    @Autowired
    LibrosRepositorio repository;

    @Transactional(rollbackFor = {SQLException.class})
    public Response<Libros> insert(Libros Libros) {
        try {
            return new Response<>(this.repository.saveAndFlush(Libros), false, 201, "OK");
        } catch (Exception e) {
            return new Response<>(null, true, 500, "Error de servidor");
        }
    }

    @Transactional(rollbackFor = {SQLException.class})
    public Response<Libros> update(Libros Libros) {
        try {
            if (!this.repository.existsById(Libros.getId())) return new Response<>(null, true, 400, "ERROR");
            return new Response<>(this.repository.saveAndFlush(Libros), false, 201, "OK");
        } catch (Exception e) {
            return new Response<>(null, true, 500, "Error de servidor");
        }
    }

    @Transactional(rollbackFor = {SQLException.class})
    public Response<Libros> delete(String id) {
        try {
            if (!this.repository.existsById(id)) return new Response<>(null, true, 400, "ERROR");
            this.repository.deleteById(id);
            return new Response<>(null, false, 200, "OK");
        } catch (Exception e) {
            return new Response<>(null, true, 500, "Error de servidor");
        }
    }

    @Transactional(readOnly = true)
    public Response<List<Libros>> getAll() {
        try {
            return new Response<>(this.repository.findAll(), false, 200, "OK");
        } catch (Exception e) {
            return new Response<>(null, true, 500, "Error de servidor");
        }
    }

    @Transactional(readOnly = true)
    public Response<Libros> getById(String id) {
        try {
            return new Response<>(this.repository.findById(id).orElse(null), false, 200, "OK");
        } catch (Exception e) {
            return new Response<>(null, true, 500, "Error de servidor");
        }
    }

    @Transactional(readOnly = true)
    public Response<List<Libros>> getConImagen() {
        try {
            return new Response<>(repository.listarLibrosConImagen(), false, 200, "OK");
        } catch (Exception e) {
            return new Response<>(null, true, 500, "Error de servidor");
        }
    }

    @Transactional(readOnly = true)
    public Response<List<Libros>> getOrdenadoPorAutor() {
        try {
            return new Response<>(this.repository.listarOrdenadoPorAutor(), false, 200, "OK");
        } catch (Exception e) {
            return new Response<>(null, true, 500, "Error de servidor");

        }
    }

    @Transactional(readOnly = true)
    public Response<List<Libros>> getPorFechaPublicacion() {
        try {
            return new Response<>(repository.listarOrdenadoPorFechaPublicacion(), false, 200, "OK");
        } catch (Exception e) {
            return new Response<>(null, true, 500, "Error de servidor");
        }
    }


}
