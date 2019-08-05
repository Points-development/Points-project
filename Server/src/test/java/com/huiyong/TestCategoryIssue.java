package com.huiyong;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.TreeSet;
import java.util.stream.Collectors;

import org.junit.BeforeClass;
import org.junit.Test;

import com.huiyong.model.pingyi.CategoryIssue;

public class TestCategoryIssue {
	
	private static List<CategoryIssue> categoryTopIssues;
	
	@BeforeClass
	public static void testBeforeClass(){
		categoryTopIssues = new ArrayList<CategoryIssue>();
		CategoryIssue aCI1 = new CategoryIssue();
		aCI1.setCategoryId(1);
		aCI1.setDescription("test aci1");
		aCI1.setHitNum(2);
		categoryTopIssues.add(aCI1);
		CategoryIssue aCI2 = new CategoryIssue();
		aCI2.setCategoryId(1);
		aCI2.setDescription("test aci2");
		aCI2.setHitNum(2);
		categoryTopIssues.add(aCI2);
		CategoryIssue aCI3 = new CategoryIssue();
		aCI3.setCategoryId(2);
		aCI3.setDescription("test aci3");
		aCI3.setHitNum(3);
		categoryTopIssues.add(aCI3);
	}

	@Test
	public void test() {
		categoryTopIssues.stream().forEach((x)->{
			System.out.println("categoryId is " + x.getCategoryId() + " discription is " + x.getDescription() + " hitNum is " + x.getHitNum());
		});
		categoryTopIssues = categoryTopIssues.stream().collect(
				Collectors.collectingAndThen(
				Collectors.toCollection(() -> new TreeSet<>(Comparator.comparing(ci->ci.getCategoryId()))), ArrayList::new)
				);
		categoryTopIssues.stream().forEach((x)->{
			System.out.println("categoryId is " + x.getCategoryId() + " discription is " + x.getDescription() + " hitNum is " + x.getHitNum());
		});
	}

}
