package org.hopen.framework.encryption;

import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;
import java.security.interfaces.RSAPrivateKey;
import java.security.interfaces.RSAPublicKey;
import javax.crypto.BadPaddingException;
import javax.crypto.Cipher;
import javax.crypto.IllegalBlockSizeException;
import javax.crypto.NoSuchPaddingException;

public class EncrypRSA {
		protected byte[] encrypt(RSAPublicKey publicKey,byte[] scrBytes) throws NoSuchAlgorithmException, NoSuchPaddingException, InvalidKeyException, IllegalBlockSizeException, BadPaddingException {
			if(publicKey != null){
				Cipher cipher = Cipher.getInstance("RSA");
				cipher.init(Cipher.ENCRYPT_MODE, publicKey);
				byte [] resultBytes = cipher.doFinal(scrBytes);
				return resultBytes;
			}
			return null;
		}
		protected byte [] decrypt(RSAPrivateKey privateKey,byte[] srcBytes) throws NoSuchAlgorithmException, NoSuchPaddingException, InvalidKeyException, IllegalBlockSizeException, BadPaddingException{
			if(privateKey!= null){
				Cipher cipher = Cipher.getInstance("RSA");
				cipher.init(Cipher.DECRYPT_MODE, privateKey);
				byte [] resultBytes = cipher.doFinal(srcBytes);
				return resultBytes;
			}
			return null;
		}
}
