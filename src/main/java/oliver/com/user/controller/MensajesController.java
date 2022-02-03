package oliver.com.user.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class MensajesController {
	
	private final Logger logger = LoggerFactory.getLogger(getClass());
	
	public static final String RESPONSE_STRING_FORMAT = "mensaje v2 from '%s': %d\n";
	
	private int count = 0;
	
	public static final String HOSTNAME = parseContainerIdFromHostname(
            System.getenv().getOrDefault("HOSTNAME", "unknown"));
	
	static String parseContainerIdFromHostname(String hostname) {
        return hostname.replaceAll("api-usuario-v\\d+-", "");
    }
	
	@GetMapping("/mensajes")
	public ResponseEntity<String> getMensajes() {
		
		logger.info("ingresando al servicio ..");

		count++;

		return ResponseEntity.ok(String.format(MensajesController.RESPONSE_STRING_FORMAT, HOSTNAME, count));
	}
}
