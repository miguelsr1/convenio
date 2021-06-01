/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sv.gob.mined.convenio.view;

import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.annotation.PostConstruct;
import javax.faces.view.ViewScoped;
import javax.inject.Inject;
import javax.inject.Named;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;
import sv.gob.mined.convenio.facade.CatalogoFacade;
import sv.gob.mined.convenio.facade.clientrest.UbicacionRestClient;
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

    private static final Logger LOGGER = Logger.getLogger(SocioEstrategicoView.class.getName());

    private SocioEstrategico socioEstrategico = new SocioEstrategico();
    private RepresentanteSocio representanteSocio = new RepresentanteSocio();
    private Convenio convenio = new Convenio();

    private List<TipoSocio> lstTipoSocio;

    @Inject
    private CatalogoFacade catalogoFacade;
    @Inject
    private UbicacionRestClient ubicacionRestClient;

    private String userToken;
    private LocalDateTime userTokenGeneratedDate;
    private Integer userTokenExpirationTimeMinutes = 20;

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
        try {
            String contenido = ubicacionRestClient.getAuth(userToken);
            JSONParser parser = new JSONParser();
            JSONObject token = (JSONObject) parser.parse(contenido);
            String json = ubicacionRestClient.getSedes(token.get("jwt").toString());
            System.out.println(json);
            
        } catch (ParseException ex) {
            Logger.getLogger(SocioEstrategicoView.class.getName()).log(Level.SEVERE, null, ex);
        }
        return "lstSocios.mined";
    }

//    @Produces
//    @Named("userToken")
//    public String getUserToken() {
//        try {
//            if (userTokenGeneratedDate == null || !userTokenGeneratedDate.plusMinutes(userTokenExpirationTimeMinutes - 2L).isAfter(LocalDateTime.now())) {
//                LOGGER.log(Level.INFO, "Token cerca de expirar. Generando nuevo token. Usuario: " + this.user.getName());
//                generarTokenUsuario();
//            }
//            return this.userToken;
//        } catch (Exception ex) {
//            LOGGER.log(Level.SEVERE, ex.getMessage(), ex);
//        }
//        return null;
//    }
//
//    public void generarTokenUsuario() throws Exception {
//        this.userToken = JWTUtils.generarToken(this.user.getName(), this.userIp, "/privateKey.pem", operaciones, userTokenExpirationTimeMinutes);
//        this.userTokenGeneratedDate = LocalDateTime.now();
//    }
}
