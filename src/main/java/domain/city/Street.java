package domain.city;

import java.util.List;

import org.apache.commons.lang3.builder.EqualsBuilder;
import org.apache.commons.lang3.builder.HashCodeBuilder;
import org.apache.commons.lang3.builder.ToStringBuilder;

public class Street {
  private String name;
  private List<House> houses;

  public Street() {
  }

  public Street(String name, List<House> houses) {
    this.name = name;
    this.houses = houses;
  }

  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  public List<House> getHouses() {
    return houses;
  }

  public void setHouses(List<House> houses) {
    this.houses = houses;
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) return true;
    if (o == null || getClass() != o.getClass()) return false;
    Street street = (Street) o;
    return new EqualsBuilder()
        .append(name, street.name)
        .append(houses, street.houses)
        .isEquals();
  }

  @Override
  public int hashCode() {
    return new HashCodeBuilder(17, 37)
        .append(name)
        .append(houses)
        .toHashCode();
  }

  @Override
  public String toString() {
    return new ToStringBuilder(this)
        .append("name", name)
        .append("houses", houses)
        .toString();
  }
}
