package de.ochmanski.microservices.oss.module_a.module_a_service_rest.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import io.swagger.annotations.ApiModelProperty;

import java.util.Objects;

@javax.annotation.Generated(value = "org.openapitools.codegen.languages.JavaResteasyServerCodegen", date = "2022-07-01T15:48:33.129484100+02:00[Europe/Berlin]")
public class OssDataFileHeader {

  private Integer doorInfoEntries;
  private Integer dateTimeSchedules;
  private Integer dayIdsPerSchedule;
  private Integer timePeriodsPerDayId;
  private Integer extensionInfo;

  /**
   *
   **/

  @ApiModelProperty(value = "")
  @JsonProperty("doorInfoEntries")
  public Integer getDoorInfoEntries() {
    return doorInfoEntries;
  }

  public void setDoorInfoEntries(Integer doorInfoEntries) {
    this.doorInfoEntries = doorInfoEntries;
  }

  /**
   *
   **/

  @ApiModelProperty(value = "")
  @JsonProperty("dateTimeSchedules")
  public Integer getDateTimeSchedules() {
    return dateTimeSchedules;
  }

  public void setDateTimeSchedules(Integer dateTimeSchedules) {
    this.dateTimeSchedules = dateTimeSchedules;
  }

  /**
   *
   **/

  @ApiModelProperty(value = "")
  @JsonProperty("dayIdsPerSchedule")
  public Integer getDayIdsPerSchedule() {
    return dayIdsPerSchedule;
  }

  public void setDayIdsPerSchedule(Integer dayIdsPerSchedule) {
    this.dayIdsPerSchedule = dayIdsPerSchedule;
  }

  /**
   *
   **/

  @ApiModelProperty(value = "")
  @JsonProperty("timePeriodsPerDayId")
  public Integer getTimePeriodsPerDayId() {
    return timePeriodsPerDayId;
  }

  public void setTimePeriodsPerDayId(Integer timePeriodsPerDayId) {
    this.timePeriodsPerDayId = timePeriodsPerDayId;
  }

  /**
   *
   **/

  @ApiModelProperty(value = "")
  @JsonProperty("extensionInfo")
  public Integer getExtensionInfo() {
    return extensionInfo;
  }

  public void setExtensionInfo(Integer extensionInfo) {
    this.extensionInfo = extensionInfo;
  }


  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    OssDataFileHeader ossDataFileHeader = (OssDataFileHeader) o;
    return Objects.equals(doorInfoEntries, ossDataFileHeader.doorInfoEntries) &&
            Objects.equals(dateTimeSchedules, ossDataFileHeader.dateTimeSchedules) &&
            Objects.equals(dayIdsPerSchedule, ossDataFileHeader.dayIdsPerSchedule) &&
            Objects.equals(timePeriodsPerDayId, ossDataFileHeader.timePeriodsPerDayId) &&
            Objects.equals(extensionInfo, ossDataFileHeader.extensionInfo);
  }

  @Override
  public int hashCode() {
    return Objects.hash(doorInfoEntries, dateTimeSchedules, dayIdsPerSchedule, timePeriodsPerDayId, extensionInfo);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class OssDataFileHeader {\n");

    sb.append("    doorInfoEntries: ").append(toIndentedString(doorInfoEntries)).append("\n");
    sb.append("    dateTimeSchedules: ").append(toIndentedString(dateTimeSchedules)).append("\n");
    sb.append("    dayIdsPerSchedule: ").append(toIndentedString(dayIdsPerSchedule)).append("\n");
    sb.append("    timePeriodsPerDayId: ").append(toIndentedString(timePeriodsPerDayId)).append("\n");
    sb.append("    extensionInfo: ").append(toIndentedString(extensionInfo)).append("\n");
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

