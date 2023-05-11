package user.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import user.bean.UserDTO;

@Repository
public interface UserDAO extends JpaRepository<UserDTO, String>{
	
	//쿼리 메소드
	//select * from usertable where name like '%' || ? || '%'
	public List<UserDTO> findByNameContaining(String keyword); ///containing을 쓰면 퍼센트 기호를 써서 찾겠다는 거 
	
	//select * from usertable where id like '%' || ? || '%'
	public List<UserDTO> findByIdContaining (String keyword);

	//=======================
	//어노테이션!
	//검색 대상이 테이블이 아니라 영속성 컨텍스트에 등록된 엔티티이다. 
	//변수 이름은 대소문자를 구분하여 정확하게 지정해야 한다. 
	//?1은 첫번째 파라메터를 의미한다. 즉 물음표 1번이 keyword의미하고 만약 public List<UserDTO> getUserSearchName(String keyword, String cc, String dd); 이면 ?1,?2,?3으로 넣어야함 
	//UserDTO dto = new UserDTO(); 
	
	/*
	@Query("select dto from UserDTO dto where dto.name like '%' || ?1 || '%'")
	public List<UserDTO> getUserSearchName(String keyword);

	@Query("select dto from UserDTO dto where dto.id like '%' || ?1 || '%'")
	public List<UserDTO> getUserSearchId(String keyword);
	*/
	
	//물음표 대신에 직접적으로 :keyword를 넣어줘도 됨
	@Query("select dto from UserDTO dto where dto.name like '%' || :keyword || '%'")
	public List<UserDTO> getUserSearchName(String keyword);

	@Query("select dto from UserDTO dto where dto.id like '%' || :keyword || '%'")
	public List<UserDTO> getUserSearchId(String keyword);

}



