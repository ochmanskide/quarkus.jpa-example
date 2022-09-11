package de.ochmanski.generated.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import io.swagger.annotations.ApiModelProperty;

import javax.validation.constraints.NotNull;
import java.util.Objects;

@javax.annotation.Generated(value = "org.openapitools.codegen.languages.JavaResteasyServerCodegen", date = "2022-07-01T15:48:33.129484100+02:00[Europe/Berlin]")
public class OssUpdateCredentialSyncResponse {

  private OssSyncResponseStatus status;
  private Object updateCredentialResponse;

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
  @JsonProperty("updateCredentialResponse")
  public Object getUpdateCredentialResponse() {
    return updateCredentialResponse;
  }

  public void setUpdateCredentialResponse(Object updateCredentialResponse) {
    this.updateCredentialResponse = updateCredentialResponse;
  }


  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    OssUpdateCredentialSyncResponse ossUpdateCredentialSyncResponse = (OssUpdateCredentialSyncResponse) o;
    return Objects.equals(status, ossUpdateCredentialSyncResponse.status) &&
            Objects.equals(updateCredentialResponse, ossUpdateCredentialSyncResponse.updateCredentialResponse);
  }

  @Override
  public int hashCode() {
    return Objects.hash(status, updateCredentialResponse);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class OssUpdateCredentialSyncResponse {\n");

    sb.append("    status: ").append(toIndentedString(status)).append("\n");
    sb.append("    updateCredentialResponse: ").append(toIndentedString(updateCredentialResponse)).append("\n");
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

