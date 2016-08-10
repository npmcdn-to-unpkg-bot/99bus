/**
 * @author Administrator
 * @mail : jerry_lzw@139.com 
 */
package org.hopen.jjbus.bean;

import java.io.Serializable;

/**
 * @author Administrator
 *
 */
public class BidDetail implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private String agency_name=null;
	private String amount=null;
	private String apr=null;
	private String award_scale=null;
	private String bid_image_filename=null;
	private String bonus=null;
	private String bonus_type=null;
	private CreditLevel creditLevel=null;
	private String credit_image_filename=null;
	private String credit_level_id=null;
	private String credit_name=null;
	private String dayBid=null;
	private String entityId=null;
	private String has_invested_amount=null;
	private String id=null;
	private String is_agency=null;
	private String is_hot=null;
	private String is_show_agency_name=null;
	private String loan_schedule=null;
	private String no=null;
	private String num=null;
	private String period=null;
	private String period_unit=null;
	/**
	 * @return the periodUnitStr
	 */
	public String getPeriodUnitStr() {
		if(period_unit.equals("-1")){
			return "年";
		} else if(period_unit.equals("0")){
			return "个月";
		} else if(period_unit.equals("1")){
			return "天";
		}
		System.out.println("******************:" + period_unit);
		return "";
	}
	private String persistent=null;
	private String product_filename=null;
	private String product_id=null;
	private String product_name=null;
	private String repay_name=null;
	private String repayment_time=null;
	private String small_image_filename=null;
	private String status=null;
	private String time=null;
	private JJtime title=null;
	private String user_id=null;
	/**
	 * @return the agency_name
	 */
	public String getAgency_name() {
		return agency_name;
	}
	/**
	 * @param agency_name the agency_name to set
	 */
	public void setAgency_name(String agency_name) {
		this.agency_name = agency_name;
	}
	/**
	 * @return the amount
	 */
	public String getAmount() {
		return amount;
	}
	/**
	 * @param amount the amount to set
	 */
	public void setAmount(String amount) {
		this.amount = amount;
	}
	/**
	 * @return the apr
	 */
	public String getApr() {
		return apr;
	}
	/**
	 * @param apr the apr to set
	 */
	public void setApr(String apr) {
		this.apr = apr;
	}
	/**
	 * @return the award_scale
	 */
	public String getAward_scale() {
		return award_scale;
	}
	/**
	 * @param award_scale the award_scale to set
	 */
	public void setAward_scale(String award_scale) {
		this.award_scale = award_scale;
	}
	/**
	 * @return the bid_image_filename
	 */
	public String getBid_image_filename() {
		return bid_image_filename;
	}
	/**
	 * @param bid_image_filename the bid_image_filename to set
	 */
	public void setBid_image_filename(String bid_image_filename) {
		this.bid_image_filename = bid_image_filename;
	}
	/**
	 * @return the bonus
	 */
	public String getBonus() {
		return bonus;
	}
	/**
	 * @param bonus the bonus to set
	 */
	public void setBonus(String bonus) {
		this.bonus = bonus;
	}
	/**
	 * @return the bonus_type
	 */
	public String getBonus_type() {
		return bonus_type;
	}
	/**
	 * @param bonus_type the bonus_type to set
	 */
	public void setBonus_type(String bonus_type) {
		this.bonus_type = bonus_type;
	}
	/**
	 * @return the creditLevel
	 */
	public CreditLevel getCreditLevel() {
		return creditLevel;
	}
	/**
	 * @param creditLevel the creditLevel to set
	 */
	public void setCreditLevel(CreditLevel creditLevel) {
		this.creditLevel = creditLevel;
	}
	/**
	 * @return the credit_image_filename
	 */
	public String getCredit_image_filename() {
		return credit_image_filename;
	}
	/**
	 * @param credit_image_filename the credit_image_filename to set
	 */
	public void setCredit_image_filename(String credit_image_filename) {
		this.credit_image_filename = credit_image_filename;
	}
	/**
	 * @return the credit_level_id
	 */
	public String getCredit_level_id() {
		return credit_level_id;
	}
	/**
	 * @param credit_level_id the credit_level_id to set
	 */
	public void setCredit_level_id(String credit_level_id) {
		this.credit_level_id = credit_level_id;
	}
	/**
	 * @return the credit_name
	 */
	public String getCredit_name() {
		return credit_name;
	}
	/**
	 * @param credit_name the credit_name to set
	 */
	public void setCredit_name(String credit_name) {
		this.credit_name = credit_name;
	}
	/**
	 * @return the dayBid
	 */
	public String getDayBid() {
		return dayBid;
	}
	/**
	 * @param dayBid the dayBid to set
	 */
	public void setDayBid(String dayBid) {
		this.dayBid = dayBid;
	}
	/**
	 * @return the entityId
	 */
	public String getEntityId() {
		return entityId;
	}
	/**
	 * @param entityId the entityId to set
	 */
	public void setEntityId(String entityId) {
		this.entityId = entityId;
	}
	/**
	 * @return the has_invested_amount
	 */
	public String getHas_invested_amount() {
		return has_invested_amount;
	}
	/**
	 * @param has_invested_amount the has_invested_amount to set
	 */
	public void setHas_invested_amount(String has_invested_amount) {
		this.has_invested_amount = has_invested_amount;
	}
	/**
	 * @return the id
	 */
	public String getId() {
		return id;
	}
	/**
	 * @param id the id to set
	 */
	public void setId(String id) {
		this.id = id;
	}
	/**
	 * @return the is_agency
	 */
	public String getIs_agency() {
		return is_agency;
	}
	/**
	 * @param is_agency the is_agency to set
	 */
	public void setIs_agency(String is_agency) {
		this.is_agency = is_agency;
	}
	/**
	 * @return the is_hot
	 */
	public String getIs_hot() {
		return is_hot;
	}
	/**
	 * @param is_hot the is_hot to set
	 */
	public void setIs_hot(String is_hot) {
		this.is_hot = is_hot;
	}
	/**
	 * @return the is_show_agency_name
	 */
	public String getIs_show_agency_name() {
		return is_show_agency_name;
	}
	/**
	 * @param is_show_agency_name the is_show_agency_name to set
	 */
	public void setIs_show_agency_name(String is_show_agency_name) {
		this.is_show_agency_name = is_show_agency_name;
	}
	/**
	 * @return the loan_schedule
	 */
	public String getLoan_schedule() {
		return loan_schedule;
	}
	/**
	 * @param loan_schedule the loan_schedule to set
	 */
	public void setLoan_schedule(String loan_schedule) {
		this.loan_schedule = loan_schedule;
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
	/**
	 * @return the num
	 */
	public String getNum() {
		return num;
	}
	/**
	 * @param num the num to set
	 */
	public void setNum(String num) {
		this.num = num;
	}
	/**
	 * @return the period
	 */
	public String getPeriod() {
		return period;
	}
	/**
	 * @param period the period to set
	 */
	public void setPeriod(String period) {
		this.period = period;
	}
	/**
	 * @return the period_unit
	 */
	public String getPeriod_unit() {
		return period_unit;
	}
	/**
	 * @param period_unit the period_unit to set
	 */
	public void setPeriod_unit(String period_unit) {
	
		this.period_unit = period_unit;
	}
	/**
	 * @return the persistent
	 */
	public String getPersistent() {
		return persistent;
	}
	/**
	 * @param persistent the persistent to set
	 */
	public void setPersistent(String persistent) {
		this.persistent = persistent;
	}
	/**
	 * @return the product_filename
	 */
	public String getProduct_filename() {
		return product_filename;
	}
	/**
	 * @param product_filename the product_filename to set
	 */
	public void setProduct_filename(String product_filename) {
		this.product_filename = product_filename;
	}
	/**
	 * @return the product_id
	 */
	public String getProduct_id() {
		return product_id;
	}
	/**
	 * @param product_id the product_id to set
	 */
	public void setProduct_id(String product_id) {
		this.product_id = product_id;
	}
	/**
	 * @return the product_name
	 */
	public String getProduct_name() {
		return product_name;
	}
	/**
	 * @param product_name the product_name to set
	 */
	public void setProduct_name(String product_name) {
		this.product_name = product_name;
	}
	/**
	 * @return the repay_name
	 */
	public String getRepay_name() {
		return repay_name;
	}
	/**
	 * @param repay_name the repay_name to set
	 */
	public void setRepay_name(String repay_name) {
		this.repay_name = repay_name;
	}
	/**
	 * @return the repayment_time
	 */
	public String getRepayment_time() {
		return repayment_time;
	}
	/**
	 * @param repayment_time the repayment_time to set
	 */
	public void setRepayment_time(String repayment_time) {
		this.repayment_time = repayment_time;
	}
	/**
	 * @return the small_image_filename
	 */
	public String getSmall_image_filename() {
		return small_image_filename;
	}
	/**
	 * @param small_image_filename the small_image_filename to set
	 */
	public void setSmall_image_filename(String small_image_filename) {
		this.small_image_filename = small_image_filename;
	}
	/**
	 * @return the status
	 */
	public String getStatus() {
		return status;
	}
	/**
	 * @param status the status to set
	 */
	public void setStatus(String status) {
		this.status = status;
	}
	/**
	 * @return the time
	 */
	public String getTime() {
		return time;
	}
	/**
	 * @param time the time to set
	 */
	public void setTime(String time) {
		this.time = time;
	}
	/**
	 * @return the title
	 */
	public JJtime getTitle() {
		return title;
	}
	/**
	 * @param title the title to set
	 */
	public void setTitle(JJtime title) {
		this.title = title;
	}
	/**
	 * @return the user_id
	 */
	public String getUser_id() {
		return user_id;
	}
	/**
	 * @param user_id the user_id to set
	 */
	public void setUser_id(String user_id) {
		this.user_id = user_id;
	}
	
}
