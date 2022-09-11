package de.ochmanski.microservices.oss.module_a.module_a_service_rest.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import io.swagger.annotations.ApiModelProperty;

import java.time.ZonedDateTime;
import java.util.Objects;

@javax.annotation.Generated(value = "org.openapitools.codegen.languages.JavaResteasyServerCodegen", date = "2022-07-01T15:48:33.129484100+02:00[Europe/Berlin]")
public class OssRevocationEntry {

  private String credentialId;
  private ZonedDateTime expirationDate;

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

  /**
   *
   **/

  @ApiModelProperty(value = "")
  @JsonProperty("expirationDate")
  public ZonedDateTime getExpirationDate() {
    return expirationDate;
  }

  public void setExpirationDate(ZonedDateTime expirationDate) {
    this.expirationDate = expirationDate;
  }


  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    OssRevocationEntry ossRevocationEntry = (OssRevocationEntry) o;
    return Objects.equals(credentialId, ossRevocationEntry.credentialId) &&
            Objects.equals(expirationDate, ossRevocationEntry.expirationDate);
  }

  @Override
  public int hashCode() {
    return Objects.hash(credentialId, expirationDate);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class OssRevocationEntry {\n");

    sb.append("    credentialId: ").append(toIndentedString(credentialId)).append("\n");
    sb.append("    expirationDate: ").append(toIndentedString(expirationDate)).append("\n");
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

