package rutrob.jobboardapi.rest;

import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import rutrob.jobboardapi.rest.dto.CompanyDto;
import rutrob.jobboardapi.rest.dto.CreateCompanyRequest;
import rutrob.jobboardapi.security.SecurityUser;
import rutrob.jobboardapi.service.CompanyService;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/companies")
public class CompanyController {

    private final CompanyService companyService;

    @PostMapping
    public CompanyDto createCompany(@Valid @RequestBody CreateCompanyRequest companyRequest, Authentication authentication) {
        Long userId = ((SecurityUser) authentication.getPrincipal()).getId();
        return companyService.saveCompany(companyRequest, userId);
    }


}
