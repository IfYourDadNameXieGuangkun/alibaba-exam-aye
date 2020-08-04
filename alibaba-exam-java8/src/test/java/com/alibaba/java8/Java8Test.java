package com.alibaba.java8;

import lombok.extern.slf4j.Slf4j;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.web.context.WebApplicationContext;

import javax.annotation.Resource;
import java.util.*;
import java.util.function.Predicate;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;

import static org.springframework.boot.test.context.SpringBootTest.WebEnvironment.RANDOM_PORT;

@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment = RANDOM_PORT)
@AutoConfigureMockMvc
@ActiveProfiles("test")
public class Java8Test {

    @Autowired
    private WebApplicationContext webApplicationContext;

    @Resource
    private MockMvc mockMvc;


    /**
     * 1.使用Lambda表达式对字符串列表进行排序
     */
    @Test
    public void test01() {
        //1.传统方式
        List features = Arrays.asList("Lambdas", "Default Method", "Stream API", "Date and Time API");
        Collections.sort(features, new Comparator<String>() {
            @Override
            public int compare(String a, String b) {
                return b.compareTo(a);
            }
        });
        System.out.println("传统方式" + features);


        //2.Lambda表达式 简化版:
        List features2 = Arrays.asList("Lambdas", "Default Method", "Stream API", "Date and Time API");
        Collections.sort(features2, (String a, String b) -> {
            return b.compareTo(a);
        });
        System.out.println("简化版" + features2);


        //3.Lambda表达式 精简版: 去掉return 以及大括号
        List features3 = Arrays.asList("Lambdas", "Default Method", "Stream API", "Date and Time API");
        Collections.sort(features3, (String a, String b) -> b.compareTo(a));
        System.out.println("精简版" + features3);

        //4.Lambda表达式 极简版: 去掉return 以及大括号
        List features4 = Arrays.asList("Lambdas", "Default Method", "Stream API", "Date and Time API");
//        Collections.sort(features4, ( a, b)->b.compareTo(a));
//        System.out.println("极简版" + features4);
    }


    /**
     * 3.遍历集合
     */
    @Test
    public void test02() {
        //1.传统方式遍历结合
        List features = Arrays.asList("Lambdas", "Default Method", "Stream API", "Date and Time API");
        for (Object feature : features) {
            System.out.println(feature);
        }

        //2.Lambda表达式遍历
        List features1 = Arrays.asList("Lambdas", "Default Method", "Stream API", "Date and Time API");
        features1.forEach((n) -> {
            System.out.println(n);
        });//有{}
        features1.forEach((n) -> System.out.println(n));//省略{}方法体
        features.forEach(System.out::println);
    }


    @Test
    public void test03() {

        List<String> languages = Arrays.asList("Java", "Scala", "C++", "Haskell", "Lisp");
        System.out.println("startWith J");
        filter(languages, (str) -> ((String) str).startsWith("J"));

    }

    public static void filter(List<String> names, Predicate condition) {

        for (String name : names) {
            if (condition.test(name)) {
                System.out.println(name + " ");
            }
        }
    }


    /**
     *
     */
    @Test
    public void test04() {

        List<String> languages = Arrays.asList("Java", "Scala", "C++", "Haskell", "Lisp");
        languages.stream().filter((name) -> name.startsWith("J")).filter((name) -> name.length() == 4).forEach((n) -> System.out.println(n));

    }


    /**
     * 集合调用 Stream操作  filter map sorted forEach
     */
    @Test
    public void test05() {
        List<String> languages = Arrays.asList("ddd2", "aaa2", "bbb1", "aaa1", "bbb3", "ccc", "bbb2", "ddd1");
        languages.stream().filter(s -> s.startsWith("c")).map(String::toUpperCase).sorted().forEach(s -> System.out.println(s));
        languages.stream().filter(s -> s.startsWith("a")).map(String::toUpperCase).sorted().forEach(System.out::println);
    }

    /**
     * 直接用Stream.of("a","b","c")创建流,并遍历打印
     */

    @Test
    public void test06() {
        Stream.of("ddd2", "aaa2", "bbb1", "aaa1", "bbb3", "ccc", "bbb2", "ddd1").map(String::toUpperCase).collect(Collectors.toList()).forEach(n -> System.out.println(n));
    }

    /**
     * IntStream LongStream DoubleStream 创建流进行操作
     */
    @Test
    public void test07() {
        IntStream.range(0, 4).forEach(System.out::println);
        Stream.of(1.0, 2.0, 3.0).mapToInt(Double::intValue);
    }

    /**
     * 两个集合取差集
     */
    @Test
    public void test() {
        List<String> less = Arrays.asList("10802781985649877", "16488802775738731", "16488803183474243", "16863691813158088", "18584594098396045", "18588153142777988", "21894550859310716", "26031402906713422", "27569442906713422", "30080701813158088", "52941630425849127", "52943280418898077", "52943281518314092", "56963822438248125", "58683370661252444", "58683371409469209", "65873534098396045", "82288360202915351", "82288360333642972", "82288360458336545", "82288360744361256", "82288361239428080", "82288361922721414", "82288362153095920", "82288362387071806", "82288362487451510", "82288362512495925", "82288362698972040", "82288362719262295", "82288362827920256", "82288362879059490", "82288363026788229", "82288363142777988", "82288363165904561", "82288363398046258", "82288363476984927", "82288363754946970", "82288364289711124", "82288371813158088", "82288682512213938", "82297561011003659", "92393222438248125");
        List<String> more = Arrays.asList("82288362153095920", "21878510744361256", "21878510158748232", "58683371409469209", "82288362387071806", "82288360458336545", "82288362487451510", "11824662387217215", "82288361922721414", "21882262387217215", "61238602387217215", "82288360202915351", "21878511356215351", "82288364289711124", "21878513142777988", "21878513857583294", "9434172387217215", "58683370661252444", "21878510661192173", "18588153142777988", "52943280418898077", "16863622387217215", "21878513754946970", "21878510222676052", "24065162387217215", "9434173434853694", "82288363026788229", "82288363476984927", "21878512512495925", "21878512827920256", "30083152387217215", "82288363142777988", "30080701813158088", "21878511771916350", "18584594098396045", "21878512721898763", "21878510552957793", "38047302387217215", "21878511929021922", "21878510202915351", "21878512879075389", "21878514039662824", "82288362827920256", "21878512253897604", "5246792387217215", "21878512737569190", "82288363398046258", "3588922387217215", "21878510362605194", "21878510460928562", "21878512411492991", "25603802387217215", "10802781985649877", "21878512218359854", "26031182387217215", "27569442906713422", "52941502387217215", "16488802775738731", "82288361239428080", "21878510333642972", "21878510029609220", "92393222438248125", "21878512434275222", "21878511494773076", "21878512222259088", "11824532387217215", "21878513464071061", "52943281518314092", "21878511300606125", "82288363754946970", "56379932387217215", "16863722387217215", "82288360744361256", "21878513741357319", "21878512387071806", "21878510617970169", "21878511999123439", "21878511562630905", "21878511922721414", "52941630425849127", "21878510223711193", "21878514028531005", "21878510205334896", "82288360333642972", "82288362512495925", "21878513257997866", "29187052387217215", "52943102387217215", "16863533434853694", "82288362698972040", "21878514150823897", "82288362719262295", "21878511594930278", "5246942882200757", "26031402906713422", "21878512879059490", "65873534098396045", "57611900964435488", "21878511239428080", "21894550859310716", "21878513733477827", "82288363165904561", "21878511336901957", "21878514219315926", "21878512512213938", "16488803183474243", "21878511785295613", "56963822438248125", "16863691813158088", "21878511820084003", "21878511210458557", "82288362879059490", "21878513445691747", "21882242387217215", "9432822387217215", "82288682512213938", "82288371813158088", "82297561011003659", "21878512153095920", "21878514072181587", "21878512387217215", "21878511644733096", "65872612882200757", "8454462387217215", "21878512400733140", "21878512882200757", "21878511800154328", "21878510127887422", "21878511848021554", "21878513126568044", "21878512871595796", "21878511046535479", "21878513931450702", "21878510979632448", "21878513586875043", "21878511181012550");
        List<String> collect = more.stream().filter(item -> !less.contains(item)).collect(Collectors.toList());
        System.out.println(collect);

    }

    /**
     * 对象操作
     */
    @Test
    public void test08() {
        List<Student> students =
                Arrays.asList(
                        new Student("Max", 18),
                        new Student("Peter", 23),
                        new Student("Pamela", 23),
                        new Student("David", 12));

//        List<Student> students1 = students.stream().filter(p -> p.getName().startsWith("P")).collect(Collectors.toList());
//        System.out.println(students1.toString());
    }


}
