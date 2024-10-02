package com.example.demo.service;

import java.util.List;
import java.util.Optional;

import javax.management.RuntimeErrorException;

import org.springframework.stereotype.Service;

import com.example.demo.model.TodoEntity;
import com.example.demo.presistence.TodoRepository;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@Service
@RequiredArgsConstructor
public class TodoService {
	
	//TodoRepository 생성자 주입하기
	private final TodoRepository repository;
	
	//메서드형태로 비즈니스로직을 구현함
	public String testService() {
//		return "Test Service";
		
		//TodoEntity생성
		TodoEntity entity = TodoEntity.builder().title("My first todo item").build();
		
		//TodoEntity를 저장 -> save( ) : insert라고 보면 됨, 저장하면서 자동으로 생성된 key값을 ID에 메핑함
		repository.save(entity);
		
		//TodoEntity를 검색
		//findById(entity.getId()) : 기본키를 이용해 DB에 저장된 TodoEntity찾기
		TodoEntity savedEntity = repository.findById(entity.getId()).get();
		
		return savedEntity.getTitle();}
		
//---------------------------------------------------------수정--------------------------------------------------------------------------------------

	//Entity를 수정하고, 수정한 entity를 확인할 수 있는 update메서드
	public List<TodoEntity>update(TodoEntity entity){ //TodoEntity entity 매개변수는 수정된 값이 들어있음
		//1. 수정할 entity가 유효한지 확인해야 함
		validate(entity);
		
		//존재하지않는 entity는 업데이트 할 수 없음, 기존에 저장되어 있는 데이터를 조회함
		Optional<TodoEntity> original = repository.findById(entity.getId());
		
		original.ifPresent(todo -> {
			//반환된 TodoEntity가 존재하면 값을 새Entity로 덮어씀
			todo.setTitle(entity.getTitle());
			todo.setDone(entity.isDone());
			
			//데이터베이스에 새 값을 저장함
			repository.save(todo);
			
		});
		
		/*람다식이 아닌 if문을 사용할땐)
		 
		 if(original.isPresent()){
		 	TodoEntity todo = original.get();
		 	todo.setTitle(entity.get.Title());
		 	todo.setDone(entity.isDone());
		 	
		 	repository.save(todo);
		 }
		 
		 */
		
		//수정이 잘됐는지 확인하기위해 retrieve메서드를 실행한 결과를 반환함
		return retrieve(entity.getUserId());
		
	}
	
	
	//---------------------------------------------------------삭제--------------------------------------------------------------------------------------

	public List<TodoEntity>delete(TodoEntity entity){
		
		//1. 엔티티가 유효한지 확인
		validate(entity);
		
		try {
		//2. 엔티티를 삭제	
		repository.delete(entity);
			
		} catch (Exception e) {
		//3. 예외 발생 시 id와 exception을 로그로 찍음
		log.error("error deleting entity"+entity.getId(),e);
			
		//컨트롤러로 exception을 날림 -> 데이터베이스 내부 로직을 캡슐화하기위해 e를 반환하지 않고 새 exception객체를 반환함
				throw new RuntimeException("error deleting entity"+entity.getId());
		}
		
		
		//새Todo 리스트를 가져와 반환함
		return retrieve(entity.getUserId());
		
	}
	
//-----------------------------------------------------------------------------------------------------------------------------------------------
		
		//Controller에서 넘어온 데이터를 검증하고 Todo 테이블에 저장함
		//데이터를 추가하고, 추가가 잘됐는지 확인하는 로직
		public List<TodoEntity> create(TodoEntity entity){
			
			validate(entity);
			
		/*	//매개변수로 넘어온 Entity가 유효한지 검사함
			if(entity == null) {
				log.warn("Entity cannot be null");
				throw new RuntimeException("Entity cannot be null");
			}
			
			//userId가 안넘어왔을 때
			if(entity.getUserId() == null) {
				log.warn("Unknown user");
			throw new RuntimeException("Unknown user");
			}*/
			
			//넘어온 Entity에 문제가 없을 때 DB에 추가함
			repository.save(entity);
			
	        //{ }는 SLF4J에서 제공하는 플레이스홀더로, 두 번째 매개변수로 전달된 entity.getId() 값이 여기에 대입되어 출력됨
			log.info("Entity Id : { } is saved",entity.getId());
			
			/*넘어온 entity로부터 userId를 가지고 DB에서 조회된 내용을 List에 묶어서 반환함
			SELECT*FROM TodoEntity WHERE userid = 'temporary-user';
			실행해서 조회된 결과를 List에 묶어서 반환하겠다는 의미임*/
			return repository.findByUserId(entity.getUserId());
		}
		
		//userId를 넘겨받아 해당유저가 추가한 Todo를 모두 조회하는 메서드

		public List<TodoEntity> retrieve(String userId){
			return repository.findByUserId(userId);
		}
		

//-----------------------------------------------------------------------------------------------------------------------------------------------		
		
		
		private void validate(TodoEntity entity) {
			/*전달된 TodoEntity가 null인지 확인함 -> 만약 null이면 RuntimeException을 발생시키고, 경고 로그를 기록*/
			if(entity == null) {
				log.warn("Entity cannot be null");
				throw new RuntimeException("Entity cannot be null");
			}
			
			if(entity.getUserId() == null) {
				log.warn("Unknown user");
				throw new RuntimeException("Unknown user");
			}
			
			
			
		}
		
		
		
			
	}
