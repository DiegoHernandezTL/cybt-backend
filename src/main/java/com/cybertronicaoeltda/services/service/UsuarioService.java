package com.cybertronicaoeltda.services.service;

import com.cybertronicaoeltda.services.dto.UsuarioDto;
import com.cybertronicaoeltda.services.entity.Usuario;
import com.cybertronicaoeltda.services.repository.UsuarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
@Transactional
public class UsuarioService {

    @Autowired
    private UsuarioRepository usuarioRepository;


    // Búsquedas individuales
    public Optional<Usuario> fyndBySub(String sub) { return usuarioRepository.findBySub(sub); }

    public Optional<Usuario> findById(int id) { return usuarioRepository.findById(id); }
    public Optional<Usuario> findByCorreo(String correo) { return usuarioRepository.findByCorreo(correo.toLowerCase()); }
    public Optional<Usuario> findByTelefono(Long telefono) { return usuarioRepository.findByTelefono(telefono); }


    // Búsquedas grupales

    public List<Usuario> findAll() { return usuarioRepository.findAll(); }
    public List<Usuario> findAllByNombre(String nombre) { return usuarioRepository.findAllByNombre(nombre.toLowerCase()); }
    public List<Usuario> findAllByApellido(String apellido){ return usuarioRepository.findAllByApellido(apellido.toLowerCase()); }
    public List<Usuario> findAllByArea(String area){ return usuarioRepository.findAllByArea(area.toLowerCase()); }
    public List<Usuario> findAllByCargo(String cargo){ return usuarioRepository.findAllByCargo(cargo.toLowerCase()); }
    public List<Usuario> findAllByRol(String rol){ return usuarioRepository.findAllByRol(rol.toLowerCase()); }
    public List<Usuario> findAllByEstado(String estado){ return usuarioRepository.findAllByEstado(estado.toLowerCase()); }


    // Existencia de individuales
    public boolean existsBySub(String sub) { return usuarioRepository.existsBySub(sub); }

    public boolean existsById(int id) { return usuarioRepository.existsById(id); }
    public boolean existsByCorreo(String correo) { return usuarioRepository.existsByCorreo(correo.toLowerCase()); }
    public boolean existsByTelefono(Long telefono) { return usuarioRepository.existsByTelefono(telefono); }


    // Eliminación por individuales

    public int deleteBySub(String sub){
        if(usuarioRepository.existsBySub(sub)) {
            usuarioRepository.deleteBySub(sub);
            if(usuarioRepository.existsBySub(sub))
                return 2; // Ha fallado al eliminar
            else
                return 0;
        } else {
            return 1; // No existe el usuario
        }

    }
    public int deleteByCorreo(String correo){
        if(usuarioRepository.existsByCorreo(correo.toLowerCase())) {
            usuarioRepository.deleteByCorreo(correo.toLowerCase());
            if(usuarioRepository.existsByCorreo(correo.toLowerCase()))
                return 2; // Ha fallado al eliminar
            else
                return 0;
        } else {
            return 1; // No existe el usuario
        }

    }
    public int deleteByTelefono(Long telefono){
        if(usuarioRepository.existsByTelefono(telefono)) {
            usuarioRepository.existsByTelefono(telefono);
            if(usuarioRepository.existsByTelefono(telefono))
                return 2; // Ha fallado al eliminar
            else
                return 0;
        } else {
            return 1; // No existe el usuario
        }

    }


    // Creación

    public int save(UsuarioDto usuarioDto) {
        try {
            // Validaciones
            if(usuarioRepository.existsByCorreo(usuarioDto.getCorreo().toLowerCase())) {
                return 2; // Correo ya registrado
            }
            if(Long.parseLong(usuarioDto.getTelefono()) != 0) {
                if (usuarioRepository.existsByTelefono(Long.parseLong(usuarioDto.getTelefono())))
                    return 3; // Teléfono ya registrado.
            }

            Usuario nuevoUsuario = new Usuario(
                    usuarioDto.getSub(),
                    usuarioDto.getCorreo().toLowerCase(),
                    usuarioDto.getNombre().toLowerCase(),
                    usuarioDto.getApellido().toLowerCase(),
                    usuarioDto.getArea().toLowerCase(),
                    usuarioDto.getCargo().toLowerCase(),
                    Long.parseLong(usuarioDto.getTelefono()),
                    usuarioDto.getRol().toLowerCase(),
                    usuarioDto.getEstado().toLowerCase()
            );
            usuarioRepository.save(nuevoUsuario);
            if (usuarioRepository.existsByCorreo(nuevoUsuario.getCorreo())) {
                return 0; //Exitoso
            } else {
                return 1;
            }
        } catch (Exception e) {
            System.out.println(e);
            return 1; // Algo falló realizando la operación
        }
    }

    // Actualización

    public int update(String sub, UsuarioDto usuarioDto) {
        try {
            // Validaciones
            if (usuarioRepository.existsBySub(sub)) {
                Usuario usuarioBase = usuarioRepository.findBySub(sub).get();
                if(usuarioBase.getCorreo() == usuarioDto.getCorreo().toLowerCase()) {
                    return 3; // No se puede cambiar el correo
                }
                if(usuarioRepository.existsByTelefono(Long.parseLong(usuarioDto.getTelefono())) && Long.parseLong(usuarioDto.getTelefono()) != usuarioBase.getTelefono()) {
                    return 4; // Teléfono ya registrado.
                }

                usuarioBase.setSub(usuarioDto.getSub());
                usuarioBase.setNombre(usuarioDto.getNombre().toLowerCase());
                usuarioBase.setApellido(usuarioDto.getApellido().toLowerCase());
                usuarioBase.setCorreo(usuarioDto.getCorreo().toLowerCase());
                usuarioBase.setArea(usuarioDto.getArea().toLowerCase());
                usuarioBase.setCargo(usuarioDto.getCargo().toLowerCase());
                usuarioBase.setTelefono(Long.parseLong(usuarioDto.getTelefono()));
                usuarioBase.setRol(usuarioDto.getRol().toLowerCase());
                usuarioBase.setEstado(usuarioDto.getEstado().toLowerCase());

                usuarioRepository.save(usuarioBase);
                return 0;

            }else {
                return 2; // Usuario no existe
            }
        } catch (Exception e) {
            return 1; //Algo falló realizando la operación
        }
    }


}
