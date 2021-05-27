/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sv.gob.mined.convenio.view;

import java.io.Serializable;
import java.util.List;
import javax.faces.view.ViewScoped;
import javax.inject.Inject;
import javax.inject.Named;
import sv.gob.mined.convenio.facade.CatalogoFacade;
import sv.gob.mined.convenio.model.SocioEstrategico;

@Named
@ViewScoped
public class ListadoSocioView implements Serializable {

    @Inject
    private CatalogoFacade catalogoFacade;
    
    public List<SocioEstrategico> getListadoSocios(){
        return catalogoFacade.findAll();
    }
}
