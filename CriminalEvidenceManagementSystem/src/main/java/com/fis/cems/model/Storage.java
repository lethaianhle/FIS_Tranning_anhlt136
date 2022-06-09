package com.fis.cems.model;

import java.time.LocalDateTime;
import java.util.Set;

public class Storage  extends AbstractEntity {
    private String name;

    private String location;

    private Set<Evidence> evidenceSet;

    public Storage() {
        super();
    }

    public Storage(String name, String location, Set<Evidence> evidenceSet) {
        this.name = name;
        this.location = location;
        this.evidenceSet = evidenceSet;
    }

    public Storage(Long id,
                   int version,
                   LocalDateTime createdAt,
                   LocalDateTime modifiedAt,
                   String name,
                   String location,
                   Set<Evidence> evidenceSet) {
        super(id, version, createdAt, modifiedAt);
        this.name = name;
        this.location = location;
        this.evidenceSet = evidenceSet;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public Set<Evidence> getEvidenceSet() {
        return evidenceSet;
    }

    public void setEvidenceSet(Set<Evidence> evidenceSet) {
        this.evidenceSet = evidenceSet;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Storage storage = (Storage) o;

        if (name != null ? !name.equals(storage.name) : storage.name != null) return false;
        if (location != null ? !location.equals(storage.location) : storage.location != null) return false;
        return evidenceSet != null ? evidenceSet.equals(storage.evidenceSet) : storage.evidenceSet == null;
    }

    @Override
    public int hashCode() {
        int result = name != null ? name.hashCode() : 0;
        result = 31 * result + (location != null ? location.hashCode() : 0);
        result = 31 * result + (evidenceSet != null ? evidenceSet.hashCode() : 0);
        return result;
    }

    @Override
    public String toString() {
        return "Storage{" +
                "name='" + name + '\'' +
                ", location='" + location + '\'' +
                ", evidenceSet=" + evidenceSet +
                '}';
    }
}
