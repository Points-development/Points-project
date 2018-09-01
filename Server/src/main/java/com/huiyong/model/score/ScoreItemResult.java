/**
 * 
 */
package com.huiyong.model.score;

import com.fasterxml.jackson.annotation.JsonIgnore;

/**
 * @author gangpu
 *
 */
public class ScoreItemResult {
	@JsonIgnore
	private int scoreId;
	private int questionId;
	private Integer optionsId;
	//选择题有optionId, 问答题有answer
	private String answer;
	public int getQuestionId() {
		return questionId;
	}
	public void setQuestionId(int questionId) {
		this.questionId = questionId;
	}
	public Integer getOptionsId() {
		return optionsId;
	}
	public void setOptionsId(Integer optionsId) {
		this.optionsId = optionsId;
	}
	public int getScoreId() {
		return scoreId;
	}
	public void setScoreId(int scoreId) {
		this.scoreId = scoreId;
	}
	/**
	 * @return the answer
	 */
	public String getAnswer() {
		return answer;
	}
	/**
	 * @param answer the answer to set
	 */
	public void setAnswer(String answer) {
		this.answer = answer;
	}
}
