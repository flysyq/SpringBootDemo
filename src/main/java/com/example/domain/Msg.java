/**
 * @创建人：石永强
 * @创建时间：　2016年4月18日下午5:13:38
 * @类名：　Msg
 * @说明：
 * @修改人：
 * @修改时间：
 * @修改说明
 */
package com.example.domain;

public class Msg {
	private String title;
	private String content;
	private String etraInfo;
	/**
	 * @param title
	 * @param content
	 * @param etraInfo
	 */
	public Msg(String title, String content, String etraInfo) {
		super();
		this.title = title;
		this.content = content;
		this.etraInfo = etraInfo;
	}
	
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getContent() {
		return content;
	}
	public void setContent(String content) {
		this.content = content;
	}
	public String getEtraInfo() {
		return etraInfo;
	}
	public void setEtraInfo(String etraInfo) {
		this.etraInfo = etraInfo;
	}
	
}
