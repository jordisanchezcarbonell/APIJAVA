package com.example.Api.FrasesDao;
import java.util.List;

import javax.persistence.EntityManager;

import org.hibernate.Session;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import com.example.Api.BDClass.Frases;
import org.springframework.transaction.annotation.Transactional;
/*@Repository que indica que es un DAO
@Autowired inyectaremos EntityManager, que lo utilizaremos para crear una sessión y poder enviar las peticiones a la base de datos en cada método
* */
@Repository

public class FasesDaoclass implements FasesDao {
    @Autowired
    private EntityManager entityManager;

    @Override
    public List<Frases> findAll() {
        Session currentSession = entityManager.unwrap(Session.class);

        Query<Frases> theQuery = currentSession.createQuery("from Frases", Frases.class);

        List<Frases> Frases = theQuery.getResultList();

        return Frases;

    }

    @Override
    public Frases findById(int id) {
        Session currentSession = entityManager.unwrap(Session.class);

        Frases user = currentSession.get(Frases.class, id);

        return user;
    }

    @Override
    public void save(Frases user) {
        Session currentSession = entityManager.unwrap(Session.class);

        currentSession.saveOrUpdate(user);

    }

    @Override
    @Transactional
    public void deleteById(int id) {
        Session currentSession = entityManager.unwrap(Session.class);

        Query<Frases> theQuery = currentSession.createQuery("delete from Frases where id=:idfrases");

        theQuery.setParameter("idfrases", id);
        theQuery.executeUpdate();

    }
}
