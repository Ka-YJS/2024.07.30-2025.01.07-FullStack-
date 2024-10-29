import React, {useState} from "react";
import { View, Text, Button } from "react-native";


const ToggleText = () => {

    const [toggle, setToggle] = useState(true);

    return(
        <View style={{alignItems: 'center'}}>
            <Button title="Toggle Text" onPress={() => setToggle(!toggle)}/>
            {toggle && (<Text>This text can be toggled</Text>)}
            
        </View>
    )

}


export default ToggleText;