package com.wei.app.utils.junit;

import java.util.Map;

import org.springframework.util.Assert;
import org.springframework.web.client.RestTemplate;

public class JunitUtils {

	private static final JunitUtils m_oJunitUtils = new JunitUtils();

	private RestTemplate m_oRestTemplate = new RestTemplate();

	public static JunitUtils getInstance() {
		return m_oJunitUtils;
	}

	public <T> void testByGet(String url, T oExpect, Class<T> responseClazz, ICompare<T> oICompare,
			Object... requestParams) {
		T response = m_oRestTemplate.getForObject(url, responseClazz, requestParams);
		Assert.isTrue(oICompare.isEqual(response, oExpect), "Fail");
	}

	public <T> void testByGet(String url, T oExpect, Class<T> responseClazz, ICompare<T> oICompare,
			Map<String, ?> requestParams) {
		T response = m_oRestTemplate.getForObject(url, responseClazz, requestParams);
		Assert.isTrue(oICompare.isEqual(response, oExpect), "Fail");
	}

	public <T> void testByPost(String url, Object oRequestParams, T oExpect, Class<T> responseClazz,
			ICompare<T> oICompare, Object... params) {
		// HttpHeaders headers = new HttpHeaders();
		// headers.setAccept(Arrays.asList(MediaType.APPLICATION_JSON_UTF8));
		// headers.setContentType(MediaType.APPLICATION_JSON_UTF8);
		T response = m_oRestTemplate.postForObject(url, oRequestParams, responseClazz, params);
		Assert.isTrue(oICompare.isEqual(response, oExpect), "Fail");
	}

}
