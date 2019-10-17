package com.mycafe.mycafe_api.model.loginmodel;

//import com.mycafe.mycafe_api.model.audit.DateAudit;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.mycafe.mycafe_api.model.canteenmodel.Employee;
import com.mycafe.mycafe_api.model.canteenmodel.Food;
import com.mycafe.mycafe_api.model.canteenmodel.Orders;
import com.mycafe.mycafe_api.model.canteenmodel.Summary;
import org.hibernate.annotations.NaturalId;

import javax.persistence.*;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Entity
@Table(name = "users", uniqueConstraints = {
        @UniqueConstraint(columnNames = {
                "username"
        }),
        @UniqueConstraint(columnNames = {
                "email"
        })
})
public class User /*extends DateAudit*/ {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    @Column(name = "user_id")
    private int id;

    @Column(name = "name")
    private String name;

    @Column(name = "nic")
    private String nic;

    @Column(name = "canteen")
    private String canteen;

    @Column(name = "tid")
    private String tid;

    @NaturalId
    @NotBlank
    @Size(max = 40)
    @Email
    @Column(name = "email")
    private String email;

    @NotBlank
    @Size(max = 10)
    @Column(name = "phone")
    private String phone;



    @NotBlank
    @Size(max = 15)
    @Column(name = "username")
    private String username;

    @NotBlank
    @Size(max = 100)
    @Column(name = "password")
    private String password;

    @ManyToMany(fetch = FetchType.LAZY)
    @JoinTable(name = "user_roles",
            joinColumns = @JoinColumn(name = "user_id"),
            inverseJoinColumns = @JoinColumn(name = "role_id"))
    private Set<Role> roles = new HashSet<>();

    @JsonIgnore
    @OneToMany(fetch = FetchType.LAZY, mappedBy = "user")
    private List<Food> foodList;

    @JsonIgnore
    @OneToMany(fetch = FetchType.LAZY, mappedBy = "user")
    private List<Employee> employeeList;

    @JsonIgnore
    @OneToMany(fetch = FetchType.LAZY, mappedBy = "user")
    private List<Summary> summaryList;

    @JsonIgnore
    @OneToMany(fetch = FetchType.LAZY, mappedBy = "user")
    private List<Orders> ordersList;

    public User() {
    }

    public User(String name, String nic, String canteen, String tid,String email,String phone,String username,String password) {
        this.name = name;
        this.nic = nic;
        this.canteen = canteen;
        this.tid = tid;
        this.email = email;
        this.phone = phone;
        this.username = username;
        this.password = password;
    }

    public User(String username,String email,String phone,String password) {
        this.email = email;
        this.phone = phone;
        this.username = username;
        this.password = password;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getNic() {
        return nic;
    }

    public void setNic(String nic) {
        this.nic = nic;
    }

    public String getCanteen() {
        return canteen;
    }

    public void setCanteen(String canteen) {
        this.canteen = canteen;
    }

    public String getTid() {
        return tid;
    }

    public void setTid(String tid) {
        this.tid = tid;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }


    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }


    public Set<Role> getRoles() {
        return roles;
    }

    public void setRoles(Set<Role> roles) {
        this.roles = roles;
    }

}
