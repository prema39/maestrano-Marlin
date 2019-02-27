package io.maestrano.marlin.test;

import io.maestrano.marlin.utils.Constants;

public class rough {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		String name = "qwertyu";
		
	}
	public static String getProperty(String property, String... macros) {

		// TODO: Change code below to ensure that 'missing from properties' is
		// clearly differentiated from 'not found on page'.

		// swap out any macros
		if (macros != null && macros.length >= 0) {
			for (int i = 0; i < macros.length; i++) {
				property = property.replaceFirst("\\$\\{[A-Za-z][A-Za-z]*\\}",
						macros[i]);

			}
			property = property.replaceAll("'(?<=\\p{L})'", "\\\\\"");
			property = property.replaceAll("(\\[@\\w+=)'(.*?)']", "$1\"$2\"]");
		}
		return property;
	}

}
