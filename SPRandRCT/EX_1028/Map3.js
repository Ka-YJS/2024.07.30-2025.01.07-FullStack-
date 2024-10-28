import React, {useState, useEffect} from "react";
import { useDaumPostcodePopup } from "react-daum-postcode";
import { Map, MapInfoWindow, MapMarker } from "react-kakao-maps-sdk";


function MyMap3(){

  const [address, setAddress] = useState('');

  const[position, setPosition] = useState(null);

  let scriptUrl = "http://t1.daumcdn.net/mapjsapi/bundle/postcode/prod/postcode.v2.js"
  const open = useDaumPostcodePopup(scriptUrl);

  //주소-좌표 변환 객체를 생성
  let geoCoder = new window.kakao.maps.services.Geocoder();

  const handleComplete = (data) => {
    let addr = data.address;
    setAddress(addr);

    geoCoder.addressSearch(data.address,function(results,status){
      //정상적으로 검색이 완료됐으면
      if(status === window.kakao.maps.services.Status.OK){
        let result = results[0];
        console.log('좌표 : ',result.x,',',result.y)

        //좌표를 객체로 만들어서
        let center = {
          lat :result.y,
          lng :result.x
        }
        //state에 저장함
        setPosition(center);
      }
    })
  }

  function handleClick(){
    open({onComplete:handleComplete})
  }
    

  return(
      <div>
        
        <input type="text" value={address} placeholder="주소" readOnly/>
        <input type="button" onClick={handleClick} value="주소검색"/>
        {/* Map컴포넌트를 사용할 때 초기값으로 위도, 경도를 주지않으며 다른좌표넣어도
        이동이 안됨 */}
        {position !==null && (<Map 
          center={position}
          style={{width:'400px', height:'400px'}}
          level={3}
        >
          <MapMarker
            position={position}/>  
        </Map>)}
      </div>
  );


}

export default MyMap3;