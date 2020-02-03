package domain.book;

import java.util.List;

import org.apache.commons.lang3.builder.EqualsBuilder;
import org.apache.commons.lang3.builder.HashCodeBuilder;
import org.apache.commons.lang3.builder.ToStringBuilder;

public class Section {
  private int pageNumber;
  private List<String> sectionName;

  public Section(int pageNumber, List<String> sectionName) {
    this.pageNumber = pageNumber;
    this.sectionName = sectionName;
  }

  public int getPageNumber() {
    return pageNumber;
  }

  public void setPageNumber(int pageNumber) {
    this.pageNumber = pageNumber;
  }

  public List<String> getSectionName() {
    return sectionName;
  }

  public void setSectionName(List<String> sectionName) {
    this.sectionName = sectionName;
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) return true;
    if (o == null || getClass() != o.getClass()) return false;
    Section section = (Section) o;
    return new EqualsBuilder()
        .append(pageNumber, section.pageNumber)
        .append(sectionName, section.sectionName)
        .isEquals();
  }

  @Override
  public int hashCode() {
    return new HashCodeBuilder(17, 37)
        .append(pageNumber)
        .append(sectionName)
        .toHashCode();
  }

  @Override
  public String toString() {
    return new ToStringBuilder(this)
        .append("pageNumber", pageNumber)
        .append("sectionName", sectionName)
        .toString();
  }
}
