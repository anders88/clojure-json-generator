package no.steria.json.util;

import static org.fest.assertions.Assertions.assertThat;

import org.junit.Test;

public class TestJSONGenerator {
	@Test
	public void shouldGenerateSimpleJson() throws Exception {
		String generatedJson = JSONGenerator.generate("['firstName 'Darth 'lastName 'Vader]");
		assertThat(generatedJson).isEqualTo("{\"firstName\" : \"Darth\", \"lastName\" : \"Vader\"}");
	}
}
