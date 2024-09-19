import React from "react";
import { Navigate } from "react-router-dom";

function PrivateRoute(element, isAuthenticated){
    // element에는 Dashboard가 들어오고, isAuthenticated는 true or false 값을 가짐
    return isAuthenticated ? element : <Navigate to = "/login"/>

}
export default PrivateRoute;