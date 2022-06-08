package fis.java.bigexample.dao;

import fis.java.bigexample.model.CriminalCase;

public interface ICriminalDAO {
    public void add(CriminalCase criminalCase);
    public CriminalCase remove(int code);
    public CriminalCase update(CriminalCase criminalCase);

}
