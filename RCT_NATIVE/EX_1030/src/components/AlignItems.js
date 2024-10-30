import React, {useState} from 'react';
import { View, Text, Button, ScrollView } from 'react-native';
import { box_styles } from '../styles';

const AlignItems = () => {
    const [alignItems, setAlignment] = React.useState('row');

    return (
        <View style={box_styles.container}>
            <Text style={box_styles.title}>AlignItems: {alignItems}</Text>
            {/* 아래의 View에 감싸진 요소들을 AlignItems로 방향을 설정 */}
            <View style={[box_styles.boxContainer, { alignItems: alignItems }]}>
                <View style={box_styles.box}><Text style={box_styles.boxText}>1</Text></View>
                <View style={box_styles.box}><Text style={box_styles.boxText}>2</Text></View>
                <View style={box_styles.box}><Text style={box_styles.boxText}>3</Text></View>
            </View>
            <View style={box_styles.buttons}>
                <Button title="Flex Start" onPress={() => setAlignment('flex-start')} />
                <Button title="Center" onPress={() => setAlignment('center')} />
                <Button title="Flex End" onPress={() => setAlignment('flex-end')} />
                <Button title="Stretch" onPress={() => setAlignment('stretch')} />
            </View>
        </View>
    );
};

export default AlignItems;