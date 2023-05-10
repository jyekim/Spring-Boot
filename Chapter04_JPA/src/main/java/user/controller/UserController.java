package user.controller;

import java.util.List;
import java.util.Map;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import user.bean.UserDTO;
import user.service.UserService;

@Controller
@RequestMapping("user")
public class UserController {
	
	@Autowired // 값을 끌고 와야함 
	private UserService userService; 
	
	@GetMapping("writeForm")
	public String writeForm() {
		return "user/writeForm"; //web-inf 앞에 있는거 생략, 뒤에는 .jsp가 생략됨 
	}
	
	
	@PostMapping("write")
	@ResponseBody
	public void write(@ModelAttribute UserDTO userDTO) {
		userService.write(userDTO);
	}
	
	
	@GetMapping("list")
	public String list() {
		return "user/list";
	}
	
	@PostMapping("getUserList")
	@ResponseBody
	public List<UserDTO> getUsetList() {
		List<UserDTO> list =userService.getUserList();
		return list; 
	}
	
	@PostMapping("isExistId")
	@ResponseBody
	public String isExistId(@RequestParam String id) {
		String result = userService.isExistId(id);
		return result;
	}
	
	@PostMapping("search")
	@ResponseBody
	//public List<UserDTO> search(@RequestParam String searchOption, @RequestParam String keyword  )
	public List<UserDTO> search(@RequestParam Map<String, String> map){
		List<UserDTO> list = userService.search(map);
		return list; 
	}
	
	
	@GetMapping("updateForm")
	public String updateForm() {
		return "user/updateForm";
	}
	
	
	@PostMapping(value="getUser")
	@ResponseBody
	public Optional<UserDTO> getUser(@RequestParam String id) {
		Optional<UserDTO> userDTO = userService.getUser(id);
		return userDTO;
	}
	
	

}
