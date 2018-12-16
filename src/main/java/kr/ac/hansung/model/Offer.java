package kr.ac.hansung.model;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@NoArgsConstructor
@ToString
public class Offer {

	private int id;
	private int year;
	private int term;
	private int code;
	private int score;
	
	@Size(min=2, max=100, message="Subject must be between 2 and 100 chars")
	@NotEmpty(message="The subjet cannot be empty")
	private String subject;
	
	@Size(min=2, max=100, message="Subject must be between 2 and 100 chars")
	private String part;
	

}
