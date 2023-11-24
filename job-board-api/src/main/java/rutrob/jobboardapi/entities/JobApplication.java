package rutrob.jobboardapi.entities;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.proxy.HibernateProxy;

import java.time.LocalDateTime;
import java.util.Objects;

@Getter
@Setter
@NoArgsConstructor
@Entity
@Table(name = "job_applications")
public class JobApplication {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotNull
    private String firstName;

    @NotNull
    private String lastName;

    @NotNull
    private String email;

    @NotNull
    private String cvUrl;

    private String details;

    @Column(nullable = false)
    @CreationTimestamp
    private LocalDateTime createdAt;

    @JoinColumn(name = "offer_id", insertable = false, updatable = false)
    @ManyToOne(targetEntity = Offer.class, fetch = FetchType.EAGER)
    private Offer offer;

    @Column(name = "offer_id")
    private Long offerId;

    @JoinColumn(name = "applicant_id", insertable = false, updatable = false)
    @ManyToOne(targetEntity = User.class, fetch = FetchType.EAGER)
    private User applicant;

    @Column(name = "applicant_id")
    private Long applicantId;

    @Override
    public final boolean equals(Object o) {
        if (this == o) return true;
        if (o == null) return false;
        Class<?> oEffectiveClass = o instanceof HibernateProxy ? ((HibernateProxy) o).getHibernateLazyInitializer().getPersistentClass() : o.getClass();
        Class<?> thisEffectiveClass = this instanceof HibernateProxy ? ((HibernateProxy) this).getHibernateLazyInitializer().getPersistentClass() : this.getClass();
        if (thisEffectiveClass != oEffectiveClass) return false;
        JobApplication that = (JobApplication) o;
        return getId() != null && Objects.equals(getId(), that.getId());
    }

    @Override
    public final int hashCode() {
        return this instanceof HibernateProxy ? ((HibernateProxy) this).getHibernateLazyInitializer().getPersistentClass().hashCode() : getClass().hashCode();
    }
}
