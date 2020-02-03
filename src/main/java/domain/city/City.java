package domain.city;

import java.util.List;

import org.apache.commons.lang3.builder.EqualsBuilder;
import org.apache.commons.lang3.builder.HashCodeBuilder;
import org.apache.commons.lang3.builder.ToStringBuilder;

public class City {
  private String name;
  private List<Street> streets;

  public City(String name, List<Street> streets) {
    this.name = name;
    this.streets = streets;
  }

  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  public List<Street> getStreets() {
    return streets;
  }

  public void setStreets(List<Street> streets) {
    this.streets = streets;
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) return true;
    if (o == null || getClass() != o.getClass()) return false;
    City city = (City) o;
    return new EqualsBuilder()
        .append(name, city.name)
        .append(streets, city.streets)
        .isEquals();
  }

  @Override
  public int hashCode() {
    return new HashCodeBuilder(17, 37)
        .append(name)
        .append(streets)
        .toHashCode();
  }

  @Override
  public String toString() {
    return new ToStringBuilder(this)
        .append("name", name)
        .append("streets", streets)
        .toString();
  }
}
