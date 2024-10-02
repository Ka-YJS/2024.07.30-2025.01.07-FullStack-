let backendHost;
/*
1. window 객체 : 브라우저에서 실행되는 모든 코드에 접근할 수 있는 최상위 객체임
   ->웹 페이지에서 실행되는 모든 JavaScript는 window 객체를 기반으로 동작함

2. window.location 객체는 현재 웹 페이지의 URL 정보를 다루는 객체임

3. window.location.hostname: 현재 페이지의 호스트 이름(도메인)을 반환함
 ->호스트 이름은 도메인의 이름 부분으로, 프로토콜(http:// 또는 https://), 
  경로, 쿼리 문자열을 제외한 부분임

4. 왼쪽부터 차례대로 진행되며, false나 null, undefined가 나오면    
  바로 평가를 중단하고 그 값을 반환함*/
const hostname = window && window.location && window.location.hostname;

if(hostname == "localhost"){
    backendHost = "http://localhost:9090";
}

export const API_BASE_URL = `${backendHost}`