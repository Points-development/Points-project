/**
 * 
 */
package com.huiyong.model.paper;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnore;

/**
 * @author gangpu
 *
 */


public class PaperTest {
	public enum PaperAttribute{
		PARTY_HISTORY("partyHistory", 0);
		public String attributeName; 
		public int index; 
	    // 构造方法 
	    private PaperAttribute(String name, int index) { 
	        this.attributeName = name; this.index = index;
	    }
	};
	private Integer id;
	@JsonIgnore
	private Integer attribute;
	private String name;
	private List<PaperQuestion> questions;

	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public List<PaperQuestion> getQuestions() {
		return questions;
	}
	public void setSections(List<PaperQuestion> questions) {
		this.questions = questions;
	}
	public void setQuestions(List<PaperQuestion> questions) {
		this.questions = questions;
	}
	public Integer getAttribute() {
		return attribute;
	}
	public void setAttribute(Integer attribute) {
		this.attribute = attribute;
	} 
	@JsonIgnore
	public Boolean isPartyHistory() {
		return (attribute == PaperAttribute.PARTY_HISTORY.index);
	}
}
