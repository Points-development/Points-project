/**
 * 
 */
package com.huiyong.model;

import java.util.Date;
import java.util.Map;

/**
 * @author gangpu
 *
 */
public class Score {
	private String id;
	private User scorer;
	private User scoree;
	private Date lastModifiedTime;	
	private Map<PaperQuestion, PaperOption> scores;
	
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public User getScorer() {
		return scorer;
	}
	public void setScorer(User scorer) {
		this.scorer = scorer;
	}
	public User getScoree() {
		return scoree;
	}
	public void setScoree(User scoree) {
		this.scoree = scoree;
	}
	public Map<PaperQuestion, PaperOption> getScores() {
		return scores;
	}
	public void setScores(Map<PaperQuestion, PaperOption> scores) {
		this.scores = scores;
	}
	public Date getLastModifiedTime() {
		return lastModifiedTime;
	}
	public void setLastModifiedTime(Date lastModifiedTime) {
		this.lastModifiedTime = lastModifiedTime;
	}
}
