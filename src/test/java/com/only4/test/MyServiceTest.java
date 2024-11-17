package com.only4.test;

import static org.mockito.Mockito.mockStatic;
import static org.mockito.Mockito.times;

import org.junit.jupiter.api.Test;
import org.mockito.MockedStatic;

public class MyServiceTest {

    @Test
    public void testExecute() {
        // 创建 MockedStatic 对象
        try (MockedStatic<StaticUtils> mockedStatic = mockStatic(StaticUtils.class)) {
            // 模拟静态方法行为
            mockedStatic.when(StaticUtils::doSomething).thenAnswer(invocation -> {
                System.out.println("Mocked static method called!");
                return null; // 必须返回 null 因为是 void 方法
            });

            // 测试业务逻辑
            MyService service = new MyService();
            service.execute();

            // 验证静态方法调用
            mockedStatic.verify(StaticUtils::doSomething, times(1));
        }
    }
}
