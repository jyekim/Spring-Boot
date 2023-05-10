package user.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import user.bean.UserDTO;

@Repository
public interface UserDAO extends JpaRepository<UserDTO, String>{
	
	//쿼리 메소드
	//select * from usertable where name like '%' || ? || '%'
	public List<UserDTO> findByNameContaining(String keyword); ///containing을 쓰면 퍼센트 기호를 써서 찾겠다는 거 
	
	//select * from usertable where id like '%' || ? || '%'
	public List<UserDTO> findByIdContaining (String keyword); 
}



