package ws;

import java.util.HashMap;
import java.util.Map;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.test.IntegrationTest;
import org.springframework.boot.test.SpringApplicationConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;

import ws.app.utils.junit.ICompare;
import ws.app.utils.junit.JunitUtils;
import ws.app.vo.AppInputVo;
import ws.app.vo.AppOutputVo;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringApplicationConfiguration(classes = Application.class)
@WebAppConfiguration
@IntegrationTest({ "server.port=0" })
public class TestApp {

	private static final String baseUrl = "http://localhost:";

	@Value("${local.server.port}")
	private int port;

	@Test
	public void index() {

		String url = baseUrl + port + "/";

		JunitUtils.getInstance().testByGet(url, "Hello spring-boot", String.class, new ICompare<String>() {

			public boolean isEqual(String oReal, String oExpect) {

				return oReal != null ? oReal.equals(oExpect) : false;
			}

		});
	}

	@Test
	public void getMessageByGet() {

		String url = baseUrl + port + "/app1?message={message}";

		String message = "sunday";
		AppOutputVo oExpect = new AppOutputVo(true, message);

		Map<String, Object> params = new HashMap<String, Object>();
		params.put("message", message);

		JunitUtils.getInstance().testByGet(url, oExpect, AppOutputVo.class, new ICompare<AppOutputVo>() {

			public boolean isEqual(AppOutputVo oReal, AppOutputVo oExpect) {

				if (oReal.isSuccess() == oExpect.isSuccess()) {
					return oReal.getMessage() != null ? oReal.getMessage().equals(oExpect.getMessage()) : false;
				}
				return false;
			}

		}, params);
	}

	@Test
	public void getMessageByPost() {
		String name = "destina";
		String alias = "des";
		AppInputVo oAppInputVo = new AppInputVo(name, alias);

		AppOutputVo oAppOutputVo = new AppOutputVo(true, "");

		String url = baseUrl + port + "/";

		JunitUtils.getInstance().testByPost(url + "app", oAppInputVo, oAppOutputVo, AppOutputVo.class,
				new ICompare<AppOutputVo>() {

					public boolean isEqual(AppOutputVo oReal, AppOutputVo oExpect) {

						if (oReal.isSuccess() == oExpect.isSuccess()) {
							return oReal.getMessage() != null ? oReal.getMessage().equals(oExpect.getMessage()) : false;
						}
						return false;
					}

				});
	}

}
