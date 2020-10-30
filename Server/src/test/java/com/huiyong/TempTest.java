/**
 * 
 */
package com.huiyong;

import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import com.huiyong.model.pingyi.CategoryInfo;
import com.huiyong.model.pingyi.CategoryPoint;
import com.huiyong.model.pingyi.ZuZhiPingJia;

/**
 * @author gangpu
 *
 */
public class TempTest {

	/**
	 * @param args
	 * @throws IllegalAccessException 
	 * @throws IllegalArgumentException 
	 */
	public static void main(String[] args) throws IllegalArgumentException, IllegalAccessException {
		ZuZhiPingJia zzpj = new ZuZhiPingJia();
		zzpj.setZhengZhiBenSe(5);
		ZuZhiPingJia zzpj1 = new ZuZhiPingJia();
		zzpj1.setZhengZhiBenSe(6);
		Class<?> clazz=zzpj.getClass();
		Field[] fields = clazz.getDeclaredFields();
		List<CategoryPoint> cpList = new ArrayList<CategoryPoint>();
		for(Field f:fields){
			f.setAccessible(true);
			if(f.isAnnotationPresent(CategoryInfo.class)){
				System.out.println("field name is " + f.getName());
				System.out.println("value of zzpj is " + f.get(zzpj));
				System.out.println("value of zzpj1 is " + f.get(zzpj1));
				f.set(zzpj, (Integer)f.get(zzpj) + (Integer)f.get(zzpj1));
				System.out.println("after process value of zzpj is " + f.get(zzpj));
			}
		}
		for(Field f:fields){
			f.setAccessible(true);
			if(f.isAnnotationPresent(CategoryInfo.class)){
				CategoryPoint cp = new CategoryPoint();
				CategoryInfo ci = f.getAnnotation(CategoryInfo.class);
				cp.setCategoryId(ci.categoryId());
				cp.setDescription(ci.description());
				cp.setPoint(Optional.ofNullable((Integer)f.get(zzpj)).map(u->u).orElse(0));
				cpList.add(cp);
			}
		}
		cpList.stream().forEach(x->{
			System.out.println("category id is " + x.getCategoryId());
			System.out.println("category description is " + x.getDescription());
			System.out.println("category point is " + x.getPoint());
		});
	}

}
