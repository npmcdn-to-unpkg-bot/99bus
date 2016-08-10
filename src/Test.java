import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.select.Elements;

/**
 * @author jerry
 * @mail : jerry_lzw@139.com 
 */

/**
 * @author jerry
 *
 */
public class Test {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Document document = Jsoup.parse("<!DOCTYPE html><html><head><meta http-equiv=\"Content-Type\" content=\"text/html; charset=utf-8\" /><title>Servlet AccountServlet</title></head><body><h4>处理中...</h4><form action=http://www-1.fuiou.com:9057/jzh/app/500002.action id=\"frm1\" method=\"post\"><input type=\"hidden\" name=login_id value=15181832591 /><input type=\"hidden\" name=amt value=200000 /><input type=\"hidden\" name=page_notify_url value=http://120.27.166.228/front/PaymentAction/fuiou_recharge_callback_1 /><input type=\"hidden\" name=rem value=rem /><input type=\"hidden\" name=mchnt_cd value=0002900F0096235 /><input type=\"hidden\" name=back_notify_url value=http://120.27.166.228/front/PaymentAction/fuiou_recharge_callback_2 /><input type=\"hidden\" name=signature value=3B5kjWQQAEZYF9BGSwvT+PKYAnkY90hXgXMcaJbvJPIGY+lV9Lq8wce/L8yr/DCjrFapgW6kqz1SiMvZiQxqrKdqUh+p6kwbVkffiqVgH0k1Dwqmdqg3lv3+UnpkHYMoc1Q4YUoiZrPv92lmR5TzBjVM/SZfONNxXGcsCElZV2I= /><input type=\"hidden\" name=mchnt_txn_ssn value=1507345124412362 /></form><script language=\"javascript\">document.getElementById(\"frm1\").submit();</script></body></html>");
		Elements e = document.getElementsByAttributeValue("name","page_notify_url");
		
		String pageNotifyUrl = e.attr("value");
		e.attr("value","tttt");
		Elements el = document.getElementsByAttributeValue("name","back_notify_url");
		String backNotifyUrl = el.attr("value");
		e.attr("value","ffff");
		System.out.println(pageNotifyUrl+"|" + backNotifyUrl+"|" + document.html());
		
	}

}
