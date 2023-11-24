package rutrob.jobboardapi.entities;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;
import org.hibernate.proxy.HibernateProxy;

import java.time.LocalDateTime;
import java.util.Objects;
import java.util.Set;

@Getter
@Setter
@NoArgsConstructor
@Entity
@Table(name = "offers")
public class Offer {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotNull
    private String position;

    @NotNull
    private String location;

    @NotNull
    private String description;

    @NotNull
    private Long salary;

    @Column(nullable = false)
    @CreationTimestamp
    private LocalDateTime createdAt;

    @Column(nullable = false)
    @UpdateTimestamp
    private LocalDateTime lastModified;

    @JoinColumn(name = "company_id", insertable = false, updatable = false)
    @ManyToOne(targetEntity = Company.class, fetch = FetchType.EAGER)
    private Company company;

    @NotNull
    @Column(name = "company_id")
    private Long companyId;

    @JoinColumn(name = "branch_id", insertable = false, updatable = false)
    @ManyToOne(targetEntity = Branch.class, fetch = FetchType.EAGER)
    private Branch branch;

    @NotNull
    @Column(name = "branch_id")
    private Long branchId;

    @OneToMany(mappedBy = "offer")
    private Set<JobApplication> applications;

    @Override
    public final boolean equals(Object o) {
        if (this == o) return true;
        if (o == null) return false;
        Class<?> oEffectiveClass = o instanceof HibernateProxy ? ((HibernateProxy) o).getHibernateLazyInitializer().getPersistentClass() : o.getClass();
        Class<?> thisEffectiveClass = this instanceof HibernateProxy ? ((HibernateProxy) this).getHibernateLazyInitializer().getPersistentClass() : this.getClass();
        if (thisEffectiveClass != oEffectiveClass) return false;
        Offer offer = (Offer) o;
        return getId() != null && Objects.equals(getId(), offer.getId());
    }

    @Override
    public final int hashCode() {
        return this instanceof HibernateProxy ? ((HibernateProxy) this).getHibernateLazyInitializer().getPersistentClass().hashCode() : getClass().hashCode();
    }
}
