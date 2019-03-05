package spring.service;

import spring.entity.Authority;

import java.util.List;

public interface AuthorityService {

    public List<Authority> getAuthorities();

    public void saveAuthority(Authority theAuthority);

    public Authority getAuthority(int theId);

    public void deleteAuthority(int theId);
}
