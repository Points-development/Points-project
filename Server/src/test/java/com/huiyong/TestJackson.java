/**
 * 
 */
package com.huiyong;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonInclude.Include;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;
import com.huiyong.model.Score;
import com.huiyong.model.ScoreItemResult;

public class TestJackson {

    public static void main(String[] args) throws Exception {
        ObjectMapper objectMapper = new ObjectMapper();
        objectMapper.configure(SerializationFeature.INDENT_OUTPUT, true);
        //objectMapper.configure(SerializationFeature.WRAP_ROOT_VALUE, true);
        //objectMapper.configure(DeserializationFeature.UNWRAP_ROOT_VALUE, true);
        objectMapper.configure(SerializationFeature.WRITE_EMPTY_JSON_ARRAYS, false);
        objectMapper.setSerializationInclusion(Include.NON_NULL);
        
		Score score = new Score();
		score.setId(1);
		score.setLastModifiedTime(new Date());
		score.setPaperId(2);
		score.setScoree("gangpu");
		score.setScorer("ganxiangzhen");
		List<ScoreItemResult> aList = new ArrayList<ScoreItemResult>();
		ScoreItemResult testItem1 = new ScoreItemResult();
		testItem1.setOptionsId(1);
		testItem1.setQuestionId(2);
		testItem1.setScoreId(1);
		ScoreItemResult testItem2 = new ScoreItemResult();
		testItem2.setOptionsId(1);
		testItem2.setQuestionId(2);
		testItem2.setScoreId(1);
		aList.add(testItem1);
		aList.add(testItem2);
		score.setScores(aList);

        String teststring=objectMapper.writeValueAsString(score);
        System.out.println(teststring);
        Score scoreDer = objectMapper.readValue(teststring, Score.class);
        System.out.println(scoreDer.getScorer());   
        System.out.println(scoreDer.getLastModifiedTime());   
    }
}
