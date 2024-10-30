//shadow는 ios만 가능함
import React from "react";
import { StyleSheet, View, Platform } from "react-native";

export default () => {

    return(
        <View style={styles.shadow} />
    )
}

const styles = StyleSheet.create({

    shadow : {
        backgroundColor: '#fff',
        width: 200,
        height:200,
        ...Platform.select({
            ios: {
                shadowColor:'#000',
                shadowOffset: {
                    width:10,
                    height:10
                },
                shadowOpacity: 0.5,
                shadowRadius:10,
            },
            android : {
                elevation: 20,
            },
        }),
    },
})