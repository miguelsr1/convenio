/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sv.gob.mined.convenio.view;

import java.io.Serializable;
import java.util.List;
import javax.annotation.PostConstruct;
import javax.faces.view.ViewScoped;
import javax.inject.Inject;
import javax.inject.Named;
import sv.gob.mined.convenio.facade.CatalogoFacade;
import sv.gob.mined.convenio.model.Convenio;
import sv.gob.mined.convenio.model.RepresentanteSocio;
import sv.gob.mined.convenio.model.SocioEstrategico;
import sv.gob.mined.convenio.model.TipoSocio;

/**
 *
 * @author misanchez
 */
@Named
@ViewScoped
public class SocioEstrategicoView implements Serializable {

    
    private SocioEstrategico socioEstrategico = new SocioEstrategico();
    private RepresentanteSocio representanteSocio = new RepresentanteSocio();
    private Convenio convenio = new Convenio();

    private List<TipoSocio> lstTipoSocio;
    
    @Inject
    private CatalogoFacade catalogoFacade;

    @PostConstruct
    public void init() {
        representanteSocio.setSocioEstrategico(socioEstrategico);
        socioEstrategico.getRepresentanteSocioList().add(representanteSocio);
        lstTipoSocio = catalogoFacade.findAllTipoSocio();
    }

    public SocioEstrategico getSocioEstrategico() {
        return socioEstrategico;
    }

    public void setSocioEstrategico(SocioEstrategico socioEstrategico) {
        this.socioEstrategico = socioEstrategico;
    }

    public RepresentanteSocio getRepresentanteSocio() {
        return representanteSocio;
    }

    public void setRepresentanteSocio(RepresentanteSocio representanteSocio) {
        this.representanteSocio = representanteSocio;
    }

    public Convenio getConvenio() {
        return convenio;
    }

    public void setConvenio(Convenio convenio) {
        this.convenio = convenio;
    }

    public List<TipoSocio> getLstTipoSocio() {
        return lstTipoSocio;
    }

    public String guadar() {
        return "lstSocios.mined";
    }
}
