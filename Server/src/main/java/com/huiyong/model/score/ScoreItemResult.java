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
	private int optionsId;
	public int getQuestionId() {
		return questionId;
	}
	public void setQuestionId(int questionId) {
		this.questionId = questionId;
	}
	public int getOptionsId() {
		return optionsId;
	}
	public void setOptionsId(int optionsId) {
		this.optionsId = optionsId;
	}
	public int getScoreId() {
		return scoreId;
	}
	public void setScoreId(int scoreId) {
		this.scoreId = scoreId;
	}
}
