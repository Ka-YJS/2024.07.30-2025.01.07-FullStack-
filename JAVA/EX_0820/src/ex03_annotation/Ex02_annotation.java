package ex03_annotation;

import java.lang.annotation.Annotation;

@TestInfo(value = "테스트정보")
//value=를 통해 TestInfo의 value( )메서드의 정보가 저장됨

public class Ex02_annotation {
	public static void main(String[] args) {

		Annotation[] annos = Ex02_annotaion.class.getAnnotations();
		
		for(Annotation anno : annos) {
			System.out.println(anno);
		}
		
		//.class : 클래스 리터럴, 그  클래스 자체에 대한 정보를 얻을 수 있음
		//ex)클래스의 이름, 메서드에 무엇이 있는지, 적용된 어노테이션은 뭐가 있는지 등등
		TestInfo testInfo = (TestInfo)Ex02_annotaion.class.getAnnotation(TestInfo.class);
		System.out.println(testInfo.value());
	
		
	}}
