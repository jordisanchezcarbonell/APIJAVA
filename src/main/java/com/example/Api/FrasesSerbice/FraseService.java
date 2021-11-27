package com.example.Api.FrasesSerbice;
import java.util.List;
import com.example.Api.BDClass.Frases;
public interface FraseService {

    public List<Frases> findAll();

    public Frases findById(int id);

    public void save(Frases user);

    public void deleteById(int id);
}
