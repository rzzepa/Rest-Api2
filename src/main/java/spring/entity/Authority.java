package spring.entity;

import javax.persistence.*;


@Entity
@Table(name="authorities")
public class Authority {


    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    @Column(name="id")
    private int id;

    private String username;

    @Column(name="authority")
    private String authority;

    public Authority() {};

    public Authority(String authority,String username) { this.authority=authority; this.username=username;};


    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getAuthority() {
        return authority;
    }

    public void setAuthority(String authority) {
        this.authority = authority;
    }
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }
}
