package rutrob.jobboardapi.rest;

import lombok.RequiredArgsConstructor;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestPart;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;
import rutrob.jobboardapi.rest.dto.CreateApplicationRequest;
import rutrob.jobboardapi.security.SecurityUser;

@RequiredArgsConstructor
@RestController
@RequestMapping("/api/applications")
public class JobApplicationController {

    @PostMapping
    public void createApplication(@RequestPart("application") CreateApplicationRequest applicationRequest,
                                  @RequestPart("cv") MultipartFile cv,
                                  Authentication authentication) {

        Long userId = ((SecurityUser) authentication.getPrincipal()).getId();

    }
}
