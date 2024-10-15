package ex03_list;

import java.util.ArrayList;
import java.util.Scanner;

public class PersonManager {
	
	public void personManager() {
		int select;
		Person p;
		
		ArrayList<Person> personArr = new ArrayList<>();
		
		while(true){
			
			System.out.println("1. 정보추가");
			System.out.println("2. 정보삭제");
			System.out.println("3. 전체정보");
			System.out.println("4. 종료");
			System.out.print("항목선택 : ");

			Scanner scan = new Scanner(System.in);
			select = scan.nextInt();
			
			switch(select) {
			
			case 1 : //정보추가
				p = new Person();
				
				System.out.println("===정보추가===");
				
				System.out.print("이름 : ");
				p.setName(scan.next());
				
				System.out.print("나이 : ");
				p.setAge(scan.nextInt());
				
				System.out.print("전화 : ");
				p.setTel(scan.next());
				
				personArr.add(p);
				System.out.println("정보가 저장되었습니다.");
				System.out.println("=======================");
				break;
				
				
			case 2 : //정보삭제
				//이름입력받음 -> 리스트안에 이름있으면 삭제->삭제했습니다 출력, 없으면 -> 존재x출력
				
				System.out.println("===정보삭제===");
				System.out.print("삭제할 이름 : ");
				String name = scan.next();
				
				for(int i = 0; i < personArr.size(); i++){
					
					if((personArr.get(i).getName()).equals(name)){
						personArr.remove(i);//personArr의 i 번째 정보를 삭제한다.
						System.out.println(name + "의 정보를 삭제했습니다.");
						break;
						
          }else{
            if(i + 1 == personArr.size()){
              System.out.println(name + " 이 존재하지 않습니다.");
            }
          }		}
          break;
          
			case 3 : //전체정보
				
			      System.out.println("-===전체정보===");
			      System.out.println("등록인원 " + personArr.size() + "명");
						      
			      for(int i = 0; i < personArr.size(); i++){
          System.out.println("이름 : " + personArr.get(i).getName());
          System.out.println("나이 : " + personArr.get(i).getAge());
          System.out.println("번호 : " + personArr.get(i).getTel());
          
			System.out.println("=======================");
				  }break;	//for문끝
				  //다시 case1으로 들어갈 수 있게끔 break사용, case4로 넘어가지않게 함
			      
					//for문 대신 Iterator를 이용한 while문 사용 가능
					/*Iterator<Person> it = personArr.iterator();
					while(it.hasNext()){
						
						p = it.next();
						System.out.println("이름 : " + p.getName());
						System.out.println("나이 : " + p.getAge());
						System.out.println("번호 : " + p.getTel());	
						System.out.println("---------------------");
					}*/
				
			case 4 : //종료
						System.out.println("프로그램 종료");
						return;
				
			}//switch끝
	}//while끝
	}}