//특정 API에 GET요청을 보내고 응답받기 -> 커스텀 훅

import { useState,useEffect } from "react";

export const useFetch = url => {
    const [data, setData] = useState(null);
    const [error, setError] = useState(null);

    useEffect(async() => {
        try {
            const res = await fetch(url);
            //url비동기통신요청(default get방식)
            const result = await res.json();
            //fetch를통해 얻어온 데이터는 json형식으로 변환함
            if (res.ok){
                setData(result);
                setError(null);
            } else {
                throw result;
            }
        } catch (error) {
            setError(error);
        }
    },[]);

    
    return {data, error};
}