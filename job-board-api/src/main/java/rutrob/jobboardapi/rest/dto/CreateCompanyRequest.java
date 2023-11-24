package rutrob.jobboardapi.rest.dto;

import jakarta.validation.constraints.NotBlank;
import lombok.Data;

@Data
public class CreateCompanyRequest {

    @NotBlank
    private String companyName;

    private String description;

    private String address;

    private String imageUrl;
}
