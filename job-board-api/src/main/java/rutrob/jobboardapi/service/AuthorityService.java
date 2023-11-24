package rutrob.jobboardapi.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import rutrob.jobboardapi.entity.Authority;
import rutrob.jobboardapi.repository.AuthorityRepository;

@Service
@RequiredArgsConstructor
public class AuthorityService {

    private final AuthorityRepository authorityRepository;

    public Authority getAuthorityByName(String name) {
        return authorityRepository.findByName(name)
                .orElseThrow(() -> new RuntimeException("Role " + name + " does not exist"));
    }
}
