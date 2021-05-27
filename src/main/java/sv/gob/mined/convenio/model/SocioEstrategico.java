/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sv.gob.mined.convenio.model;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
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
@Table(name = "socio_estrategico")
@NamedQueries({
    @NamedQuery(name = "SocioEstrategico.findAll", query = "SELECT s FROM SocioEstrategico s")})
public class SocioEstrategico implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "id_socio")
    private Integer idSocio;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 150)
    @Column(name = "nombre_socio")
    private String nombreSocio;
    @Size(max = 10)
    @Column(name = "siglas_socio")
    private String siglasSocio;
    @Size(max = 14)
    @Column(name = "nit_socio")
    private String nitSocio;
    @Size(max = 50)
    @Column(name = "telefono_socio")
    private String telefonoSocio;
    @Size(max = 100)
    @Column(name = "correo_socio")
    private String correoSocio;
    @Size(max = 2)
    @Column(name = "departamento_socio")
    private String departamentoSocio;
    @Size(max = 4)
    @Column(name = "municipio_socio")
    private String municipioSocio;
    @Size(max = 200)
    @Column(name = "direccion_socio")
    private String direccionSocio;
    @Size(max = 200)
    @Column(name = "oficina_enlace")
    private String oficinaEnlace;
    @Size(max = 1000)
    @Column(name = "estatutos_socio")
    private String estatutosSocio;
    @Size(max = 500)
    @Column(name = "credenciales_socio")
    private String credencialesSocio;
    @Size(max = 200)
    @Column(name = "ruta_logo_socio")
    private String rutaLogoSocio;
    @Column(name = "habilitado")
    private Boolean habilitado;
    @OneToMany(mappedBy = "socioEstrategico", fetch = FetchType.LAZY)
    private List<Convenio> convenioList;
    @JoinColumn(name = "tipo_socio", referencedColumnName = "id_tipo_socio")
    @ManyToOne(fetch = FetchType.LAZY)
    private TipoSocio tipoSocio;
    @OneToMany(mappedBy = "socioEstrategico", fetch = FetchType.LAZY)
    private List<RepresentanteSocio> representanteSocioList;

    public SocioEstrategico() {
    }

    public SocioEstrategico(Integer idSocio) {
        this.idSocio = idSocio;
    }

    public SocioEstrategico(Integer idSocio, String nombreSocio) {
        this.idSocio = idSocio;
        this.nombreSocio = nombreSocio;
    }

    public Integer getIdSocio() {
        return idSocio;
    }

    public void setIdSocio(Integer idSocio) {
        this.idSocio = idSocio;
    }

    public String getNombreSocio() {
        return nombreSocio;
    }

    public void setNombreSocio(String nombreSocio) {
        this.nombreSocio = nombreSocio;
    }

    public String getSiglasSocio() {
        return siglasSocio;
    }

    public void setSiglasSocio(String siglasSocio) {
        this.siglasSocio = siglasSocio;
    }

    public String getNitSocio() {
        return nitSocio;
    }

    public void setNitSocio(String nitSocio) {
        this.nitSocio = nitSocio;
    }

    public String getTelefonoSocio() {
        return telefonoSocio;
    }

    public void setTelefonoSocio(String telefonoSocio) {
        this.telefonoSocio = telefonoSocio;
    }

    public String getCorreoSocio() {
        return correoSocio;
    }

    public void setCorreoSocio(String correoSocio) {
        this.correoSocio = correoSocio;
    }

    public String getDepartamentoSocio() {
        return departamentoSocio;
    }

    public void setDepartamentoSocio(String departamentoSocio) {
        this.departamentoSocio = departamentoSocio;
    }

    public String getMunicipioSocio() {
        return municipioSocio;
    }

    public void setMunicipioSocio(String municipioSocio) {
        this.municipioSocio = municipioSocio;
    }

    public String getDireccionSocio() {
        return direccionSocio;
    }

    public void setDireccionSocio(String direccionSocio) {
        this.direccionSocio = direccionSocio;
    }

    public String getOficinaEnlace() {
        return oficinaEnlace;
    }

    public void setOficinaEnlace(String oficinaEnlace) {
        this.oficinaEnlace = oficinaEnlace;
    }

    public String getEstatutosSocio() {
        return estatutosSocio;
    }

    public void setEstatutosSocio(String estatutosSocio) {
        this.estatutosSocio = estatutosSocio;
    }

    public String getCredencialesSocio() {
        return credencialesSocio;
    }

    public void setCredencialesSocio(String credencialesSocio) {
        this.credencialesSocio = credencialesSocio;
    }

    public String getRutaLogoSocio() {
        return rutaLogoSocio;
    }

    public void setRutaLogoSocio(String rutaLogoSocio) {
        this.rutaLogoSocio = rutaLogoSocio;
    }

    public Boolean getHabilitado() {
        return habilitado;
    }

    public void setHabilitado(Boolean habilitado) {
        this.habilitado = habilitado;
    }

    public List<Convenio> getConvenioList() {
        return convenioList;
    }

    public void setConvenioList(List<Convenio> convenioList) {
        this.convenioList = convenioList;
    }

    public TipoSocio getTipoSocio() {
        return tipoSocio;
    }

    public void setTipoSocio(TipoSocio tipoSocio) {
        this.tipoSocio = tipoSocio;
    }

    public List<RepresentanteSocio> getRepresentanteSocioList() {
        if (representanteSocioList == null) {
            representanteSocioList = new ArrayList();
        }
        return representanteSocioList;
    }

    public void setRepresentanteSocioList(List<RepresentanteSocio> representanteSocioList) {
        this.representanteSocioList = representanteSocioList;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idSocio != null ? idSocio.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof SocioEstrategico)) {
            return false;
        }
        SocioEstrategico other = (SocioEstrategico) object;
        if ((this.idSocio == null && other.idSocio != null) || (this.idSocio != null && !this.idSocio.equals(other.idSocio))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "sv.gob.mined.convenio.model.SocioEstrategico[ idSocio=" + idSocio + " ]";
    }

}
