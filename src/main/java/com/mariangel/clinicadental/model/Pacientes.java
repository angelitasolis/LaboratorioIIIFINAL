/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mariangel.clinicadental.model;

import java.io.Serializable;
import java.time.ZoneId;
import java.util.Date;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author Administrador
 */
@Entity
@Table(name = "TBL_PACIENTES")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Pacientes.findAll", query = "SELECT p FROM Pacientes p"),
    @NamedQuery(name = "Pacientes.findByPacCedula", query = "SELECT p FROM Pacientes p WHERE p.pacCedula = :pacCedula"),
    @NamedQuery(name = "Pacientes.findByPacNombre", query = "SELECT p FROM Pacientes p WHERE p.pacNombre = :pacNombre"),
    @NamedQuery(name = "Pacientes.findByPacPapellido", query = "SELECT p FROM Pacientes p WHERE p.pacPapellido = :pacPapellido"),
    @NamedQuery(name = "Pacientes.findByPacSapellido", query = "SELECT p FROM Pacientes p WHERE p.pacSapellido = :pacSapellido"),
    @NamedQuery(name = "Pacientes.findByPacDirec", query = "SELECT p FROM Pacientes p WHERE p.pacDirec = :pacDirec"),
    @NamedQuery(name = "Pacientes.findByPacFecnac", query = "SELECT p FROM Pacientes p WHERE p.pacFecnac = :pacFecnac"),
    @NamedQuery(name = "Pacientes.findByPacId", query = "SELECT p FROM Pacientes p WHERE p.pacId = :pacId")})
public class Pacientes implements Serializable {

    private static final long serialVersionUID = 1L;
    @Basic(optional = false)
    @Column(name = "PAC_CEDULA")
    private Long pacCedula;
    @Column(name = "PAC_NOMBRE")
    private String pacNombre;
    @Column(name = "PAC_PAPELLIDO")
    private String pacPapellido;
    @Column(name = "PAC_SAPELLIDO")
    private String pacSapellido;
    @Column(name = "PAC_DIREC")
    private String pacDirec;
    @Column(name = "PAC_FECNAC")
    @Temporal(TemporalType.TIMESTAMP)
    private Date pacFecnac;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Id
    @Basic(optional = false)
    @Column(name = "PAC_ID")
    private Long pacId;

    public Pacientes() {
    }

    public Pacientes(Long pacId) {
        this.pacId = pacId;
    }

    public Pacientes(Long pacId, Long pacCedula) {
        this.pacId = pacId;
        this.pacCedula = pacCedula;
    }

    public Long getPacCedula() {
        return pacCedula;
    }

    public void setPacCedula(Long pacCedula) {
        this.pacCedula = pacCedula;
    }

    public String getPacNombre() {
        return pacNombre;
    }

    public void setPacNombre(String pacNombre) {
        this.pacNombre = pacNombre;
    }

    public String getPacPapellido() {
        return pacPapellido;
    }

    public void setPacPapellido(String pacPapellido) {
        this.pacPapellido = pacPapellido;
    }

    public String getPacSapellido() {
        return pacSapellido;
    }

    public void setPacSapellido(String pacSapellido) {
        this.pacSapellido = pacSapellido;
    }

    public String getPacDirec() {
        return pacDirec;
    }

    public void setPacDirec(String pacDirec) {
        this.pacDirec = pacDirec;
    }

    public Date getPacFecnac() {
        return pacFecnac;
    }

    public void setPacFecnac(Date pacFecnac) {
        this.pacFecnac = pacFecnac;
    }

    public Long getPacId() {
        return pacId;
    }

    public void setPacId(Long pacId) {
        this.pacId = pacId;
    }
        public Pacientes(PacientesDto pacientesDto) {
        this.pacId = pacientesDto.getpacId();
        actualizar(pacientesDto);
    }

    public void actualizar(PacientesDto pacientesDto) {
        this.pacId = pacientesDto.getpacId();
        this.pacNombre = pacientesDto.getPacNombre();
        this.pacCedula = pacientesDto.getPacCedula();
        this.pacPapellido = pacientesDto.getPacPApellido();
        this.pacSapellido = pacientesDto.getPacSApellido();
        this.pacFecnac = Date.from(pacientesDto.getPacFecnac().atStartOfDay(ZoneId.systemDefault()).toInstant());

    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (pacId != null ? pacId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Pacientes)) {
            return false;
        }
        Pacientes other = (Pacientes) object;
        if ((this.pacId == null && other.pacId != null) || (this.pacId != null && !this.pacId.equals(other.pacId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.mariangel.clinicadental.model.Pacientes[ pacId=" + pacId + " ]";
    }
    
}
