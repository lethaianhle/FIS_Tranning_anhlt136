package fis.training.entity;

import com.fasterxml.jackson.annotation.JsonBackReference;
import fis.training.enums.EmploymentStatus;
import fis.training.enums.Rank;
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
public class Detective extends AbstractEntity {

    @OneToOne
    @JoinColumn(name = "person_id")
    private Person person;

    @Column(name = "badge_number", unique = true)
    private String badgeNumber;

    @Enumerated(EnumType.STRING)
    private Rank rank;

    private boolean armed;

    @Enumerated(EnumType.STRING)
    private EmploymentStatus status;

    @ManyToMany(cascade = CascadeType.MERGE)
    @JoinTable(
            name = "working_detective_case",
            joinColumns = @JoinColumn(name = "detective_id", referencedColumnName = "id"),
            inverseJoinColumns = @JoinColumn(name = "criminal_case_id", referencedColumnName = "id"))
    @JsonBackReference
    private Set<CriminalCase> criminalCases = new HashSet<>();

    @OneToMany(mappedBy = "detective")
    @JsonBackReference
    private Set<TrackEntry> trackEntries = new HashSet<>();

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || Hibernate.getClass(this) != Hibernate.getClass(o)) return false;
        Detective detective = (Detective) o;
        return getId() != null && Objects.equals(getId(), detective.getId());
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
                "person = " + getPerson() + ", " +
                "badgeNumber = " + getBadgeNumber() + ", " +
                "rank = " + getRank() + ", " +
                "armed = " + isArmed() + ", " +
                "status = " + getStatus() + ")";
    }

}
