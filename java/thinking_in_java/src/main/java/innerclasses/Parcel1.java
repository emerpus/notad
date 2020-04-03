package innerclasses;

/**
 * 创建内部类的方式就像你想的那样——把类的定义放在外围类的里面
 *
 */
public class Parcel1 {
    class Contents {
        private int i = 11;
        
        public int value() {
            return i;
        }
    }

    class Destination {
        private String label; 

        Destination(String whereTo) {
            label = whereTo;
        }

        String readLabel() {
            return label;
        }
    }

    public void ship(String dest) {
        Contents c = new Contents();
        Destination d = new Destination(dest);
        System.out.println(d.readLabel());
    }

    public static void main(String[] args) {
        Parcel1 p  = new Parcel1();
        p.ship("Tasmania");
    }
}
