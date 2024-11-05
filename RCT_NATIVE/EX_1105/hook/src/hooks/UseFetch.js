//특정 API에 GET요청을 보내고 응답받기 -> 커스텀 훅

import { useState,useEffect } from "react";

export const useFetch = url => {
    const [data, setData] = useState(null);
    const [error, setError] = useState(null);
    const [inProgress, setInProgress] = useState(false);

    useEffect(() => {
        const fetchData = async () => {
            try {
                setInProgress(true);
                const res = await fetch(url);
                const result = await res.json();
            if (res.ok){
                setData(result);
                setError(null);
            } else {
                throw result;
            }
        } catch (error) {
            setError(error);
        }finally{
            setInProgress(false);
        }
        }//fetchData

        fetchData();
        
    },[]);


    return {data, error, inProgress};
}