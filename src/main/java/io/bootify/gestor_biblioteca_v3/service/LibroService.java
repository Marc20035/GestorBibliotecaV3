package io.bootify.gestor_biblioteca_v3.service;

import io.bootify.gestor_biblioteca_v3.domain.Libro;
import io.bootify.gestor_biblioteca_v3.domain.Prestamo;
import io.bootify.gestor_biblioteca_v3.model.LibroDTO;
import io.bootify.gestor_biblioteca_v3.repos.LibroRepository;
import io.bootify.gestor_biblioteca_v3.repos.PrestamoRepository;
import io.bootify.gestor_biblioteca_v3.util.NotFoundException;
import io.bootify.gestor_biblioteca_v3.util.WebUtils;
import java.util.List;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;


@Service
public class LibroService {

    private final LibroRepository libroRepository;
    private final PrestamoRepository prestamoRepository;

    public LibroService(final LibroRepository libroRepository,
            final PrestamoRepository prestamoRepository) {
        this.libroRepository = libroRepository;
        this.prestamoRepository = prestamoRepository;
    }

    public List<LibroDTO> findAll() {
        final List<Libro> libroes = libroRepository.findAll(Sort.by("id"));
        return libroes.stream()
                .map(libro -> mapToDTO(libro, new LibroDTO()))
                .toList();
    }

    public LibroDTO get(final Long id) {
        return libroRepository.findById(id)
                .map(libro -> mapToDTO(libro, new LibroDTO()))
                .orElseThrow(NotFoundException::new);
    }

    public Long create(final LibroDTO libroDTO) {
        final Libro libro = new Libro();
        mapToEntity(libroDTO, libro);
        return libroRepository.save(libro).getId();
    }

    public void update(final Long id, final LibroDTO libroDTO) {
        final Libro libro = libroRepository.findById(id)
                .orElseThrow(NotFoundException::new);
        mapToEntity(libroDTO, libro);
        libroRepository.save(libro);
    }

    public void delete(final Long id) {
        libroRepository.deleteById(id);
    }

    private LibroDTO mapToDTO(final Libro libro, final LibroDTO libroDTO) {
        libroDTO.setId(libro.getId());
        libroDTO.setTitulo(libro.getTitulo());
        libroDTO.setAutor(libro.getAutor());
        libroDTO.setIsbn(libro.getIsbn());
        libroDTO.setAnioPublicacion(libro.getAnioPublicacion());
        libroDTO.setEditorial(libro.getEditorial());
        libroDTO.setCategoria(libro.getCategoria());
        return libroDTO;
    }

    private Libro mapToEntity(final LibroDTO libroDTO, final Libro libro) {
        libro.setTitulo(libroDTO.getTitulo());
        libro.setAutor(libroDTO.getAutor());
        libro.setIsbn(libroDTO.getIsbn());
        libro.setAnioPublicacion(libroDTO.getAnioPublicacion());
        libro.setEditorial(libroDTO.getEditorial());
        libro.setCategoria(libroDTO.getCategoria());
        return libro;
    }

    public String getReferencedWarning(final Long id) {
        final Libro libro = libroRepository.findById(id)
                .orElseThrow(NotFoundException::new);
        final Prestamo libroPrestamo = prestamoRepository.findFirstByLibro(libro);
        if (libroPrestamo != null) {
            return WebUtils.getMessage("libro.prestamo.libro.referenced", libroPrestamo.getId());
        }
        return null;
    }

}
