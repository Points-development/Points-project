/**
 * 
 */
package com.huiyong;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import org.junit.BeforeClass;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;

import com.huiyong.dao.PaperMapper;
import com.huiyong.model.paper.PaperOption;
import com.huiyong.model.paper.PaperQuestion;
import com.huiyong.model.paper.PaperTest;
import com.huiyong.model.score.CategoryScorePoint;
import com.huiyong.model.score.Score;
import com.huiyong.model.score.ScoreItemResult;

/**
 * @author gangpu
 *
 */
@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest(classes = SpringPointsApplication.class)
@WebAppConfiguration
public class TestCategoryPoint {
	
	@Autowired
	private PaperMapper paperDao;
	
	private static Score score;
	
	@BeforeClass
	public static void testBeforeClass(){
		score = new Score();
		score.setId(1);
		score.setLastModifiedTime(new Date());
		score.setPaperId(1);
		score.setScoree("gangpu");
		score.setScorer("ganxiangzhen");
		List<ScoreItemResult> aList = new ArrayList<ScoreItemResult>();
		ScoreItemResult testItem1 = new ScoreItemResult();
		testItem1.setOptionsId(1);
		testItem1.setQuestionId(1);
		testItem1.setScoreId(1);
		ScoreItemResult testItem2 = new ScoreItemResult();
		testItem2.setOptionsId(1);
		testItem2.setQuestionId(5);
		testItem2.setScoreId(1);
		ScoreItemResult testItem3 = new ScoreItemResult();
		testItem3.setOptionsId(1);
		testItem3.setQuestionId(15);
		testItem3.setScoreId(1);
		ScoreItemResult testItem4 = new ScoreItemResult();
		testItem4.setAnswer("this is a type 2 question");
		testItem4.setOptionsId(2);
		testItem4.setQuestionId(42);
		testItem4.setScoreId(1);
		aList.add(testItem1);
		aList.add(testItem2);
		aList.add(testItem3);
		aList.add(testItem4);

		score.setScores(aList);
	}
	
	@Test
    public void testCategoryScore(){
		PaperTest paper = paperDao.getPaperById(score.getPaperId());
		List<PaperQuestion> pqList = paper.getQuestions();
		List<PaperOption> opList = paper.getOptions();
		//opList.stream().map(a->a.getDescription()).forEach(System.out::println);
		Map<Integer, Integer> qId2CIdMap = pqList.stream().filter(a -> (a.getType()==1)).collect(Collectors.toMap(PaperQuestion::getId, PaperQuestion::getCategoryId));
		qId2CIdMap.entrySet().stream().forEach(System.out::println);
		Map<Integer, Integer> oId2OpointMap = opList.stream().collect(Collectors.toMap(PaperOption::getId, PaperOption::getOptionPoint));
		Map<Integer, Integer> categoryPoingMap = score.getScores().stream().filter(a ->
			null != qId2CIdMap.get(a.getQuestionId())
		).map(a -> {
			a.setQuestionId(qId2CIdMap.get(a.getQuestionId()));
			return a;
		})
		.peek(a-> System.out.println(a.getQuestionId()))
		.map(a -> {
			a.setOptionsId(oId2OpointMap.get(a.getOptionsId()));
			return a;
		}).collect(Collectors.groupingBy(ScoreItemResult::getQuestionId, Collectors.summingInt(ScoreItemResult::getOptionsId)));
		List<CategoryScorePoint> aList = categoryPoingMap.entrySet().stream().map((et)->{
			CategoryScorePoint aCSP = new CategoryScorePoint();
			aCSP.setScoreId(score.getPaperId());
			aCSP.setCategoryId(et.getKey());
			aCSP.setPoint(et.getValue());
			return aCSP;
		}).collect(Collectors.toList());
		aList.stream().forEach(a-> System.out.println("score category is " + a.getCategoryId() + " score point is " + a.getPoint()));
    }
}
