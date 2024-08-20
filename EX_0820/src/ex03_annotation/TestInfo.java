package ex03_annotation;

import static java.lang.annotation.ElementType.METHOD;
import static java.lang.annotation.ElementType.TYPE;
import static java.lang.annotation.ElementType.TYPE_USE;
import static java.lang.annotation.RetentionPolicy.RUNTIME;

import java.lang.annotation.Retention;
import java.lang.annotation.Target;

@Target({TYPE.FIELD, TYPE_USE,METHOD})
@Retention(RUNTIME)
public @interface TestInfo {
	//위와같이 만들어 놓으면 다른데서 @TestInfo 사용가능
	
	String value();//추상메서드
	

}
