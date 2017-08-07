/**
 * 
 */
package com.huiyong.model;

import java.util.Date;
import java.util.List;

/**
 * @author gangpu
 *
 */
public class Score {
	private Integer id;
	private Integer paperId;
	private String scorer;
	private String scoree;
	private Date lastModifiedTime;	
	private List<ScoreItemResult> scores;
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public Integer getPaperId() {
		return paperId;
	}
	public void setPaperId(Integer paperId) {
		this.paperId = paperId;
	}
	public String getScorer() {
		return scorer;
	}
	public void setScorer(String scorer) {
		this.scorer = scorer;
	}
	public String getScoree() {
		return scoree;
	}
	public void setScoree(String scoree) {
		this.scoree = scoree;
	}
	public Date getLastModifiedTime() {
		return lastModifiedTime;
	}
	public void setLastModifiedTime(Date lastModifiedTime) {
		this.lastModifiedTime = lastModifiedTime;
	}
	public List<ScoreItemResult> getScores() {
		return scores;
	}
	public void setScores(List<ScoreItemResult> scores) {
		this.scores = scores;
	}
}
