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
    public List<Usuario> findAllByNombre(String nombre) { return usuarioRepository.findAllByNombre(nombre.charAt(0) + nombre.substring(1)); }
    public List<Usuario> findAllByApellido(String apellido){ return usuarioRepository.findAllByApellido(apellido.charAt(0) + apellido.substring(1)); }
    public List<Usuario> findAllByArea(String area){ return usuarioRepository.findAllByArea(area.charAt(0) + area.substring(1)); }
    public List<Usuario> findAllByCargo(String cargo){ return usuarioRepository.findAllByCargo(cargo.charAt(0) + cargo.substring(1)); }
    public List<Usuario> findAllByRol(String rol){ return usuarioRepository.findAllByRol(rol.charAt(0) + rol.substring(1)); }
    public List<Usuario> findAllByEstado(String estado){ return usuarioRepository.findAllByEstado(estado.charAt(0) + estado.substring(1)); }


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
                    usuarioDto.getNombre().charAt(0) + usuarioDto.getNombre().substring(1),
                    usuarioDto.getApellido().charAt(0) + usuarioDto.getApellido().substring(1),
                    usuarioDto.getArea().charAt(0) + usuarioDto.getArea().substring(1),
                    usuarioDto.getCargo().charAt(0) + usuarioDto.getCargo().substring(1),
                    Long.parseLong(usuarioDto.getTelefono()),
                    usuarioDto.getRol().charAt(0) + usuarioDto.getRol().substring(1),
                    usuarioDto.getEstado().charAt(0) + usuarioDto.getEstado().substring(1)
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
                usuarioBase.setNombre(usuarioDto.getNombre().charAt(0) + usuarioDto.getNombre().substring(1));
                usuarioBase.setApellido(usuarioDto.getApellido().charAt(0) + usuarioDto.getApellido().substring(1));
                usuarioBase.setCorreo(usuarioDto.getCorreo().toLowerCase());
                usuarioBase.setArea(usuarioDto.getArea().charAt(0) + usuarioDto.getArea().substring(1));
                usuarioBase.setCargo(usuarioDto.getCargo().charAt(0) + usuarioDto.getCargo().substring(1));
                usuarioBase.setTelefono(Long.parseLong(usuarioDto.getTelefono()));
                usuarioBase.setRol(usuarioDto.getRol().charAt(0) + usuarioDto.getRol().substring(1));
                usuarioBase.setEstado(usuarioDto.getEstado().charAt(0) + usuarioDto.getEstado().substring(1));

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
