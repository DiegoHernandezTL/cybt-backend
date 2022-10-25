package com.cybertronicaoeltda.services.controller;

import com.cybertronicaoeltda.services.dto.Mensaje;
import com.cybertronicaoeltda.services.dto.UsuarioDto;
import com.cybertronicaoeltda.services.entity.Usuario;
import com.cybertronicaoeltda.services.service.UsuarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/user")
@CrossOrigin(origins = "http://10.147.17.75:4200/")
//@CrossOrigin(origins= "http://localhost:4200", allowedHeaders = {
//        "Content-type",
//},maxAge = 4800, allowCredentials = "false", methods = {RequestMethod.GET, RequestMethod.POST, RequestMethod.OPTIONS, RequestMethod.DELETE, RequestMethod.PUT})
public class UsuarioController {

    @Autowired
    private UsuarioService usuarioService;

    // Búsquedas individuales

    @GetMapping("/find/id/{id}")
    public ResponseEntity<Usuario> findById(
        @PathVariable("id") int id
    ) {
        if(usuarioService.existsById(id))
            return new ResponseEntity(usuarioService.findById(id), HttpStatus.OK);
        else
            return new ResponseEntity(new Mensaje("Usuario inexistente"), HttpStatus.NOT_FOUND);
    }

    @GetMapping("/find/email/{email}")
    public ResponseEntity<Usuario> findByCorreo(
            @PathVariable("email") String correo
    ) {
        if(usuarioService.existsByCorreo(correo))
            return new ResponseEntity(usuarioService.findByCorreo(correo), HttpStatus.OK);
        else
            return new ResponseEntity(new Mensaje("Usuario inexistente"), HttpStatus.NOT_FOUND);
    }

    @GetMapping("/find/phone/{telefono}")
    public ResponseEntity<Usuario> findByTelefono(
            @PathVariable("telefono") Long telefono
    ) {
        if(usuarioService.existsByTelefono(telefono))
            return new ResponseEntity(usuarioService.findByTelefono(telefono), HttpStatus.OK);
        else
            return new ResponseEntity(new Mensaje("Usuario inexistente"), HttpStatus.NOT_FOUND);
    }

    @GetMapping("/find/sub/{sub}")
    public ResponseEntity<Usuario> findBySub(
            @PathVariable("sub") String sub
    ) {
        if(usuarioService.existsBySub(sub))
            return new ResponseEntity(usuarioService.fyndBySub(sub), HttpStatus.OK);
        else
            return new ResponseEntity(new Mensaje("Usuario inexistente"), HttpStatus.NOT_FOUND);
    }


    // Búsquedas grupales

    @GetMapping("/list/all")
    public ResponseEntity<List<Usuario>> listAll() {
        List<Usuario> list = usuarioService.findAll();
        if(list.toArray().length > 0) {
            return new ResponseEntity(list, HttpStatus.OK);
        } else {
            return new ResponseEntity(new Mensaje("No se encontraron usuarios"), HttpStatus.NOT_FOUND);
        }
    }

    @GetMapping("/list/name/{nombre}")
    public ResponseEntity<List<Usuario>> listByNombre(
            @PathVariable("nombre") String nombre
    ) {
        List<Usuario> list = usuarioService.findAllByNombre(nombre);
        if(list.toArray().length > 0) {
            return new ResponseEntity(list, HttpStatus.OK);
        } else {
            return new ResponseEntity(new Mensaje("No se encontraron usuarios"), HttpStatus.NOT_FOUND);
        }
    }

    @GetMapping("/list/lastname/{apellido}")
    public ResponseEntity<List<Usuario>> listByApellido(
            @PathVariable("apellido") String apellido
    ) {
        List<Usuario> list = usuarioService.findAllByApellido(apellido);
        if(list.toArray().length > 0) {
            return new ResponseEntity(list, HttpStatus.OK);
        } else {
            return new ResponseEntity(new Mensaje("No se encontraron usuarios"), HttpStatus.NOT_FOUND);
        }
    }

    @GetMapping("/list/area/{area}")
    public ResponseEntity<List<Usuario>> listByArea(
            @PathVariable("area") String area
    ) {
        List<Usuario> list = usuarioService.findAllByArea(area);
        if(list.toArray().length > 0) {
            return new ResponseEntity(list, HttpStatus.OK);
        } else {
            return new ResponseEntity(new Mensaje("No se encontraron usuarios"), HttpStatus.NOT_FOUND);
        }
    }

    @GetMapping("/list/job/{cargo}")
    public ResponseEntity<List<Usuario>> listByCargo(
            @PathVariable("cargo") String cargo
    ) {
        List<Usuario> list = usuarioService.findAllByCargo(cargo);
        if(list.toArray().length > 0) {
            return new ResponseEntity(list, HttpStatus.OK);
        } else {
            return new ResponseEntity(new Mensaje("No se encontraron usuarios"), HttpStatus.NOT_FOUND);
        }
    }

    @GetMapping("/list/rol/{rol}")
    public ResponseEntity<List<Usuario>> listByRol(
            @PathVariable("rol") String rol
    ) {
        List<Usuario> list = usuarioService.findAllByRol(rol);
        if(list.toArray().length > 0) {
            return new ResponseEntity(list, HttpStatus.OK);
        } else {
            return new ResponseEntity(new Mensaje("No se encontraron usuarios"), HttpStatus.NOT_FOUND);
        }
    }

    @GetMapping("/list/status/{estado}")
    public ResponseEntity<List<Usuario>> listByEstado(
            @PathVariable("estado") String estado
    ) {
        List<Usuario> list = usuarioService.findAllByEstado(estado);
        if(list.toArray().length > 0) {
            return new ResponseEntity(list, HttpStatus.OK);
        } else {
            return new ResponseEntity(new Mensaje("No se encontraron usuarios"), HttpStatus.NOT_FOUND);
        }
    }


    // Verificacion de Sub
    @GetMapping("exists/sub/{sub}")
    public ResponseEntity<?> existsBySub(
            @PathVariable("sub") String sub
    ) {
        if(usuarioService.existsBySub(sub))
            return new ResponseEntity(true, HttpStatus.OK);
        else
            return new ResponseEntity(false, HttpStatus.NOT_FOUND);
    }


    // Eliminación por individuales

    @DeleteMapping("/delete/sub/{sub}")
    public ResponseEntity<?> deleteBySub(
            @PathVariable("sub") String sub
    ) {
        switch (usuarioService.deleteBySub(sub)) {
            case 0:
                return new ResponseEntity(new Mensaje("Eliminado con éxito"), HttpStatus.OK);
            case 1:
                return new ResponseEntity(new Mensaje("Usuario no existente."), HttpStatus.NOT_FOUND);
            default:
                return new ResponseEntity(new Mensaje("Algo ha fallado, no se ha podido eliminar"), HttpStatus.BAD_REQUEST);
        }
    }

    @DeleteMapping("/delete/email/{correo}")
    public ResponseEntity<?> deleteByCorreo(
            @PathVariable("correo") String correo
    ) {
        switch (usuarioService.deleteByCorreo(correo)) {
            case 0:
                return new ResponseEntity(new Mensaje("Eliminado con éxito"), HttpStatus.OK);
            case 1:
                return new ResponseEntity(new Mensaje("Usuario no existente."), HttpStatus.NOT_FOUND);
            default:
                return new ResponseEntity(new Mensaje("Algo ha fallado, no se ha podido eliminar"), HttpStatus.BAD_REQUEST);
        }
    }

    @DeleteMapping("/delete/phone/{telefono}")
    public ResponseEntity<?> deleteByTelefono(
            @PathVariable("telefono") Long telefono
    ) {
        switch (usuarioService.deleteByTelefono(telefono)) {
            case 0:
                return new ResponseEntity(new Mensaje("Eliminado con éxito"), HttpStatus.OK);
            case 1:
                return new ResponseEntity(new Mensaje("Usuario no existente."), HttpStatus.NOT_FOUND);
            default:
                return new ResponseEntity(new Mensaje("Algo ha fallado, no se ha podido eliminar"), HttpStatus.BAD_REQUEST);
        }
    }


    // Creación

    @PostMapping("/create")
    public ResponseEntity<?> create(
            @RequestBody UsuarioDto usuarioDto
    ) {
        switch (usuarioService.save(usuarioDto)) {
            case 0:
                return new ResponseEntity(new Mensaje("Se ha creado correctamente."), HttpStatus.CREATED);
            case 2:
                return new ResponseEntity(new Mensaje("El correo ya se encuentra registrado"), HttpStatus.BAD_REQUEST);
            case 3:
                return new ResponseEntity(new Mensaje("El teléfono ya se encuentra registrado"), HttpStatus.BAD_REQUEST);
            default:
                return new ResponseEntity(new Mensaje("Algo ha fallado creando el usuario."), HttpStatus.BAD_REQUEST);
        }
    }


    // Actualización

    @PutMapping("/update/sub/{sub}")
    public ResponseEntity<?> updateById(
            @PathVariable("sub") String sub,
            @RequestBody UsuarioDto usuarioDto
    ) {
        switch (usuarioService.update(sub, usuarioDto)) {
            case 0:
                return new ResponseEntity(new Mensaje("Se ha creado correctamente."), HttpStatus.CREATED);
            case 2:
                return new ResponseEntity(new Mensaje("Usuario inexistente."), HttpStatus.BAD_REQUEST);
            case 3:
                return new ResponseEntity(new Mensaje("No puedes modificar el correo."), HttpStatus.BAD_REQUEST);
            case 4:
                return new ResponseEntity(new Mensaje("Teléfono ya se encuentra registrado."), HttpStatus.BAD_REQUEST);
            default:
                return new ResponseEntity(new Mensaje("Algo ha fallado creando el usuario."), HttpStatus.BAD_REQUEST);
        }
    }



}
