package com.etouch.taf.util;

import com.microsoft.tfs.util.base64.Base64;

public class encrypt_decrypt{
	
	public static String getEncodedValue(String value){
		String orig = value;
		 byte[] encoded = Base64.encodeBase64(orig.getBytes());
		 return new String(encoded);
	}

	public static String getDecodedValue(String value1){

	  String encoded = value1;
        byte[] decoded = Base64.decodeBase64(value1.getBytes());
       return new String(decoded);
    }


}