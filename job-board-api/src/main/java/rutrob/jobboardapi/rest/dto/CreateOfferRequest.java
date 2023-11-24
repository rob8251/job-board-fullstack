package rutrob.jobboardapi.rest.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.Data;

@Data
public class CreateOfferRequest {

    @NotBlank
    private String position;

    @NotBlank
    private String location;

    @NotBlank
    private String description;

    @NotNull
    private Long salary;

    @NotNull
    private Long companyId;

    @NotNull
    private Long branchId;
}
