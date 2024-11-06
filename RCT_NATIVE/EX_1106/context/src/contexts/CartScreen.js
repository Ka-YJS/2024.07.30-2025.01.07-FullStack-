import React, { useContext } from 'react';
import { View, Text, Button, FlatList } from 'react-native';
import CartContext from './Cart';

const CartScreen = () => {
  const { cart, dispatch } = useContext(CartContext);

  const addItem = () => {
    const newItem = { id: Date.now().toString(), name: 'New Item' };
    dispatch({ type: 'ADD_ITEM', payload: newItem });
    //dispatch안에 꼭 하나만 전달가능한 것은 아님
  };

  const removeItem = (id) => {
    dispatch({ type: 'REMOVE_ITEM', payload: { id } });
  };

  return (
    <View style={{ flex: 1, justifyContent: 'center', alignItems: 'center' }}>
      <Button title="Add Item" onPress={addItem} />
      <FlatList
        data={cart}
        keyExtractor={item => item.id}
        renderItem={({ item }) => (
          <View style={{ flexDirection: 'row', alignItems: 'center', marginVertical: 5 }}>
            <Text>{item.name}</Text>
            <Button title="Remove" onPress={() => removeItem(item.id)} />
          </View>
        )}
      />
    </View>
  );
};

export default CartScreen;