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
        </div>
    );
}

export default MultiButtons;