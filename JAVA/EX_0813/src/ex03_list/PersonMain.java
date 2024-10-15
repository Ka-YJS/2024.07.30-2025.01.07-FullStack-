package ex03_list;

		/*문제)고객의 인적사항을 추가하고, 삭제하고, 확인하기 위한 문제출제.
		-이름과 나이, 번호를 갖는 Person클래스를 만든 후, ArrayList를 사용하여
		-아래의 결과처럼 Person객체의 정보추가와 전체정보 보기를 할 수 있도록 만들어보자
		-결과 : 
					1. 정보추가
					2. 정보삭제
					3. 전체정보
					4. 종료
					항목선택 : 1 <- 정보추가 항목
					-----정보추가-----
					이름 : 1
					나이 : 1
					전화 : 1
					정보가 저장되었습니다.
					
					1. 정보추가
					2. 정보삭제
					3. 전체정보
					4. 종료
					항목선택 : 3 <- 정보보기 항목
					----전체정보----
					등록인원 1명
					이름 : 1
					나이 : 1
					전화 : 1
		 */

public class PersonMain {
	public static void main(String[] args) {
		
		PersonManager pMgr = new PersonManager();
		pMgr.personManager();
		
	}
		

	}
