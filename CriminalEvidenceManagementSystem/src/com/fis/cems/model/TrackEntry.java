package com.fis.cems.model;

import com.fis.cems.model.enums.TrackAction;
import java.time.LocalDateTime;

public class TrackEntry extends AbstractEntity {
    private LocalDateTime date;

    private Evidence evidence;

    private Detective detective;

    private TrackAction action;

    private String reason;

    public TrackEntry() {

    }

    public TrackEntry(LocalDateTime date,
                      Evidence evidence,
                      Detective detective,
                      TrackAction action,
                      String reason) {
        this.date = date;
        this.evidence = evidence;
        this.detective = detective;
        this.action = action;
        this.reason = reason;
    }

    public TrackEntry(Long id, int version, LocalDateTime createdAt, LocalDateTime modifiedAt,
                      LocalDateTime date,
                      Evidence evidence,
                      Detective detective,
                      TrackAction action,
                      String reason) {
        super(id, version, createdAt, modifiedAt);
        this.date = date;
        this.evidence = evidence;
        this.detective = detective;
        this.action = action;
        this.reason = reason;
    }

    public LocalDateTime getDate() {
        return date;
    }

    public void setDate(LocalDateTime date) {
        this.date = date;
    }

    public Evidence getEvidence() {
        return evidence;
    }

    public void setEvidence(Evidence evidence) {
        this.evidence = evidence;
    }

    public Detective getDetective() {
        return detective;
    }

    public void setDetective(Detective detective) {
        this.detective = detective;
    }

    public TrackAction getAction() {
        return action;
    }

    public void setAction(TrackAction action) {
        this.action = action;
    }

    public String getReason() {
        return reason;
    }

    public void setReason(String reason) {
        this.reason = reason;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        TrackEntry that = (TrackEntry) o;

        if (date != null ? !date.equals(that.date) : that.date != null) return false;
        if (evidence != null ? !evidence.equals(that.evidence) : that.evidence != null) return false;
        if (detective != null ? !detective.equals(that.detective) : that.detective != null) return false;
        if (action != that.action) return false;
        return reason != null ? reason.equals(that.reason) : that.reason == null;
    }

    @Override
    public int hashCode() {
        int result = date != null ? date.hashCode() : 0;
        result = 31 * result + (evidence != null ? evidence.hashCode() : 0);
        result = 31 * result + (detective != null ? detective.hashCode() : 0);
        result = 31 * result + (action != null ? action.hashCode() : 0);
        result = 31 * result + (reason != null ? reason.hashCode() : 0);
        return result;
    }

    @Override
    public String toString() {
        return "TrackEntry{" +
                "date=" + date +
                ", evidence=" + evidence +
                ", detective=" + detective +
                ", action=" + action +
                ", reason='" + reason + '\'' +
                '}';
    }
}
