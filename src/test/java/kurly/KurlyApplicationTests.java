package kurly;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import kurly.domain.entity.Sos;
import kurly.domain.entity.SosRepository;

@SpringBootTest
class KurlyApplicationTests {
	
	@Autowired
	private SosRepository repository;


	@Test
	public void contextLoads() {
		for(int i=1 ; i<=20 ; i++) {
			Sos entity=Sos.builder()
					.subject("제목"+i).writer("test")
					.content("내용"+i).user_ip("127.0.0.1").build();
			repository.save(entity);
		}
	}
	
}
