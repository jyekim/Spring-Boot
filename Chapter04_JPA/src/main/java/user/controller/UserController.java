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
	//Optional이 null을 허용하지 않는 컨테이너 역할을 하며 객체가 존재하지 않을 때 예외를 발생시키지 않고 그 상황에 대해 대처하는 기능 제공
	//그래서 UserDTO 객체가 없을 경우에도 예외를 발생시키지 않는다.  이 경우에는 Optional
	public Optional<UserDTO> getUser(@RequestParam String id) {
		Optional<UserDTO> userDTO = userService.getUser(id);
		return userDTO;
	}
	
	@PostMapping("update")
	@ResponseBody
	public void update(@ModelAttribute UserDTO userDTO) {
		userService.update(userDTO);
	}
	
	@GetMapping("deleteForm")
	public String deleteForm() {
		return "user/deleteForm";
	}
	
	
	@PostMapping("delete")
	@ResponseBody
	public void delete(@RequestParam String id) {
		userService.delete(id);
	}
	
	
	

}
