/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.ufpr.tads.tcc.spge.model;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

/**
 *
 * @author Tom
 */
public interface Authenticable {
    
    public String getEmail();

    public void setEmail(String email);

    public String getSenha();

    public void setSenha(String senha);

    public class Util {

        public static String generateHash(String senha) {
            StringBuilder hash = new StringBuilder();

            try {
                MessageDigest crypt = MessageDigest.getInstance("MD5");
                byte[] hashedBytes = crypt.digest(senha.getBytes());
                char[] digits = {'0', '1', '2', '3', '4', '5', '6', '7', '8', '9', 'a', 'b', 'c', 'd', 'e', 'f'};
                for (int idx = 0; idx < hashedBytes.length; ++idx) {
                    byte b = hashedBytes[idx];
                    hash.append(digits[(b & 0xf0) >> 4]);
                    hash.append(digits[b & 0x0f]);
                }
            } catch (NoSuchAlgorithmException e) {
                // Silence is golden
            }

            return hash.toString();
        }
    }
}
