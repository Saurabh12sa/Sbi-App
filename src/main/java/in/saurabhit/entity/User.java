package in.saurabhit.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "USER_TBL")
public class User {
	
	@Id
   @GeneratedValue(strategy = GenerationType.AUTO)
	private Integer userId;
	
	@Column(name = "USER_NAME")
	private String userName;
	
	private String email;
	
	private String password;

}
