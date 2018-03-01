package com.xy.framework.util;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.URL;
import java.security.KeyManagementException;
import java.security.NoSuchAlgorithmException;
import java.security.SecureRandom;
import java.security.cert.CertificateException;
import java.security.cert.X509Certificate;

import javax.net.ssl.HostnameVerifier;
import javax.net.ssl.HttpsURLConnection;
import javax.net.ssl.KeyManager;
import javax.net.ssl.SSLContext;
import javax.net.ssl.SSLSession;
import javax.net.ssl.SSLSocketFactory;
import javax.net.ssl.TrustManager;
import javax.net.ssl.X509TrustManager;

import org.apache.http.Consts;

public class HttpsUtil {
	private static class DefaultTrustManager implements X509TrustManager {
		@Override
		public void checkClientTrusted(X509Certificate[] chain, String authType) throws CertificateException {
		}

		@Override
		public void checkServerTrusted(X509Certificate[] chain, String authType) throws CertificateException {
		}

		@Override
		public X509Certificate[] getAcceptedIssuers() {
			return null;
		}
	}

	public static HttpsURLConnection getHttpsURLConnection(String uri) throws IOException {
		SSLContext ctx = null;
		try {
			ctx = SSLContext.getInstance("TLS");
			ctx.init(new KeyManager[0], new TrustManager[] { new DefaultTrustManager() }, new SecureRandom());
		} catch (KeyManagementException e) {
			e.printStackTrace();
		} catch (NoSuchAlgorithmException e) {
			e.printStackTrace();
		}
		SSLSocketFactory ssf = ctx.getSocketFactory();
		URL url = new URL(uri);
		HttpsURLConnection httpsConn = (HttpsURLConnection) url.openConnection();
		httpsConn.setSSLSocketFactory(ssf);
		httpsConn.setHostnameVerifier(new HostnameVerifier() {
			@Override
			public boolean verify(String arg0, SSLSession arg1) {
				return true;
			}
		});
		httpsConn.setDoInput(true);
		httpsConn.setDoOutput(true);
		// 响应输入流
		InputStream is = (InputStream) httpsConn.getContent();
		// 转换为字符输入流
		BufferedReader br = new BufferedReader(new InputStreamReader(is, Consts.UTF_8));
		String line = null;
		while ((line = br.readLine()) != null) {
			System.out.println(line);
		}
		// 关闭输入流
		is.close();
		return httpsConn;
	}
	public static void main(String[] args) {
		try {
			System.out.println(getHttpsURLConnection("https://item.taobao.com/item.htm?spm=a1z09.8149145.0.0.6d2dcc9kCQCLG&id=564759793990&_u=11hd6r7n7d7a"));
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
}
