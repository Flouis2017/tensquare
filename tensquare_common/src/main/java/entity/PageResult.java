package entity;

import lombok.*;

import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class PageResult <T> {

	private Long total;
	private List<T> rows;

}
