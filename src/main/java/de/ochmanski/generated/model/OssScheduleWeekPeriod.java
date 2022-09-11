package de.ochmanski.generated.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import io.swagger.annotations.ApiModelProperty;

import java.util.Objects;

@javax.annotation.Generated(value = "org.openapitools.codegen.languages.JavaResteasyServerCodegen", date = "2022-07-01T15:48:33.129484100+02:00[Europe/Berlin]")
public class OssScheduleWeekPeriod {

  private String validFrom;
  private String validTo;

  /**
   *
   **/

  @ApiModelProperty(value = "")
  @JsonProperty("validFrom")
  public String getValidFrom() {
    return validFrom;
  }

  public void setValidFrom(String validFrom) {
    this.validFrom = validFrom;
  }

  /**
   *
   **/

  @ApiModelProperty(value = "")
  @JsonProperty("validTo")
  public String getValidTo() {
    return validTo;
  }

  public void setValidTo(String validTo) {
    this.validTo = validTo;
  }


  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    OssScheduleWeekPeriod ossScheduleWeekPeriod = (OssScheduleWeekPeriod) o;
    return Objects.equals(validFrom, ossScheduleWeekPeriod.validFrom) &&
            Objects.equals(validTo, ossScheduleWeekPeriod.validTo);
  }

  @Override
  public int hashCode() {
    return Objects.hash(validFrom, validTo);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class OssScheduleWeekPeriod {\n");

    sb.append("    validFrom: ").append(toIndentedString(validFrom)).append("\n");
    sb.append("    validTo: ").append(toIndentedString(validTo)).append("\n");
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

