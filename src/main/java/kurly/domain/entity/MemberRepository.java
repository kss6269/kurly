package kurly.domain.entity;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface MemberRepository extends JpaRepository<Member, String>{

	@Query("select m from Member m where id=:input_id and pw=:input_pw")
	Member findByIdAndPw(@Param("input_id")String id, @Param("input_pw")String pw);
	
	/*
	@Query("select m from Member m where id=:input_id and pw=:input_pw")
	Member findByIdAndPw(@Param("input_id")String id, @Param("input_pw")String pw);
	*/
	

}
