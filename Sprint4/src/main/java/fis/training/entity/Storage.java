package fis.training.entity;

import com.fasterxml.jackson.annotation.JsonBackReference;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.Hibernate;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.OneToMany;
import java.util.HashSet;
import java.util.Objects;
import java.util.Set;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class Storage extends AbstractEntity {

    private String name;

    private String location;

    @OneToMany(mappedBy = "storage", cascade = CascadeType.ALL)
    @JsonBackReference
    private Set<Evidence> evidenceSet = new HashSet<>();

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || Hibernate.getClass(this) != Hibernate.getClass(o)) return false;
        Storage storage = (Storage) o;
        return getId() != null && Objects.equals(getId(), storage.getId());
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
                "name = " + getName() + ", " +
                "location = " + getLocation() + ")";
    }

}