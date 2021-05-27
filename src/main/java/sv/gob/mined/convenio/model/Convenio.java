/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sv.gob.mined.convenio.model;

import java.io.Serializable;
import java.math.BigDecimal;
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
@Table(name = "convenio")
@NamedQueries({
    @NamedQuery(name = "Convenio.findAll", query = "SELECT c FROM Convenio c")})
public class Convenio implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "id_convenio")
    private Integer idConvenio;
    @Size(max = 30)
    @Column(name = "codigo_convenio")
    private String codigoConvenio;
    @Column(name = "fecha_firma_convenio")
    @Temporal(TemporalType.DATE)
    private Date fechaFirmaConvenio;
    @Column(name = "fecha_ini_vigencia_convenio")
    @Temporal(TemporalType.DATE)
    private Date fechaIniVigenciaConvenio;
    @Column(name = "fecha_fin_vigencia_convenio")
    @Temporal(TemporalType.DATE)
    private Date fechaFinVigenciaConvenio;
    @Size(max = 10)
    @Column(name = "unidad_orga_edificio_ubic")
    private String unidadOrgaEdificioUbic;
    @Size(max = 250)
    @Column(name = "proyecto_convenio")
    private String proyectoConvenio;
    @Size(max = 2000)
    @Column(name = "motivo_convenio")
    private String motivoConvenio;
    @Size(max = 100)
    @Column(name = "resp_ejecucion_convenio_socio")
    private String respEjecucionConvenioSocio;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Column(name = "monto_total")
    private BigDecimal montoTotal;
    @Column(name = "cantidad_desembolsos")
    private Short cantidadDesembolsos;
    @Size(max = 1000)
    @Column(name = "plan_cuscatlan")
    private String planCuscatlan;
    @Size(max = 1000)
    @Column(name = "objetivo_general_convenio")
    private String objetivoGeneralConvenio;
    @Size(max = 1000)
    @Column(name = "objetivos_especi_convenio")
    private String objetivosEspeciConvenio;
    @Size(max = 1000)
    @Column(name = "metas_convenio")
    private String metasConvenio;
    @Size(max = 30)
    @Column(name = "rubricas_convenio")
    private String rubricasConvenio;
    @Column(name = "convenio_etiquetado_asam_leg")
    private Boolean convenioEtiquetadoAsamLeg;
    @Column(name = "avalado_por_juridico")
    private Boolean avaladoPorJuridico;
    @Column(name = "fecha_avalado_juridico")
    @Temporal(TemporalType.DATE)
    private Date fechaAvaladoJuridico;
    @Size(max = 200)
    @Column(name = "ruta_convenio_digitalizado")
    private String rutaConvenioDigitalizado;
    @JoinColumn(name = "personaria_convenio", referencedColumnName = "id_personeria")
    @ManyToOne(fetch = FetchType.LAZY)
    private Personeria personariaConvenio;
    @JoinColumn(name = "socio_estrategico", referencedColumnName = "id_socio")
    @ManyToOne(fetch = FetchType.LAZY)
    private SocioEstrategico socioEstrategico;
    @JoinColumn(name = "unidad_orga_designada", referencedColumnName = "id_unidad_organizativa")
    @ManyToOne(fetch = FetchType.LAZY)
    private UnidadOrganizativa unidadOrgaDesignada;
    @JoinColumn(name = "unidad_orga_responsable", referencedColumnName = "id_unidad_organizativa")
    @ManyToOne(fetch = FetchType.LAZY)
    private UnidadOrganizativa unidadOrgaResponsable;

    public Convenio() {
    }

    public Convenio(Integer idConvenio) {
        this.idConvenio = idConvenio;
    }

    public Integer getIdConvenio() {
        return idConvenio;
    }

    public void setIdConvenio(Integer idConvenio) {
        this.idConvenio = idConvenio;
    }

    public String getCodigoConvenio() {
        return codigoConvenio;
    }

    public void setCodigoConvenio(String codigoConvenio) {
        this.codigoConvenio = codigoConvenio;
    }

    public Date getFechaFirmaConvenio() {
        return fechaFirmaConvenio;
    }

    public void setFechaFirmaConvenio(Date fechaFirmaConvenio) {
        this.fechaFirmaConvenio = fechaFirmaConvenio;
    }

    public Date getFechaIniVigenciaConvenio() {
        return fechaIniVigenciaConvenio;
    }

    public void setFechaIniVigenciaConvenio(Date fechaIniVigenciaConvenio) {
        this.fechaIniVigenciaConvenio = fechaIniVigenciaConvenio;
    }

    public Date getFechaFinVigenciaConvenio() {
        return fechaFinVigenciaConvenio;
    }

    public void setFechaFinVigenciaConvenio(Date fechaFinVigenciaConvenio) {
        this.fechaFinVigenciaConvenio = fechaFinVigenciaConvenio;
    }

    public String getUnidadOrgaEdificioUbic() {
        return unidadOrgaEdificioUbic;
    }

    public void setUnidadOrgaEdificioUbic(String unidadOrgaEdificioUbic) {
        this.unidadOrgaEdificioUbic = unidadOrgaEdificioUbic;
    }

    public String getProyectoConvenio() {
        return proyectoConvenio;
    }

    public void setProyectoConvenio(String proyectoConvenio) {
        this.proyectoConvenio = proyectoConvenio;
    }

    public String getMotivoConvenio() {
        return motivoConvenio;
    }

    public void setMotivoConvenio(String motivoConvenio) {
        this.motivoConvenio = motivoConvenio;
    }

    public String getRespEjecucionConvenioSocio() {
        return respEjecucionConvenioSocio;
    }

    public void setRespEjecucionConvenioSocio(String respEjecucionConvenioSocio) {
        this.respEjecucionConvenioSocio = respEjecucionConvenioSocio;
    }

    public BigDecimal getMontoTotal() {
        return montoTotal;
    }

    public void setMontoTotal(BigDecimal montoTotal) {
        this.montoTotal = montoTotal;
    }

    public Short getCantidadDesembolsos() {
        return cantidadDesembolsos;
    }

    public void setCantidadDesembolsos(Short cantidadDesembolsos) {
        this.cantidadDesembolsos = cantidadDesembolsos;
    }

    public String getPlanCuscatlan() {
        return planCuscatlan;
    }

    public void setPlanCuscatlan(String planCuscatlan) {
        this.planCuscatlan = planCuscatlan;
    }

    public String getObjetivoGeneralConvenio() {
        return objetivoGeneralConvenio;
    }

    public void setObjetivoGeneralConvenio(String objetivoGeneralConvenio) {
        this.objetivoGeneralConvenio = objetivoGeneralConvenio;
    }

    public String getObjetivosEspeciConvenio() {
        return objetivosEspeciConvenio;
    }

    public void setObjetivosEspeciConvenio(String objetivosEspeciConvenio) {
        this.objetivosEspeciConvenio = objetivosEspeciConvenio;
    }

    public String getMetasConvenio() {
        return metasConvenio;
    }

    public void setMetasConvenio(String metasConvenio) {
        this.metasConvenio = metasConvenio;
    }

    public String getRubricasConvenio() {
        return rubricasConvenio;
    }

    public void setRubricasConvenio(String rubricasConvenio) {
        this.rubricasConvenio = rubricasConvenio;
    }

    public Boolean getConvenioEtiquetadoAsamLeg() {
        return convenioEtiquetadoAsamLeg;
    }

    public void setConvenioEtiquetadoAsamLeg(Boolean convenioEtiquetadoAsamLeg) {
        this.convenioEtiquetadoAsamLeg = convenioEtiquetadoAsamLeg;
    }

    public Boolean getAvaladoPorJuridico() {
        return avaladoPorJuridico;
    }

    public void setAvaladoPorJuridico(Boolean avaladoPorJuridico) {
        this.avaladoPorJuridico = avaladoPorJuridico;
    }

    public Date getFechaAvaladoJuridico() {
        return fechaAvaladoJuridico;
    }

    public void setFechaAvaladoJuridico(Date fechaAvaladoJuridico) {
        this.fechaAvaladoJuridico = fechaAvaladoJuridico;
    }

    public String getRutaConvenioDigitalizado() {
        return rutaConvenioDigitalizado;
    }

    public void setRutaConvenioDigitalizado(String rutaConvenioDigitalizado) {
        this.rutaConvenioDigitalizado = rutaConvenioDigitalizado;
    }

    public Personeria getPersonariaConvenio() {
        return personariaConvenio;
    }

    public void setPersonariaConvenio(Personeria personariaConvenio) {
        this.personariaConvenio = personariaConvenio;
    }

    public SocioEstrategico getSocioEstrategico() {
        return socioEstrategico;
    }

    public void setSocioEstrategico(SocioEstrategico socioEstrategico) {
        this.socioEstrategico = socioEstrategico;
    }

    public UnidadOrganizativa getUnidadOrgaDesignada() {
        return unidadOrgaDesignada;
    }

    public void setUnidadOrgaDesignada(UnidadOrganizativa unidadOrgaDesignada) {
        this.unidadOrgaDesignada = unidadOrgaDesignada;
    }

    public UnidadOrganizativa getUnidadOrgaResponsable() {
        return unidadOrgaResponsable;
    }

    public void setUnidadOrgaResponsable(UnidadOrganizativa unidadOrgaResponsable) {
        this.unidadOrgaResponsable = unidadOrgaResponsable;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idConvenio != null ? idConvenio.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Convenio)) {
            return false;
        }
        Convenio other = (Convenio) object;
        if ((this.idConvenio == null && other.idConvenio != null) || (this.idConvenio != null && !this.idConvenio.equals(other.idConvenio))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "sv.gob.mined.convenio.model.Convenio[ idConvenio=" + idConvenio + " ]";
    }
    
}
