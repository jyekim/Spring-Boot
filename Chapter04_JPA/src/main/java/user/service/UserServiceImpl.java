package user.service;

import java.util.List;
import java.util.Map;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import user.bean.UserDTO;
import user.dao.UserDAO;

@Service
public class UserServiceImpl implements UserService {
	@Autowired
	private UserDAO userDAO;

	@Override
	public void write(UserDTO userDTO) {
		userDAO.save(userDTO); //이 세이브는 userdao의 jparepository 가 가지고 있는 것
							//세이브는 insert의 역할을 하고 update의 역할도 한다. 기존의 내용이 없다면 insert 기존 내용이 있다면 update
		
	}

	@Override
	public List<UserDTO> getUserList() {
		
		return userDAO.findAll();
	}

	@Override
	public String isExistId(String id) {
		//findById
		//select * from usertable where id=?
		Optional <UserDTO> userDTO = userDAO.findById(id);
		System.out.println(userDTO);  //id가 없으면 Optional.empty가 출력된다.
		
		if(userDTO.isPresent())
			return "exist";
		else
			return "non_exist";
	}

	@Override
	public List<UserDTO> search(Map<String, String> map) {
		String searchOption = map.get("searchOption");
		String keyword = map.get("keyword");
		
		if(searchOption.equals("name"))
			return userDAO.findByNameContaining(keyword);
		else
			return userDAO.findByIdContaining(keyword);
	}

	@Override
	public Optional<UserDTO> getUser(String id) {
		//findById
		//select * from usertable where id=?
		Optional<UserDTO> userDTO = userDAO.findById(id);
		System.out.println(userDTO);  //id가 없으면 Optional.empty가 출력된다.
				
		return userDTO;
	}






}
