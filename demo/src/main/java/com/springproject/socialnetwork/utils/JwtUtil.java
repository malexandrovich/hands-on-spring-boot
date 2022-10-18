package com.springproject.socialnetwork.utils;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import java.util.function.Function;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Service;

/**
 * Util that implements methods for iteration with Jwt.
 */
@Service
public class JwtUtil {

  private String SECRET_KEY = "secretkey";

  /**
   * Extract username from token.
   *
   * @param token - token.
   * @return username.
   */
  public String extractUsername(String token) {
    return extractClaim(token, Claims::getSubject);
  }

  /**
   * Extract expiration date from token.
   *
   * @param token - token.
   * @return Date of expiration.
   */
  public Date extractExpiration(String token) {
    return extractClaim(token, Claims::getExpiration);
  }

  /**
   * Extract claims from token.
   *
   * @param token - token.
   * @param claimsResolver - claimsResolver.
   * @return List of claims.
   */
  public <T> T extractClaim(String token, Function<Claims, T> claimsResolver) {
    final Claims claims = extractAllClaims(token);
    return claimsResolver.apply(claims);
  }

  /**
   * Extract all claims from token.
   *
   * @param token - token.
   * @return Claims.
   */
  private Claims extractAllClaims(String token) {
    return Jwts.parser().setSigningKey(SECRET_KEY).parseClaimsJws(token).getBody();
  }

  /**
   * Check if the token is valid.
   *
   * @param token - token.
   * @return - boolean.
   */
  private Boolean isTokenExpired(String token) {
    return extractExpiration(token).before(new Date());
  }

  /**
   * Generate jwt token.
   *
   * @param userDetails - user details.
   * @return String - token.
   */
  public String generateToken(UserDetails userDetails) {
    Map<String, Object> claims = new HashMap<>();
    return createToken(claims, userDetails.getUsername());
  }

  /**
   * Create jwt token.
   *
   * @param claims - claims.
   * @param subject - subject.
   * @return String - token.
   */
  private String createToken(Map<String, Object> claims, String subject) {

    return Jwts.builder().setClaims(claims).setSubject(subject).setIssuedAt(new Date(System.currentTimeMillis()))
      .setExpiration(new Date(System.currentTimeMillis() + 1000 * 60 * 60 * 24))
      .signWith(SignatureAlgorithm.HS256, SECRET_KEY).compact();
  }

  /**
   * Validate token.
   *
   * @param token- token.
   * @param userDetails - userDetails.
   * @return boolean.
   */
  public Boolean validateToken(String token, UserDetails userDetails) {
    final String username = extractUsername(token);
    return (username.equals(userDetails.getUsername()) && !isTokenExpired(token));
  }

}
