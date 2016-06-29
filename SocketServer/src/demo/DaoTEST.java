package demo;

import com.sdingba.bean.Sendqq;
import com.sdingba.dao.sendMessageDao;
import com.sdingba.factory.Factory;
import com.sdingba.service.sendMessageService;
import com.sun.xml.internal.ws.resources.SenderMessages;
import org.junit.Test;

import java.util.List;

/**
 * Created by su on 16-6-8.
 */
public class DaoTEST {

    @Test
    public void sttetrer(){
        sendMessageDao dao = Factory.getFactory().getInstance(sendMessageDao.class);
        List<Sendqq> aa = dao.MessageHistory("sdingba","alphabet",1);
        for (Sendqq aaa : aa) {
            System.out.println(aaa.getTitle());
        }
        System.out.println("++++++++++++++++++++++++++++++++++++++++++++++++++++++++==");
        sendMessageService impl = Factory.getFactory().getInstance(sendMessageService.class);
        String aaa = impl.MessageHistoryString("sdingba", "alphabet");
        System.out.println(aaa);

    }


    @Test
    public void sssss(){
        sendMessageService impl = Factory.getFactory().getInstance(sendMessageService.class);
        System.out.println(impl.MessageHistoryString("sdingba","alphabet"));

    }

    @Test
    public void ssss(){
        sendMessageDao dao = Factory.getFactory().getInstance(sendMessageDao.class);
        dao.addMessageSendqq("sdingba","alphabet","sdfsdfsdafasdf");
    }

//    @Test
//    public void dsfsdf(){
//
//        String sss = "sdfd:dfsdf:sdfsd";
//        String[] ssa = sss.split("\\:");
//        for (String dsfd : ssa) {
//            System.out.println(dsfd.toString());
//        }
//
//    }d
}
