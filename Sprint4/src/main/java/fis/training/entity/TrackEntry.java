package fis.training.entity;

import com.fasterxml.jackson.annotation.JsonBackReference;
import fis.training.enums.TrackAction;
import lombok.*;
import org.hibernate.Hibernate;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.Objects;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
@Entity
public class TrackEntry extends AbstractEntity{

    @Column(columnDefinition = "TIMESTAMP DEFAULT CURRENT_TIMESTAMP")
    private LocalDateTime date;

    @ManyToOne
    @JoinColumn(name = "evidence_id", nullable = false)
    @JsonBackReference
    private Evidence evidence;

    @ManyToOne
    @JoinColumn(name = "detective_id", nullable = false)
    @JsonBackReference
    private Detective detective;

    @Enumerated(EnumType.STRING)
    private TrackAction action;

    private String reason;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || Hibernate.getClass(this) != Hibernate.getClass(o)) return false;
        TrackEntry that = (TrackEntry) o;
        return getId() != null && Objects.equals(getId(), that.getId());
    }

    @Override
    public int hashCode() {
        return getClass().hashCode();
    }
}