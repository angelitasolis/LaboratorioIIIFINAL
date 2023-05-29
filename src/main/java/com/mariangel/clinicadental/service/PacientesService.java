/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mariangel.clinicadental.service;

import com.mariangel.clinicadental.model.Pacientes;
import com.mariangel.clinicadental.model.PacientesDto;
import com.mariangel.clinicadental.util.EntityManagerHelper;
import com.mariangel.clinicadental.util.Respuesta;
import java.sql.SQLIntegrityConstraintViolationException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.persistence.NoResultException;
import javax.persistence.NonUniqueResultException;
import javax.persistence.Query;

/**
 *
 * @author Administrador
 */
public class PacientesService {
   
    EntityManager em = EntityManagerHelper.getInstance().getManager();
    private EntityTransaction et;
    
    public Respuesta getUsuario(String usuario, String clave) {
        try {
            Query qryPaciente = em.createNamedQuery("Empleado.findByUsuClave", Pacientes.class);
            qryPaciente.setParameter("usuario", usuario);
            qryPaciente.setParameter("clave", clave);
            PacientesDto pacientesDto = new PacientesDto((Pacientes) qryPaciente.getSingleResult());
            return new Respuesta(true, "", "", "Paciente", pacientesDto);

        } catch (NoResultException ex) {
            return new Respuesta(false, "No existe un usuario con las credenciales ingresadas.", "getUsuario NoResultException");
        } catch (NonUniqueResultException ex) {
            Logger.getLogger(PacientesService.class.getName()).log(Level.SEVERE, "Ocurrio un error al consultar el usuario.", ex);
            return new Respuesta(false, "Ocurrio un error al consultar el paciente.", "getUsuario NonUniqueResultException");
        } catch (Exception ex) {
            Logger.getLogger(PacientesService.class.getName()).log(Level.SEVERE, "Error obteniendo el usuario [" + usuario + "]", ex);
            return new Respuesta(false, "Error obteniendo el paciente.", "getUsuario " + ex.getMessage());
        }
    }
    
    public Respuesta getPaciente(Long pacId) {
        try {
            Query qryPaciente = em.createNamedQuery("Pacientes.findByPacId", Pacientes.class);
            qryPaciente.setParameter("pacId", pacId);

            return new Respuesta(true, "", "", "Paciente", new PacientesDto((Pacientes) qryPaciente.getSingleResult()));

        } catch (NoResultException ex) {
            return new Respuesta(false, "No existe un paciente con el código ingresado.", "getPaciente NoResultException");
        } catch (NonUniqueResultException ex) {
            Logger.getLogger(PacientesService.class.getName()).log(Level.SEVERE, "Ocurrio un error al consultar el paciente .", ex);
            return new Respuesta(false, "Ocurrio un error al consultar el paciente.", "getPaciente NonUniqueResultException");
        } catch (Exception ex) {
            Logger.getLogger(PacientesService.class.getName()).log(Level.SEVERE, "Ocurrio un error al consultar el paciente.", ex);
            return new Respuesta(false, "Ocurrio un error al consultar el paciente.", "getPaciente " + ex.getMessage());
        }
    }
    
    public Respuesta guardarPaciente(PacientesDto pacientesDto) {
        try {
            et = em.getTransaction();
            et.begin();
            Pacientes paciente;
            if (pacientesDto.getpacId() != null && pacientesDto.getpacId() > 0) {
                paciente = em.find(Pacientes.class, pacientesDto.getpacId());
                if (paciente == null) {
                    et.rollback();
                    return new Respuesta(false, "No se encrontró el paciente a modificar.", "guardarPaciente NoResultException");
                }
                paciente.actualizar(pacientesDto);
                paciente = em.merge(paciente);
            } else {
                paciente= new Pacientes(pacientesDto);
                em.persist(paciente);
            }
            et.commit();
            return new Respuesta(true, "", "", "Pacientes", new  PacientesDto(paciente));
        } catch (Exception ex) {
            et.rollback();
            Logger.getLogger(PacientesService.class.getName()).log(Level.SEVERE, "Ocurrió un error al guardar el paciente.", ex);
            return new Respuesta(false, "Ocurrio un error al guardar el paciente.", "guardarPaciente " + ex.getMessage());
        }
    }
    
    
    public Respuesta eliminarPaciente(Long id) {
        try {
            et = em.getTransaction();
            et.begin();
            Pacientes pacientes;
            if (id != null && id > 0) {
                pacientes = em.find(Pacientes.class, id);
                if (pacientes == null) {
                    et.rollback();
                    return new Respuesta(false, "No se encrontró el paciente a eliminar.", "eliminarPaciente NoResultException");
                }
                em.remove(pacientes);
            } else {
                et.rollback();
                return new Respuesta(false, "Debe cargar el paciente a eliminar.", "eliminarPaciente NoResultException");
            }
            et.commit();
            return new Respuesta(true, "", "");
        } catch (Exception ex) {
            et.rollback();
            if (ex.getCause() != null && ex.getCause().getCause().getClass() == SQLIntegrityConstraintViolationException.class) {
                return new Respuesta(false, "No se puede eliminar el paciente porque tiene relaciones con otros registros.", "eliminarPaciente " + ex.getMessage());
            }
            Logger.getLogger(PacientesService.class.getName()).log(Level.SEVERE, "Ocurrio un error al guardar el paciente.", ex);
            return new Respuesta(false, "Ocurrio un error al eliminar el paciente.", "eliminarPaciente " + ex.getMessage());
        }
    }
}
