package rutrob.jobboardapi.service.impl;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import rutrob.jobboardapi.entity.Company;
import rutrob.jobboardapi.mappers.CompanyMapper;
import rutrob.jobboardapi.repository.CompanyRepository;
import rutrob.jobboardapi.rest.dto.CompanyDto;
import rutrob.jobboardapi.rest.dto.CreateCompanyRequest;
import rutrob.jobboardapi.service.CompanyService;

@Service
@RequiredArgsConstructor
public class CompanyServiceImpl implements CompanyService {

    private final CompanyRepository companyRepository;
    private final CompanyMapper mapper;

    @Override
    public CompanyDto saveCompany(CreateCompanyRequest companyRequest, Long userId) {
        Company company = mapper.toCompany(companyRequest);
        company.setAdminId(userId);
        return mapper.toCompanyDto(companyRepository.save(company));
    }
}
