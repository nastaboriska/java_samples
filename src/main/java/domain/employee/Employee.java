package domain.employee;

import org.apache.commons.lang3.builder.EqualsBuilder;
import org.apache.commons.lang3.builder.HashCodeBuilder;
import org.apache.commons.lang3.builder.ToStringBuilder;

public class Employee {
  private int age;
  private String firstName;
  private String lastName;

  public Employee(int age, String firstName, String lastName) {
    this.age = age;
    this.firstName = firstName;
    this.lastName = lastName;
  }

  public int getAge() {
    return age;
  }

  public void setAge(int age) {
    this.age = age;
  }

  public String getFirstName() {
    return firstName;
  }

  public void setFirstName(String firstName) {
    this.firstName = firstName;
  }

  public String getLastName() {
    return lastName;
  }

  public void setLastName(String lastName) {
    this.lastName = lastName;
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) return true;
    if (o == null || getClass() != o.getClass()) return false;
    Employee employee = (Employee) o;
    return new EqualsBuilder()
        .append(age, employee.age)
        .append(firstName, employee.firstName)
        .append(lastName, employee.lastName)
        .isEquals();
  }

  @Override
  public int hashCode() {
    return new HashCodeBuilder(17, 37)
        .append(age)
        .append(firstName)
        .append(lastName)
        .toHashCode();
  }

  @Override
  public String toString() {
    return new ToStringBuilder(this)
        .append("age", age)
        .append("firstName", firstName)
        .append("lastName", lastName)
        .toString();
  }
}
