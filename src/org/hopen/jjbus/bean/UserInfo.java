/**
 * @author jerry
 * @mail : jerry_lzw@139.com 
 */
package org.hopen.jjbus.bean;

/**
 * @author jerry
 *
 */
@Deprecated
public class UserInfo {

		String userName;
		String ss_number;
		String mobile;
		
		/**
		 * @return the userName
		 */
		public String getUserName() {
			return userName;
		}
		/**
		 * @return the mobile
		 */
		public String getMobile() {
			return mobile;
		}
		/**
		 * @param mobile the mobile to set
		 */
		public void setMobile(String mobile) {
			this.mobile = mobile;
		}
		/**
		 * @param userName the userName to set
		 */
		public void setUserName(String userName) {
			this.userName = userName;
		}
		/**
		 * @return the ss_number
		 */
		public String getSs_number() {
			return ss_number;
		}
		/**
		 * @param ss_number the ss_number to set
		 */
		public void setSs_number(String ss_number) {
			this.ss_number = ss_number;
		}

}
