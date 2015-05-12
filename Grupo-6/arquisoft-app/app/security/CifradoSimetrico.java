package security;



import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.security.NoSuchAlgorithmException;

import javax.crypto.Cipher;
import javax.crypto.KeyGenerator;
import javax.crypto.SecretKey;

public class CifradoSimetrico
{
	private SecretKey desKey;
	private final static String ALGORITMO = "AES";
	private final static String PADDING = "AES/ECB/PKCS5Padding";
	//private final static String PADDING = "RSA";

	public  CifradoSimetrico(SecretKey desKey1){
		desKey = desKey1;
	}
	public SecretKey key(){
		return desKey;
	}
	public byte[] cifrar(String mensaje) {
		byte [] cipheredText;
		try {
			Cipher cipher = Cipher.getInstance(ALGORITMO);
			String pwd = mensaje;
			byte [] clearText = pwd.getBytes();
			String x = new String (clearText);
			cipher.init(1, desKey);
			cipheredText = cipher.doFinal(clearText);
			new String (cipheredText);
			//return cipheredText;
		}
		catch (Exception e) {
			System.out.println("Excepcion: " + e.getMessage());
			return null;
		}
		return cipheredText;
	}

	public String descifrar(byte [] cipheredText)
	{
		String s3 = "";
		try
		{
			Cipher cipher = Cipher.getInstance(PADDING);
			cipher.init(Cipher.DECRYPT_MODE, desKey);
			byte [] clearText = cipher.doFinal(cipheredText);
			s3 = new String(clearText);
			System.out.println("Clave Original: " + s3);
		}
		catch (Exception e)
		{
			System.out.println("Excepci�n: " + e.getMessage());
		}
		return s3;
	}
}

