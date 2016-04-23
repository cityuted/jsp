/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Mesong
 */
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.ocpsoft.prettytime.PrettyTime;

public class timeTest {

    public static void main(final String[] args) {
        PrettyTime p = new PrettyTime(new Locale("en"));
        String dateString = "2016-04-17 03:14:27.0";
//設定日期格式
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
//進行轉換
        Date date;
        try {
            date = sdf.parse(dateString);
             System.out.println(date);
             System.out.println(p.format(date));
             
        } catch (ParseException ex) {
            Logger.getLogger(timeTest.class.getName()).log(Level.SEVERE, null, ex);
        }
       
        

    }

}
