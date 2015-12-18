
package com.apcon.model;
 
public class Authenticator {
 
	public String authenticate(String username, String password) {
		if (("chetan".equalsIgnoreCase(username))
				&& ("password".equals(password))) {
			return "success";
		} else {
			return "failure";
		}
	}
}