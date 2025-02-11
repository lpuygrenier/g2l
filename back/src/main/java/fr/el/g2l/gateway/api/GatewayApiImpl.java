package fr.el.g2l.gateway.api;

import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;

import fr.el.g2l.common.dto.AuthLoginPostRequest;
import fr.el.g2l.common.dto.AuthenticationResponse;
import fr.el.g2l.gateway.internal.service.JwtService;
import jakarta.validation.Valid;
import lombok.AllArgsConstructor;

@Controller
@AllArgsConstructor
public class GatewayApiImpl implements AuthApi {

    private final JwtService jwtService;
	private final AuthenticationManager authenticationManager;

	@Override
	public ResponseEntity<AuthenticationResponse> authLoginPost(@Valid AuthLoginPostRequest authLoginPostRequest) {
        Authentication authentication = authenticationManager.authenticate(
			new UsernamePasswordAuthenticationToken(authLoginPostRequest.getUsername(), authLoginPostRequest.getPassword()));
        SecurityContextHolder.getContext().setAuthentication(authentication);
        String jwt = jwtService.generateToken(authLoginPostRequest.getUsername());

        AuthenticationResponse response = new AuthenticationResponse();
        response.accessToken(jwt);

        return ResponseEntity.ok(response);
	}
}
