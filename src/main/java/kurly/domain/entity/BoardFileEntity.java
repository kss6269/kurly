package kurly.domain.entity;

import java.time.LocalDateTime;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EntityListeners;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import lombok.Data;

@EntityListeners(AuditingEntityListener.class)
@Data
@SequenceGenerator(
		name="t_file_seq_Generator",
		sequenceName = "SEQ_T_FILE",
		initialValue = 1,
		allocationSize = 1
	)
@Table(name = "t_jpa_file")
@Entity
public class BoardFileEntity {
	
	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "t_file_seq_Generator")
	long idx;
	
	@Column(nullable = false)
	String orignalFileName;
	@Column(nullable = false)
	String storedfilePath;
	@Column(nullable = false)
	long fileSize;
	@Column(nullable = false)
	String creatorId;
	
	@CreatedDate// entity가 생성되어 저장될때 시간이 자동 저장
	@Column(nullable = false)
	LocalDateTime createdDate;
	String updatorId;
	
	@LastModifiedDate// entity의 값을 변결할 때 시간이 자동 저장된다.
	LocalDateTime updatedDate;

}
