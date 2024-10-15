package com.example.demo.controller;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.http.ResponseEntity;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.dto.ResponseDTO;
import com.example.demo.dto.TodoDTO;
import com.example.demo.model.TodoEntity;
import com.example.demo.service.TodoService;

import lombok.RequiredArgsConstructor;

//@Controller//View(html,jsp,thymelef)를 반환함 그래서 @RestController를 써야함
@RestController//이 클래스가 컨트롤러임을 명시하는 어노테이션(@Controller+@ResponseBody으로, 직렬화해서 반환해줌)
@RequestMapping("todo")
@RequiredArgsConstructor//final이나 @Nonnull이 붙어있는 필드만 생성자의 매개변수로 생성됨
public class TodoController {
	
  /*다른 클래스에 있는 메서드를 사용하기위해 객체를 우선 만들어야 함
	스프링에서는 객체를 이미 만들어놨기때문에 주입만 하면 됨
	
	-TodoService 의존성 주입하기
	-Get /todo/test로 요청을 했을 때 testTodo()메서드 호출되도록 정의하기
	-testTodo에서는 TodoService의 메서드를 호출하여 결과를 ResposeDTO의 리스트에 추가하기
	-testTodo에서는 ResposeEntity.ok().body(response)로 반환하기*/
	
	//의존성 주입
//	@Autowired
	private final TodoService todoService;
	
	//아래의 메서드가 실횅되기 위한 조건 : 브라우저에 주소가 호출되어야 함(localhost:9090/todo/test)
	@GetMapping("/test")
	public ResponseEntity<?> testTodo(){

		String str = todoService.testService();//테스트결과
		List<String> list = new ArrayList<>();//리스트의 생성 : 인덱스를 가지고 크기에 제한 없는 자료구조
		list.add(str);//리스트에 값 추가하기 : list.add(value)
		//ResponseDTO 객체의 생성
		ResponseDTO<String>response = ResponseDTO.<String>builder().data(list).build();
		//ResponseEntity;에 body에 response를 실어서 응답을 보냄
		return ResponseEntity.ok().body(response);
		
	}

	@PostMapping
	public ResponseEntity<?> createTodo(@AuthenticationPrincipal String userId,@RequestBody TodoDTO dto){
		try {
//			String tempraryUserId = "temporary-user"; //임시 유저id
			
			//TodoDTO객체를 TodoEntity객체로 변환함
			TodoEntity entity = TodoDTO.toEntity(dto);
			System.out.println(entity);
			
			//id에 null값이 이미 들어가있지만, 명시적으로 null로 설정 -> 엔티티가 새로운 데이터임을 보장함
			entity.setId(userId);//만약 id를 설정해놓으면 새로운 user가 id를 추가할 수 없으므로 안전장치의 느낌으로 기재함
			
			/*임시 유저id를 설정해줌 -> 이 부분은 인증과 인가에서 수정할 예정임
			지금은 인증과 인가 기능이 없으므로 한 유저(temporary-user)만 로그인 없이 사용 가능한 애플리케이션인 셈임*/
			entity.setUserId(userId);
			
			/*TodoService 레이어의 create 메서드를 호출하여, TodoEntity를 데이터베이스에 저장하는 작업을 수행함
			이 메서드는 저장된 TodoEntity 객체들을 저장한 리스트를 반환함
			->entities라는 변수명으로 코드를 작성하기*/
			List<TodoEntity> entities = todoService.create(entity);
			
		//-----------------------------------------------------------------여기까지의 과정 : TodoDTO를 Entity로 바꿔서 DB에 저장함(추가)	
			
			/*자바 스트림을 이용해 반환된 엔티티리스트를 TodoDTO리스트로 변환함
            entities.stream().map(TodoDTO::new): TodoEntity 객체의 리스트를 TodoDTO 리스트로 변환하는 과정임
            .collect(Collectors.toList()): 스트림으로 변환된 객체들을 리스트로 다시 수집함
			List<TodoDTO> repsonse = entities.stream( ).map(Todo::new); 를 먼저 입력
			->List<TodoDTO> repsonse = entities.stream( ).map(Todo::new).collect(Collectors.toList());
			->List<TodoDTO> dtos = entities.stream().map(TodoDTO::new).collect(Collectors.toList());*/
			List<TodoDTO> dtos = entities.stream().map(TodoDTO::new).collect(Collectors.toList());
			
			/*변환된 TodoDTO 리스트를 이용해 ResponseDTO를 초기화함
			 ->변환된 TodoDTO객체를 담고있는 리스트를 ResponseDTO의 data필드에 대입함
            builder( ) 패턴을 사용하여 ResponseDTO 객체를 생성함*/
			ResponseDTO<TodoDTO> response = ResponseDTO.<TodoDTO>builder().data(dtos).build();
			
			//ResponseDTO객체를 반환함
			return ResponseEntity.ok().body(response);
			
			
			} catch (Exception e) {
			// 혹시 예외가 발생하는 경우 ResponseDTO객체에 리스트 대신 error에 메시지를 넣어 반환함
			String error = e.getMessage();
			
			//에러 메시지를 포함한 ResponseDTO 객체를 생성함
			ResponseDTO<TodoDTO> response = ResponseDTO.<TodoDTO>builder().error(error).build();
			
			/*ResponseEntity.badRequest(): 400 Bad Request 상태 코드를 가진 응답을 반환함
			이는 클라이언트가 잘못된 요청을 했음을 나타냄*/
			return ResponseEntity.badRequest().body(response);
		}
	}
	
	//-----------------------------------------------------------------
	
	//조회하는 기능만 있음, 현재 H2가 인메모리되어있어서 재시작하면 내용물이 다 날아감
	@GetMapping
	public ResponseEntity<?> retrieveTodoList(@AuthenticationPrincipal String userId){
//			String temporaryUserId = "temporary-user";
			
			//서비스레이어의 retrieve메서드를 이용해 TodoEntity가 담겨있는 리스트를 반환받아 entities에 저장함
			List<TodoEntity> entities = todoService.retrieve(userId);
			
			//자바 스트림을 이용해 반환된 엔티티 리스트를 TodoDTO객체로 변환하고 리스트로 변환하여 dtos에 저장함
			List<TodoDTO> dtos = entities.stream().map(TodoDTO::new).collect(Collectors.toList());
			//map(TodoDTO::new) : .map(entity -> new TodoDTO(entity))
			
			//변환된 TodoDTO(dtos) 리스트를 이용해 ResponseDTO에 담고, ResponseEntity를 이용해 응답을 반환함
			ResponseDTO<TodoDTO> response = ResponseDTO.<TodoDTO>builder().data(dtos).build();
			
			return ResponseEntity.ok().body(response);
		}
		
		
	//-----------------------------------------------------------------여기까지의 과정 : 조회
	
	//외부로부터 수정하려고 하는 엔티티를 요청을 통해 받음
	@PutMapping
	public ResponseEntity<?> updateTodo(@AuthenticationPrincipal String userId, @RequestBody TodoDTO dto){
		
//		String temporaryUserId = "temporary-user";
	
		//dto -> Entity로 변환
		TodoEntity entity = TodoDTO.toEntity(dto);
		
		//dto에는 userId에 대한 정보가 없기 때문에 임시유저를 묶어서 보내야 함
		entity.setUserId(userId);
		
		List<TodoEntity> entities = todoService.update(entity);
	
		//응답으로 돌려주려면 Entity -> DTO 변환
		List<TodoDTO> dtos = entities.stream().map(TodoDTO::new).collect(Collectors.toList());	
		
		//ResposeDTOl에 담아서 반환
		ResponseDTO<TodoDTO> response = ResponseDTO.<TodoDTO>builder().data(dtos).build();
		
		
		return ResponseEntity.ok().body(response);
		
		
	
	}
	
	//-----------------------------------------------------------------여기까지의 과정 : 수정
	
	//삭제하기 -> id 를 받아서 삭제함
	@DeleteMapping
	public ResponseEntity<?> deleteTodo(@AuthenticationPrincipal String userId, @RequestBody TodoDTO dto){
		
		try {
//			String temporaryUserId = "temporary-user";//: 임시 유저 아이디
			
			//1. 엔티티로 변경
			TodoEntity entity = TodoDTO.toEntity(dto);
			
			//2. 임시유저아이디 설정
			entity.setUserId(userId);
			
			//3. 서비스를 이용해 entity를 삭제
			List<TodoEntity> entities = todoService.delete(entity);
			
			//4. 자바스크림을 이용해 반환된 엔티티 리스트를 TodoDTO리스트로 변환함
			List<TodoDTO> dtos = entities.stream().map(TodoDTO::new).collect(Collectors.toList());
			
			//5. ResponseDTO에 담아서 반환함
			ResponseDTO<TodoDTO> response = ResponseDTO.<TodoDTO>builder().data(dtos).build();
			
			return ResponseEntity.ok().body(response);
			
		} catch (Exception e) {
			
			//6. 예외가 발생하는 경우, ResponseDTO에 error를 실어서 반환함
			String error = e.getMessage();
			ResponseDTO<TodoDTO> response = ResponseDTO.<TodoDTO>builder().error(error).build();
			
			return ResponseEntity.badRequest().body(response);
			
		}
				
	}
	

	//-----------------------------------------------------------------여기까지의 과정 : 삭제


}