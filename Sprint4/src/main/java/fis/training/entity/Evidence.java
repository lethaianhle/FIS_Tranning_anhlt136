package fis.training.entity;

import com.fasterxml.jackson.annotation.JsonBackReference;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.Hibernate;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Objects;
import java.util.Set;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class Evidence extends AbstractEntity {

    @ManyToOne
    @JoinColumn(name="criminal_case_id", nullable = false)
    private CriminalCase criminalCase;

    @ManyToOne
    @JoinColumn(name = "storage_id", nullable = false)
    private Storage storage;

    private String number;

    @Column(name = "item_name")
    private String itemName;

    private String notes;

    private boolean archived;

    @OneToMany(mappedBy = "evidence", cascade = CascadeType.ALL)
    @JsonBackReference
    private Set<TrackEntry> trackEntries = new HashSet<>();

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || Hibernate.getClass(this) != Hibernate.getClass(o)) return false;
        Evidence evidence = (Evidence) o;
        return getId() != null && Objects.equals(getId(), evidence.getId());
    }

    @Override
    public int hashCode() {
        return getClass().hashCode();
    }

    @Override
    public String toString() {
        return getClass().getSimpleName() + "(" +
                "id = " + getId() + ", " +
                "version = " + getVersion() + ", " +
                "createdAt = " + getCreatedAt() + ", " +
                "modifiedAt = " + getModifiedAt() + ", " +
                "criminalCase = " + getCriminalCase() + ", " +
                "storage = " + getStorage() + ", " +
                "number = " + getNumber() + ", " +
                "itemName = " + getItemName() + ", " +
                "notes = " + getNotes() + ", " +
                "archived = " + isArchived() + ")";
    }

}
