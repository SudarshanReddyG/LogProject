package com.sudarshan.test;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.context.SecurityContextHolder;

public class AuthenticationExample {

	private static AuthenticationManager am = new SampleAuthenticationManager();

	public static void main(String[] args) throws Exception {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));

		while(true) {
			System.out.println("Please enter the user name:");
			String name = in.readLine();

			System.out.println("Please enter the password:");
			String password = in.readLine();

			try {
				Authentication request = new UsernamePasswordAuthenticationToken(name, password);
				Authentication response =am.authenticate(request);
				SecurityContextHolder.getContext().setAuthentication(response);
				break;
			} catch(AuthenticationException aExp) {
				System.out.println("Authetication failed "+aExp.getMessage());
			}
		}
	}

}


class SampleAuthenticationManager implements AuthenticationManager {
	static final List<GrantedAuthority> AUTHORITIES = new ArrayList<GrantedAuthority>();

	static {
		AUTHORITIES.add(new SimpleGrantedAuthority("ROLE_USER"));
	}

	@Override
	public Authentication authenticate(Authentication ath) throws AuthenticationException {
		if (ath.getName().equals(ath.getCredentials())) {
			return new UsernamePasswordAuthenticationToken(ath.getName(), ath.getCredentials(), AUTHORITIES);
		}
		throw new BadCredentialsException("Bad Credentials");
	}

}
