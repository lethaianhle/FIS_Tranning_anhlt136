package fis.java.bigexample.dao.storage;

import fis.java.bigexample.model.Storage;

public interface IStorageDAO {
    public void add(Storage storage);
    public Storage remove(int code);
    public Storage update(Storage storage);
}
