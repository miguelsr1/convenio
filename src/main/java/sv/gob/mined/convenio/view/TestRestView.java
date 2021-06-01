/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sv.gob.mined.convenio.view;

import com.mashape.unirest.http.HttpResponse;
import com.mashape.unirest.http.Unirest;
import com.mashape.unirest.http.exceptions.UnirestException;
import java.io.Serializable;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.faces.view.ViewScoped;
import javax.inject.Named;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

@Named
@ViewScoped
public class TestRestView implements Serializable {

    private String metodo;
    private String json;
    private String resultado;
    private String jwt;

    public String getMetodo() {
        return metodo;
    }

    public void setMetodo(String metodo) {
        this.metodo = metodo;
    }

    public String getJson() {
        return json;
    }

    public void setJson(String json) {
        this.json = json;
    }

    public String getResultado() {
        return resultado;
    }

    public void setResultado(String resultado) {
        this.resultado = resultado;
    }

    public void auth() throws ParseException {
        resultado = "";
        try {
            if (jwt == null || jwt.isEmpty()) {
                String wsURL = "https://accessmanager-mobile.siges.sv/am/auth/basic";
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
                        .asString();
                jwt = response.getBody();
            }
            getDatos();
        } catch (UnirestException ex) {
            Logger.getLogger(TestRestView.class.getName()).log(Level.SEVERE, null, ex);
            jwt = null;
        }

    }

    public void getDatos() throws ParseException {
        JSONParser parser = new JSONParser();
        JSONObject token = (JSONObject) parser.parse(jwt);

        if (jwt == null) {
            resultado = "Error en la obtención del JWT";
        } else
        try {
            HttpResponse<String> response = Unirest.post("https://catalogos.siges.sv/" + metodo) //ce/sedes/buscar
                    .header("Content-Type", "application/json")
                    .header("Authorization", "Bearer " + token.get("jwt").toString())
                    .header("Accept", "*/*")
                    .header("Cache-Control", "no-cache")
                    .header("Host", "catalogo.siges.sv")
                    .header("Cookie", "SIGESID=.1")
                    .header("Accept-Encoding", "gzip, deflate")
                    .header("Connection", "keep-alive")
                    .header("cache-control", "no-cache")
                    .body(json)
                    .asString();
            resultado = response.getBody();
        } catch (UnirestException ex) {
            Logger.getLogger(TestRestView.class.getName()).log(Level.SEVERE, null, ex);
            resultado = "Server exception";
        }
    }

}
