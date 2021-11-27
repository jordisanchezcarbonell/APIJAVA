package com.example.Api.FrasesSerbice;

import com.example.Api.BDClass.Frases;
import com.example.Api.FrasesDao.FasesDao;

import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;
import org.springframework.stereotype.Service;

/*@Repository que indica que es un DAO
@Autowired inyectaremos EntityManager, que lo utilizaremos para crear una sessión y poder enviar las peticiones a la base de datos en cada método
* */
@Service
public class FasesDaoService implements FraseService {

    @Autowired
    private FasesDao fraseDAO;

    @Override
    public List<Frases> findAll() {
        List<Frases> listFrases= fraseDAO.findAll();
        return listFrases;
    }

    @Override
    public Frases findById(int id) {
        Frases frase = fraseDAO.findById(id);
        return frase;
    }

    @Override
    public void save(Frases frase) {
        fraseDAO.save(frase);

    }

    @Override
    public void deleteById(int id) {
        fraseDAO.deleteById(id);
    }
}
