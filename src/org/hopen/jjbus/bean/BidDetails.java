/**
 * @author Administrator
 * @mail : jerry_lzw@139.com 
 */
package org.hopen.jjbus.bean;

/**
 * @author Administrator
 *
 */
@Deprecated
public class BidDetails {
	//编号
	String bid;
	/**
	 * @return the bidStr
	 */
	public String getBidStr() {
		return bidStr;
	}
	/**
	 * @param bidStr the bidStr to set
	 */
	public void setBidStr(String bidStr) {
		this.bidStr = bidStr;
	}
	//转编号
	String bidStr;
	//类型
	String type;
	//标题
	String title1;
	//剩余时间
	String remainingTime;
	//总金额
	String amt;
	//可投金额
	String canAmt;
	//投资周期
	String invest_period;
	//最小投资金额
	String min_invest_amount;
	//年利率
	String rate;
	//进度
	String progress;
	/**
	 * @return the rate
	 */
	public String getRate() {
		return rate;
	}
	/**
	 * @param rate the rate to set
	 */
	public void setRate(String rate) {
		this.rate = rate;
	}
	/**
	 * @return the progress
	 */
	public String getProgress() {
		return progress;
	}
	/**
	 * @param progress the progress to set
	 */
	public void setProgress(String progress) {
		this.progress = progress;
	}

	/**
	 * @return the remainingTime
	 */
	public String getRemainingTime() {
		return remainingTime;
	}
	/**
	 * @param remainingTime the remainingTime to set
	 */
	public void setRemainingTime(String remainingTime) {
		this.remainingTime = remainingTime;
	}
	/**
	 * @return the amt
	 */
	public String getAmt() {
		return amt;
	}
	/**
	 * @param amt the amt to set
	 */
	public void setAmt(String amt) {
		this.amt = amt;
	}
	/**
	 * @return the canAmt
	 */
	public String getCanAmt() {
		return canAmt;
	}
	/**
	 * @param canAmt the canAmt to set
	 */
	public void setCanAmt(String canAmt) {
		this.canAmt = canAmt;
	}
	/**
	 * @return the type
	 */
	public String getType() {
		return type;
	}
	/**
	 * @return the bid
	 */
	public String getBid() {
		return bid;
	}
	/**
	 * @param bid the bid to set
	 */
	public void setBid(String bid) {
		this.bid = bid;
	}
	/**
	 * @return the title1
	 */
	public String getTitle1() {
		return title1;
	}
	/**
	 * @param title1 the title1 to set
	 */
	public void setTitle1(String title1) {
		this.title1 = title1;
	}
	/**
	 * @param type the type to set
	 */
	public void setType(String type) {
		this.type = type;
	}
	/**
	 * @return the no
	 */
	public String getNo() {
		return no;
	}
	/**
	 * @param no the no to set
	 */
	public void setNo(String no) {
		this.no = no;
	}
	String no;
	String title;
	/**
	 * @return the title1
	 */
	public String getTitle() {
		return title;
	}
	/**
	 * @param title1 the title1 to set
	 */
	public void setTitle(String title) {
		this.title = title;
	}
	/**
	 * @return the invest_period
	 */
	public String getInvest_period() {
		return invest_period;
	}
	/**
	 * @param invest_period the invest_period to set
	 */
	public void setInvest_period(String invest_period) {
		this.invest_period = invest_period;
	}
	/**
	 * @return the min_invest_amount
	 */
	public String getMin_invest_amount() {
		return min_invest_amount;
	}
	/**
	 * @param min_invest_amount the min_invest_amount to set
	 */
	public void setMin_invest_amount(String min_invest_amount) {
		this.min_invest_amount = min_invest_amount;
	}

}
