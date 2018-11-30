import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;
import java.time.Instant;

/**
 * @author Satalia Team.
 */
public class Serializavimas {

  public static void main(String[] args) throws JsonProcessingException {
    ObjectMapper mapper = new ObjectMapper()
        .findAndRegisterModules()
        .configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false)
        .disable(SerializationFeature.WRITE_DATES_AS_TIMESTAMPS)
//      .disable(SerializationFeature.WRITE_DATE_KEYS_AS_TIMESTAMPS)
        ;
    Instant instant = Instant.now();
    String slot = mapper.writeValueAsString(instant);
    System.out.println(slot);

  }

}
