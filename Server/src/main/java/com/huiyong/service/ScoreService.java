/**
 * 
 */
package com.huiyong.service;

import java.util.List;

import com.huiyong.model.score.Score;
import com.huiyong.model.score.ScorePoint;

/**
 * @author gangpu
 *
 */
public interface ScoreService {
	public List<Score> getScoreByUser(String username, boolean recent);
	public List<Score> getScoreByScorer(String username, String socrername, boolean recent);
	public List<Score> getScoreByOther(String username, boolean recent);
	public Integer getSelfScorePoint(String username);
	public Integer getOtherScorePoint(String username);
	public boolean addScore(Score score);
	public List<ScorePoint> getScorePointByBranch(String branch);
}
