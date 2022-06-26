package fis_training.entity;

import com.fasterxml.jackson.annotation.*;
import fis_training.enums.CaseStatus;
import fis_training.enums.CaseType;
import lombok.*;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Getter
@Setter
@AllArgsConstructor
@Builder
@Entity
@Table(name = "criminal_case")
@JsonIdentityInfo(
        generator = ObjectIdGenerators.PropertyGenerator.class,
        property = "id")
public class CriminalCase extends  AbstractEntity{

    @Column(name = "number")
    private String number;

    @Column(name = "type")
    private CaseType type;

    @Column(name = "short_description")
    private String shortDescription;

    @Column(name = "detailed_description")
    private String detailedDescription;

    @Column(name = "case_status")
    @Enumerated(EnumType.STRING)
    private CaseStatus status;

    @Column(name = "notes")
    private String notes;

    @OneToMany(mappedBy = "criminalCase", cascade = CascadeType.ALL)
    @EqualsAndHashCode.Exclude
    @ToString.Exclude
    @Transient
    private Set<Evidence> evidenceSet = new HashSet<>();

    @OneToOne
    @JoinColumn(name="lead_investigator", nullable = false)
    private Detective leadInvestigator;

    @ManyToMany
    @JoinTable(name = "working_detective_case", joinColumns = @JoinColumn(name = "criminal_case_id"),
            inverseJoinColumns = @JoinColumn(name = "detective_id"))
    @EqualsAndHashCode.Exclude
    @ToString.Exclude
    @JsonManagedReference(value = "criminal_case-detective")
    @Transient
    private Set<Detective> assigned = new HashSet<>();

    public CriminalCase() {
        super();
        this.status = CaseStatus.SUBMITTED;
        this.type = CaseType.UNCATEGORIZED;
    }

    public String getNumber() {
        return number;
    }

    public void setNumber(String number) {
        this.number = number;
    }

    public CaseType getType() {
        return type;
    }

    public void setType(CaseType type) {
        this.type = type;
    }

    public String getShortDescription() {
        return shortDescription;
    }

    public void setShortDescription(String shortDescription) {
        this.shortDescription = shortDescription;
    }

    public String getDetailedDescription() {
        return detailedDescription;
    }

    public void setDetailedDescription(String detailedDescription) {
        this.detailedDescription = detailedDescription;
    }

    public CaseStatus getStatus() {
        return status;
    }

    public void setStatus(CaseStatus status) {
        this.status = status;
    }

    public String getNotes() {
        return notes;
    }

    public void setNotes(String notes) {
        this.notes = notes;
    }

    public Set<Evidence> getEvidenceSet() {
        return evidenceSet;
    }

    public void setEvidenceSet(Set<Evidence> evidenceSetArg) {
        evidenceSetArg.forEach(this :: addEvidence);
    }

    public boolean addEvidence(Evidence evidence) {
        evidence.setCriminalCase(this);
        return evidenceSet.add(evidence);
    }

    public Detective getLeadInvestigator() {
        return leadInvestigator;
    }

    public void setLeadInvestigator(Detective leadInvestigator) {
        this.leadInvestigator = leadInvestigator;
    }

    public Set<Detective> getAssigned() {
        return assigned;
    }

    public void setAssigned(Set<Detective> assigned) {
        this.assigned = assigned;
    }

}
