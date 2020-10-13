package kurly.domain.dto;

import lombok.Getter;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@Getter
public class PageMaker {
	
	private int block=5;//페이지 표현할 개수
	private int from;//시작번호
	private int to;//끝번호
	private int totalPages;//마지막번호
	public PageMaker(int page, int totalPages) {
		this.totalPages=totalPages;
		int blockNo=page/block;
		if(page%block > 0){
			blockNo++;
		}
		
		//끝번호연산
		to=blockNo*block;
		//시작번호 연산
		from=to-block+1;
		if(to  > totalPages) {
			to=totalPages;
		}
	}

}
