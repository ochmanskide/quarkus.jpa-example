package de.ochmanski.generated.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import io.swagger.annotations.ApiModelProperty;

import java.util.Objects;

@javax.annotation.Generated(value = "org.openapitools.codegen.languages.JavaResteasyServerCodegen", date = "2022-07-01T15:48:33.129484100+02:00[Europe/Berlin]")
public class OssProfile {

  private String id;
  private Integer schedule;
  private OssProfileType type;
  private OssProfileToggleFunction toggleFunction;
  private OssProfileUnlockTime unlockTime;

  /**
   *
   **/

  @ApiModelProperty(value = "")
  @JsonProperty("id")
  public String getId() {
    return id;
  }

  public void setId(String id) {
    this.id = id;
  }

  /**
   *
   **/

  @ApiModelProperty(value = "")
  @JsonProperty("schedule")
  public Integer getSchedule() {
    return schedule;
  }

  public void setSchedule(Integer schedule) {
    this.schedule = schedule;
  }

  /**
   *
   **/

  @ApiModelProperty(value = "")
  @JsonProperty("type")
  public OssProfileType getType() {
    return type;
  }

  public void setType(OssProfileType type) {
    this.type = type;
  }

  /**
   *
   **/

  @ApiModelProperty(value = "")
  @JsonProperty("toggleFunction")
  public OssProfileToggleFunction getToggleFunction() {
    return toggleFunction;
  }

  public void setToggleFunction(OssProfileToggleFunction toggleFunction) {
    this.toggleFunction = toggleFunction;
  }

  /**
   *
   **/

  @ApiModelProperty(value = "")
  @JsonProperty("unlockTime")
  public OssProfileUnlockTime getUnlockTime() {
    return unlockTime;
  }

  public void setUnlockTime(OssProfileUnlockTime unlockTime) {
    this.unlockTime = unlockTime;
  }


  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    OssProfile ossProfile = (OssProfile) o;
    return Objects.equals(id, ossProfile.id) &&
            Objects.equals(schedule, ossProfile.schedule) &&
            Objects.equals(type, ossProfile.type) &&
            Objects.equals(toggleFunction, ossProfile.toggleFunction) &&
            Objects.equals(unlockTime, ossProfile.unlockTime);
  }

  @Override
  public int hashCode() {
    return Objects.hash(id, schedule, type, toggleFunction, unlockTime);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class OssProfile {\n");

    sb.append("    id: ").append(toIndentedString(id)).append("\n");
    sb.append("    schedule: ").append(toIndentedString(schedule)).append("\n");
    sb.append("    type: ").append(toIndentedString(type)).append("\n");
    sb.append("    toggleFunction: ").append(toIndentedString(toggleFunction)).append("\n");
    sb.append("    unlockTime: ").append(toIndentedString(unlockTime)).append("\n");
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

