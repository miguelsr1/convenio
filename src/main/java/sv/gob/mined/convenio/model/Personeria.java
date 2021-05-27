/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sv.gob.mined.convenio.model;

import java.io.Serializable;
import java.util.Date;
import java.util.List;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
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
@Table(name = "personeria")
@NamedQueries({
    @NamedQuery(name = "Personeria.findAll", query = "SELECT p FROM Personeria p")})
public class Personeria implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "id_personeria")
    private Short idPersoneria;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 1000)
    @Column(name = "contenido_personeria")
    private String contenidoPersoneria;
    @Column(name = "personeria_activa")
    private Boolean personeriaActiva;
    @Column(name = "fecha_ini_vigencia_personeria")
    @Temporal(TemporalType.DATE)
    private Date fechaIniVigenciaPersoneria;
    @Column(name = "fecha_fin_vigencia_personeria")
    @Temporal(TemporalType.DATE)
    private Date fechaFinVigenciaPersoneria;
    @OneToMany(mappedBy = "personariaConvenio", fetch = FetchType.LAZY)
    private List<Convenio> convenioList;

    public Personeria() {
    }

    public Personeria(Short idPersoneria) {
        this.idPersoneria = idPersoneria;
    }

    public Personeria(Short idPersoneria, String contenidoPersoneria) {
        this.idPersoneria = idPersoneria;
        this.contenidoPersoneria = contenidoPersoneria;
    }

    public Short getIdPersoneria() {
        return idPersoneria;
    }

    public void setIdPersoneria(Short idPersoneria) {
        this.idPersoneria = idPersoneria;
    }

    public String getContenidoPersoneria() {
        return contenidoPersoneria;
    }

    public void setContenidoPersoneria(String contenidoPersoneria) {
        this.contenidoPersoneria = contenidoPersoneria;
    }

    public Boolean getPersoneriaActiva() {
        return personeriaActiva;
    }

    public void setPersoneriaActiva(Boolean personeriaActiva) {
        this.personeriaActiva = personeriaActiva;
    }

    public Date getFechaIniVigenciaPersoneria() {
        return fechaIniVigenciaPersoneria;
    }

    public void setFechaIniVigenciaPersoneria(Date fechaIniVigenciaPersoneria) {
        this.fechaIniVigenciaPersoneria = fechaIniVigenciaPersoneria;
    }

    public Date getFechaFinVigenciaPersoneria() {
        return fechaFinVigenciaPersoneria;
    }

    public void setFechaFinVigenciaPersoneria(Date fechaFinVigenciaPersoneria) {
        this.fechaFinVigenciaPersoneria = fechaFinVigenciaPersoneria;
    }

    public List<Convenio> getConvenioList() {
        return convenioList;
    }

    public void setConvenioList(List<Convenio> convenioList) {
        this.convenioList = convenioList;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idPersoneria != null ? idPersoneria.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Personeria)) {
            return false;
        }
        Personeria other = (Personeria) object;
        if ((this.idPersoneria == null && other.idPersoneria != null) || (this.idPersoneria != null && !this.idPersoneria.equals(other.idPersoneria))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "sv.gob.mined.convenio.model.Personeria[ idPersoneria=" + idPersoneria + " ]";
    }
    
}
