
package com.aimprosoft.entity;



import com.aimprosoft.util.UniqueCheck;
import net.sf.oval.constraint.*;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;


import javax.persistence.*;
import java.util.Date;



/**
 * Created by user on 04.07.16.
 */

@Entity
@Table(name = "Employee")
public class Employee {

    public Employee() {
    }

    private Integer id;

    @NotEmpty(message = "First name not be empty")
    @Length(max = 16, message = "First name too long, max characters is 16")
    private String firstName;
    @NotEmpty(message = "Last name name not be empty")
    @Length(max = 16, message = "Last name too long, max characters is 16")
    private String lastName;

    @CheckWith(value = UniqueCheck.class, message = "Email must be unique!!")
    @Email(message = "incorrect email", errorCode = "errEmail")
    private String email;

    @DateRange(format = "yyyy-mm-dd", max = "today", min = "1800-01-01",  message = "incorrect date format")
    @NotNull(message = "incorrect date format")
    private Date birthday;

    @NotNull(message = "Salary must be a number", errorCode = "errSalary")
    @NotNegative(message = "Salary must be positive number")
    private Integer salary;

    private Department department;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_employee")
    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    @Column(name = "first_name")
    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    @Column(name = "email")
    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    @Column(name = "last_name")
    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    @Column(name = "birthday")
    @Temporal(TemporalType.DATE)
    public Date getBirthday() {
        return birthday;
    }

    public void setBirthday(Date birhday) {
        this.birthday = birhday;
    }

    @Column(name = "salary")
    public Integer getSalary() {
        return salary;
    }

    public void setSalary(Integer salary) {
        this.salary = salary;
    }

    @ManyToOne()
    public Department getDepartment() {
        return department;
    }

    public void setDepartment(Department department) {
        this.department = department;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Employee employee = (Employee) o;
        return id != null ? id.equals(employee.id) : employee.id == null;
    }

    @Override
    public int hashCode() {
        return id != null ? id.hashCode() : 0;
    }
}
