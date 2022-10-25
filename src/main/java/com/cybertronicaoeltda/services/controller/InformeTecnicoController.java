package com.cybertronicaoeltda.services.controller;

import com.cybertronicaoeltda.services.dto.FirmaDto;
import com.cybertronicaoeltda.services.dto.InformeTecnicoDto;
import com.cybertronicaoeltda.services.dto.Mensaje;
import com.cybertronicaoeltda.services.entity.InformeTecnico;
import com.cybertronicaoeltda.services.service.InformeTecnicoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.text.ParseException;
import java.util.List;

@RestController
@RequestMapping("/inftecnico")
@CrossOrigin(origins= "http://10.147.17.75:4200/")
//@CrossOrigin(origins= "http://localhost:4200", allowedHeaders = {
//        "Content-type",
//},maxAge = 4800, allowCredentials = "false", methods = {RequestMethod.GET, RequestMethod.POST, RequestMethod.OPTIONS, RequestMethod.DELETE})
public class InformeTecnicoController {

    @Autowired
    InformeTecnicoService informeTecnicoService;

    // Obtención de Listas
    @GetMapping("/list/all")
    public ResponseEntity<List<InformeTecnico>> listAll() {
        List<InformeTecnico> list = informeTecnicoService.list();
        if(list.toArray().length < 1)
            return new ResponseEntity(new Mensaje("No hay informes."), HttpStatus.NOT_FOUND);
        else
            return new ResponseEntity(list, HttpStatus.OK);
    }

    @GetMapping("/list/client/{cliente}")
    public ResponseEntity<List<InformeTecnico>> listClient(
            @PathVariable("cliente") String cliente
    ) {
        List<InformeTecnico> list = informeTecnicoService.findAllByCliente(cliente);
        if(list.toArray().length < 1)
            return new ResponseEntity(new Mensaje("No hay informes."), HttpStatus.NOT_FOUND);
        else
            return new ResponseEntity(list, HttpStatus.OK);
    }

    @GetMapping("/list/depend/{dependencia}")
    public ResponseEntity<List<InformeTecnico>> listDependencia(
            @PathVariable("dependencia") String dependencia
    ) {
        List<InformeTecnico> list = informeTecnicoService.findAllByDependencia(dependencia);
        if(list.toArray().length < 1)
            return new ResponseEntity(new Mensaje("No hay informes."), HttpStatus.NOT_FOUND);
        else
            return new ResponseEntity(list, HttpStatus.OK);
    }

    @GetMapping("/list/comp/brand/{equipoMarca}")
    public ResponseEntity<List<InformeTecnico>> listEquipoMarca(
            @PathVariable("equipoMarca") String equipoMarca
    ) {
            List<InformeTecnico> list = informeTecnicoService.findAllByEquipoMarca(equipoMarca);
        if(list.toArray().length < 1)
            return new ResponseEntity(new Mensaje("No hay informes."), HttpStatus.NOT_FOUND);
        else
            return new ResponseEntity(list, HttpStatus.OK);
    }

    @GetMapping("/list/comp/name/{equipoNombre}")
    public ResponseEntity<List<InformeTecnico>> listEquipoNombre(
            @PathVariable("equipoNombre") String equipoNombre
    ) {
        List<InformeTecnico> list = informeTecnicoService.findAllByEquipoNombre(equipoNombre);
        if(list.toArray().length < 1)
            return new ResponseEntity(new Mensaje("No hay informes."), HttpStatus.NOT_FOUND);
        else
            return new ResponseEntity(list, HttpStatus.OK);
    }

    @GetMapping("/list/type/{tipo}")
    public ResponseEntity<List<InformeTecnico>> listTipo(
            @PathVariable("tipo") int tipo
    ) {
        List<InformeTecnico> list = informeTecnicoService.findAllByTipo(tipo);
        if(list.toArray().length < 1)
            return new ResponseEntity(new Mensaje("No hay informes."), HttpStatus.NOT_FOUND);
        else
            return new ResponseEntity(list, HttpStatus.OK);
    }

    @GetMapping("/list/user/{usuario}")
    public ResponseEntity<List<InformeTecnico>> listUsuario(
            @PathVariable("usuario") String usuario
    ) {
        List<InformeTecnico> list = informeTecnicoService.findAllByUsuario(usuario);
        if(list.toArray().length < 1)
            return new ResponseEntity(new Mensaje("No hay informes."), HttpStatus.NOT_FOUND);
        else
            return new ResponseEntity(list, HttpStatus.OK);
    }

    @GetMapping("/list/comptype/{equipoTipo}")
    public ResponseEntity<List<InformeTecnico>> listEquipoTipo(
            @PathVariable("equipoTipo") String equipoTipo
    ) {
        List<InformeTecnico> list = informeTecnicoService.findAllByEquipoTipo(equipoTipo);
        if(list.toArray().length < 1)
            return new ResponseEntity(new Mensaje("No hay informes."), HttpStatus.NOT_FOUND);
        else
            return new ResponseEntity(list, HttpStatus.OK);
    }

    @GetMapping("/list/sn/{equipoSN}")
    public ResponseEntity<List<InformeTecnico>> listEquipoSN(
            @PathVariable("equipoSN") String equipoSN
    ) {
        List<InformeTecnico> list = informeTecnicoService.findAllByEquipoSN(equipoSN);
        if(list.toArray().length < 1)
            return new ResponseEntity(new Mensaje("No hay informes."), HttpStatus.NOT_FOUND);
        else
            return new ResponseEntity(list, HttpStatus.OK);
    }

    @GetMapping("/list/ip/{direccionIP}")
    public ResponseEntity<List<InformeTecnico>> listDireccionIP(
            @PathVariable("direccionIP") String direccionIP
    ) {
        List<InformeTecnico> list = informeTecnicoService.findAllByDireccionIP(direccionIP);
        if(list.toArray().length < 1)
            return new ResponseEntity(new Mensaje("No hay informes."), HttpStatus.NOT_FOUND);
        else
            return new ResponseEntity(list, HttpStatus.OK);
    }

    // Obteción de resultados únicos

    @GetMapping("/find/id/{id}")
    public ResponseEntity<InformeTecnico> findById(
            @PathVariable("id") int id
    ) {
        if(informeTecnicoService.existsById(id))
            return new ResponseEntity(informeTecnicoService.findById(id).get(), HttpStatus.OK);
        else
            return new ResponseEntity(new Mensaje("No existe."), HttpStatus.NOT_FOUND);
    }

    // Eliminación

    // TODO - VERIFICAR POR QUÉ NO FUCNIONA Y CORREGIR
    @DeleteMapping("/delete/sn/{equipoSN}")
    public ResponseEntity<?> deleteByEquipoSN(
            @PathVariable("equipoSN") String equipoSN
    ) {
        switch (informeTecnicoService.deleteByEquipoSN(equipoSN)) {
            case 0 :
                return new ResponseEntity(new Mensaje("Eliminado con éxito."), HttpStatus.OK);
            case 1:
                return new ResponseEntity(new Mensaje("Informe no existe."), HttpStatus.NOT_FOUND);
            case 2:
                return new ResponseEntity(new Mensaje("Algo ha fallado, intente nuevamente."), HttpStatus.BAD_REQUEST);
            default:
                return new ResponseEntity(new Mensaje("Algo ha fallado, intente nuevamente."), HttpStatus.BAD_REQUEST);
        }
    }

    @DeleteMapping("/delete/id/{id}")
    public ResponseEntity<?> deleteById(
            @PathVariable("id") int id
    ) {
        switch (informeTecnicoService.deleteById(id)) {
            case 0 :
                return new ResponseEntity(new Mensaje("Eliminado con éxito."), HttpStatus.OK);
            case 1:
                return new ResponseEntity(new Mensaje("Informe no existe."), HttpStatus.NOT_FOUND);
            case 2:
                return new ResponseEntity(new Mensaje("Algo ha fallado, intente nuevamente."), HttpStatus.BAD_REQUEST);
            default:
                return new ResponseEntity(new Mensaje("Algo ha fallado, intente nuevamente."), HttpStatus.BAD_REQUEST);
        }
    }

    // Creación

    @PostMapping("/create")
    public ResponseEntity<?> create(
            @RequestBody InformeTecnicoDto informeTecnicoDto
    ) {
        switch (informeTecnicoService.save(informeTecnicoDto)) {
            case 0 :
                return new ResponseEntity(new Mensaje("Creado con éxito."), HttpStatus.CREATED);
            case 1:
                return new ResponseEntity(new Mensaje("Serial de equipo duplicado."), HttpStatus.BAD_REQUEST);
            default:
                return new ResponseEntity(new Mensaje("Algo ha fallado, intente nuevamente."), HttpStatus.BAD_REQUEST);
        }
    }

    @PutMapping("/update/id/{id}")
    public ResponseEntity<?> update(
            @PathVariable("id") int id,
            @RequestBody InformeTecnicoDto informeTecnicoDto
    ) throws ParseException {
        switch (informeTecnicoService.update(id, informeTecnicoDto)) {
            case 0 :
                return new ResponseEntity(new Mensaje("Creado con éxito."), HttpStatus.CREATED);
            case 2:
                return new ResponseEntity(new Mensaje("Informe no existe."), HttpStatus.NOT_FOUND);
            case 3:
                return new ResponseEntity(new Mensaje("Serial de equipo duplicado."), HttpStatus.BAD_REQUEST);
            default:
                return new ResponseEntity(new Mensaje("Algo ha fallado, intente nuevamente."), HttpStatus.BAD_REQUEST);
        }
    }

    @PutMapping("/sign/{id}")
    public ResponseEntity<?> sign(
            @PathVariable("id") int id,
            @RequestBody FirmaDto firmaDto
            ) throws ParseException {
        switch (informeTecnicoService.sign(id, firmaDto)) {
            case 0 :
                return new ResponseEntity(new Mensaje("Creado con éxito."), HttpStatus.CREATED);
            case 1:
                return new ResponseEntity(new Mensaje("Informe no existe."), HttpStatus.NOT_FOUND);
            default:
                return new ResponseEntity(new Mensaje("Algo ha fallado, intente nuevamente."), HttpStatus.BAD_REQUEST);
        }
    }



    /*
     */

}
