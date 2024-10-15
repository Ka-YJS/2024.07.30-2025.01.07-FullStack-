import React from "react";
import { Navigate } from "react-router-dom";

function NotFound(){
    return <Navigate to = "/"/>
    /* 원래는 error가 나고, home을 요청해야 home화면으로 가는데 
    Navigate to를 이용해서 자동으로 home화면으로 보냄*/
}

export default NotFound;