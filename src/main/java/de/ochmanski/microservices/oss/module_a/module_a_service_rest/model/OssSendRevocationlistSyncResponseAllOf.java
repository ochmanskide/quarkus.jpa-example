package de.ochmanski.microservices.oss.module_a.module_a_service_rest.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import io.swagger.annotations.ApiModelProperty;

import java.util.Objects;

@javax.annotation.Generated(value = "org.openapitools.codegen.languages.JavaResteasyServerCodegen", date = "2022-07-01T15:48:33.129484100+02:00[Europe/Berlin]")
public class OssSendRevocationlistSyncResponseAllOf {

  private Object sendRevocationlistResponse;

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
    OssSendRevocationlistSyncResponseAllOf ossSendRevocationlistSyncResponseAllOf = (OssSendRevocationlistSyncResponseAllOf) o;
    return Objects.equals(sendRevocationlistResponse, ossSendRevocationlistSyncResponseAllOf.sendRevocationlistResponse);
  }

  @Override
  public int hashCode() {
    return Objects.hash(sendRevocationlistResponse);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class OssSendRevocationlistSyncResponseAllOf {\n");

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

