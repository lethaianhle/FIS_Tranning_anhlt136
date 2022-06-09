package com.fis.cems.model;

import java.time.LocalDateTime;
import java.util.Set;

public class Evidence extends AbstractEntity {
    private CriminalCase criminalCase;

    private Storage storage;

    private String number;

    private String itemName;

    private String notes;

    private Boolean archived;

    private Set<TrackEntry> trackEntries;

    public Evidence() {
    }

    public Evidence(CriminalCase criminalCase,
                    Storage storage,
                    String number,
                    String itemName,
                    String notes,
                    Boolean archived,
                    Set<TrackEntry> trackEntries) {
        this.criminalCase = criminalCase;
        this.storage = storage;
        this.number = number;
        this.itemName = itemName;
        this.notes = notes;
        this.archived = archived;
        this.trackEntries = trackEntries;
    }

    public Evidence(Long id, int version, LocalDateTime createdAt, LocalDateTime modifiedAt,
                    CriminalCase criminalCase,
                    Storage storage,
                    String number,
                    String itemName,
                    String notes,
                    Boolean archived,
                    Set<TrackEntry> trackEntries) {
        super(id, version, createdAt, modifiedAt);
        this.criminalCase = criminalCase;
        this.storage = storage;
        this.number = number;
        this.itemName = itemName;
        this.notes = notes;
        this.archived = archived;
        this.trackEntries = trackEntries;
    }

    public CriminalCase getCriminalCase() {
        return criminalCase;
    }

    public void setCriminalCase(CriminalCase criminalCase) {
        this.criminalCase = criminalCase;
    }

    public Storage getStorage() {
        return storage;
    }

    public void setStorage(Storage storage) {
        this.storage = storage;
    }

    public String getNumber() {
        return number;
    }

    public void setNumber(String number) {
        this.number = number;
    }

    public String getItemName() {
        return itemName;
    }

    public void setItemName(String itemName) {
        this.itemName = itemName;
    }

    public String getNotes() {
        return notes;
    }

    public void setNotes(String notes) {
        this.notes = notes;
    }

    public Boolean getArchived() {
        return archived;
    }

    public void setArchived(Boolean archived) {
        this.archived = archived;
    }

    public Set<TrackEntry> getTrackEntries() {
        return trackEntries;
    }

    public void setTrackEntries(Set<TrackEntry> trackEntries) {
        this.trackEntries = trackEntries;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Evidence evidence = (Evidence) o;

        if (criminalCase != null ? !criminalCase.equals(evidence.criminalCase) : evidence.criminalCase != null)
            return false;
        if (storage != null ? !storage.equals(evidence.storage) : evidence.storage != null) return false;
        if (number != null ? !number.equals(evidence.number) : evidence.number != null) return false;
        if (itemName != null ? !itemName.equals(evidence.itemName) : evidence.itemName != null) return false;
        if (notes != null ? !notes.equals(evidence.notes) : evidence.notes != null) return false;
        if (archived != null ? !archived.equals(evidence.archived) : evidence.archived != null) return false;
        return trackEntries != null ? trackEntries.equals(evidence.trackEntries) : evidence.trackEntries == null;
    }

    @Override
    public int hashCode() {
        int result = criminalCase != null ? criminalCase.hashCode() : 0;
        result = 31 * result + (storage != null ? storage.hashCode() : 0);
        result = 31 * result + (number != null ? number.hashCode() : 0);
        result = 31 * result + (itemName != null ? itemName.hashCode() : 0);
        result = 31 * result + (notes != null ? notes.hashCode() : 0);
        result = 31 * result + (archived != null ? archived.hashCode() : 0);
        result = 31 * result + (trackEntries != null ? trackEntries.hashCode() : 0);
        return result;
    }

    @Override
    public String toString() {
        return "Evidence{" +
                "criminalCase=" + criminalCase +
                ", storage=" + storage +
                ", number='" + number + '\'' +
                ", itemName='" + itemName + '\'' +
                ", notes='" + notes + '\'' +
                ", archived=" + archived +
                ", trackEntries=" + trackEntries +
                '}';
    }
}
