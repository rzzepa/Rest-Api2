package spring.dao;

import spring.entity.Authority;

import java.util.List;

public interface AuthorityDAO {

    public List<Authority> getAuthority();

    public void saveAuthority(Authority theAuthority);

    public Authority getAuthority(int theId);

    public void deleteAuthority(int theId);

}
