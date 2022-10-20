package com.cybertronicaoeltda.services.repository;

import com.cybertronicaoeltda.services.entity.InformeTecnico;
import com.cybertronicaoeltda.services.entity.Usuario;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface UsuarioRepository extends JpaRepository<Usuario, Integer> {

    // Búsquedas únicas
    Optional<Usuario> findBySub(String sub);
    Optional<Usuario> findByCorreo(String correo);
    Optional<Usuario> findByTelefono(Long telefono);

    // Búsqueda por listas
    List<Usuario> findAllByNombre(String nombre);
    List<Usuario> findAllByApellido(String apellido);
    List<Usuario> findAllByArea(String area);
    List<Usuario> findAllByCargo(String cargo);
    List<Usuario> findAllByRol(String rol);
    List<Usuario> findAllByEstado(String estado);

    // Existencia de individuales
    boolean existsBySub(String sub);
    boolean existsByCorreo(String correo);
    boolean existsByTelefono(Long telefono);

    // Eliminación
    void deleteByCorreo(String correo);
    void deleteByTelefono(Long telefono);
    void deleteBySub(String sub);



}
