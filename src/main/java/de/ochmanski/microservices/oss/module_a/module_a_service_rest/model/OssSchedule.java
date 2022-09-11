package de.ochmanski.microservices.oss.module_a.module_a_service_rest.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import io.swagger.annotations.ApiModelProperty;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

@javax.annotation.Generated(value = "org.openapitools.codegen.languages.JavaResteasyServerCodegen", date = "2022-07-01T15:48:33.129484100+02:00[Europe/Berlin]")
public class OssSchedule {

  private List<OssScheduleWeek> weeks = new ArrayList<>();

  /**
   *
   **/

  @ApiModelProperty(value = "")
  @JsonProperty("weeks")
  public List<OssScheduleWeek> getWeeks() {
    return weeks;
  }

  public void setWeeks(List<OssScheduleWeek> weeks) {
    this.weeks = weeks;
  }


  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    OssSchedule ossSchedule = (OssSchedule) o;
    return Objects.equals(weeks, ossSchedule.weeks);
  }

  @Override
  public int hashCode() {
    return Objects.hash(weeks);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class OssSchedule {\n");

    sb.append("    weeks: ").append(toIndentedString(weeks)).append("\n");
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

