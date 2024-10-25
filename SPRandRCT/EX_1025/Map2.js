import React, {useState, useEffect} from "react";
import { Map, MapInfoWindow, MapMarker } from "react-kakao-maps-sdk";

//검색을 통해서 마커찍기
function MyMap2(){

    //사용자가 클릭한 마커의 정보를 저장할 state
    const [info, setInfo] = useState(null);

    //지도에 표시될 마커들의 리스트상태
    const [markers, setMarkers] = useState([]);    

    //생성된 카카오 맵 객체를 저장할 state
    const [map, setMap] = useState(null);    

    //검색한 키워드를 저장하는 상태
    const [keyword, setKeyword] = useState('');

    //마우스를 올린 마커에 정보를 저장하는 state
    const [hoverInfo, setHoberInfo] = useState(null);


    //카카오 장소 검색 API를 호출하는 함수
    const searchPlaces = (searchKeyword) => {
        //map 객체와 카카오 지도 API가 로드되지 않았으면 함수 종료
        if (!map || !window.kakao || !window.kakao.maps || !window.kakao.maps.services) {
          return;
        }
        
        //카카오 장소 검색 객체 생성
        const ps = new window.kakao.maps.services.Places();//카카오 장소 검색 객체 생성
    
        //키워드로 장소 검색 실행
        ps.keywordSearch(searchKeyword, (data, status) => {
          //검색이 성공적으로 완료되었을 때
          if (status === window.kakao.maps.services.Status.OK) {
            //지도밖에 마커가 있을 때, 지도 범위를 설정하기 위한 객체 생성
            const bounds = new window.kakao.maps.LatLngBounds();

            //검색된 장소 리스트를 마커로 변환
            const newMarkers = data.map((place) => ({
              position: {
                lat: place.y,//장소의 위도
                lng: place.x,//장소의 경도
              },
              content: place.place_name,//마커에 표시할 장소명
            }));
    
            //모든 마커의 위치를 기준으로 지도의 범위를 조정
            //지도위치를 수정하기위해 bounds객체에 모든 마커의 좌표를 넣음
            newMarkers.forEach(marker => bounds.extend(new window.kakao.maps.LatLng(marker.position.lat, marker.position.lng)));
            
            setMarkers(newMarkers);//마커 리스트를 상태를 업데이트
            map.setBounds(bounds);//지도를 좌표 재설정하기
          } else {//검색 결과가 없을 때 알림 메시지 표시
            alert('검색 결과가 없습니다.');
          }
        });
      };

      //맵이 처음 생성될 때 기본 검색어로 장소를 검색하는 useEffect 훅
      useEffect(() => {
        if (map) searchPlaces(keyword);//맵이 생성되면 기본 키워드로 장소 검색 실행
      }, [map]);  //map 객체가 생성될 때마다 실행

    const hadleSearch = () => {
        //검색어가 비어있을 시 경고
        if(keyword == ''){
            alert('검색어를 입력해주세요')
            return;
        }
        searchPlaces(keyword);//입력된 검색어로 장소 검색을 실행
    }


    return(
        <div>
            {/* 검색결과버튼 */}
            <div style={{marginBottom:"10px"}}>
                <input 
                    type="text" 
                    value={keyword}//검색어의 상태를 입력창의 값으로 설정
                    onChange={(e) => setKeyword(e.target.value)}
                    //입력할때마다 상태를 검색어 상태를 업데이트함
                    placeholder="검색어를 입력하세요."//입력창에 표기할 힌트, 텍스트
                    style={{padding:"5px", marginRight:"5px"}}/>
                <button onClick={hadleSearch}>검색</button>
            </div>
            {/* 지도표시 */}
            <Map
                center={{
                    lat: 37.566826,
                    lng: 126.9786567,
                }}
                style={{
                    width: "400px",
                    height: "400px",
                }}
                level={3}
                onCreate={setMap}
              /*onCreate={setMap} : 
                -맵이 처음 생성될 때 호출되는 이벤트 핸들러
                -이 핸들러는 지도의 초기화가 완료되면 카카오 맵 객체(kakao.maps.map)를
                 매개변수로 받아 그 객체에 대한 접근 및 추가 설정을 가능하게 함*/
                >
                {markers.map((marker, index) => (
                    <MapMarker
                        key={`marker-${index}`}
                        //마커에 고유한 key를 설정 (리스트 렌더링을 위해 필요)
                        position={marker.position}//마커의 위치 설정
                        onClick={() => setInfo(marker)}
                        //마커 클릭 시 해당 마커 정보를 info 상태에 저장

                        onMouseOver={() => setHoberInfo(marker)}
                        onMouseOut={() => setHoberInfo(null)}
                        
                    >
                        {/* 선택된 마커에 정보 표시 */}
                        {info && info.content === marker.content && (
                        <div style={{ color: "#000" }}>{marker.content}</div> 
                        )}

                        {/* 마우스를 올렸을 때 표시 */}
                        {hoverInfo === marker && (
                             <div style={{ color: "#000" }}>{marker.content}</div>
                        )}
                        
                    </MapMarker>
                ))}     
            
            </Map> 
                 
        </div>
    );


}

export default MyMap2;