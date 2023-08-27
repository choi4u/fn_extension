package ml.choi4u.code.controller;

import java.util.HashMap;
import java.util.Map;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import jakarta.annotation.Resource;
import jakarta.servlet.http.HttpSession;
import ml.choi4u.code.model.FnVO;
import ml.choi4u.code.service.FnService;

@Controller
public class FnController {

	@Resource(name="fnService")
	protected FnService fnService;
	
	@GetMapping("/")
	public ModelAndView logIn(ModelAndView mav, HttpSession session) {
		mav.setViewName("layouts/main");
		try {
			mav.addObject("defList", fnService.selectFnExtension(FnVO.builder().def("Y").build()));
			mav.addObject("addList", fnService.selectFnExtension(FnVO.builder().def("N").build()));
		} catch(Exception e) {
			e.printStackTrace();
		}
		return mav;
	}
	
	@PostMapping("/ajaxUpdateDef")
	@ResponseBody
	public Map<String, Object> ajaxUpdateDef(@RequestBody FnVO vo) {
		Map<String, Object> result = new HashMap<String, Object>();
		try {
			result.put("msg", (fnService.updateFnDef(vo) == 1) ? "success" : "");
		} catch(Exception e) {
			e.printStackTrace();
		}
		return result;
	}
	
	@PostMapping("/ajaxInsertAdd")
	@ResponseBody
	public Map<String, Object> ajaxInsertAdd(@RequestBody FnVO vo) {
		Map<String, Object> result = new HashMap<String, Object>();
		try {
			result.put("msg", (fnService.insertFnAdd(vo) == 1) ? "success" : "");
		} catch(Exception e) {
			e.printStackTrace();
		}
		return result;
	}
	
	@PostMapping("/ajaxDeleteAdd")
	@ResponseBody
	public Map<String, Object> ajaxDeleteAdd(@RequestBody FnVO vo) {
		Map<String, Object> result = new HashMap<String, Object>();
		try {
			result.put("msg", (fnService.deleteFnAdd(vo) == 1) ? "success" : "");
		} catch(Exception e) {
			e.printStackTrace();
		}
		return result;
	}
	
	@PostMapping("/ajaxUploadChk")
	@ResponseBody
	public Map<String, Object> ajaxUploadChk(@RequestBody FnVO vo) {
		Map<String, Object> result = new HashMap<String, Object>();
		try {
			result.put("msg", (fnService.selectFnExtensionChk(vo).size() == 0) ? "success" : "");
		} catch(Exception e) {
			e.printStackTrace();
		}
		return result;
	}
	
}
