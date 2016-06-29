import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by su on 16-6-26.
 */
public class demo2 {
    @Test
    public void lists(){
        List<bean> bs = new ArrayList<bean>();
        bean bean1 = new bean();
        bean1.setLl("0000");

        bean bean2 = new bean();
        bean2.setLl("1111");

        bean bean3 = new bean();
        bean3.setLl("2222");

        bean bean4 = new bean();
        bean4.setLl("3333");

        bs.add(bean1);
        bs.add(bean2);
        bs.add(bean3);
        bs.add(bean4);

        System.out.println(bs.get(1).getLl());

        bs.remove(0);

        System.out.println(bs.get(2).getLl());


    }
    class bean{
        private String ll;

        public String getLl() {
            return ll;
        }

        public void setLl(String ll) {
            this.ll = ll;
        }
    }
}
