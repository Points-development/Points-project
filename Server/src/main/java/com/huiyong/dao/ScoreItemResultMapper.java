/**
 * 
 */
package com.huiyong.dao;

import java.util.List;

import com.huiyong.model.score.CategoryScorePoint;
import com.huiyong.model.score.ScoreItemResult;

/**
 * @author gangpu
 *
 */
public interface ScoreItemResultMapper {
	public void addBatchItemResult(List<ScoreItemResult> aList);
	public List<ScoreItemResult> getItemResultByScoreId(int id);
	public void deleteScoreItemResult(int scoreId);
	/**
	 * @param scoreId
	 */
	public void deleteScoreCategoryPoint(int scoreId);
	/**
	 * @param categoryPointByScore
	 */
	public void addBatchCategoryPoint(List<CategoryScorePoint> categoryPointByScoreList);
}
