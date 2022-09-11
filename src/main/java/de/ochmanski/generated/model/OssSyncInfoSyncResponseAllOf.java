package de.ochmanski.generated.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import io.swagger.annotations.ApiModelProperty;

import java.util.Objects;

@javax.annotation.Generated(value = "org.openapitools.codegen.languages.JavaResteasyServerCodegen", date = "2022-07-01T15:48:33.129484100+02:00[Europe/Berlin]")
public class OssSyncInfoSyncResponseAllOf {

  private OssSyncInfoMessage syncInfoResponse;

  /**
   *
   **/

  @ApiModelProperty(value = "")
  @JsonProperty("syncInfoResponse")
  public OssSyncInfoMessage getSyncInfoResponse() {
    return syncInfoResponse;
  }

  public void setSyncInfoResponse(OssSyncInfoMessage syncInfoResponse) {
    this.syncInfoResponse = syncInfoResponse;
  }


  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    OssSyncInfoSyncResponseAllOf ossSyncInfoSyncResponseAllOf = (OssSyncInfoSyncResponseAllOf) o;
    return Objects.equals(syncInfoResponse, ossSyncInfoSyncResponseAllOf.syncInfoResponse);
  }

  @Override
  public int hashCode() {
    return Objects.hash(syncInfoResponse);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class OssSyncInfoSyncResponseAllOf {\n");

    sb.append("    syncInfoResponse: ").append(toIndentedString(syncInfoResponse)).append("\n");
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

