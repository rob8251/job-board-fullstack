package rutrob.jobboardapi.rest.dto;

import rutrob.jobboardapi.entity.Branch;

import java.time.LocalDateTime;

public record OfferDto(String position, String location, String description, Long salary,
                       LocalDateTime createdAt, CompanyDto company, Branch branch) {
}
