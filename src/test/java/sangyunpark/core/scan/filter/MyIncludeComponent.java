package sangyunpark.core.scan.filter;


import java.lang.annotation.*;

@Target(ElementType.TYPE) // type : class레벨에 붙는다.
@Retention(RetentionPolicy.RUNTIME)
@Documented
public @interface MyIncludeComponent {
}
