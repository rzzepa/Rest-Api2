package spring.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import spring.dao.AuthorityDAO;
import spring.entity.Authority;

import java.util.List;

@Service
public class AuthorityServiceImpl implements AuthorityService {

    @Autowired
    private AuthorityDAO authoritydao;

    @Override
    @Transactional
    public List<Authority> getAuthorities() {
        return authoritydao.getAuthority();
    }

    @Override
    @Transactional
    public void saveAuthority(Authority theAuthority) {
        authoritydao.saveAuthority(theAuthority);
    }

    @Override
    @Transactional
    public Authority getAuthority(int theId) {
        return authoritydao.getAuthority(theId);
    }

    @Override
    @Transactional
    public void deleteAuthority(int theId) {
        authoritydao.deleteAuthority(theId);
    }
}
