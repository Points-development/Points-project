/**
 * 
 */
package com.huiyong.service;

import java.util.List;

import com.huiyong.model.Score;

/**
 * @author gangpu
 *
 */
public interface ScoreService {
	public List<Score> getScoreByUser(String username, boolean recent);
	public List<Score> getScoreByScorer(String username, String socrername, boolean recent);
	public List<Score> getScoreByOther(String username, boolean recent);
	public void addScore(Score score);
}
