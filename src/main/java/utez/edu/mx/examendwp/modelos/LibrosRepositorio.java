package utez.edu.mx.examendwp.modelos;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;


@Repository
public interface LibrosRepositorio extends JpaRepository<Libros, String> {
    @Query(value = "SELECT * FROM libros ORDER BY autor;", nativeQuery = true)
    List<Libros> listarOrdenadoPorAutor();
    @Query(value = "SELECT * FROM libros ORDER BY fecha_publicacion;", nativeQuery = true)
    List<Libros> listarOrdenadoPorFechaPublicacion();

    @Query(value = "SELECT * FROM libros WHERE imagen IS NOT NULL", nativeQuery = true)
    List<Libros> listarLibrosConImagen();
}
