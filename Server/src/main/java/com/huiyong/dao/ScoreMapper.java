/**
 * 
 */
package com.huiyong.dao;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.huiyong.model.score.Score;
import com.huiyong.model.score.ScorePoint;

/**
 * @author gangpu
 *
 */
public interface ScoreMapper {
	public List<Score> getScoreByUser(@Param(value = "username") String username, @Param(value = "recent") boolean recent);
	public List<Score> getScoreByScorer(@Param(value = "username") String username, @Param(value = "socrername") String socrername, @Param(value = "recent") boolean recent);
	public List<Score> getScoreByOther(@Param(value = "username") String username, @Param(value = "recent") boolean recent);
	public void addScore(Score score);
	public Integer getSelfScorePoint(String username);
	public Integer getOtherScorePoint(String username);
	public void updateScore(Score score);
	public List<ScorePoint> getScorePointByBranch(String branch);
}
