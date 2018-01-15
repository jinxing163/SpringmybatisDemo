package com.ssm.baseTools;

import com.ssm.entity.Student;
import com.ssm.entity.Student2;
import org.apache.commons.beanutils.BeanUtils;
import org.apache.commons.collections.map.HashedMap;
import org.springframework.util.Assert;
import org.springframework.util.CollectionUtils;

import java.lang.reflect.InvocationTargetException;
import java.util.*;

/**
 * @author JinXing
 * @date 2018/1/8 11:35
 */
public class BeanHelper {

    /**
     * 对象属性之间的copy
     * @param source 数据源
     * @param target 目标对象
     * @author JinXing
     * @param
     * @date 2018/1/8 14:43
     */
    public static void copyProperties(Object source, Object target){

        try {
            if(source ==null || target ==null)return;
            BeanUtils.copyProperties(target,source);
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (InvocationTargetException e) {
            e.printStackTrace();
        }
    }

    /**
     * 将对象转换为Map
     * @author JinXing
     * @date 2018/1/8 15:17
     */
    public static Map<String, String> describe(Object obj){
        Map<String, String> map=new HashMap<String,String>();
        try {
            if (obj == null) return map;
            map=BeanUtils.describe(obj);
            if(!CollectionUtils.isEmpty(map)){
                //过滤空值与class元素
                Iterator<Map.Entry<String, String>> iterator = map.entrySet().iterator();
                while (iterator.hasNext()){
                    Map.Entry<String, String> next = iterator.next();
                    if(next ==null){
                        iterator.remove();
                    }else if ("class".equals(next.getKey())){
                        iterator.remove();
                    }
                }
            }
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (InvocationTargetException e) {
            e.printStackTrace();
        } catch (NoSuchMethodException e) {
            e.printStackTrace();
        }

        return map;
    }

    /**
     * 对象类型转换
     * @param source 数据源
     * @param targetType 目标类型
     * @author JinXing
     * @date 2018/1/9 9:23
     */
    public static <T>T transTo(Object source, Class<T> targetType){

        if (source==null)return null;
        Assert.notNull(targetType);
        //实例对象,并copy对象的属性
        T target= org.springframework.beans.BeanUtils.instantiate(targetType);
        copyProperties(source,target);
        return target;
    }

    /**
     * 集合类型转换
     * @param collection 数据源
     * @param targetType 目标类型
     * @author JinXing
     * @date 2018/1/9 9:23
     */
    public static <T> List<T> transTo(Collection<?> collection, Class<T> targetType){

        if (CollectionUtils.isEmpty(collection))return null;
        Assert.notNull(targetType);
        List<T> targetList=new ArrayList<T>();
        Iterator<?> iterator = collection.iterator();
        while (iterator.hasNext()){
            Object next = iterator.next();
            T target=transTo(next,targetType);
            targetList.add(target);
        }
        return targetList;
    }

    /**
     * 将Map转换成Bean
     * @param map
     * @param targetType 对象类型
     * @author JinXing
     * @date 2018/1/9 13:39
     */
    public static <T> T transTo(Map<String,?> map, Class<T> targetType){
        if(CollectionUtils.isEmpty(map)) return null;
        Assert.notNull(targetType);
        T target= org.springframework.beans.BeanUtils.instantiate(targetType);
        try {
            BeanUtils.populate(target,map);
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (InvocationTargetException e) {
            e.printStackTrace();
        }
        return target;
    }

    public static void main(String[] args) {
        test1();
        test2();
        test3();
    }

    private static void test3(){
        System.out.println("test3.............");
        Map<String,Object> map=new HashedMap();
        map.put("id",1);
        map.put("name","aaa");
        map.put("age",20);
        Student student = transTo(map, Student.class);
        System.out.println(student);
    }


    /**
     * (这里用一句话描述这个方法的作用)
     * @author JinXing
     * @date 2018/1/9 14:14
     */
    private static void test2(){
        System.out.println("test2.............");

        List<Student> list1=new ArrayList<Student>();
        list1.add(new Student(1L,"aaa",18));
        list1.add(new Student(2L,"bbb",20));

        List<String> list=new ArrayList<String>();

        aaa(list1,"aaa");
        System.out.println(list1);

        List<Student2> list2=new ArrayList<Student2>();

        list2=transTo(list1,Student2.class);
        System.out.println(list2);
    }

    private static void aaa(List<Student> list1, String aaa) {

    }

    private static void test1(){
        System.out.println("test2.............");

        Student stu=new Student();
        stu.setId(10L);
        stu.setName("aaa");
        stu.setAge(18);

        Student2 stu2=new Student2();

        copyProperties(stu,stu2);

        System.out.println(stu+"--"+stu2);

        Map<String, String> describe = describe(stu);
        System.out.println(describe);

        stu2=new Student2();

        stu2=transTo(stu,Student2.class);
        System.out.println(stu2);
        System.out.println(describe(stu2));
    }


}
