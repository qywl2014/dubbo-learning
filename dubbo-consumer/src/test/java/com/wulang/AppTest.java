package com.wulang;

import static org.junit.Assert.assertTrue;

import com.sun.org.apache.bcel.internal.generic.ClassGen;
import org.apache.dubbo.common.bytecode.ClassGenerator;
import org.apache.dubbo.common.utils.ReflectUtils;
import org.junit.Test;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Modifier;
import java.util.ArrayList;
import java.util.List;

/**
 * Unit test for simple App.
 */
public class AppTest {
    /**
     * Rigorous Test :-)
     */
    @Test
    public void shouldAnswerWithTrue() throws Exception {
        ClassLoader cl = ClassGenerator.class.getClassLoader();
        Class<Hello> helloClass = Hello.class;
        ClassGenerator ccp = ClassGenerator.newInstance(cl);
        ccp.addInterface(helloClass);
        List<Method> methods = new ArrayList<Method>();
        for (Method method : helloClass.getMethods()) {

            int ix = 0;
            Class<?> rt = method.getReturnType();
            Class<?>[] pts = method.getParameterTypes();

            StringBuilder code = new StringBuilder("Object[] args = new Object[").append(pts.length).append("];");
            for (int j = 0; j < pts.length; j++)
                code.append(" args[").append(j).append("] = ($w)$").append(j + 1).append(";");
            code.append(" Object ret = handler.invoke(this, methods[" + ix + "], args);");
            if (!Void.TYPE.equals(rt))
                code.append(" return ").append(asArgument(rt, "ret")).append(";");

            methods.add(method);
            ccp.addMethod(method.getName(), method.getModifiers(), rt, pts, method.getExceptionTypes(), code.toString());
        }
        String pkg = helloClass.getPackage().getName();
        String pcn = pkg + ".proxy" + 0;
        ccp.setClassName(pcn);
        ccp.addField("public static java.lang.reflect.Method[] methods;");
        ccp.addField("private " + InvocationHandler.class.getName() + " handler;");
        ccp.addConstructor(Modifier.PUBLIC, new Class<?>[]{InvocationHandler.class}, new Class<?>[0], "handler=$1;");
        ccp.addDefaultConstructor();
        Class<?> clazz = ccp.toClass();
        clazz.getField("methods").set(null, methods.toArray(new Method[0]));
        System.out.println(ccp.toString());
    }

    private static String asArgument(Class<?> cl, String name) {
        if (cl.isPrimitive()) {
            if (Boolean.TYPE == cl)
                return name + "==null?false:((Boolean)" + name + ").booleanValue()";
            if (Byte.TYPE == cl)
                return name + "==null?(byte)0:((Byte)" + name + ").byteValue()";
            if (Character.TYPE == cl)
                return name + "==null?(char)0:((Character)" + name + ").charValue()";
            if (Double.TYPE == cl)
                return name + "==null?(double)0:((Double)" + name + ").doubleValue()";
            if (Float.TYPE == cl)
                return name + "==null?(float)0:((Float)" + name + ").floatValue()";
            if (Integer.TYPE == cl)
                return name + "==null?(int)0:((Integer)" + name + ").intValue()";
            if (Long.TYPE == cl)
                return name + "==null?(long)0:((Long)" + name + ").longValue()";
            if (Short.TYPE == cl)
                return name + "==null?(short)0:((Short)" + name + ").shortValue()";
            throw new RuntimeException(name + " is unknown primitive type.");
        }
        return "(" + ReflectUtils.getName(cl) + ")" + name;
    }
}
