package util;

import org.hibernate.query.internal.NativeQueryImpl;
import org.hibernate.transform.Transformers;
import org.springframework.beans.factory.annotation.Autowired;
import javax.persistence.EntityManager;
import javax.persistence.Query;
import java.util.List;
import java.util.Map;

public class SqlUtil {

	@Autowired
	private EntityManager em;

	public List findList(String sql, Map<String, Object> paramMap){
		Query query = this.em.createNativeQuery(sql);
		for (Map.Entry entry : paramMap.entrySet()){
			query.setParameter(String.valueOf(entry.getKey()), entry.getValue());
		}
		return query.unwrap(NativeQueryImpl.class).setResultTransformer(Transformers.ALIAS_TO_ENTITY_MAP).list();
	}

	public List findList(String sql, List<String> paramList){
		Query query = this.em.createNativeQuery(sql);
		for (int i = 0; i < paramList.size(); i++){
			query.setParameter(i+1, paramList.get(i));
		}
		return query.unwrap(NativeQueryImpl.class).setResultTransformer(Transformers.ALIAS_TO_ENTITY_MAP).list();
	}

	public List findList(String sql, Map<String, Object> paramMap, Class clazz){
		Query query = this.em.createNativeQuery(sql);
		for (Map.Entry entry : paramMap.entrySet()){
			query.setParameter(String.valueOf(entry.getKey()), entry.getValue());
		}
		return query.unwrap(NativeQueryImpl.class).setResultTransformer(Transformers.aliasToBean(clazz)).list();
	}

	public List findList(String sql, List<String> paramList, Class clazz){
		Query query = this.em.createNativeQuery(sql);
		for (int i = 0; i < paramList.size(); i++){
			query.setParameter(i+1, paramList.get(i));
		}
		return query.unwrap(NativeQueryImpl.class).setResultTransformer(Transformers.aliasToBean(clazz)).list();
	}

	public int executeUpdate(String sql, Map<String, Object> paramMap){
		Query query = this.em.createNativeQuery(sql);
		for (Map.Entry entry: paramMap.entrySet()){
			query.setParameter(String.valueOf(entry.getKey()), entry.getValue());
		}
		return query.executeUpdate();
	}

	public int executeUpdate(String sql, List<String> paramList){
		Query query = this.em.createNativeQuery(sql);
		for (int i = 0; i < paramList.size(); i++){
			query.setParameter(i+1, paramList.get(i));
		}
		return query.executeUpdate();
	}

}
