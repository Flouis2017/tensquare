package com.tensquare.base.controller;

import com.tensquare.base.pojo.Label;
import com.tensquare.base.service.LabelService;
import entity.Result;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@CrossOrigin
@RequestMapping("/label")
public class LabelController {

	@Autowired
	private LabelService labelService;

	@GetMapping
	public Result findAll(){
		return Result.success(this.labelService.findAll());
	}

	@GetMapping("/{labelId}")
	public Result findById(@PathVariable("labelId") String labelId){
		return Result.success(this.labelService.findById(labelId));
	}

	@PostMapping
	public Result insert(@RequestBody Label label){
		try {
			this.labelService.insert(label);
			return Result.success();
		} catch (Exception e){
			e.printStackTrace();
			return Result.fail(e.getMessage());
		}
	}

	@PutMapping("/{labelId}")
	public Result update(@PathVariable String labelId, @RequestBody Label label){
		try {
			label.setId(labelId);
			this.labelService.update(label);
			return Result.success();
		} catch (Exception e){
			e.printStackTrace();
			return Result.fail(e.getMessage());
		}
	}

	@DeleteMapping("/{labelId}")
	public Result deleteById(@PathVariable String labelId){
		try {
			this.labelService.delete(labelId);
			return Result.success();
		} catch (Exception e){
			e.printStackTrace();
			return Result.fail(e.getMessage());
		}
	}

	@GetMapping("/testCustomQuery")
	public Result testCustomQuery(){
		return this.labelService.testCustomQuery();
	}

}
