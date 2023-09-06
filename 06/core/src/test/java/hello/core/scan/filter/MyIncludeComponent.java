package hello.core.scan.filter;

//import java.lang.annotation.Target;

import java.lang.annotation.*;

// 타입아니면 필드에 붙나 어디에 붙나 확인
@Target(ElementType.TYPE)
@Retention(RetentionPolicy.RUNTIME)
@Documented
public @interface MyIncludeComponent {
}


