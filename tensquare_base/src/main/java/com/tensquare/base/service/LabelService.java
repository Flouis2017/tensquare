package com.tensquare.base.service;

import com.tensquare.base.dao.LabelDao;
import com.tensquare.base.pojo.Label;
import org.hibernate.SQLQuery;
import org.hibernate.transform.Transformers;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import util.IdWorker;

import javax.persistence.EntityManager;
import javax.persistence.Query;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
@Transactional
public class LabelService {

	@Autowired
	private LabelDao labelDao;

	@Autowired
	private IdWorker idWorker;

	@Autowired
	private EntityManager em;

	public List<Label> findAll(){
		return this.labelDao.findAll();
	}

	public Label findById(String labelId){
		return this.labelDao.findById(labelId).get();
	}

	public Map testCustomQuery(){
		Map resMap = new HashMap();
		String sql = "SELECT * FROM tb_label WHERE labelname LIKE ? AND id > ?";
		Query query = em.createNativeQuery(sql);
		query.setParameter(1, "%p%");
		query.setParameter(2, 0);
		List<Label> list = query.unwrap(SQLQuery.class).setResultTransformer(Transformers.aliasToBean(Label.class)).list();
		resMap.put("res", list);
		return resMap;
	}

}
