package fis.training.entity;

import com.fasterxml.jackson.annotation.JsonBackReference;
import fis.training.enums.CaseStatus;
import fis.training.enums.CaseType;
import lombok.*;
import org.hibernate.Hibernate;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Objects;
import java.util.Set;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "criminal_case")
public class CriminalCase extends AbstractEntity{

    private String number;

    @Enumerated(EnumType.STRING)
    private CaseType type;

    @Column(name = "short_description")
    private String shortDescription;

    @Column(name = "detailed_description")
    private String detailedDescription;

    @Enumerated(EnumType.STRING)
    private CaseStatus status;

    private String notes;

    @OneToMany(mappedBy = "criminalCase", cascade = CascadeType.ALL)
    @JsonBackReference
    private Set<Evidence> evidenceSet = new HashSet<>();

    @OneToOne
    @JoinColumn(name="lead_investigator", nullable = false)
    private Detective leadInvestigator;

    @ManyToMany(cascade = CascadeType.MERGE)
    @JsonBackReference
    @JoinTable(name = "working_detective_case",
            joinColumns = @JoinColumn(name = "criminal_case_id", referencedColumnName="id"),
            inverseJoinColumns = @JoinColumn(name = "detective_id", referencedColumnName="id"))
    private Set<Detective> assigned = new HashSet<>();

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || Hibernate.getClass(this) != Hibernate.getClass(o)) return false;
        CriminalCase that = (CriminalCase) o;
        return getId() != null && Objects.equals(getId(), that.getId());
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
                "number = " + getNumber() + ", " +
                "type = " + getType() + ", " +
                "shortDescription = " + getShortDescription() + ", " +
                "detailedDescription = " + getDetailedDescription() + ", " +
                "status = " + getStatus() + ", " +
                "notes = " + getNotes() + ", " +
                "leadInvestigator = " + getLeadInvestigator() + ")";
    }

}
