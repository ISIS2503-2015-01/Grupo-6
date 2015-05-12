package security;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.security.Key;
import java.security.KeyPair;
import java.security.KeyPairGenerator;
import java.security.PrivateKey;
import java.security.PublicKey;

import javax.crypto.Cipher;
import javax.crypto.SecretKey;

public class CifradoAsimetrico {

	private final static String ALGORITMO ="RSA"; 
	private KeyPair keyPair;

	public CifradoAsimetrico(KeyPair keyPair){
		this.keyPair = keyPair;
	}

	public byte[] cifrar(byte[] clearText, PublicKey pk) {
		try {
			Cipher cipher = Cipher.getInstance(ALGORITMO);
			//System.out.println("clave original: " + s1);
			cipher.init(Cipher.ENCRYPT_MODE, pk);
			byte [] cipheredText = cipher.doFinal(clearText);
			//System.out.println("clave cifrada: " + cipheredText);
			return cipheredText;
		}
		catch (Exception e) {
			System.out.println("Excepcion: " + e.getMessage());
			return null;
		}
	}


	public String descifrar(byte[] cipheredText) { 
		String s3 = null;
		try { 
			Cipher cipher = Cipher.getInstance(ALGORITMO); 
			cipher.init(Cipher.DECRYPT_MODE, keyPair.getPrivate()); 
			byte [] clearText = cipher.doFinal(cipheredText); 
			s3 = new String(clearText); 
			System.out.println("clave original: " + s3); 
		} 
		catch (Exception e) { 
			System.out.println("Excepcion: " + e.getMessage()); 
		} 
		return s3;
	}
	
	public byte[] descifrarB(byte[] cipheredText) throws Exception{
		byte[] clearText = new byte[1024];
			Cipher cipher = Cipher.getInstance(ALGORITMO); 
			cipher.init(Cipher.DECRYPT_MODE, keyPair.getPrivate()); 
			clearText = cipher.doFinal(cipheredText); 
			//s3 = new String(clearText); 
			System.out.println("clave original: " + clearText); 
		return clearText;
	}
}
