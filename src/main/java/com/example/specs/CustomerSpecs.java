/**
 * 
 */
package com.example.specs;

import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.List;

import static com.google.common.collect.Iterables.toArray;

import javax.persistence.EntityManager;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Expression;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;
import javax.persistence.metamodel.Attribute;
import javax.persistence.metamodel.EntityType;
import javax.persistence.metamodel.SingularAttribute;

import org.springframework.data.jpa.domain.Specification;
import org.springframework.util.ReflectionUtils;
import org.springframework.util.StringUtils;



/**
 * @作者 admin
 * @时间 2016年4月12日 下午4:49:58
 * @类名 CustomerSpecs.java
 * @类描述 
 * @修改记录
 * 1、修改人 2016年4月12日 下午4:49:58
 *   修改描述
 */
public class CustomerSpecs {
	public static <T> Specification<T> byAuto(final EntityManager entityManager, final T example){
		final Class<T> type = (Class<T>) example.getClass();
		return new Specification<T>(){

			@Override
			public Predicate toPredicate(Root<T> root, CriteriaQuery<?> query, CriteriaBuilder cb) {
				List<Predicate> predicates = new ArrayList<>();
				EntityType<T> entity = entityManager.getMetamodel().entity(type);
				for(Attribute<T, ?> attr: entity.getDeclaredAttributes()){
					Object attrValue = getValue(example, attr);
					if(attrValue != null){
						if(attr.getJavaType()== String.class){
							if(!StringUtils.isEmpty(attrValue)){
								predicates.add(cb.like(root.get(attribute(entity,attr.getName(),String.class)), pattern((String) attrValue)));
							}
						}else{
							predicates.add(cb.equal(root.get(attribute(entity,attr.getName(),attrValue.getClass())), attrValue));
						}
					}
				}
				return predicates.isEmpty()?cb.conjunction():cb.and(toArray(predicates,Predicate.class));
			}
			
			private <T> Object getValue(T example, Attribute<T, ?> attr){
				return ReflectionUtils.getField((Field)attr.getJavaMember(), example);
			}
			
			private <E, T> SingularAttribute<T,E> attribute(EntityType<T> entity, String fieldName,Class<E> fieldClass){
				return entity.getDeclaredSingularAttribute(fieldName, fieldClass);
			}			
		};	
		
	}

	static private String pattern(String str) {
		// TODO Auto-generated method stub
		return "%"+str +"%";
	}

	
}
