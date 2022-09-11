package de.ochmanski.microservices.quarkus.jpa.example.repository;

import de.ochmanski.annotations.ExcludeFromJacocoGeneratedReport;
import io.quarkus.runtime.annotations.RegisterForReflection;
import lombok.*;
import lombok.experimental.FieldDefaults;
import lombok.experimental.FieldNameConstants;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import java.util.Objects;
import java.util.UUID;

@RegisterForReflection(targets = {OssMapIdentity.class, OssMapIdentity.OssMapIdentityBuilder.class, OssMapIdentity.Fields.class})
@ExcludeFromJacocoGeneratedReport
@Getter
@Setter
@ToString
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Entity
@FieldNameConstants
@FieldDefaults(level = AccessLevel.PRIVATE)
@Table(
        name = OssMapIdentity.Table.OSS_MAP_IDENTITY,
        schema = OssMapIdentity.Schema.OSS_MCIP,
        indexes = {
                @Index(name = OssMapIdentity.Indexes.IDX_IDENTITY, columnList = OssMapIdentity.Columns.IDENTITY),
                @Index(name = OssMapIdentity.Indexes.IDX_TOKEN, columnList = OssMapIdentity.Columns.TOKEN),
                @Index(name = OssMapIdentity.Indexes.IDX_CREDENTIAL_ID, columnList = OssMapIdentity.Columns.CREDENTIAL_ID)
        },
        uniqueConstraints = {
                @UniqueConstraint(columnNames = {OssMapIdentity.Columns.IDENTITY})
        }
)
public class OssMapIdentity {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO, generator = ColumnDefinitions.GENERATOR)
    @GenericGenerator(name = ColumnDefinitions.GENERATOR, strategy = ColumnDefinitions.GENERIC_GENERATOR_STRATEGY)
    @Column(name = Columns.ID, nullable = false, updatable = false, columnDefinition = ColumnDefinitions.BINARY_16)
    UUID id;

    @Column(name = Columns.IDENTITY, columnDefinition = ColumnDefinitions.VARCHAR_255, unique = true)
    String identity;

    @Column(name = Columns.TOKEN, columnDefinition = ColumnDefinitions.VARCHAR_255)
    String token;

    @Column(name = Columns.CREDENTIAL_ID, columnDefinition = ColumnDefinitions.VARCHAR_255)
    String credentialId;

    // <editor-fold defaultstate="collapsed" desc="override equals and hashCode">
    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        return o instanceof OssMapIdentity && Objects.equals(getId(), ((OssMapIdentity) o).getId());
    }

    @Override
    public int hashCode() {
        return id == null ? super.hashCode() : id.hashCode();
    }
    // </editor-fold>

    // <editor-fold defaultstate="collapsed" desc="database schema">
    @RegisterForReflection
    public static final class Schema {
        public static final String OSS_MCIP = "OSS_MCIP_V1";
    }
    // </editor-fold>

    // <editor-fold defaultstate="collapsed" desc="table name">
    @RegisterForReflection
    public static final class Table {
        public static final String OSS_MAP_IDENTITY = "OSS_MAP_IDENTITY_V1";
    }
    // </editor-fold>

    // <editor-fold defaultstate="collapsed" desc="column names">
    @RegisterForReflection
    public static final class Columns {
        public static final String ID = "ID";
        public static final String IDENTITY = "IDENTITY";
        public static final String TOKEN = "TOKEN";
        public static final String CREDENTIAL_ID = "CREDENTIAL_ID";

    }
    // </editor-fold>

    // <editor-fold defaultstate="collapsed" desc="column definitions">
    @RegisterForReflection
    public static final class ColumnDefinitions {
        public static final String GENERATOR = "uuid2";
        public static final String GENERIC_GENERATOR_STRATEGY = "uuid2";
        public static final String BINARY_16 = "BINARY(16)";
        public static final String VARCHAR_255 = "VARCHAR(255)";
    }
    // </editor-fold>

    // <editor-fold defaultstate="collapsed" desc="indexes">
    @RegisterForReflection
    public static final class Indexes {
        public static final String IDX_ID = "IDX_ID";
        public static final String IDX_IDENTITY = "IDX_IDENTITY";
        public static final String IDX_TOKEN = "IDX_TOKEN";
        public static final String IDX_CREDENTIAL_ID = "IDX_CREDENTIAL_ID";
    }
    // </editor-fold>
}
