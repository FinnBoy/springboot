package net.awaken.springboot.domain.secondary;

import javax.persistence.*;

/**
 * @author Finn Zhao
 * @version 2019-11-15
 */
@Entity(name = "role")
@Table(name = "role", catalog = "dbwrite")
public class RoleReadonly {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private String name;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "RoleReadonly{" +
                "id=" + id +
                ", name='" + name + '\'' +
                '}';
    }
}
