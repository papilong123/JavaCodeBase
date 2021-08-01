package langlearn.copy;

import java.io.*;

//如果引用类型里面还包含很多引用类型，或者内层引用类型的类里面又包含引用类型，使用clone方法就会很麻烦。这时我们可以用序列化的方式来实现对象的深克隆。
public class MultilayerClone implements Serializable {
    private static final long serialVersionUID = 369285298572941L;  //最好是显式声明ID
    public Inner inner;
    //Description:[深度复制方法,需要对象及对象所有的对象属性都实现序列化]　
    public MultilayerClone myClone() {
        MultilayerClone outer = null;
        try { // 将该对象序列化成流,因为写在流里的是对象的一个拷贝，而原对象仍然存在于JVM里面。所以利用这个特性可以实现对象的深拷贝
            ByteArrayOutputStream baos = new ByteArrayOutputStream();
            ObjectOutputStream oos = new ObjectOutputStream(baos);
            oos.writeObject(this);
            // 将流序列化成对象
            ByteArrayInputStream bais = new ByteArrayInputStream(baos.toByteArray());
            ObjectInputStream ois = new ObjectInputStream(bais);
            outer = (MultilayerClone) ois.readObject();
        } catch (IOException | ClassNotFoundException e) {
            e.printStackTrace();
        }
        return outer;
    }
}

//Inner也必须实现Serializable，否则无法序列化
class Inner implements Serializable{
    private static final long serialVersionUID = 872390113109L; //最好是显式声明ID
    public String name = "";

    public Inner(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "Inner的name值为：" + name;
    }
}

