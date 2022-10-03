package com.cybertronicaoeltda.services.repository;

import com.cybertronicaoeltda.services.entity.InformeTecnico;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Date;
import java.util.List;
import java.util.Optional;

@Repository
public interface InformeTecnicoRepository extends JpaRepository<InformeTecnico, Integer> {

    // Sencillos
    Optional<InformeTecnico> findByEquipoSN(String equipoSN);

    // Listas
    List<InformeTecnico> findAllByCliente(String cliente);
    List<InformeTecnico> findAllByDependencia(String dependencia);
    List<InformeTecnico> findAllByEquipoMarca(String equipoMarca);
    List<InformeTecnico> findAllByEquipoNombre(String equipoNombre);
    List<InformeTecnico> findAllByFechaRetiro(String fechaRetiro);
    List<InformeTecnico> findAllByFechaRecibe(String fechaRecibe);
    List<InformeTecnico> findAllByTipo(int tipo);
    List<InformeTecnico> findAllByUsuario(String usuario);
    List<InformeTecnico> findAllByEquipoTipo(String equipoTipo);


    boolean existsByEquipoSN(String equipoSN);

    void deleteByEquipoSN(String equipoSN);

}
