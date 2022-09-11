package de.ochmanski.generated.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import io.swagger.annotations.ApiModelProperty;

import java.util.Objects;

@javax.annotation.Generated(value = "org.openapitools.codegen.languages.JavaResteasyServerCodegen", date = "2022-07-01T15:48:33.129484100+02:00[Europe/Berlin]")
public class OssUpdateCredentialSyncResponseAllOf {

  private Object updateCredentialResponse;

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
    OssUpdateCredentialSyncResponseAllOf ossUpdateCredentialSyncResponseAllOf = (OssUpdateCredentialSyncResponseAllOf) o;
    return Objects.equals(updateCredentialResponse, ossUpdateCredentialSyncResponseAllOf.updateCredentialResponse);
  }

  @Override
  public int hashCode() {
    return Objects.hash(updateCredentialResponse);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class OssUpdateCredentialSyncResponseAllOf {\n");

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

