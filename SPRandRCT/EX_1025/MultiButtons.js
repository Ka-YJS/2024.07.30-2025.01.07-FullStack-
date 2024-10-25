import { useNavigate } from "react-router-dom";


function MultiButtons(){

    const navigate = useNavigate();

    const handleBottonClick = (event) => {

        const buttonId = event.target.id;

        switch(buttonId){
            case 'address':
            navigate('/address');
            break;
            case 'bookSearch':
            navigate('/search');
            break;
            case 'newsSearch':
            navigate('/newsSearch');
            break;
            case 'map':
            navigate('/map');
            break;
            case 'map2':
            navigate('/map2');
            break;
            case 'map3':
            navigate('/map3');
            break;
        }
    }
    



    return(
        <div>
            <button id="address" onClick={handleBottonClick}>
                    주소찾기 api
            </button>
            <button id="bookSearch" onClick={handleBottonClick}>
                    도서찾기 api
            </button>
            <button id="newsSearch" onClick={handleBottonClick}>
                    뉴스검색 api
            </button>
            <button id="map" onClick={handleBottonClick}>
                    카카오 지도 api
            </button>
            <button id="map2" onClick={handleBottonClick}>
                    카카오 지도 api2
            </button>
            <button id="map3" onClick={handleBottonClick}>
                    카카오 지도 api3
            </button>
        </div>
    );
}

export default MultiButtons;