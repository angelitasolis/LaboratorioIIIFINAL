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
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author Administrador
 */
@Entity
@Table(name = "TBL_CITAS")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Citas.findAll", query = "SELECT c FROM Citas c"),
    @NamedQuery(name = "Citas.findByCitaDia", query = "SELECT c FROM Citas c WHERE c.citaDia = :citaDia"),
    @NamedQuery(name = "Citas.findByCitaHora", query = "SELECT c FROM Citas c WHERE c.citaHora = :citaHora"),
    @NamedQuery(name = "Citas.findByCitaCedupac", query = "SELECT c FROM Citas c WHERE c.citaCedupac = :citaCedupac"),
    @NamedQuery(name = "Citas.findByCitaId", query = "SELECT c FROM Citas c WHERE c.citaId = :citaId")})
public class Citas implements Serializable {

    private static final long serialVersionUID = 1L;
    @Column(name = "CITA_DIA")
    @Temporal(TemporalType.TIMESTAMP)
    private Date citaDia;
    @Column(name = "CITA_HORA")
    private String citaHora;
    @Basic(optional = false)
    @Column(name = "CITA_CEDUPAC")
    private String citaCedupac;
    @Id
    @Basic(optional = false)
    @Column(name = "CITA_ID")
     @SequenceGenerator(name = "PLAM_EMPLEADOS_EMP_ID_GENERATOR", sequenceName = "una.PLAM_EMPLEADOS_SEQ01", allocationSize = 1)
    private Long citaId;

    public Citas() {
    }

    public Citas(Long citaId) {
        this.citaId = citaId;
    }

    public Citas(Long citaId, String citaCedupac) {
        this.citaId = citaId;
        this.citaCedupac = citaCedupac;
    }
    public Citas(CitasDto citasDto) {
        this.citaId = citasDto.getCitaId();
        actualizar(citasDto);
    }
    public Date getCitaDia() {
        return citaDia;
    }

    public void setCitaDia(Date citaDia) {
        this.citaDia = citaDia;
    }

    public String getCitaHora() {
        return citaHora;
    }

    public void setCitaHora(String citaHora) {
        this.citaHora = citaHora;
    }

    public String getCitaCedupac() {
        return citaCedupac;
    }

    public void setCitaCedupac(String citaCedupac) {
        this.citaCedupac = citaCedupac;
    }

    public Long getCitaId() {
        return citaId;
    }

    public void setCitaId(Long citaId) {
        this.citaId = citaId;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (citaId != null ? citaId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Citas)) {
            return false;
        }
        Citas other = (Citas) object;
        if ((this.citaId == null && other.citaId != null) || (this.citaId != null && !this.citaId.equals(other.citaId))) {
            return false;
        }
        return true;
    }
    public void actualizar(CitasDto citasDto) {
        this.citaHora = citasDto.getcitaHora();
        this.citaCedupac = citasDto.getCitaCedupac();
        this.citaDia = Date.from(citasDto.getCitaDia().atStartOfDay(ZoneId.systemDefault()).toInstant());;
        this.citaId = citasDto.getCitaId();

    }
    @Override
    public String toString() {
        return "com.mariangel.clinicadental.model.Citas[ citaId=" + citaId + " ]";
    }
    
}
