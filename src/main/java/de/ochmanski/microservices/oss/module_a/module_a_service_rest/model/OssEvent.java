package de.ochmanski.microservices.oss.module_a.module_a_service_rest.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import io.swagger.annotations.ApiModelProperty;

import java.time.ZonedDateTime;
import java.util.Objects;

@javax.annotation.Generated(value = "org.openapitools.codegen.languages.JavaResteasyServerCodegen", date = "2022-07-01T15:48:33.129484100+02:00[Europe/Berlin]")
public class OssEvent {

  private Long id;
  private byte[] credentialId;
  private ZonedDateTime timestamp;
  private Integer doorId;
  private Integer siteId;
  private Integer eventId;
  private Integer eventInfo;

  /**
   *
   **/

  @ApiModelProperty(value = "")
  @JsonProperty("id")
  public Long getId() {
    return id;
  }

  public void setId(Long id) {
    this.id = id;
  }

  /**
   *
   **/

  @ApiModelProperty(value = "")
  @JsonProperty("credentialId")
  public byte[] getCredentialId() {
    return credentialId;
  }

  public void setCredentialId(byte[] credentialId) {
    this.credentialId = credentialId;
  }

  /**
   *
   **/

  @ApiModelProperty(value = "")
  @JsonProperty("timestamp")
  public ZonedDateTime getTimestamp() {
    return timestamp;
  }

  public void setTimestamp(ZonedDateTime timestamp) {
    this.timestamp = timestamp;
  }

  /**
   *
   **/

  @ApiModelProperty(value = "")
  @JsonProperty("doorId")
  public Integer getDoorId() {
    return doorId;
  }

  public void setDoorId(Integer doorId) {
    this.doorId = doorId;
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
  @JsonProperty("eventId")
  public Integer getEventId() {
    return eventId;
  }

  public void setEventId(Integer eventId) {
    this.eventId = eventId;
  }

  /**
   *
   **/

  @ApiModelProperty(value = "")
  @JsonProperty("eventInfo")
  public Integer getEventInfo() {
    return eventInfo;
  }

  public void setEventInfo(Integer eventInfo) {
    this.eventInfo = eventInfo;
  }


  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    OssEvent ossEvent = (OssEvent) o;
    return Objects.equals(id, ossEvent.id) &&
            Objects.equals(credentialId, ossEvent.credentialId) &&
            Objects.equals(timestamp, ossEvent.timestamp) &&
            Objects.equals(doorId, ossEvent.doorId) &&
            Objects.equals(siteId, ossEvent.siteId) &&
            Objects.equals(eventId, ossEvent.eventId) &&
            Objects.equals(eventInfo, ossEvent.eventInfo);
  }

  @Override
  public int hashCode() {
    return Objects.hash(id, credentialId, timestamp, doorId, siteId, eventId, eventInfo);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class OssEvent {\n");

    sb.append("    id: ").append(toIndentedString(id)).append("\n");
    sb.append("    credentialId: ").append(toIndentedString(credentialId)).append("\n");
    sb.append("    timestamp: ").append(toIndentedString(timestamp)).append("\n");
    sb.append("    doorId: ").append(toIndentedString(doorId)).append("\n");
    sb.append("    siteId: ").append(toIndentedString(siteId)).append("\n");
    sb.append("    eventId: ").append(toIndentedString(eventId)).append("\n");
    sb.append("    eventInfo: ").append(toIndentedString(eventInfo)).append("\n");
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

