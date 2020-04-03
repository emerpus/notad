package innerclasses;

/**
 * 更典型的情况是，外围类有一个方法返回指向内部类的引用
 * 如果想从外部类的非静态方法之外的任意位置创建内部类的对象，必须声明内部类对象的类型：
 * {@code OuterClassName.InnerClassName object}
 *
 * ship()方法是一个非静态方法，在其中创建内部类对象不需要完整的类型声明；main()方法可以
 * 看成是特殊的静态方法，在其中声明内部类的对象必须完整的类型声明。
 *
 * 对于访问控制权限，先要看类的可见性，再看成员变量和方法的可见性。
 */
public class Parcel2 {
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

    public Destination to(String s) {
        return new Destination(s);
    }

    public Contents contents() {
        return new Contents();
    }

    public void ship(String dest) {
        Contents c = contents();
        Destination d = to(dest);
        System.out.println(d.readLabel());
    }

    public static void main(String[] args) {
        Parcel2 p = new Parcel2();
        p.ship("Tasmania");

        Parcel2 q = new Parcel2();
        Parcel2.Contents c = q.contents();
        Parcel2.Destination d = q.to("Borneo");
    }
}
