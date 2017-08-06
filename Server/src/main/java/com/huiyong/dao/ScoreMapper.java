/**
 * 
 */
package com.huiyong.dao;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.huiyong.model.Score;

/**
 * @author gangpu
 *
 */
public interface ScoreMapper {
	public List<Score> getScoreByUser(@Param(value = "username") String username, @Param(value = "recent") boolean recent);
	public List<Score> getScoreByScorer(@Param(value = "username") String username, @Param(value = "socrername") String socrername, @Param(value = "recent") boolean recent);
	public List<Score> getScoreByOther(@Param(value = "username") String username, @Param(value = "recent") boolean recent);
	public void addScore(Score score);
}
