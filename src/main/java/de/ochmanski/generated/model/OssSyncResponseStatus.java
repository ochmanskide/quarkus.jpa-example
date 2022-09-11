package de.ochmanski.generated.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import io.swagger.annotations.ApiModelProperty;

import javax.validation.constraints.NotNull;
import java.util.Objects;

@javax.annotation.Generated(value = "org.openapitools.codegen.languages.JavaResteasyServerCodegen", date = "2022-07-01T15:48:33.129484100+02:00[Europe/Berlin]")
public class OssSyncResponseStatus {

  private Integer code;
  private String description;

  /**
   * Return code of any request. Codes are 5-digit, and the first digit indicates status category; 2&#x3D;ok, 4&#x3D;warning (data problem), 6&#x3D;error (processing problems), 8&#x3D;fatal (unexpected error)
   **/

  @ApiModelProperty(example = "23000", required = true, value = "Return code of any request. Codes are 5-digit, and the first digit indicates status category; 2=ok, 4=warning (data problem), 6=error (processing problems), 8=fatal (unexpected error)")
  @JsonProperty("code")
  @NotNull
  public Integer getCode() {
    return code;
  }

  public void setCode(Integer code) {
    this.code = code;
  }

  /**
   * Description of the status in English. May contain parseable content.
   **/

  @ApiModelProperty(example = "OK", required = true, value = "Description of the status in English. May contain parseable content.")
  @JsonProperty("description")
  @NotNull
  public String getDescription() {
    return description;
  }

  public void setDescription(String description) {
    this.description = description;
  }


  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    OssSyncResponseStatus ossSyncResponseStatus = (OssSyncResponseStatus) o;
    return Objects.equals(code, ossSyncResponseStatus.code) &&
            Objects.equals(description, ossSyncResponseStatus.description);
  }

  @Override
  public int hashCode() {
    return Objects.hash(code, description);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class OssSyncResponseStatus {\n");

    sb.append("    code: ").append(toIndentedString(code)).append("\n");
    sb.append("    description: ").append(toIndentedString(description)).append("\n");
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

