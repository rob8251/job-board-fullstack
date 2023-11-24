package rutrob.jobboardapi.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import rutrob.jobboardapi.entity.Company;

@Repository
public interface CompanyRepository extends JpaRepository<Company, Long> {
}
