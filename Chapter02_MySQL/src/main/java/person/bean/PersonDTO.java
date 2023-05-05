package person.bean;

import org.springframework.stereotype.Component;

import lombok.Data;

@Component
@Data
public class PersonDTO {
	private int seq;
	private String name;
	private int age;
	private String photo;
}
