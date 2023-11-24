package rutrob.jobboardapi.service;

import rutrob.jobboardapi.rest.dto.CompanyDto;
import rutrob.jobboardapi.rest.dto.CreateCompanyRequest;

public interface CompanyService {

    CompanyDto saveCompany(CreateCompanyRequest companyRequest, Long userId);
}
