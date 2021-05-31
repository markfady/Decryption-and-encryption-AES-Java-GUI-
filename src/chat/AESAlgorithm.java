
package chat;
import java.security.Key;
import javax.crypto.Cipher;
import javax.crypto.spec.SecretKeySpec;
import sun.misc.BASE64Decoder;
import sun.misc.BASE64Encoder;
                                          //Decryption and Encryption using AES Algorithm
public class AESAlgorithm {
    public static String algo="AES";
    public byte[]keyValue;
     public AESAlgorithm(byte key[]){
     
     keyValue=key;
     }
public Key generateKey ()throws Exception{
     Key key=new SecretKeySpec(keyValue,algo);
     return key;
 }
     
    
public String encrypt (String msg) throws Exception{       //Public string because when i call it in chat_server i can convert string to string not to have error cant convert from void to string 
Key key=generateKey();
Cipher c=Cipher.getInstance(algo);
c.init(Cipher.ENCRYPT_MODE,key);
byte[] encVal=c.doFinal(msg.getBytes());
String encryptedValue=new BASE64Encoder().encode(encVal);
return encryptedValue;
}




public String decrypt(String msg) throws Exception{

Key key=generateKey();
Cipher c=Cipher.getInstance(algo);
c.init(Cipher.DECRYPT_MODE,key);
byte[] decoderValue=new BASE64Decoder().decodeBuffer(msg);
byte[] decValue=c.doFinal(decoderValue);
String decryptedValue=new String(decValue);
return decryptedValue;
}
}

