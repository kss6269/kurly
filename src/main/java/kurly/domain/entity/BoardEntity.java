package kurly.domain.entity;

import java.time.LocalDateTime;
import java.util.Collection;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EntityListeners;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

import org.hibernate.annotations.GenericGenerator;
import org.hibernate.tuple.GeneratedValueGeneration;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import lombok.Data;

@EntityListeners(AuditingEntityListener.class)
@SequenceGenerator(
	name="t_board_seq_Generator",
	sequenceName = "SEQ_T_BOARD",
	initialValue = 1,
	allocationSize = 1
)
@Table(name = "t_jpa_board")
@Data
@Entity
public class BoardEntity {
	
	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "t_board_seq_Generator")
	private long boardIdx;
	
	@Column(nullable = false)
	private String title;
	@Column(nullable = false)
	private String content;
	@Column(nullable = false)
	private int hitCnt=0;
	@Column(nullable = false)
	private String creatorId;
	
	@CreatedDate
	@Column(nullable = false)
	private LocalDateTime createDate;
	
	private String updaterId;
	
	@LastModifiedDate
	private LocalDateTime updateDate;
	//1:N관계 : 1개의 게시글은 첨부파일이 없거나, 1개이상의  첨부파일을 가질수 있기에..
	@OneToMany(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
	@JoinColumn(name = "boardIdx")//릴레이션 관계가 있는 테이블의 컬럼을 지정
	private Collection<BoardFileEntity> fileList;

}
