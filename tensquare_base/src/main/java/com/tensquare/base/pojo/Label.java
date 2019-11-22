package com.tensquare.base.pojo;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.io.Serializable;

@Getter
@Setter
@ToString
@Entity
@Table(name = "tb_label")
public class Label implements Serializable {

	@Id
	private String id;

	private String labelname;
	private String state;
	private Long count;
	private String recommend;
	private Long fans;

}
