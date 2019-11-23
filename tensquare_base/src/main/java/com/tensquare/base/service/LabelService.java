package com.tensquare.base.service;

import com.tensquare.base.dao.LabelDao;
import com.tensquare.base.pojo.Label;
import entity.Result;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import util.IdWorker;
import util.SqlUtil;
import java.util.*;

@Service
@Transactional
public class LabelService {

	@Autowired
	private LabelDao labelDao;

	@Autowired
	private IdWorker idWorker;

	@Autowired
	private SqlUtil sqlUtil;

	public List<Label> findAll(){
		return this.labelDao.findAll();
	}

	public Label findById(String labelId){
		return this.labelDao.findById(labelId).orElse(null);
	}

	public void insert(Label label) throws Exception{
		label.setId(String.valueOf(this.idWorker.nextId()));
		this.labelDao.save(label);
	}

	public void update(Label label) throws Exception{
		this.labelDao.save(label);
	}

	public void delete(String labelId) throws Exception{
		this.labelDao.deleteById(labelId);
	}

	public Result testCustomQuery(){
		try {
			StringBuilder sql = new StringBuilder();
			sql.append("UPDATE tb_city SET ishot = IF(ishot = 1, 0, 1) WHERE id = ?");
			List<String> paramList = new ArrayList<>();
			paramList.add("9");
			int cnt = this.sqlUtil.executeUpdate(sql.toString(), paramList);
			System.out.println("Result1 Cnt: " + cnt);

			sql.setLength(0);
			sql.append("UPDATE tb_city SET ishot = IF(ishot = 1, 0, 1) WHERE id IN (:ids)");
			Map<String, Object> paramMap = new HashMap<>();
			paramMap.put("ids", Arrays.asList(new String[]{"1", "2", "5"}));
			cnt = this.sqlUtil.executeUpdate(sql.toString(), paramMap);
			System.out.println("Result2 Cnt: " + cnt);

			sql.setLength(0);
			sql.append("SELECT * FROM tb_label WHERE labelname LIKE :arg1 AND id > :arg2");

			paramMap.clear();
			paramMap.put("arg1", "%p%");
			paramMap.put("arg2", "1");

//			将查询结果封装成List<Map>
			List list = this.sqlUtil.findList(sql.toString(), paramMap);

//			将查询结果封装成一个List<T>
//			List list = this.sqlUtil.findList(sql.toString(), paramMap, Label.class);

			return Result.success(list);
		} catch (Exception e){
			e.printStackTrace();
			return Result.fail(e.getMessage());
		}
	}

}
