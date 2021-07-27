package cn.chaseshu.thinking.in.spring.ioc.java.beans;

import java.beans.BeanInfo;
import java.beans.IntrospectionException;
import java.beans.Introspector;
import java.util.stream.Stream;

public class BeanInfoDemo {

    public static void main(String[] args) throws IntrospectionException {

        BeanInfo info = Introspector.getBeanInfo(Person.class);

        Stream.of(info.getPropertyDescriptors()).forEach(propertyDescriptor -> {

            System.out.println(propertyDescriptor.getDisplayName() + " " + propertyDescriptor.getPropertyType());

//            propertyDescriptor.setPropertyEditorClass();
        });


    }

}
