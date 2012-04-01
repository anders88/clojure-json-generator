package no.steria.json.util;

import java.io.IOException;

import clojure.lang.RT;
import clojure.lang.Var;

public class JSONGenerator {
	public static String generate(String jsconCode) {
		try {
			RT.loadResourceScript("jsonGenerator.clj");
		} catch (IOException e) {
			throw new RuntimeException(e);
		}
		Var generator = RT.var("jsonGenerator", "to-json");
		
		String result = (String) generator.invoke(jsconCode);

		return result;

	}
}
