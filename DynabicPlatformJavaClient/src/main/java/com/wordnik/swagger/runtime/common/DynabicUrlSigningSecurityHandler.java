package com.wordnik.swagger.runtime.common;

import java.io.UnsupportedEncodingException;
import java.net.MalformedURLException;
import java.net.URL;
import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;
import java.util.Map;

import javax.crypto.Mac;
import javax.crypto.spec.SecretKeySpec;

import com.sun.jersey.core.util.Base64;

public class DynabicUrlSigningSecurityHandler implements SecurityHandler {

	private static final String ENC = "UTF-8";
	private static final String SIGN_ALG = "HmacSHA1";
    private String clientKey;
    private String privateKey;

    public DynabicUrlSigningSecurityHandler(String clientKey, String privateKey) {
    	this.clientKey = clientKey;
        this.privateKey = privateKey;
    }

    public void populateSecurityInfo(StringBuilder resourceURL, Map<String, String> httpHeaders) {
    	String toSign = resourceURL.toString();
    	if(toSign.startsWith("http")){
        	try {
    			URL url = new URL(toSign);
    			resourceURL.append((url.getQuery() == null ? "?" : "&")).append("clientkey=").append(clientKey);
    			
    			String signature = sign(resourceURL.toString());
    			resourceURL.append("&signature=").append(signature);
    		} catch (MalformedURLException e) {
    			e.printStackTrace();
    		}
    	} else {
    		signRequestBody(toSign, httpHeaders);
    	}
    }
    
    private void signRequestBody(String toSign, Map<String, String> httpHeaders){
		String signature = sign(toSign);
		httpHeaders.put("clientkey", clientKey);
		httpHeaders.put("signature", signature);
    }
    
	private String sign(String toSign){
		try {
			Mac mac = Mac.getInstance(SIGN_ALG);
			mac.init(new SecretKeySpec(privateKey.getBytes(ENC), SIGN_ALG));
			String signature = new String(Base64.encode(mac.doFinal(toSign.toLowerCase().getBytes(ENC))), ENC);
			if(signature.endsWith("=")){
				signature = signature.substring(0, signature.length() - 1);
			}
			return encode(signature);
		} catch (UnsupportedEncodingException e) {
			e.printStackTrace();
		} catch (NoSuchAlgorithmException e) {
			e.printStackTrace();
		} catch (InvalidKeyException e) {
			e.printStackTrace();
		}
		
		return null;
	}

    private static String encode(String value){
        return value.replaceAll("\\+", "-").replaceAll("\\/", "_");
    }

	public String getClientKey() {
		return clientKey;
	}

	public String getPrivateKey() {
		return privateKey;
	}

}
