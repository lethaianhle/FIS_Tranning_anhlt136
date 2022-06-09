package fis.java.bigexample.dao.imp;

import fis.java.bigexample.dao.IEvidenceDAO;
import fis.java.bigexample.model.Evidence;

import java.util.ArrayList;
import java.util.List;

public class EvidenceDAO implements IEvidenceDAO {
    // memory storage example
    private List<Evidence> evidenceList = new ArrayList<>();

    private EvidenceDAO() {

    }

    //Apply Singleton Pattern for DAO class
    private static EvidenceDAO evidenceDAO = null;

    public static EvidenceDAO getInstance() {
        return evidenceDAO == null ? new EvidenceDAO() : evidenceDAO;
    }

    @Override
    public void add(Evidence evidence) {
        this.evidenceList.add(evidence);
    }

    @Override
    public Evidence remove(int code) {
        return null;
    }

    @Override
    public Evidence update(Evidence evidence) {
        return null;
    }
}
