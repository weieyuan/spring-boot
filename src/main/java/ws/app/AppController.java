package ws.app;

import org.apache.log4j.Logger;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import ws.app.vo.AppInputVo;
import ws.app.vo.AppOutputVo;

@RestController
public class AppController {

	private static final Logger logger = Logger.getLogger(AppController.class);

	@RequestMapping("/")
	public String index() {
		return "Hello spring-boot";
	}

	@RequestMapping(value = "/app1", method = RequestMethod.GET)
	public AppOutputVo getMessageByGet(@RequestParam("message") String message) {

		logger.info("getMessageByGet");

		AppOutputVo oAppOutputVo = new AppOutputVo();
		oAppOutputVo.setSuccess(true);
		oAppOutputVo.setMessage(message);

		return oAppOutputVo;
	}

	@RequestMapping(value = "/app", method = RequestMethod.POST)
	public AppOutputVo getMessageByPost(@RequestBody AppInputVo oAppInputVo) {
		logger.info("getMessageByPost");

		String strMessage = "name is " + oAppInputVo.getName() + ", alias is " + oAppInputVo.getAlias();
		AppOutputVo oAppOutputVo = new AppOutputVo(true, strMessage);
		return oAppOutputVo;
	}

}
