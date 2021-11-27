package com.example.Api.FrasesDao;


import java.util.List;
import com.example.Api.BDClass.Frases;

public interface FasesDao {
    public List<Frases> findAll();

    public Frases findById(int id);

    public void save(Frases user);

    public void deleteById(int id);
}
