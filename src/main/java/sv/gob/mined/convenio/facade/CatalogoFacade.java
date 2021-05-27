/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sv.gob.mined.convenio.facade;

import java.util.List;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import sv.gob.mined.convenio.model.SocioEstrategico;
import sv.gob.mined.convenio.model.TipoSocio;

@Stateless
public class CatalogoFacade {

    @PersistenceContext(unitName = "convenioPU")
    private EntityManager em;

    public List<SocioEstrategico> findAll() {
        Query q = em.createQuery("SELECT s FROM SocioEstrategico s ORDER BY s.idSocio", SocioEstrategico.class);
        return q.getResultList();
    }
    
    public List<TipoSocio> findAllTipoSocio(){
        Query q = em.createQuery("SELECT t FROM TipoSocio t ORDER BY t.idTipoSocio", TipoSocio.class);
        return q.getResultList();
    }
}
