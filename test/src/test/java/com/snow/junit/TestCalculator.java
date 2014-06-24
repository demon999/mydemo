package com.snow.junit;

import static org.junit.Assert.*;

import org.junit.*;

/**
 * Created by Administrator on 14-6-23.
 */
public class TestCalculator {

    //你要测试哪个类，那么你首先就要创建一个该类的对象
    private static Calculator calculator = new Calculator();
    /*
     * @Before和@After是每个测试方法执行前后均需要执行，
     * 因此不适合累中耗资源，或者耗时过大的操作。
     * @BeforeClass 和 @AfterClass两个Fixture来帮规避此问题。
     * 从名字上就可以看出，用这两个Fixture标注的函数，只在测试用例
     * 初始化时执行 @BeforeClass方法，当所有测试执行完毕之后，执行
     * @AfterClass进行收尾工作。在这里要注意一下，每个测试类只能有
     * 一个方法被标注为 @BeforeClass 或 @AfterClass，
     * 并且该方法必须是Public和Static的
     * */
    @BeforeClass
    public static void setUpBeforeClass() throws Exception {
    }

    @AfterClass
    public static void tearDownAfterClass() throws Exception {
    }
    /*
     * 我们非常希望每一个测试都是独立的，相互之间没有任何耦合度。
     * 因此，我们就很有必要在执行每一个测试之前，对Calculator对象进行一个“复原”操作，
     * 以消除其他测试造成的影响。因此，“在任何一个测试执行之前必须执行的代码”就是一个Fixture，
     * 我们用@Before来标注它     这里不在需要@Test标注*
     * */
    @Before
    public void setUp() throws Exception {
        calculator.clear();
    }

    @After
    public void tearDown() throws Exception {
    }
    //@Test 标准的方法，返回值必须是void，而且无参数

    @Test
    public void testAdd() {
        System.out.println("--------->testAdd");
        calculator.add(2);
        calculator.add(3);
        assertEquals(5,calculator.getResult());//第一个参数填写期待结果，第二个参数填写实际结果

    }

    @Test
    public void testSubstract() {
        System.out.println("--------->testSubstract");
        calculator.add(10);
        calculator.substract(2);
        assertEquals(8,calculator.getResult());
    }
    /*
     * 如果你已经把该方法的测试用例写完，但该方法尚未完成，那么测试的时候一定是“失败”。
     * 这种失败和真正的失败是有区别的，因此JUnit提供了一种方法来区别他们，那就是在这种
     * 测试函数的前面加上@Ignore标注，这个标注的含义就是“某些方法尚未完成，暂不参与此次测试”。
     * 这样的话测试结果就会提示你有几个测试被忽略，而不是失败。一旦你完成了相应函数，只需要把@Ignore标注删去，
     * 就可以进行正常的测试。
     * */
    @Ignore
    @Test
    public void testMultiply() {
        System.out.println("--------->testMultiply");
        calculator.add(2);
        calculator.multiply(3);
        assertEquals(6,calculator.getResult());
    }

    @Test
    public void testDivide() {
        System.out.println("--------->testDivide");
        calculator.add(8);
        calculator.divide(2);
        assertEquals(4, calculator.getResult());
    }
    /*
     * 对于那些逻辑很复杂，循环嵌套比较深的程序，
     * 很有可能出现死循环，因此一定要采取一些预防措 施。
     * 限时测试是一个很好的解决方案。我们给这些测试函数设定
     * 一个执行时间，超过了这个时间，他们就会被系统强行终止，
     * 并且系统还会向你汇报该函数结束的原 因是因为超时，这样你就可以发现这些Bug了
     * 测试例子calculator中的squareRoot是个死循环。
     * */
//    @Ignore
//    @Test(timeout = 1000)//单位为毫秒
//    public void squareRoot() {
//        calculator.squareRoot(4);
//        assertEquals(2, calculator.getResult());
//    }
//    /*使用@Test标注的expected属性，将我们要检验的异常传递给他，
//     * 这样JUnit框架就能自动帮我们检测是否抛出了我们指定的异常
//     * */
//    @Ignore
//    @Test(expected = ArithmeticException.class)
//    public void divideByZero() {
//        calculator.divide(0);
//    }

}
