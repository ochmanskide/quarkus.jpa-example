package de.ochmanski.generated.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import io.swagger.annotations.ApiModelProperty;

import java.util.Objects;

@javax.annotation.Generated(value = "org.openapitools.codegen.languages.JavaResteasyServerCodegen", date = "2022-07-01T15:48:33.129484100+02:00[Europe/Berlin]")
public class OssSyncInfoMessage {

  private String description;
  private String version;
  private String api;

  /**
   *
   **/

  @ApiModelProperty(value = "")
  @JsonProperty("description")
  public String getDescription() {
    return description;
  }

  public void setDescription(String description) {
    this.description = description;
  }

  /**
   *
   **/

  @ApiModelProperty(value = "")
  @JsonProperty("version")
  public String getVersion() {
    return version;
  }

  public void setVersion(String version) {
    this.version = version;
  }

  /**
   *
   **/

  @ApiModelProperty(value = "")
  @JsonProperty("api")
  public String getApi() {
    return api;
  }

  public void setApi(String api) {
    this.api = api;
  }


  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    OssSyncInfoMessage ossSyncInfoMessage = (OssSyncInfoMessage) o;
    return Objects.equals(description, ossSyncInfoMessage.description) &&
            Objects.equals(version, ossSyncInfoMessage.version) &&
            Objects.equals(api, ossSyncInfoMessage.api);
  }

  @Override
  public int hashCode() {
    return Objects.hash(description, version, api);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class OssSyncInfoMessage {\n");

    sb.append("    description: ").append(toIndentedString(description)).append("\n");
    sb.append("    version: ").append(toIndentedString(version)).append("\n");
    sb.append("    api: ").append(toIndentedString(api)).append("\n");
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

