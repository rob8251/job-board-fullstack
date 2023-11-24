package rutrob.jobboardapi.mappers;

import org.mapstruct.Mapper;
import rutrob.jobboardapi.entity.Company;
import rutrob.jobboardapi.rest.dto.CompanyDto;
import rutrob.jobboardapi.rest.dto.CreateCompanyRequest;

@Mapper
public interface CompanyMapper {

    Company toCompany(CreateCompanyRequest companyRequest);

    CompanyDto toCompanyDto(Company company);
}
