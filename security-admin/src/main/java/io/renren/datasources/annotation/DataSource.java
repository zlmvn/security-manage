package io.renren.datasources.annotation;

import java.lang.annotation.*;

/**
 * Created by flyap on 2018/9/6.
 */
@Target(ElementType.TYPE)
@Retention(RetentionPolicy.RUNTIME)
@Documented
public @interface DataSource {
    String name() default "";
}


