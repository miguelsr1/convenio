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
@Table(name = "unidad_organizativa")
@NamedQueries({
    @NamedQuery(name = "UnidadOrganizativa.findAll", query = "SELECT u FROM UnidadOrganizativa u")})
public class UnidadOrganizativa implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "id_unidad_organizativa")
    private Integer idUnidadOrganizativa;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 200)
    @Column(name = "nombre_unidad_organizativa")
    private String nombreUnidadOrganizativa;
    @Size(max = 10)
    @Column(name = "abrev_unidad_organizativa")
    private String abrevUnidadOrganizativa;
    @Column(name = "unidad_organizativa_padre")
    private Integer unidadOrganizativaPadre;
    @Column(name = "unidad_organizativa_activa")
    private Boolean unidadOrganizativaActiva;
    @OneToMany(mappedBy = "unidadOrgaDesignada", fetch = FetchType.LAZY)
    private List<Convenio> convenioList;
    @OneToMany(mappedBy = "unidadOrgaResponsable", fetch = FetchType.LAZY)
    private List<Convenio> convenioList1;

    public UnidadOrganizativa() {
    }

    public UnidadOrganizativa(Integer idUnidadOrganizativa) {
        this.idUnidadOrganizativa = idUnidadOrganizativa;
    }

    public UnidadOrganizativa(Integer idUnidadOrganizativa, String nombreUnidadOrganizativa) {
        this.idUnidadOrganizativa = idUnidadOrganizativa;
        this.nombreUnidadOrganizativa = nombreUnidadOrganizativa;
    }

    public Integer getIdUnidadOrganizativa() {
        return idUnidadOrganizativa;
    }

    public void setIdUnidadOrganizativa(Integer idUnidadOrganizativa) {
        this.idUnidadOrganizativa = idUnidadOrganizativa;
    }

    public String getNombreUnidadOrganizativa() {
        return nombreUnidadOrganizativa;
    }

    public void setNombreUnidadOrganizativa(String nombreUnidadOrganizativa) {
        this.nombreUnidadOrganizativa = nombreUnidadOrganizativa;
    }

    public String getAbrevUnidadOrganizativa() {
        return abrevUnidadOrganizativa;
    }

    public void setAbrevUnidadOrganizativa(String abrevUnidadOrganizativa) {
        this.abrevUnidadOrganizativa = abrevUnidadOrganizativa;
    }

    public Integer getUnidadOrganizativaPadre() {
        return unidadOrganizativaPadre;
    }

    public void setUnidadOrganizativaPadre(Integer unidadOrganizativaPadre) {
        this.unidadOrganizativaPadre = unidadOrganizativaPadre;
    }

    public Boolean getUnidadOrganizativaActiva() {
        return unidadOrganizativaActiva;
    }

    public void setUnidadOrganizativaActiva(Boolean unidadOrganizativaActiva) {
        this.unidadOrganizativaActiva = unidadOrganizativaActiva;
    }

    public List<Convenio> getConvenioList() {
        return convenioList;
    }

    public void setConvenioList(List<Convenio> convenioList) {
        this.convenioList = convenioList;
    }

    public List<Convenio> getConvenioList1() {
        return convenioList1;
    }

    public void setConvenioList1(List<Convenio> convenioList1) {
        this.convenioList1 = convenioList1;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idUnidadOrganizativa != null ? idUnidadOrganizativa.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof UnidadOrganizativa)) {
            return false;
        }
        UnidadOrganizativa other = (UnidadOrganizativa) object;
        if ((this.idUnidadOrganizativa == null && other.idUnidadOrganizativa != null) || (this.idUnidadOrganizativa != null && !this.idUnidadOrganizativa.equals(other.idUnidadOrganizativa))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "sv.gob.mined.convenio.model.UnidadOrganizativa[ idUnidadOrganizativa=" + idUnidadOrganizativa + " ]";
    }
    
}
