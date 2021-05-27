/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sv.gob.mined.convenio.model;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

/**
 *
 * @author misanchez
 */
@Entity
@Table(name = "representante_socio")
@NamedQueries({
    @NamedQuery(name = "RepresentanteSocio.findAll", query = "SELECT r FROM RepresentanteSocio r")})
public class RepresentanteSocio implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "id_representante_socio")
    private Integer idRepresentanteSocio;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 100)
    @Column(name = "nombres_representante_socio")
    private String nombresRepresentanteSocio;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 100)
    @Column(name = "apellidos_representante_socio")
    private String apellidosRepresentanteSocio;
    @Size(max = 9)
    @Column(name = "dui_representante_socio")
    private String duiRepresentanteSocio;
    @Size(max = 14)
    @Column(name = "nit_representante_socio")
    private String nitRepresentanteSocio;
    @Size(max = 100)
    @Column(name = "representacion")
    private String representacion;
    @Size(max = 2)
    @Column(name = "departamento_representante_socio")
    private String departamentoRepresentanteSocio;
    @Size(max = 4)
    @Column(name = "municipio_representante_socio")
    private String municipioRepresentanteSocio;
    @Size(max = 100)
    @Column(name = "domicilio_representante_socio")
    private String domicilioRepresentanteSocio;
    @Column(name = "vigente")
    private Boolean vigente;
    @Column(name = "fecha_ini_vigencia")
    @Temporal(TemporalType.DATE)
    private Date fechaIniVigencia;
    @Column(name = "fecha_fin_vigencia")
    @Temporal(TemporalType.DATE)
    private Date fechaFinVigencia;
    @JoinColumn(name = "socio_estrategico", referencedColumnName = "id_socio")
    @ManyToOne(fetch = FetchType.LAZY)
    private SocioEstrategico socioEstrategico;

    public RepresentanteSocio() {
    }

    public RepresentanteSocio(Integer idRepresentanteSocio) {
        this.idRepresentanteSocio = idRepresentanteSocio;
    }

    public RepresentanteSocio(Integer idRepresentanteSocio, String nombresRepresentanteSocio, String apellidosRepresentanteSocio) {
        this.idRepresentanteSocio = idRepresentanteSocio;
        this.nombresRepresentanteSocio = nombresRepresentanteSocio;
        this.apellidosRepresentanteSocio = apellidosRepresentanteSocio;
    }

    public Integer getIdRepresentanteSocio() {
        return idRepresentanteSocio;
    }

    public void setIdRepresentanteSocio(Integer idRepresentanteSocio) {
        this.idRepresentanteSocio = idRepresentanteSocio;
    }

    public String getNombresRepresentanteSocio() {
        return nombresRepresentanteSocio;
    }

    public void setNombresRepresentanteSocio(String nombresRepresentanteSocio) {
        this.nombresRepresentanteSocio = nombresRepresentanteSocio;
    }

    public String getApellidosRepresentanteSocio() {
        return apellidosRepresentanteSocio;
    }

    public void setApellidosRepresentanteSocio(String apellidosRepresentanteSocio) {
        this.apellidosRepresentanteSocio = apellidosRepresentanteSocio;
    }

    public String getDuiRepresentanteSocio() {
        return duiRepresentanteSocio;
    }

    public void setDuiRepresentanteSocio(String duiRepresentanteSocio) {
        this.duiRepresentanteSocio = duiRepresentanteSocio;
    }

    public String getNitRepresentanteSocio() {
        return nitRepresentanteSocio;
    }

    public void setNitRepresentanteSocio(String nitRepresentanteSocio) {
        this.nitRepresentanteSocio = nitRepresentanteSocio;
    }

    public String getRepresentacion() {
        return representacion;
    }

    public void setRepresentacion(String representacion) {
        this.representacion = representacion;
    }

    public String getDepartamentoRepresentanteSocio() {
        return departamentoRepresentanteSocio;
    }

    public void setDepartamentoRepresentanteSocio(String departamentoRepresentanteSocio) {
        this.departamentoRepresentanteSocio = departamentoRepresentanteSocio;
    }

    public String getMunicipioRepresentanteSocio() {
        return municipioRepresentanteSocio;
    }

    public void setMunicipioRepresentanteSocio(String municipioRepresentanteSocio) {
        this.municipioRepresentanteSocio = municipioRepresentanteSocio;
    }

    public String getDomicilioRepresentanteSocio() {
        return domicilioRepresentanteSocio;
    }

    public void setDomicilioRepresentanteSocio(String domicilioRepresentanteSocio) {
        this.domicilioRepresentanteSocio = domicilioRepresentanteSocio;
    }

    public Boolean getVigente() {
        return vigente;
    }

    public void setVigente(Boolean vigente) {
        this.vigente = vigente;
    }

    public Date getFechaIniVigencia() {
        return fechaIniVigencia;
    }

    public void setFechaIniVigencia(Date fechaIniVigencia) {
        this.fechaIniVigencia = fechaIniVigencia;
    }

    public Date getFechaFinVigencia() {
        return fechaFinVigencia;
    }

    public void setFechaFinVigencia(Date fechaFinVigencia) {
        this.fechaFinVigencia = fechaFinVigencia;
    }

    public SocioEstrategico getSocioEstrategico() {
        return socioEstrategico;
    }

    public void setSocioEstrategico(SocioEstrategico socioEstrategico) {
        this.socioEstrategico = socioEstrategico;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idRepresentanteSocio != null ? idRepresentanteSocio.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof RepresentanteSocio)) {
            return false;
        }
        RepresentanteSocio other = (RepresentanteSocio) object;
        return !((this.idRepresentanteSocio == null && other.idRepresentanteSocio != null) || (this.idRepresentanteSocio != null && !this.idRepresentanteSocio.equals(other.idRepresentanteSocio)));
    }

    @Override
    public String toString() {
        return "sv.gob.mined.convenio.model.RepresentanteSocio[ idRepresentanteSocio=" + idRepresentanteSocio + " ]";
    }

}
