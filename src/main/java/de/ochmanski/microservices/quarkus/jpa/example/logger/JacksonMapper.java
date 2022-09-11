package de.ochmanski.microservices.quarkus.jpa.example.logger;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;
import net.blueid.microservices.oss.module_a.module_a_service_rest.model.*;
import org.eclipse.microprofile.config.inject.ConfigProperty;

import javax.enterprise.context.ApplicationScoped;

@ApplicationScoped
public class JacksonMapper {

    @ConfigProperty(name = "net.blueid.microservices.oss.mcip.jackson.prettyPrint", defaultValue = "true")
    boolean prettyPrint;

    public String toJson(Object o) {
        return toJsonUnfiltered(o)
                .replace("class " + OssCredential.class.getSimpleName() + " ", "")
                .replace("class " + OssDataFile.class.getSimpleName() + " ", "")
                .replace("class " + OssDataFileHeader.class.getSimpleName() + " ", "")
                .replace("class " + OssEvent.class.getSimpleName() + " ", "")
                .replace("class " + OssExtensionFile.class.getSimpleName() + " ", "")
                .replace("class " + OssGetReaderMessagesRequest.class.getSimpleName() + " ", "")
                .replace("class " + OssGetReaderMessagesSyncRequest.class.getSimpleName() + " ", "")
                .replace("class " + OssGetReaderMessagesSyncResponse.class.getSimpleName() + " ", "")
                .replace("class " + OssGetReaderMessagesSyncResponseAllOf.class.getSimpleName() + " ", "")
                .replace("class " + OssMapIdentityRequest.class.getSimpleName() + " ", "")
                .replace("class " + OssMapIdentitySyncRequest.class.getSimpleName() + " ", "")
                .replace("class " + OssMapIdentitySyncResponse.class.getSimpleName() + " ", "")
                .replace("class " + OssMapIdentitySyncResponseAllOf.class.getSimpleName() + " ", "")
                .replace("class " + OssProfile.class.getSimpleName() + " ", "")
                .replace("class " + OssProfileToggleFunction.class.getSimpleName() + " ", "")
                .replace("class " + OssProfileType.class.getSimpleName() + " ", "")
                .replace("class " + OssProfileUnlockTime.class.getSimpleName() + " ", "")
                .replace("class " + OssRevocationEntry.class.getSimpleName() + " ", "")
                .replace("class " + OssSchedule.class.getSimpleName() + " ", "")
                .replace("class " + OssScheduleWeek.class.getSimpleName() + " ", "")
                .replace("class " + OssScheduleWeekPeriod.class.getSimpleName() + " ", "")
                .replace("class " + OssSendRevocationlistSyncRequest.class.getSimpleName() + " ", "")
                .replace("class " + OssSendRevocationlistSyncResponse.class.getSimpleName() + " ", "")
                .replace("class " + OssSendRevocationlistSyncResponseAllOf.class.getSimpleName() + " ", "")
                .replace("class " + OssSyncInfoMessage.class.getSimpleName() + " ", "")
                .replace("class " + OssSyncInfoSyncRequest.class.getSimpleName() + " ", "")
                .replace("class " + OssSyncInfoSyncResponse.class.getSimpleName() + " ", "")
                .replace("class " + OssSyncInfoSyncResponseAllOf.class.getSimpleName() + " ", "")
                .replace("class " + OssSyncResponse.class.getSimpleName() + " ", "")
                .replace("class " + OssSyncResponseStatus.class.getSimpleName() + " ", "")
                .replace("class " + OssTlvEntry.class.getSimpleName() + " ", "")
                .replace("class " + OssUpdateCredentialSyncRequest.class.getSimpleName() + " ", "")
                .replace("class " + OssUpdateCredentialSyncResponse.class.getSimpleName() + " ", "")
                .replace("class " + OssUpdateCredentialSyncResponseAllOf.class.getSimpleName() + " ", "");
    }

    private String toJsonUnfiltered(Object o) {
        try {
            ObjectMapper objectMapper = new ObjectMapper();
            objectMapper.configure(SerializationFeature.INDENT_OUTPUT, prettyPrint);
            return objectMapper.writeValueAsString(o);
        } catch (JsonProcessingException e) {
            try {
                return null == o ? "null" : o.toString();
            } catch (Throwable t) {
                return "toString() methods has thrown exception with message: " + t.getMessage();
            }
        }
    }

}
