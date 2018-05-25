/**
 * 
 */
package com.huiyong.model;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author gangpu
 *
 */

public class QuestionSummary {
	private Integer questionId;
	private Integer excellent;
	private Integer good;
	private Integer normal;
	private Integer bad;

	/**
	 * @return the questionId
	 */
	public Integer getQuestionId() {
		return questionId;
	}

	/**
	 * @param questionId
	 *            the questionId to set
	 */
	public void setQuestionId(Integer questionId) {
		this.questionId = questionId;
	}

	/**
	 * @return the excellent
	 */
	public Integer getExcellent() {
		return excellent;
	}

	/**
	 * @param excellent
	 *            the excellent to set
	 */
	public void setExcellent(Integer excellent) {
		this.excellent = excellent;
	}

	/**
	 * @return the good
	 */
	public Integer getGood() {
		return good;
	}

	/**
	 * @param good
	 *            the good to set
	 */
	public void setGood(Integer good) {
		this.good = good;
	}

	/**
	 * @return the normal
	 */
	public Integer getNormal() {
		return normal;
	}

	/**
	 * @param normal
	 *            the normal to set
	 */
	public void setNormal(Integer normal) {
		this.normal = normal;
	}

	/**
	 * @return the bad
	 */
	public Integer getBad() {
		return bad;
	}

	/**
	 * @param bad
	 *            the bad to set
	 */
	public void setBad(Integer bad) {
		this.bad = bad;
	}
	
	public static Map<Integer, QuestionSummary> toQuestionSummaryMap(List<QuestionSummary> qsList){
		Map<Integer, QuestionSummary> aMap = new HashMap<Integer, QuestionSummary>();
		for(QuestionSummary qs : qsList){
			aMap.put(qs.getQuestionId(), qs);
		}
		return aMap;
	}

}
