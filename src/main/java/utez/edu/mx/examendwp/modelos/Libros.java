package utez.edu.mx.examendwp.modelos;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.annotations.GenericGenerator;

import java.time.LocalDate;
@Entity
@Table(name = "libros")
@NoArgsConstructor
@AllArgsConstructor
@Setter
@Getter
public class Libros {
    @Id
    @GeneratedValue(generator = "uuid")
    @GenericGenerator(name = "uuid", strategy = "uuid2")
    private String id;
    @Column(nullable = false)
    private String autor;
    @Column(nullable = false)
    private String nombre;
    @Column(nullable = false, name = "fecha_publicacion")
    private LocalDate fechaPublicacion;
    @Column(columnDefinition="LONGTEXT")
    private String imagen;
}
