package net.blueid.microservices.oss.mcip.util;

import de.ochmanski.microservices.quarkus.jpa.example.util.Constants;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.assertj.core.api.Assertions.assertThat;

@ExtendWith(MockitoExtension.class)
class ConstantsTest {

    @Test
    void testAFewConstants() {
        assertThat(Constants.APPLICATION_PROPERTIES).isEqualTo("application.properties");
        assertThat(Constants.APPLICATION_YML).isEqualTo("application.yml");
        assertThat(Constants.REST.class).isFinal();
        assertThat(Constants.REST.DATE_FORMAT).isEqualTo("yyyy-MM-dd");
        assertThat(Constants.REST.TIME_FORMAT).isEqualTo("HH:mm:ss");
        assertThat(Constants.REST.YEAR).isEqualTo("" + Constants.YEAR);
        assertThat(Constants.RFC3986.class).isFinal();
    }
}
