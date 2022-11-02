package com.cybertronicaoeltda.services.service;

import com.cybertronicaoeltda.services.dto.FirmaDto;
import com.cybertronicaoeltda.services.dto.InformeTecnicoDto;
import com.cybertronicaoeltda.services.entity.InformeTecnico;
import com.cybertronicaoeltda.services.repository.InformeTecnicoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.sql.Timestamp;
import java.text.ParseException;
import java.text.SimpleDateFormat;

import java.util.Date;
import java.util.List;
import java.util.Objects;
import java.util.Optional;

@Service
public class InformeTecnicoService {

    @Autowired
    private InformeTecnicoRepository informeTecnicoRepository;

    public Optional<InformeTecnico> findById(int id) {
        return informeTecnicoRepository.findById(id);
    }

//    public Optional<InformeTecnico> findByEquipoSN(String equipoSN) {
//        return informeTecnicoRepository.findByEquipoSN(equipoSN);
//    }

    public List<InformeTecnico> findAllByDireccionIP(String direccionIP) {
        return informeTecnicoRepository.findAllByDireccionIP(direccionIP);
    }

    public List<InformeTecnico> findAllByEquipoSN(String equipoSN) {
        return informeTecnicoRepository.findAllByEquipoSN(equipoSN);
    }

    public List<InformeTecnico> list() {
        return informeTecnicoRepository.findAll();
    }

    public List<InformeTecnico> findAllByCliente(String cliente) {
        return informeTecnicoRepository.findAllByCliente(cliente);
    }

    public List<InformeTecnico> findAllByDependencia(String dependencia) {
        return informeTecnicoRepository.findAllByDependencia(dependencia);
    }

    public List<InformeTecnico> findAllByEquipoMarca(String equipoMarca) {
        return informeTecnicoRepository.findAllByEquipoMarca(equipoMarca);
    }

    public List<InformeTecnico> findAllByEquipoNombre(String equipoNombre) {
        return informeTecnicoRepository.findAllByEquipoNombre(equipoNombre);
    }

//    public List<InformeTecnico> findAllByFechaRetiro(Date fechaRetiro) {
//        return informeTecnicoRepository.findAllByFechaRetiro(fechaRetiro);
//    }
//
//    public List<InformeTecnico> findAllByFechaRecibe(Date fechaRecibe) {
//        return informeTecnicoRepository.findAllByFechaRecibe(fechaRecibe);
//    }

    public List<InformeTecnico> findAllByTipo(int tipo) {
        return informeTecnicoRepository.findAllByTipo(tipo);
    }

    public List<InformeTecnico> findAllByUsuario(String usuario) {
        return informeTecnicoRepository.findAllByUsuario(usuario);
    }

    public List<InformeTecnico> findAllByEquipoTipo(String equipoTipo) {
        return informeTecnicoRepository.findAllByEquipoTipo(equipoTipo);
    }

    // Eliminación

    public int deleteByEquipoSN(String equipoSN) {
        if(!informeTecnicoRepository.existsByEquipoSN(equipoSN))
            return 1;
        else {
            informeTecnicoRepository.deleteByEquipoSN(equipoSN);
            if (informeTecnicoRepository.existsByEquipoSN(equipoSN))
                return 2;
            else
                return 0;
        }
    }

    public int deleteById(int id){
        if (!informeTecnicoRepository.existsById(id))
            return 1;
        else {
            informeTecnicoRepository.deleteById(id);
            if (informeTecnicoRepository.existsById(id))
                return 2;
            else
                return 0;
        }
    }

    // Creación

    // TODO - Verificar si el equipoSN es null, en caso de serlo, anular verificación de duplicado

    public int save(InformeTecnicoDto informeTecnicoDto) {
        try {
            /**
             * Formatear fecha
             * Formato de entrada: "1998-12-31T13:37"
             * Formato de entrada: "yyyy-MM-dd'T'hh:mm"
             */

            SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm");
            if (!Objects.equals(informeTecnicoDto.getFechaRetiro(), "")) {
                System.out.println("El valor de date es");
                System.out.print(informeTecnicoDto.getFechaRetiro());
                Date parsedFechaRetiro = (Date)dateFormat.parse(informeTecnicoDto.getFechaRetiro());
                Timestamp timestampFechaRetiro = new Timestamp(parsedFechaRetiro.getTime());
                Timestamp timestampFechaRecibe = null;
                if (!Objects.equals(informeTecnicoDto.getFechaRecibe(), "")) {
                    Date parsedFechaRecibe = dateFormat.parse(informeTecnicoDto.getFechaRecibe());
                    timestampFechaRecibe = new Timestamp(parsedFechaRecibe.getTime());
                }
                System.out.println(informeTecnicoDto.getFechaRecibe());

                InformeTecnico informeTecnico = new InformeTecnico(
                        informeTecnicoDto.getCliente(),
                        informeTecnicoDto.getResponsable(),
                        informeTecnicoDto.getTipo(),
                        informeTecnicoDto.getUsuario(),
                        informeTecnicoDto.getDependencia(),
                        timestampFechaRetiro,
                        timestampFechaRecibe,
                        informeTecnicoDto.getEquipoTipo(),
                        informeTecnicoDto.getEquipoNombre(),
                        informeTecnicoDto.getEquipoMarca(),
                        informeTecnicoDto.getEquipoSN(),
                        informeTecnicoDto.getOfficeVersion(),
                        informeTecnicoDto.getOfficeKEY(),
                        informeTecnicoDto.getMonitorNombre(),
                        informeTecnicoDto.getMonitorMarca(),
                        informeTecnicoDto.getMonitorSN(),
                        informeTecnicoDto.getTecladoNombre(),
                        informeTecnicoDto.getTecladoMarca(),
                        informeTecnicoDto.getTecladoSN(),
                        informeTecnicoDto.getMouseNombre(),
                        informeTecnicoDto.getMouseMarca(),
                        informeTecnicoDto.getMouseSN(),
                        informeTecnicoDto.getRecibe(),
                        informeTecnicoDto.getFirmaRecibe(),
                        informeTecnicoDto.getServicioDetalle(),
                        informeTecnicoDto.getObservaciones(),
                        informeTecnicoDto.getContadorHojas(),
                        informeTecnicoDto.getDireccionIP(),
                        informeTecnicoDto.getRecibeCargo(),
                        informeTecnicoDto.getUsuarioCargo()
                );




                informeTecnicoRepository.save(informeTecnico);
                if (informeTecnicoRepository.existsById(informeTecnico.getId())) {
                    System.out.print("Se generó");
                    return 0;
            } else {
                return 4;  // No existe fecha de retiro o el formato no es válido
            }
            } else {
                System.out.print("No se ha generado");
                return 3;  // No se creó correctamente el informe
            }
        } catch (Exception e) {
            System.out.print("Fallo compilando");
            e.printStackTrace();
            return 2;  // error creando el producto
        }
    }

    // Actualización de datos

    public int update(int id, InformeTecnicoDto informeTecnicoDto) throws ParseException {
//        try {
            if (informeTecnicoRepository.existsById(id)) {
//                if (informeTecnicoDto.getEquipoSN() != informeTecnicoRepository.findById(id).get().getEquipoSN()) {
//                    if (informeTecnicoRepository.existsByEquipoSN(informeTecnicoDto.getEquipoSN()))
//                        return 3;   // Ya existe Equipo SN
//                }
                /**
                 * Formatear fecha
                 * Formato de entrada: "1998-12-31T13:37"
                 * Formato de entrada: "yyyy-MM-dd'T'hh:mm"
                 */

                SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd'T'hh:mm");
                Date parsedFechaRetiro = dateFormat.parse(informeTecnicoDto.getFechaRetiro());
                Timestamp timestampFechaRetiro = new java.sql.Timestamp(parsedFechaRetiro.getTime());
                Date parsedFechaRecibe = dateFormat.parse(informeTecnicoDto.getFechaRecibe());
                Timestamp timestampFechaRecibe = new java.sql.Timestamp(parsedFechaRecibe.getTime());

                InformeTecnico informeTecnico = informeTecnicoRepository.findById(id).get();

                informeTecnico.setCliente(informeTecnicoDto.getCliente());
                informeTecnico.setResponsable(informeTecnico.getResponsable());
                informeTecnico.setTipo(informeTecnicoDto.getTipo());
                informeTecnico.setUsuario(informeTecnicoDto.getUsuario());
                informeTecnico.setDependencia(informeTecnicoDto.getDependencia());
                informeTecnico.setFechaRetiro(timestampFechaRetiro);
                informeTecnico.setFechaRecibe(timestampFechaRecibe);
                informeTecnico.setEquipoTipo(informeTecnicoDto.getEquipoTipo());
                informeTecnico.setEquipoNombre(informeTecnicoDto.getEquipoNombre());
                informeTecnico.setEquipoMarca(informeTecnicoDto.getEquipoMarca());
                informeTecnico.setEquipoSN(informeTecnicoDto.getEquipoSN());
                informeTecnico.setOfficeVersion(informeTecnico.getOfficeVersion());
                informeTecnico.setOfficeKEY(informeTecnicoDto.getOfficeKEY());
                informeTecnico.setMonitorNombre(informeTecnicoDto.getMonitorNombre());
                informeTecnico.setMonitorMarca(informeTecnicoDto.getMonitorMarca());
                informeTecnico.setMonitorSN(informeTecnicoDto.getMonitorSN());
                informeTecnico.setTecladoNombre(informeTecnicoDto.getTecladoNombre());
                informeTecnico.setTecladoMarca(informeTecnicoDto.getTecladoMarca());
                informeTecnico.setTecladoSN(informeTecnicoDto.getTecladoSN());
                informeTecnico.setMouseNombre(informeTecnicoDto.getMouseNombre());
                informeTecnico.setMouseMarca(informeTecnicoDto.getMouseMarca());
                informeTecnico.setMouseSN(informeTecnicoDto.getMouseSN());
                informeTecnico.setRecibe(informeTecnicoDto.getRecibe());
                informeTecnico.setFirmaRecibe(informeTecnicoDto.getFirmaRecibe());
                informeTecnico.setServicioDetalle(informeTecnicoDto.getServicioDetalle());
                informeTecnico.setObservaciones(informeTecnicoDto.getObservaciones());
                informeTecnico.setContadorHojas(informeTecnico.getContadorHojas());
                informeTecnico.setDireccionIP(informeTecnico.getDireccionIP());
                informeTecnico.setRecibeCargo(informeTecnico.getRecibeCargo());
                informeTecnico.setUsuarioCargo(informeTecnicoDto.getUsuarioCargo());
                informeTecnicoRepository.save(informeTecnico);
                return 0;
            } else
                return 2; // ID no existe
//        } catch (Exception e) {
//            return 1; // fallo no definido
//        }
    }

    public int sign(int id, FirmaDto firmaDto) {
        try {
            if (informeTecnicoRepository.existsById(id)) {
                InformeTecnico informe = informeTecnicoRepository.findById(id).get();
                informe.setFirmaRecibe(firmaDto.getFirma());
                informeTecnicoRepository.save(informe);
                return 0;
            } else {
                return 1;
            }
        } catch (Exception e) {
            System.out.println("Error al firmar : "+e);
            return 2;
        }
    }

    // Verificación

    public boolean existsById(int id) {
        return informeTecnicoRepository.existsById(id);
    }

    public boolean existsByEquipoSN(String equipoSN) {
        return informeTecnicoRepository.existsByEquipoSN(equipoSN.strip());
    }

}
