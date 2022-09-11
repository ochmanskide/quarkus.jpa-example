package de.ochmanski.generated.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import io.swagger.annotations.ApiModelProperty;

import javax.validation.constraints.NotNull;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

@javax.annotation.Generated(value = "org.openapitools.codegen.languages.JavaResteasyServerCodegen", date = "2022-07-01T15:48:33.129484100+02:00[Europe/Berlin]")
public class OssSendRevocationlistSyncRequest {

  private List<OssRevocationEntry> sendRevocationlistRequest = new ArrayList<>();

  /**
   *
   **/

  @ApiModelProperty(required = true, value = "")
  @JsonProperty("sendRevocationlistRequest")
  @NotNull
  public List<OssRevocationEntry> getSendRevocationlistRequest() {
    return sendRevocationlistRequest;
  }

  public void setSendRevocationlistRequest(List<OssRevocationEntry> sendRevocationlistRequest) {
    this.sendRevocationlistRequest = sendRevocationlistRequest;
  }


  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    OssSendRevocationlistSyncRequest ossSendRevocationlistSyncRequest = (OssSendRevocationlistSyncRequest) o;
    return Objects.equals(sendRevocationlistRequest, ossSendRevocationlistSyncRequest.sendRevocationlistRequest);
  }

  @Override
  public int hashCode() {
    return Objects.hash(sendRevocationlistRequest);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class OssSendRevocationlistSyncRequest {\n");

    sb.append("    sendRevocationlistRequest: ").append(toIndentedString(sendRevocationlistRequest)).append("\n");
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

