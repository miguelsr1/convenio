/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sv.gob.mined.convenio.facade.clientrest;

import java.io.Serializable;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.enterprise.context.RequestScoped;
import javax.inject.Named;
import com.mashape.unirest.http.HttpResponse;
import com.mashape.unirest.http.Unirest;
import com.mashape.unirest.http.exceptions.UnirestException;

/**
 *
 * @author misanchez
 */
@Named
@RequestScoped
public class UbicacionRestClient implements Serializable {

//    
//    public List<SgDepartamento> buscar(FiltroCodiguera filtro) throws HttpServerException, HttpClientException, HttpServerUnavailableException, BusinessException {
//        if (filtro == null || userToken == null) {
//            new ArrayList<>();
//        }
//        WebTarget webTarget = RestClient.getWebTarget(ConstantesServiciosRest.SERVICIO_CATALOGO, "v1/departamentos/buscar");
//        SgDepartamento[] departamentos = RestClient.invokePost(webTarget, filtro, SgDepartamento[].class, userToken);
//        return Arrays.asList(departamentos);
//    }
    public String getAuth(String content) {
        try {
            String wsURL = "https://accessmanager-mobile.siges.sv/am/auth/basic";
            //String wsURL = "https://mobile-endpoint-preprod.siges.sv/ss/seg/auth";
            HttpResponse<String> response = Unirest.post(wsURL)
                    .header("Content-Type", "application/json")
                    .header("Accept", "*/*")
                    .header("Cache-Control", "no-cache")
                    .header("Host", "accessmanager-mobile.siges.sv")
                    .header("Cookie", "SIGESID=.1")
                    .header("Accept-Encoding", "gzip, deflate")
                    .header("Connection", "keep-alive")
                    .header("cache-control", "no-cache")
                    .body("{\n    \"username\": \"WS\",\n    \"password\": \"Pruebas123.\",\n    \"address\": \"192.168.1.2\",\n    \"audience\":\"PRESIDENCIA\", \n \"audienceSecret\":\"ujVYoBnGDx\",   \"tokenExpirationMinutes\": 120,\n    \"categoriasOperacion\": [\n        1\n    ]\n}")
                    //.body(content)
                    .asString();
            //System.out.println("Content --> " + content + " response.getBody ----> " + response.getBody());
            return response.getBody();
        } catch (UnirestException ex) {
            Logger.getLogger(UbicacionRestClient.class.getName()).log(Level.SEVERE, null, ex);
            return "You are the only exception";
        }

    }

    public String getSedes(String content) {
        System.out.println("getSedes ");
        System.out.println(content);
        try {
            HttpResponse<String> response = Unirest.post("https://centros-mobile.siges.sv/ce/sedes/buscar")
                    .header("Content-Type", "application/json")
                    .header("Authorization", "Bearer " + content)
                    .header("Accept", "*/*")
                    .header("Cache-Control", "no-cache")
                    .header("Host", "centros-mobile.siges.sv")
                    .header("Cookie", "SIGESID=.1")
                    .header("Accept-Encoding", "gzip, deflate")
                    .header("Connection", "keep-alive")
                    .header("cache-control", "no-cache")
                    .body("{\n \"maxResults\": -1,\n   \"incluirCampos\": [\n       \"sedNombre\",\n \"sedDireccion\",\n       \"sedCodigo\"\n   ]\n\n}")
                    .asString();
            return response.getBody();
        } catch (UnirestException ex) {
            Logger.getLogger(UbicacionRestClient.class.getName()).log(Level.SEVERE, null, ex);
            return "Server exception";
        }
    }
}
