package com.tensquare.base.controller;

import com.tensquare.base.pojo.Label;
import com.tensquare.base.service.LabelService;
import entity.PageResult;
import entity.Result;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin
@RequestMapping("/label")
public class LabelController {

	@Autowired
	private LabelService labelService;

	@GetMapping
	public Result findAll(){
		PageResult<Label> pageResult = new PageResult<>();
		List<Label> list =  this.labelService.findAll();
		pageResult.setRows(list);
		pageResult.setTotal((long) list.size());
		return Result.success(pageResult);
	}

	@GetMapping("/{labelId}")
	public Result findById(@PathVariable("labelId") String labelId){
		return Result.success();
	}

	@PostMapping
	public Result save(@RequestBody Label label){
		return Result.success();
	}

	@PutMapping("/{labelId}")
	public Result update(@PathVariable String labelId, @RequestBody Label label){
		return Result.success();
	}

	@DeleteMapping("/{labelId}")
	public Result deleteById(@PathVariable String labelId){
		return Result.success();
	}

	@GetMapping("/testCustomQuery")
	public Result testCustomQuery(){
		return Result.success(this.labelService.testCustomQuery());
	}



}
