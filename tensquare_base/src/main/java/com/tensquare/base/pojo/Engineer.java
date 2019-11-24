package com.tensquare.base.pojo;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component
@Getter
@Setter
@NoArgsConstructor
public class Engineer {

	@Value("Flouis")
	private String name;

	@Value("25")
	private Integer age;

}
