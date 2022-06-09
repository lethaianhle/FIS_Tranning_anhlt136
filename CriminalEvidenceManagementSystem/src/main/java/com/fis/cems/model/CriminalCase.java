package com.fis.cems.model;

import com.fis.cems.model.enums.CaseStatus;
import com.fis.cems.model.enums.CaseType;

import java.time.LocalDateTime;
import java.util.Set;

public class CriminalCase extends AbstractEntity {
    private String number;

    private CaseType type;

    private String shortDescription;

    private String detailedDescription;

    private CaseStatus status;

    private String notes;

    private Set<Evidence> evidenceSet;

    private Detective leadInvestigator;

    private Set<Detective> assigned;

    public CriminalCase() {
    }

    public CriminalCase(String number,
                        CaseType type,
                        String shortDescription,
                        String detailedDescription,
                        CaseStatus status,
                        String notes,
                        Set<Evidence> evidenceSet,
                        Detective leadInvestigator,
                        Set<Detective> assigned) {
        this.number = number;
        this.type = type;
        this.shortDescription = shortDescription;
        this.detailedDescription = detailedDescription;
        this.status = status;
        this.notes = notes;
        this.evidenceSet = evidenceSet;
        this.leadInvestigator = leadInvestigator;
        this.assigned = assigned;
    }

    public CriminalCase(Long id, int version, LocalDateTime createdAt, LocalDateTime modifiedAt,
                        String number,
                        CaseType type,
                        String shortDescription,
                        String detailedDescription,
                        CaseStatus status,
                        String notes,
                        Set<Evidence> evidenceSet,
                        Detective leadInvestigator,
                        Set<Detective> assigned) {
        super(id, version, createdAt, modifiedAt);
        this.number = number;
        this.type = type;
        this.shortDescription = shortDescription;
        this.detailedDescription = detailedDescription;
        this.status = status;
        this.notes = notes;
        this.evidenceSet = evidenceSet;
        this.leadInvestigator = leadInvestigator;
        this.assigned = assigned;
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

    public void setEvidenceSet(Set<Evidence> evidenceSet) {
        this.evidenceSet = evidenceSet;
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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        CriminalCase that = (CriminalCase) o;

        if (number != null ? !number.equals(that.number) : that.number != null) return false;
        if (type != that.type) return false;
        if (shortDescription != null ? !shortDescription.equals(that.shortDescription) : that.shortDescription != null)
            return false;
        if (detailedDescription != null ? !detailedDescription.equals(that.detailedDescription) : that.detailedDescription != null)
            return false;
        if (status != that.status) return false;
        if (notes != null ? !notes.equals(that.notes) : that.notes != null) return false;
        if (evidenceSet != null ? !evidenceSet.equals(that.evidenceSet) : that.evidenceSet != null) return false;
        if (leadInvestigator != null ? !leadInvestigator.equals(that.leadInvestigator) : that.leadInvestigator != null)
            return false;
        return assigned != null ? assigned.equals(that.assigned) : that.assigned == null;
    }

    @Override
    public int hashCode() {
        int result = number != null ? number.hashCode() : 0;
        result = 31 * result + (type != null ? type.hashCode() : 0);
        result = 31 * result + (shortDescription != null ? shortDescription.hashCode() : 0);
        result = 31 * result + (detailedDescription != null ? detailedDescription.hashCode() : 0);
        result = 31 * result + (status != null ? status.hashCode() : 0);
        result = 31 * result + (notes != null ? notes.hashCode() : 0);
        result = 31 * result + (evidenceSet != null ? evidenceSet.hashCode() : 0);
        result = 31 * result + (leadInvestigator != null ? leadInvestigator.hashCode() : 0);
        result = 31 * result + (assigned != null ? assigned.hashCode() : 0);
        return result;
    }
}
