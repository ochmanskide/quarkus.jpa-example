package de.ochmanski.generated.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import io.swagger.annotations.ApiModelProperty;

import javax.validation.constraints.NotNull;
import java.util.Objects;

@javax.annotation.Generated(value = "org.openapitools.codegen.languages.JavaResteasyServerCodegen", date = "2022-07-01T15:48:33.129484100+02:00[Europe/Berlin]")
public class OssGetReaderMessagesSyncRequest {

  private OssGetReaderMessagesRequest getReaderMessagesRequest;

  /**
   *
   **/

  @ApiModelProperty(required = true, value = "")
  @JsonProperty("getReaderMessagesRequest")
  @NotNull
  public OssGetReaderMessagesRequest getGetReaderMessagesRequest() {
    return getReaderMessagesRequest;
  }

  public void setGetReaderMessagesRequest(OssGetReaderMessagesRequest getReaderMessagesRequest) {
    this.getReaderMessagesRequest = getReaderMessagesRequest;
  }


  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    OssGetReaderMessagesSyncRequest ossGetReaderMessagesSyncRequest = (OssGetReaderMessagesSyncRequest) o;
    return Objects.equals(getReaderMessagesRequest, ossGetReaderMessagesSyncRequest.getReaderMessagesRequest);
  }

  @Override
  public int hashCode() {
    return Objects.hash(getReaderMessagesRequest);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class OssGetReaderMessagesSyncRequest {\n");

    sb.append("    getReaderMessagesRequest: ").append(toIndentedString(getReaderMessagesRequest)).append("\n");
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

