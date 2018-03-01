package com.xy.framework.util;

import java.io.BufferedReader;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.UnsupportedEncodingException;
import java.net.ConnectException;
import java.security.KeyManagementException;
import java.security.NoSuchAlgorithmException;
import java.security.SecureRandom;
import java.security.cert.CertificateException;
import java.security.cert.X509Certificate;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.net.ssl.HttpsURLConnection;
import javax.net.ssl.KeyManager;
import javax.net.ssl.SSLContext;
import javax.net.ssl.SSLSocketFactory;
import javax.net.ssl.TrustManager;
import javax.net.ssl.X509TrustManager;

import org.apache.http.Consts;
import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.HttpStatus;
import org.apache.http.NameValuePair;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.entity.UrlEncodedFormEntity;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.impl.client.BasicCookieStore;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.message.BasicNameValuePair;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.xy.framework.base.entity.CookieModel;

/**
 * java url http封装
 * 
 */
public class RedirectUtils {

	private static Logger log = LoggerFactory.getLogger(RedirectUtils.class);
	// 创建CookieStore实例
	private static CookieModel cookieStores = new CookieModel();
	private static CloseableHttpResponse httpResponse = null;
	private static CloseableHttpClient client = HttpClients.createDefault();

	/**
	 * 判断远程服务是否开启
	 * 
	 * @param url
	 * @return
	 * @author Mr.Hao
	 * @version 2011-12-31 下午02:15:37
	 */
	public static boolean judgeServerIsOpen(String url) {
		boolean result = Boolean.FALSE;
		CloseableHttpClient client = HttpClients.createDefault();
		HttpGet method = new HttpGet(url);
		try {
			HttpResponse res = client.execute(method);
			if (res.getStatusLine().getStatusCode() == HttpStatus.SC_OK)
				result = true;
		} catch (ConnectException e) {
			log.error("服务没有开启！");
		} catch (IOException e) {
			log.error("执行HTTP Get请求" + url + "时，发生异常！", e);
		} finally {
			try {
				client.close();
			} catch (IOException e) {
			}
		}
		return result;
	}

	/**
	 * 执行一个HTTP GET请求，返回请求响应的HTML
	 * 
	 * @param url
	 *            请求的URL地址
	 * @param queryString
	 *            请求的查询参数,可以为null
	 * @param charset
	 *            字符集
	 * @param string
	 * @return 返回请求响应的HTML
	 */
	public static CookieModel doGet(String url, String charset, CookieModel cookieModel) {
		StringBuffer response = new StringBuffer();
		client = HttpClients.custom().setDefaultCookieStore(cookieModel.getCookieStore()).build();
		HttpGet method = new HttpGet(url);
		try {
			// 数据传输压缩提交信息
			// method.addHeader("accept-encoding", "gzip,deflate");
			HttpResponse res = client.execute(method);
			if (res.getStatusLine().getStatusCode() == HttpStatus.SC_OK) {
				BufferedReader reader = new BufferedReader(
						new InputStreamReader(res.getEntity().getContent(), charset));
				String line;
				while ((line = reader.readLine()) != null) {
					response.append(line).append(System.getProperty("line.separator"));
				}
				reader.close();
			} else
				log.warn("状态返回码不是200!");
		} catch (ConnectException e) {
			log.error("服务没有开启！");
		} catch (IOException e) {
			log.error("执行HTTP Get请求" + url + "时，发生异常！", e);
		} finally {
			try {
				client.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
		cookieModel.setData(response.toString());
		return cookieModel;
	}

	/**
	 * 执行一个HTTP GET请求，返回请求响应的HTML
	 * 
	 * @param url
	 *            请求的URL地址
	 * @param queryString
	 *            请求的查询参数,可以为null
	 * @param charset
	 *            字符集
	 * @param string
	 * @return 返回请求响应的HTML
	 */
	public static Elements doGet(String url, String charset) {
		StringBuffer response = new StringBuffer();
		client = HttpClients.createDefault();
		HttpGet method = new HttpGet(url);
		try {
			// 数据传输压缩提交信息
			// method.addHeader("accept-encoding", "gzip,deflate");
			HttpResponse res = client.execute(method);
			if (res.getStatusLine().getStatusCode() == HttpStatus.SC_OK) {
				BufferedReader reader = new BufferedReader(
						new InputStreamReader(res.getEntity().getContent(), charset));
				String line;
				while ((line = reader.readLine()) != null) {
					response.append(line);
				}
				reader.close();
			} else
				log.warn("状态返回码不是200!");
		} catch (ConnectException e) {
			log.error("服务没有开启！");
		} catch (IOException e) {
			log.error("执行HTTP Get请求" + url + "时，发生异常！", e);
		} finally {
			try {
				client.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
		Document doc = Jsoup.parse(response.toString());
		Elements elements = doc.select(".detail-content");
		return elements;
	}

	/**
	 * 执行一个HTTP POST请求，返回请求响应的HTML
	 * 
	 * @param url
	 *            请求的URL地址
	 * @param params
	 *            请求的查询参数,可以为null
	 * @param charset
	 *            字符集
	 * @param string
	 * @return 返回请求响应的HTML
	 */
	public static CookieModel doPost(String url, Map<String, String[]> param, String charset, CookieModel cookieModel) {
		// 设置Post参数
		List<NameValuePair> params = new ArrayList<>();
		for (String key : param.keySet()) {
			params.add(new BasicNameValuePair(key, param.get(key)[0]));
		}
		client = HttpClients.custom().setDefaultCookieStore(cookieModel.getCookieStore()).build();
		cookieModel.setData(doPost(client, params, new HttpPost(url), charset));
		return cookieModel;
	}

	public static void main(String[] args) {
		/*Map<String, String[]> param = new HashMap<>();
		String[] username = { "admin" };
		String[] password = { "96e79218965eb72c92a549dd5a330112" };
		String[] isUseName = { "1" };
		param.put("username", username);
		param.put("password", password);
		param.put("isUseName", isUseName);*/
		// doPost("http://192.168.10.30:84/yysjgl/rest/default/login", param,
		// "UTF-8", "1111111111");
		// cookieStores.setCookieStore(cookieStore);
		// System.out.println(doGet("http://192.168.10.30:84/yysjgl/rest/default/welcome",
		// "UTF-8", "1111111111"));
		//System.out.println(cookieStores.getCookieStore());
		//System.out.println(doGet("https://www.lagou.com/jobs/positionAjax.json?city=郑州&district=中原区&needAddtionalResult=false&isSchoolJob=0", "UTF-8"));
		
		
		Map<String, String[]> param = new HashMap<>();
		String[] first = { "true" };
		String[] pn = { "1" };
		String[] kd = { "java" };
		param.put("first", first);
		param.put("pn", pn);
		param.put("kd", kd);
		// 设置Post参数
		List<NameValuePair> params = new ArrayList<>();
		for (String key : param.keySet()) {
			params.add(new BasicNameValuePair(key, param.get(key)[0]));
		}
		CookieModel cookieModel=new CookieModel();
		cookieModel.setCookieStore(new BasicCookieStore());
		client = HttpClients.custom().setDefaultCookieStore(new BasicCookieStore()).build();
		//doPost(client, params, new HttpPost("https://www.lagou.com/jobs/positionAjax.json?city=%E9%83%91%E5%B7%9E&district=%E4%B8%AD%E5%8E%9F%E5%8C%BA&needAddtionalResult=false&isSchoolJob=0"), "UTF-8");
		String ht=doPost(client, params, new HttpPost("https://www.zhipin.com/job_detail/?query=java&scity=101180100&source=2&ka=sel-business-2"), "UTF-8");
		
		//Document doc;
		Document doc = Jsoup.parse(ht);
		Elements elements = doc.select(".job-list ul li .job-primary");
							doc.select(".job-list ul li .job-primary .info-primary a").attr("href");
		for (Element element : elements) {
			System.out.println(element.select(" .info-company .name a").text());
			System.out.println(element.select(" .info-primary a").attr("href"));
			Elements elements1 = doGet("https://www.zhipin.com"+element.select(" .info-primary a").attr("href"), "UTF-8");
			System.out.println(elements1.select(" .job-sec .location-address").text());
			
			//System.out.println(element.select("a"));
			//https://www.zhipin.com/job_detail/1416929089.html?ka=search_list_1
		}
	}

	public static String doPost(CloseableHttpClient client, List<NameValuePair> params, HttpPost httpPost,
			String charset) {
		StringBuffer response = new StringBuffer();
		httpPost.setHeader("Content-Type", "application/x-www-form-urlencoded;charset=utf-8");// 编码
		httpPost.setHeader("User-Agent:",
				"Mozilla/5.0 (Windows NT 10.0; WOW64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/63.0.3239.132 Safari/537.36");// 编码

		httpPost.setHeader("Accept", "application/json, text/javascript");// 编码
		httpPost.setHeader("Accept-Encoding", "gzip, deflate, br");// 编码
		httpPost.setHeader("Accept-Language", "zh-CN,zh;q=0.9");// 编码
		httpPost.setHeader("Connection", "keep-alive");// 编码
		httpPost.setHeader("Content-Type", "application/x-www-form-urlencoded; charset=UTF-8");// 编码
		try {
			// 转换参数并设置编码格式
			httpPost.setEntity(new UrlEncodedFormEntity(params, Consts.UTF_8));

			// 执行Post请求 得到Response对象
			httpResponse = client.execute(httpPost);
			// httpResponse.getStatusLine() 响应头信息
			System.out.println(httpResponse.getStatusLine());
			System.out.println("-----------------");
			// 返回对象 向上造型
			HttpEntity httpEntity = httpResponse.getEntity();
			if (httpEntity != null) {
				// 响应输入流
				InputStream is = httpEntity.getContent();
				// 转换为字符输入流
				BufferedReader br = new BufferedReader(new InputStreamReader(is, Consts.UTF_8));
				String line = null;
				while ((line = br.readLine()) != null) {
					response.append(line);
				}
				// 关闭输入流
				is.close();
			}
		} catch (UnsupportedEncodingException e) {
			e.printStackTrace();
		} catch (ClientProtocolException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			if (httpResponse != null) {
				try {
					httpResponse.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
			if (client != null) {
				try {
					client.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
		}
		return response.toString();
	}
}