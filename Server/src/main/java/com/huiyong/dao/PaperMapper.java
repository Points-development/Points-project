/**
 * 
 */
package com.huiyong.dao;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.huiyong.model.PaperTest;
import com.huiyong.model.PaperQuestion;

/**
 * @author gangpu
 *
 */
public interface PaperMapper {
	public PaperTest getPaperById(int id);

	/**
	 * @param id
	 * @return
	 */
	public PaperTest getPaperByIdAndUserProperty(@Param(value = "id")int id);

	/**
	 * @param id
	 * @param property
	 * @return
	 */
	public List<PaperQuestion> getQuestionsByIdAndProperty(@Param(value = "id")int id, @Param(value = "property")String property);
}
