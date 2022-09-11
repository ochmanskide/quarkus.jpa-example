package de.ochmanski.microservices.oss.module_a.module_a_service_rest.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import io.swagger.annotations.ApiModelProperty;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

@javax.annotation.Generated(value = "org.openapitools.codegen.languages.JavaResteasyServerCodegen", date = "2022-07-01T15:48:33.129484100+02:00[Europe/Berlin]")
public class OssScheduleWeek {

  private Integer weekBits;
  private List<OssScheduleWeekPeriod> periods = new ArrayList<>();

  /**
   * Bitwise representation of week. Indicies: Monday &#x3D; 0, Tuesday &#x3D; 1, ..., Sunday&#x3D;6
   **/

  @ApiModelProperty(value = "Bitwise representation of week. Indicies: Monday = 0, Tuesday = 1, ..., Sunday=6 ")
  @JsonProperty("weekBits")
  public Integer getWeekBits() {
    return weekBits;
  }

  public void setWeekBits(Integer weekBits) {
    this.weekBits = weekBits;
  }

  /**
   *
   **/

  @ApiModelProperty(value = "")
  @JsonProperty("periods")
  public List<OssScheduleWeekPeriod> getPeriods() {
    return periods;
  }

  public void setPeriods(List<OssScheduleWeekPeriod> periods) {
    this.periods = periods;
  }


  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    OssScheduleWeek ossScheduleWeek = (OssScheduleWeek) o;
    return Objects.equals(weekBits, ossScheduleWeek.weekBits) &&
            Objects.equals(periods, ossScheduleWeek.periods);
  }

  @Override
  public int hashCode() {
    return Objects.hash(weekBits, periods);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class OssScheduleWeek {\n");

    sb.append("    weekBits: ").append(toIndentedString(weekBits)).append("\n");
    sb.append("    periods: ").append(toIndentedString(periods)).append("\n");
    sb.append("}");
    return sb.toString();
  }

  /**
   * Convert the given object to string with each line indented by 4 spaces
   * (except the first line).
   */
  private String toIndentedString(Object o) {
    if (o == null) {
      return "null";
    }
    return o.toString().replace("\n", "\n    ");
  }
}

