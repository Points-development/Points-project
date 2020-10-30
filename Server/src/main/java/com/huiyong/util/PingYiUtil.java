package com.huiyong.util;

import java.lang.reflect.Field;
import java.util.List;

import com.huiyong.model.pingyi.CategoryInfo;
import com.huiyong.model.score.CategoryScorePoint;

public class PingYiUtil {
	public static void transferCategoryPoint(List<CategoryScorePoint> aCSPList, Class<?> cls, Object obj) {
		aCSPList.stream().forEach((CategoryScorePoint aCSP)->{
			Field[] fields = cls.getDeclaredFields();
			for(Field f:fields){
				f.setAccessible(true);
				if(f.isAnnotationPresent(CategoryInfo.class)){
					CategoryInfo ci = f.getAnnotation(CategoryInfo.class);
					if(aCSP.getCategoryId() == ci.categoryId()) {
						try {
							f.set(obj, aCSP.getPoint());
						} catch (Exception e) {
							// TODO Auto-generated catch block
							e.printStackTrace();
						} 
					}
				}
			}
		});
	}
}
