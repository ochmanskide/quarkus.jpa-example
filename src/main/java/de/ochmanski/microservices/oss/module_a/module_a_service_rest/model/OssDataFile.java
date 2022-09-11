package de.ochmanski.microservices.oss.module_a.module_a_service_rest.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import io.swagger.annotations.ApiModelProperty;

import java.time.ZonedDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

@javax.annotation.Generated(value = "org.openapitools.codegen.languages.JavaResteasyServerCodegen", date = "2022-07-01T15:48:33.129484100+02:00[Europe/Berlin]")
public class OssDataFile {

  private String id;
  private ZonedDateTime validity;
  private Integer siteId;
  private OssDataFileHeader header;
  private List<OssProfile> profiles = new ArrayList<>();
  private List<OssSchedule> schedules = new ArrayList<>();

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
  @JsonProperty("validity")
  public ZonedDateTime getValidity() {
    return validity;
  }

  public void setValidity(ZonedDateTime validity) {
    this.validity = validity;
  }

  /**
   *
   **/

  @ApiModelProperty(value = "")
  @JsonProperty("siteId")
  public Integer getSiteId() {
    return siteId;
  }

  public void setSiteId(Integer siteId) {
    this.siteId = siteId;
  }

  /**
   *
   **/

  @ApiModelProperty(value = "")
  @JsonProperty("header")
  public OssDataFileHeader getHeader() {
    return header;
  }

  public void setHeader(OssDataFileHeader header) {
    this.header = header;
  }

  /**
   *
   **/

  @ApiModelProperty(value = "")
  @JsonProperty("profiles")
  public List<OssProfile> getProfiles() {
    return profiles;
  }

  public void setProfiles(List<OssProfile> profiles) {
    this.profiles = profiles;
  }

  /**
   *
   **/

  @ApiModelProperty(value = "")
  @JsonProperty("schedules")
  public List<OssSchedule> getSchedules() {
    return schedules;
  }

  public void setSchedules(List<OssSchedule> schedules) {
    this.schedules = schedules;
  }


  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    OssDataFile ossDataFile = (OssDataFile) o;
    return Objects.equals(id, ossDataFile.id) &&
            Objects.equals(validity, ossDataFile.validity) &&
            Objects.equals(siteId, ossDataFile.siteId) &&
            Objects.equals(header, ossDataFile.header) &&
            Objects.equals(profiles, ossDataFile.profiles) &&
            Objects.equals(schedules, ossDataFile.schedules);
  }

  @Override
  public int hashCode() {
    return Objects.hash(id, validity, siteId, header, profiles, schedules);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class OssDataFile {\n");

    sb.append("    id: ").append(toIndentedString(id)).append("\n");
    sb.append("    validity: ").append(toIndentedString(validity)).append("\n");
    sb.append("    siteId: ").append(toIndentedString(siteId)).append("\n");
    sb.append("    header: ").append(toIndentedString(header)).append("\n");
    sb.append("    profiles: ").append(toIndentedString(profiles)).append("\n");
    sb.append("    schedules: ").append(toIndentedString(schedules)).append("\n");
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

