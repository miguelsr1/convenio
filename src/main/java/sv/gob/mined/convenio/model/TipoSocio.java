/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sv.gob.mined.convenio.model;

import java.io.Serializable;
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
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

/**
 *
 * @author misanchez
 */
@Entity
@Table(name = "tipo_socio")
@NamedQueries({
    @NamedQuery(name = "TipoSocio.findAll", query = "SELECT t FROM TipoSocio t")})
public class TipoSocio implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "id_tipo_socio")
    private Short idTipoSocio;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 100)
    @Column(name = "nombre_tipo")
    private String nombreTipo;
    @OneToMany(mappedBy = "tipoSocio", fetch = FetchType.LAZY)
    private List<SocioEstrategico> socioEstrategicoList;

    public TipoSocio() {
    }

    public TipoSocio(Short idTipoSocio) {
        this.idTipoSocio = idTipoSocio;
    }

    public TipoSocio(Short idTipoSocio, String nombreTipo) {
        this.idTipoSocio = idTipoSocio;
        this.nombreTipo = nombreTipo;
    }

    public Short getIdTipoSocio() {
        return idTipoSocio;
    }

    public void setIdTipoSocio(Short idTipoSocio) {
        this.idTipoSocio = idTipoSocio;
    }

    public String getNombreTipo() {
        return nombreTipo;
    }

    public void setNombreTipo(String nombreTipo) {
        this.nombreTipo = nombreTipo;
    }

    public List<SocioEstrategico> getSocioEstrategicoList() {
        return socioEstrategicoList;
    }

    public void setSocioEstrategicoList(List<SocioEstrategico> socioEstrategicoList) {
        this.socioEstrategicoList = socioEstrategicoList;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idTipoSocio != null ? idTipoSocio.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof TipoSocio)) {
            return false;
        }
        TipoSocio other = (TipoSocio) object;
        if ((this.idTipoSocio == null && other.idTipoSocio != null) || (this.idTipoSocio != null && !this.idTipoSocio.equals(other.idTipoSocio))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "sv.gob.mined.convenio.model.TipoSocio[ idTipoSocio=" + idTipoSocio + " ]";
    }
    
}
