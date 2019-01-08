/**
 * 
 */
package com.huiyong.model.paper;

/**
 * @author gangpu
 *
 */
public class PaperOption {
	private Integer id;
	private String description;
	private Integer optionPoint;
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	/**
	 * @return the optionPoint
	 */
	public Integer getOptionPoint() {
		return optionPoint;
	}
	/**
	 * @param optionPoint the optionPoint to set
	 */
	public void setOptionPoint(Integer optionPoint) {
		this.optionPoint = optionPoint;
	}
}
