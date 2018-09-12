package entities;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * Created by User on 9/12/2018.
 */
@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
@Entity
@Table(name="users")
public class Users
{
    @Id
    private int userId;
    private String username;
    private String password;
    private String userRole;

    protected Users(){}

    public Users(int id, String username, String password, String userRole)
    {
        this.userId = id;
        this.username = username;
        this.password = password;
        this.userRole = userRole;
    }

}
