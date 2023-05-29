/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mariangel.clinicadental.model;

import java.time.LocalDate;
import java.time.ZoneId;
import javafx.beans.property.ObjectProperty;
import javafx.beans.property.SimpleObjectProperty;
import javafx.beans.property.SimpleStringProperty;

/**
 *
 * @author Administrador
 */
public class PacientesDto {

    public SimpleStringProperty pacCedula;
    public SimpleStringProperty pacNombre;
    public SimpleStringProperty pacPapellido;
    public SimpleStringProperty pacSapellido;
    public SimpleStringProperty pacDirec;
    public ObjectProperty<LocalDate> pacFecnac;
    public SimpleStringProperty pacId;

    public PacientesDto() {

        this.pacCedula = new SimpleStringProperty();
        this.pacNombre = new SimpleStringProperty();
        this.pacPapellido = new SimpleStringProperty();
        this.pacSapellido = new SimpleStringProperty();
        this.pacDirec = new SimpleStringProperty();
        this.pacId = new SimpleStringProperty();
        this.pacFecnac = new SimpleObjectProperty();
    }

    public PacientesDto(Pacientes paciente) {
        this();
        this.pacId.set(paciente.getPacId().toString());
        this.pacNombre.set(paciente.getPacNombre());
        this.pacPapellido.set(paciente.getPacPapellido());
        this.pacSapellido.set(paciente.getPacSapellido());
        this.pacCedula.set(paciente.getPacCedula().toString());
        this.pacDirec.set(paciente.getPacDirec());
        this.pacFecnac.set(paciente.getPacFecnac().toInstant().atZone(ZoneId.systemDefault()).toLocalDate());
    }

    public Long getpacId() {
        if (pacId.get() != null && !pacId.get().isEmpty()) {
            return Long.valueOf(pacId.get());
        } else {
            return null;
        }
    }

    public void setPacId(Long pacId) {
        this.pacId.set(pacId.toString());
    }

    public void setPacNombre(String pacNombre) {
        this.pacNombre.set(pacNombre);
    }

    public String getPacNombre() {
        return pacNombre.get();
    }

    public String getPacPApellido() {
        return pacPapellido.get();
    }

    public void setPacPApellido(String pacPapellido) {
        this.pacPapellido.set(pacPapellido);
    }

    public String getPacSApellido() {
        return pacSapellido.get();
    }

    public void setPacSApellido(String pacSapellido) {
        this.pacSapellido.set(pacSapellido);
    }

    public Long getPacCedula() {
           if (pacCedula.get() != null && !pacCedula.get().isEmpty()) {
            return Long.valueOf(pacCedula.get());
        } else {
            return null;
        }
    }

    public void setCedula(String empCedula) {
        this.pacCedula.set(empCedula);
    }

    public String getPacDirec(String empCedula) {
        return pacDirec.get();
    }
    
     public void setPacDirec(String empCedula) {
        this.pacDirec.set(empCedula);
    }
          
        public void setPacFecnac(LocalDate pacFecnac) {
        this.pacFecnac.set(pacFecnac);
    }
        
          public LocalDate getPacFecnac() {
        return pacFecnac.get();
    }
             
}
