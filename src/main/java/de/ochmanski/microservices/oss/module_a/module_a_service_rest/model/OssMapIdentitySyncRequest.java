package de.ochmanski.microservices.oss.module_a.module_a_service_rest.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import io.swagger.annotations.ApiModelProperty;

import javax.validation.constraints.NotNull;
import java.util.Objects;

@javax.annotation.Generated(value = "org.openapitools.codegen.languages.JavaResteasyServerCodegen", date = "2022-07-01T15:48:33.129484100+02:00[Europe/Berlin]")
public class OssMapIdentitySyncRequest {

  private OssMapIdentityRequest syncInfoRequest;

  /**
   *
   **/

  @ApiModelProperty(required = true, value = "")
  @JsonProperty("syncInfoRequest")
  @NotNull
  public OssMapIdentityRequest getSyncInfoRequest() {
    return syncInfoRequest;
  }

  public void setSyncInfoRequest(OssMapIdentityRequest syncInfoRequest) {
    this.syncInfoRequest = syncInfoRequest;
  }


  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    OssMapIdentitySyncRequest ossMapIdentitySyncRequest = (OssMapIdentitySyncRequest) o;
    return Objects.equals(syncInfoRequest, ossMapIdentitySyncRequest.syncInfoRequest);
  }

  @Override
  public int hashCode() {
    return Objects.hash(syncInfoRequest);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class OssMapIdentitySyncRequest {\n");

    sb.append("    syncInfoRequest: ").append(toIndentedString(syncInfoRequest)).append("\n");
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

