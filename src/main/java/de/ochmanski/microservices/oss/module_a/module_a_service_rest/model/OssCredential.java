package de.ochmanski.microservices.oss.module_a.module_a_service_rest.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import io.swagger.annotations.ApiModelProperty;

import java.util.Objects;

@javax.annotation.Generated(value = "org.openapitools.codegen.languages.JavaResteasyServerCodegen", date = "2022-07-01T15:48:33.129484100+02:00[Europe/Berlin]")
public class OssCredential {

  private OssDataFile data;
  private OssExtensionFile extension;

  /**
   *
   **/

  @ApiModelProperty(value = "")
  @JsonProperty("data")
  public OssDataFile getData() {
    return data;
  }

  public void setData(OssDataFile data) {
    this.data = data;
  }

  /**
   *
   **/

  @ApiModelProperty(value = "")
  @JsonProperty("extension")
  public OssExtensionFile getExtension() {
    return extension;
  }

  public void setExtension(OssExtensionFile extension) {
    this.extension = extension;
  }


  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    OssCredential ossCredential = (OssCredential) o;
    return Objects.equals(data, ossCredential.data) &&
            Objects.equals(extension, ossCredential.extension);
  }

  @Override
  public int hashCode() {
    return Objects.hash(data, extension);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class OssCredential {\n");

    sb.append("    data: ").append(toIndentedString(data)).append("\n");
    sb.append("    extension: ").append(toIndentedString(extension)).append("\n");
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

