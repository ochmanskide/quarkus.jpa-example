package de.ochmanski.microservices.oss.module_a.module_a_service_rest.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import io.swagger.annotations.ApiModelProperty;

import java.util.Objects;

@javax.annotation.Generated(value = "org.openapitools.codegen.languages.JavaResteasyServerCodegen", date = "2022-07-01T15:48:33.129484100+02:00[Europe/Berlin]")
public class OssMapIdentityRequest {

  private String identity;
  private String token;
  private String credentialId;

  /**
   *
   **/

  @ApiModelProperty(value = "")
  @JsonProperty("identity")
  public String getIdentity() {
    return identity;
  }

  public void setIdentity(String identity) {
    this.identity = identity;
  }

  /**
   *
   **/

  @ApiModelProperty(value = "")
  @JsonProperty("token")
  public String getToken() {
    return token;
  }

  public void setToken(String token) {
    this.token = token;
  }

  /**
   *
   **/

  @ApiModelProperty(value = "")
  @JsonProperty("credentialId")
  public String getCredentialId() {
    return credentialId;
  }

  public void setCredentialId(String credentialId) {
    this.credentialId = credentialId;
  }


  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    OssMapIdentityRequest ossMapIdentityRequest = (OssMapIdentityRequest) o;
    return Objects.equals(identity, ossMapIdentityRequest.identity) &&
            Objects.equals(token, ossMapIdentityRequest.token) &&
            Objects.equals(credentialId, ossMapIdentityRequest.credentialId);
  }

  @Override
  public int hashCode() {
    return Objects.hash(identity, token, credentialId);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class OssMapIdentityRequest {\n");

    sb.append("    identity: ").append(toIndentedString(identity)).append("\n");
    sb.append("    token: ").append(toIndentedString(token)).append("\n");
    sb.append("    credentialId: ").append(toIndentedString(credentialId)).append("\n");
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

