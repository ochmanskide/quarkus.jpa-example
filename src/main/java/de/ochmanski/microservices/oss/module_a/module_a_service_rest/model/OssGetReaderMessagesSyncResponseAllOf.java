package de.ochmanski.microservices.oss.module_a.module_a_service_rest.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import io.swagger.annotations.ApiModelProperty;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

@javax.annotation.Generated(value = "org.openapitools.codegen.languages.JavaResteasyServerCodegen", date = "2022-07-01T15:48:33.129484100+02:00[Europe/Berlin]")
public class OssGetReaderMessagesSyncResponseAllOf {

  private List<OssEvent> getReaderMessagesResponse = new ArrayList<>();

  /**
   *
   **/

  @ApiModelProperty(value = "")
  @JsonProperty("getReaderMessagesResponse")
  public List<OssEvent> getGetReaderMessagesResponse() {
    return getReaderMessagesResponse;
  }

  public void setGetReaderMessagesResponse(List<OssEvent> getReaderMessagesResponse) {
    this.getReaderMessagesResponse = getReaderMessagesResponse;
  }


  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    OssGetReaderMessagesSyncResponseAllOf ossGetReaderMessagesSyncResponseAllOf = (OssGetReaderMessagesSyncResponseAllOf) o;
    return Objects.equals(getReaderMessagesResponse, ossGetReaderMessagesSyncResponseAllOf.getReaderMessagesResponse);
  }

  @Override
  public int hashCode() {
    return Objects.hash(getReaderMessagesResponse);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class OssGetReaderMessagesSyncResponseAllOf {\n");

    sb.append("    getReaderMessagesResponse: ").append(toIndentedString(getReaderMessagesResponse)).append("\n");
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

