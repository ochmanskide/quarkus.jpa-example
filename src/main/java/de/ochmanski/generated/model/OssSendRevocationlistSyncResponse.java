package de.ochmanski.generated.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import io.swagger.annotations.ApiModelProperty;

import javax.validation.constraints.NotNull;
import java.util.Objects;

@javax.annotation.Generated(value = "org.openapitools.codegen.languages.JavaResteasyServerCodegen", date = "2022-07-01T15:48:33.129484100+02:00[Europe/Berlin]")
public class OssSendRevocationlistSyncResponse {

  private OssSyncResponseStatus status;
  private Object sendRevocationlistResponse;

  /**
   *
   **/

  @ApiModelProperty(required = true, value = "")
  @JsonProperty("status")
  @NotNull
  public OssSyncResponseStatus getStatus() {
    return status;
  }

  public void setStatus(OssSyncResponseStatus status) {
    this.status = status;
  }

  /**
   *
   **/

  @ApiModelProperty(value = "")
  @JsonProperty("sendRevocationlistResponse")
  public Object getSendRevocationlistResponse() {
    return sendRevocationlistResponse;
  }

  public void setSendRevocationlistResponse(Object sendRevocationlistResponse) {
    this.sendRevocationlistResponse = sendRevocationlistResponse;
  }


  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    OssSendRevocationlistSyncResponse ossSendRevocationlistSyncResponse = (OssSendRevocationlistSyncResponse) o;
    return Objects.equals(status, ossSendRevocationlistSyncResponse.status) &&
            Objects.equals(sendRevocationlistResponse, ossSendRevocationlistSyncResponse.sendRevocationlistResponse);
  }

  @Override
  public int hashCode() {
    return Objects.hash(status, sendRevocationlistResponse);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class OssSendRevocationlistSyncResponse {\n");

    sb.append("    status: ").append(toIndentedString(status)).append("\n");
    sb.append("    sendRevocationlistResponse: ").append(toIndentedString(sendRevocationlistResponse)).append("\n");
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

