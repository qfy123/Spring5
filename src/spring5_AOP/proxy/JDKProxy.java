package spring5_AOP.proxy;

import spring5_AOP.dao.Impl.UserDAOImpl;
import spring5_AOP.dao.UserDAO;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;
import java.util.Arrays;

/**
 * @author QFY
 * @Description
 * @create 2021-06-02 17:14
 */
/*
AOP术语：
    1、连接点：被代理类里的哪些方法可以被增强，哪些方法就称为连接点
    2、切入点：实际被真正增强的方法称为切入点
    3、通知（增强）：
        （1）实际增强的逻辑部分（新添加的代码）称为通知
        （2）通知有很多类型：
            前置通知：在要增强的方法之前执行
            后置通知：在要增强的方法之后执行
            环绕通知：在要增强的方法的前后都执行
            异常通知：当要增强的方法出现异常时执行的
            最终通知：最后必执行的，类似与finally
    4、切面：是一个过程，把通知应用到切入点的过程就叫切面

切入点表达式：
    1、作用：知道对哪个类里面的哪个方法进行增强
    2、语法结构：
        execution([权限修饰符][返回类型][类全路径][方法名称]([参数列表]))
        举例1：对spring5_AOP.dao.UserDAO里面的add进行增强
        execution(* spring5_AOP.dao.UserDAO.add(..))   权限类型一般写成*表示所有类型，返回类型可以不写，参数列表用..表示

        举例2：对spring5_AOP.dao.UserDAO里面的所有方法进行增强
        execution(* spring5_AOP.dao.UserDAO.*(..))

        举例3：对spring5_AOP.dao包里的所有类以及所有方法进行增强
        execution(* spring5_AOP.dao.*.*(..))
 */
public class JDKProxy {
    public static void main(String[] args) {
        //创建接口实现类代理对象
        Class[] interfaces={UserDAO.class};
//        Proxy.newProxyInstance(JDKProxy.class.getClassLoader(), interfaces, new InvocationHandler() {
//            @Override
//            public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
//                return null;
//            }
//        });
        UserDAOImpl userDAO = new UserDAOImpl();

        UserDAO dao = (UserDAO) Proxy.newProxyInstance(JDKProxy.class.getClassLoader(), interfaces, new UserDAOProxy(userDAO));
        System.out.println("方法执行结果为"+dao.add(1, 2));
    }
}
//创建代理对象代码
class UserDAOProxy implements InvocationHandler{
    //把要增强或者修改的代理对象传进来，通过有参构造传递
    private Object obj;
    public UserDAOProxy(Object obj){
        this.obj=obj;
    }
    //增强逻辑
    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        //方法之前做处理
        System.out.println("方法之前执行"+method.getName()+"传递的参数·····"+ Arrays.toString(args));
        //增强/修改的方法执行
        Object invoke = method.invoke(obj, args);
        //方法之后做处理
        System.out.println("方法之后执行"+obj);
        return invoke;
    }
}